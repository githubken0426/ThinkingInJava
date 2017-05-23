package web.excel;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadEecelCompatible {
	/**
	 * ��ȡExcel������Excel 2003/2007/2010 ����ÿ�����Ͷ�ȡ
	 * 
	 * @param is
	 *            �ļ���
	 * @throws Exception
	 * @throws IOException
	 *             2017-1-17 ����05:24:17
	 */
	public static void readExcelPerType(InputStream is) throws Exception,
			IOException {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		/**
		 * ���ַ�ʽ Excel 2003/2007/2010 ���ǿ��Դ����
		 */
		Workbook workbook = WorkbookFactory.create(is);
		int sheetCount = workbook.getNumberOfSheets(); // Sheet������
		// ����ÿ��Sheet
		for (int s = 0; s < sheetCount; s++) {
			Sheet sheet = workbook.getSheetAt(s);
			int rowCount = sheet.getPhysicalNumberOfRows(); // ��ȡ������
			// ����ÿһ��
			for (int r = 0; r < rowCount; r++) {
				Row row = sheet.getRow(r);
				int cellCount = row.getPhysicalNumberOfCells(); // ��ȡ������
				// ����ÿһ��
				for (int c = 0; c < cellCount; c++) {
					Cell cell = row.getCell(c);
					int cellType = cell.getCellType();
					String cellValue = null;
					switch (cellType) {
					case Cell.CELL_TYPE_STRING: // �ı�
						cellValue = cell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_NUMERIC: // ���֡�����
						if (DateUtil.isCellDateFormatted(cell)) {
							cellValue = fmt.format(cell.getDateCellValue()); // ������
						} else {
							cellValue = String.valueOf(cell
									.getNumericCellValue()); // ����
						}
						break;
					case Cell.CELL_TYPE_BOOLEAN: // ������
						cellValue = String.valueOf(cell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_BLANK: // �հ�
						cellValue = cell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_ERROR: // ����
						cellValue = "����";
						break;
					case Cell.CELL_TYPE_FORMULA: // ��ʽ
						cellValue = "����";
						break;
					default:
						cellValue = "����";
					}
				}
			}
		}
	}

	/**
	 * ���ı���ʽ
	 * 
	 * @param is
	 * @throws Exception
	 * @throws IOException
	 *             2017-1-18 ����09:00:17
	 */
	public static List<Shop> readExcelPureText(InputStream is)
			throws Exception, IOException {
		List<Shop> result = new ArrayList<Shop>();
		Workbook workbook = WorkbookFactory.create(is);
//		int sheetCount = workbook.getNumberOfSheets(); // Sheet������
		// for (int s = 0; s < sheetCount; s++) { // ����ÿ��Sheet
		Sheet sheet = workbook.getSheetAt(0);//ֻ��Ҫ������һ��sheet
		int rowCount = sheet.getPhysicalNumberOfRows(); // ��ȡ������
		for (int r = 1; r < rowCount; r++) {// ����ÿһ��
			Shop shop = new Shop();
			shop.setId(getUUID());
			shop.setProvince("����ʡ");
			shop.setCity("������");
			Row row = sheet.getRow(r);
			int cellCount = row.getLastCellNum(); //getPhysicalNumberOfCells() ��ȡ������
			for (int c = 0; c < cellCount; c++) {// ����ÿһ��
				String value="";
				Cell cell = row.getCell(c);
				if(cell!=null){
					cell.setCellType(Cell.CELL_TYPE_STRING);//ͳһ����Ϊ�ı�����
					value = cell.getStringCellValue();
				}
				switch (c) {
				case 0:
					shop.setShopName(value);
					break;
				case 2:
					shop.setTelNumberList(value);
					break;
				case 3:
					if(value!=null && !value.equals(""))
						value=value.substring(0,value.indexOf(","));
					shop.setLongtitude(value);
					break;
				case 4:
					if(value!=null && !value.equals(""))
						value=value.substring(0,value.indexOf(","));
					shop.setLatitude(value);
					break;
				case 5:
					shop.setDistrict(value);
					break;
				case 6://��ϸ��ַ
					shop.setDetailAddress(value);
					break;
				case 7://��Ӫ��Ŀ
					shop.setManageProject(value);
					break;
				case 8://���̼��
					shop.setShopDescription(value);
					break;
				case 9://�޳�
					if (value != null && value != "") {
						shop.setRepairService(5100);
					}
					break;
				case 10://ϴ��
					if (value != null && value != "") {
						shop.setCleanService(4100);
					}
					break;
				case 11://����
					if (value != null && value != "") {
						shop.setMaintainService(6100);
					}
					break;
				case 12://��̥
					if (value != null && value != "") {
						shop.setTyreService(7100);
					}
					break;
				case 13:
					if (value != null && value != "") {
						shop.setRescueService(2000);
					}
					break;
				}
			}
			result.add(shop);
		}
		return result;
	}

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static boolean contains(String content, String str) {
		if (str == "" || str == null)
			return false;
		if (content.contains(str))
			return true;
		return false;
	}
}
