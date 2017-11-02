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
	 * 读取Excel，兼容Excel 2003/2007/2010 按照每格类型读取
	 * 
	 * @param is
	 *            文件流
	 * @throws Exception
	 * @throws IOException
	 *             2017-1-17 下午05:24:17
	 */
	public static void readExcelPerType(InputStream is) throws Exception,
			IOException {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		/**
		 * 这种方式 Excel 2003/2007/2010 都是可以处理的
		 */
		Workbook workbook = WorkbookFactory.create(is);
		int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
		// 遍历每个Sheet
		for (int s = 0; s < sheetCount; s++) {
			Sheet sheet = workbook.getSheetAt(s);
			int rowCount = sheet.getPhysicalNumberOfRows(); // 获取总行数
			// 遍历每一行
			for (int r = 0; r < rowCount; r++) {
				Row row = sheet.getRow(r);
				int cellCount = row.getPhysicalNumberOfCells(); // 获取总列数
				// 遍历每一列
				for (int c = 0; c < cellCount; c++) {
					Cell cell = row.getCell(c);
					int cellType = cell.getCellType();
					String cellValue = null;
					switch (cellType) {
					case Cell.CELL_TYPE_STRING: // 文本
						cellValue = cell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_NUMERIC: // 数字、日期
						if (DateUtil.isCellDateFormatted(cell)) {
							cellValue = fmt.format(cell.getDateCellValue()); // 日期型
						} else {
							cellValue = String.valueOf(cell
									.getNumericCellValue()); // 数字
						}
						break;
					case Cell.CELL_TYPE_BOOLEAN: // 布尔型
						cellValue = String.valueOf(cell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_BLANK: // 空白
						cellValue = cell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_ERROR: // 错误
						cellValue = "错误";
						break;
					case Cell.CELL_TYPE_FORMULA: // 公式
						cellValue = "错误";
						break;
					default:
						cellValue = "错误";
					}
				}
			}
		}
	}

	/**
	 * 纯文本格式
	 * 
	 * @param is
	 * @throws Exception
	 * @throws IOException
	 *             2017-1-18 上午09:00:17
	 */
	public static List<Shop> readExcelPureText(InputStream is)
			throws Exception, IOException {
		List<Shop> result = new ArrayList<Shop>();
		Workbook workbook = WorkbookFactory.create(is);
//		int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
		// for (int s = 0; s < sheetCount; s++) { // 遍历每个Sheet
		Sheet sheet = workbook.getSheetAt(0);//只需要便利第一个sheet
		int rowCount = sheet.getPhysicalNumberOfRows(); // 获取总行数
		for (int r = 1; r < rowCount; r++) {// 遍历每一行
			Shop shop = new Shop();
			shop.setId(getUUID());
			shop.setProvince("辽宁省");
			shop.setCity("阜新市");
			Row row = sheet.getRow(r);
			int cellCount = row.getLastCellNum(); //getPhysicalNumberOfCells() 获取总列数
			for (int c = 0; c < cellCount; c++) {// 遍历每一列
				String value="";
				Cell cell = row.getCell(c);
				if(cell!=null){
					cell.setCellType(Cell.CELL_TYPE_STRING);//统一设置为文本类型
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
				case 6://详细地址
					shop.setDetailAddress(value);
					break;
				case 7://经营项目
					shop.setManageProject(value);
					break;
				case 8://店铺简介
					shop.setShopDescription(value);
					break;
				case 9://修车
					if (value != null && value != "") {
						shop.setRepairService(5100);
					}
					break;
				case 10://洗车
					if (value != null && value != "") {
						shop.setCleanService(4100);
					}
					break;
				case 11://保养
					if (value != null && value != "") {
						shop.setMaintainService(6100);
					}
					break;
				case 12://轮胎
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