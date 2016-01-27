package com.ec.calculator.dataProvider;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.DataProvider;
import com.ec.calculator.commonUtils.ExcelUtil;

public class CalculatorDataProvider {

	// This variable holds the location of excelsheet data input
	public static String calculatorDataSheet = "data/Calc_Input.xlsx";

	// Dataprovider returns array of row number and CalculatorData object which
	// is read from excelsheet data input
	@DataProvider(name = "getDataXls", parallel = false)
	public static Object[][] calculator() throws IOException {

		ArrayList<Object[]> rows;
		ExcelUtil excelUtil = new ExcelUtil();

		rows = excelUtil.readXlsxFile(calculatorDataSheet, "CalculatorDataSheet", 4, 1);
		Object row[][] = new Object[rows.size()][2];
		for (int i = 0; i < rows.size(); i++) {

			CalculatorData data = new CalculatorData();
			data.setNumber1(rows.get(i)[0].toString());
			data.setNumber2(rows.get(i)[1].toString());
			data.setAction(rows.get(i)[2].toString());
			data.setExpectedResult(rows.get(i)[3].toString());
			row[i][0] = i + 2;
			row[i][1] = data;
		}

		return row;

	}
}
