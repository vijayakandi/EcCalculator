package com.ec.calculator.commonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public ArrayList<Object[]> readXlsxFile(String args, String sheetName, int columns, int rowNumberToStartFrom) throws IOException {

		// Gets obsolutepath of current workspace
		File currentDirectory = new File(new File(".").getAbsolutePath());
		String fileName = currentDirectory.getCanonicalFile().toString() + "/src/test/resources/" + args;

		File f = new File(fileName);

		ArrayList<Object[]> ret = new ArrayList<Object[]>();
		try {

			FileInputStream file = new FileInputStream(fileName);

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int rowNumber = 0;
			while (rowIterator.hasNext()) {
				rowNumber++;
				Row row = rowIterator.next();
				if (rowNumber <= rowNumberToStartFrom) {
					continue;
				}
				Object[] cells = new Object[columns];
				boolean allNulls = true;
				for (int j = 0; j < columns; j++) {
					Cell cell = row.getCell(j);
					Object val = null;
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:

							DataFormatter fmt = new DataFormatter();
							val = fmt.formatCellValue(cell);
							break;
						case Cell.CELL_TYPE_STRING:
							val = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							val = cell.getBooleanCellValue();
							break;
						default:
							val = cell.getStringCellValue();
						}
					}
					cells[j] = val;
					if (val != null && !val.toString().trim().equals("")) {
						allNulls = false;
					}
				}
				if (!allNulls) {
					ret.add(cells);
				}
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

}
