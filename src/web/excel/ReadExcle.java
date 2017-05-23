package web.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcle {
	// 文件二进制输入流
	private InputStream inputStream = null;
	// 当前sheet
	private int currSheet = 0;
	// 当前位置
	@SuppressWarnings("unused")
	private int currPosition;
	// sheet数量
	private int numOfSheets;
	// Workbook
	Workbook workbook = null;

	/**
	 * 初始化数
	 * 
	 * @param inputfile
	 *            文件二进制流
	 * @param scanInitSheet
	 *            扫描开始sheet页数
	 * @param scanInitPosition
	 *            扫描开始位置
	 * @throws IOException
	 * @throws Exception
	 */
	private void initDataFor2003(InputStream fileInputStream,
			int scanInitPosition) throws IOException {
		inputStream = fileInputStream;
		currPosition = scanInitPosition;
		workbook = new HSSFWorkbook(inputStream);
		numOfSheets = workbook.getNumberOfSheets();
	}

	private void initDataFor2007(InputStream fileInputStream,
			int scanInitPosition) throws IOException {
		inputStream = fileInputStream;
		currPosition = scanInitPosition;
		workbook = new XSSFWorkbook(inputStream);
		numOfSheets = workbook.getNumberOfSheets();
	}

	/**
	 * 解析excle
	 * 
	 * @param inputfile
	 *            文件File
	 * @param scanInitPosition
	 *            扫描初始化位置
	 * @return List<List<ExcleDataVo>>
	 * @throws IOException
	 */
	public List<List<ExcleDataVo>> readExcle(InputStream fileInputStream,
			int scanInitPosition) throws IOException {
		initDataFor2007(fileInputStream, scanInitPosition);
		List<List<ExcleDataVo>> resultData = new ArrayList<List<ExcleDataVo>>();
		while (currSheet < numOfSheets) {
			Sheet sheet = workbook.getSheetAt(currSheet);
			if (sheet.getFirstRowNum() == sheet.getLastRowNum()) {
				currPosition = scanInitPosition;
			} else {
				resultData.add(packageExcleData(scanInitPosition));
			}
			currSheet++;
		}
		close();
		return resultData;
	}

	public int getSheetCount(InputStream inputStream) throws IOException {
		Workbook workbook = new HSSFWorkbook(inputStream);
		return workbook.getNumberOfSheets();
	}

	/**
	 * 封装每页excle数据
	 * 
	 * @param scanInitPosition
	 *            扫描初始化位置
	 * @return List<ExcleDataVo>
	 * @throws IOException
	 */
	private List<ExcleDataVo> packageExcleData(int scanInitPosition)
			throws IOException {
		Sheet sheet = workbook.getSheetAt(currSheet);
		Row headRow = sheet.getRow(scanInitPosition - 1);
		int totalCellCount = headRow.getPhysicalNumberOfCells();
		List<ExcleDataVo> excleDataList = getExcleData(totalCellCount, headRow,
				scanInitPosition);
		return excleDataList;
	}

	/**
	 * 得到每页excle数据
	 * 
	 * @param totalCellCount
	 *            总列数
	 * @param headRow
	 *            HSSFRow 对象
	 * @param scanInitPosition
	 *            扫描初始化位置
	 * @return List<ExcleDataVo>
	 */
	private List<ExcleDataVo> getExcleData(int totalCellCount, Row headRow,
			int scanInitPosition) {
		List<ExcleDataVo> excleDataList = new ArrayList<ExcleDataVo>();
		for (int i = 0; i < totalCellCount; i++) {
			ExcleDataVo excleDataVo = new ExcleDataVo();
			excleDataVo.setSerialNumber(String.valueOf(i));
			if (checkIsNull(headRow)) {
				Cell cell = headRow.getCell(i);
				excleDataVo.setCellName(packageCellValue(cell));
				excleDataVo.setCellList(getCellData(scanInitPosition, i));
				excleDataList.add(excleDataVo);
			}
		}
		return excleDataList;
	}

	/**
	 * 得到每一列数据
	 * 
	 * @param scanInitPosition
	 *            扫描初始化位置
	 * @param cellNum
	 *            列位置
	 * @return List<Object>
	 */
	private List<Object> getCellData(int scanInitPosition, int cellNum) {
		List<Object> cellList = new ArrayList<Object>();
		Sheet sheet = workbook.getSheetAt(currSheet);
		for (int i = scanInitPosition; i <= sheet.getLastRowNum(); i++) {
			Row dataRow = sheet.getRow(i);
			if (checkIsNull(dataRow)) {
				Cell cell = dataRow.getCell(cellNum);
				cellList.add(packageCellValue(cell));
			}
		}
		return cellList;
	}

	private String getCellValue(Cell cell) {
		String cellValue = "";
		switch (cell.getCellType()) {
		case XSSFCell.CELL_TYPE_NUMERIC: {
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				cellValue = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm")
						.format(cell.getDateCellValue());
			} else {
				Integer num = Integer.valueOf((int) cell.getNumericCellValue());// 默认返回时double类型
				cellValue = String.valueOf(num);
			}
			break;
		}
		case XSSFCell.CELL_TYPE_STRING:
			cellValue = cell.getStringCellValue();
			break;
		default:
			cellValue = "";
		}
		return cellValue;
	}

	private boolean checkIsNull(Row rowLine) {
		if (rowLine != null) {
			return true;
		}
		return false;
	}

	private String packageCellValue(Cell cell) {
		String resultStr = "";
		if (cell != null) {
			resultStr = getCellValue(cell);
		}
		return resultStr;
	}

	// close函数执行流的关闭操作
	private void close() {
		// 如果id不为空，则关闭InputStream文件输入流
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				System.out.println("IO error");
			}
		}
	}
}
