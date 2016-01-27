package com.ec.calculator.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ec.calculator.commonUtils.CreateDriver;
import com.ec.calculator.dataProvider.CalculatorData;
import com.ec.calculator.pageObjects.CalculatorPO;

/*
 *  This file contains two set of test cases:
 *  1. Test_CalcWithSendKeys will test the calculator application using sendkeys but not using the buttons on the calculator pad
 *  2. Test_CalcWithButtons will test the calculator application using buttons on the calculator pad
 */
public class CalculatorTests {

	/*
	 * @Param: This test case will take Row number, N1, N2, Operation and Result
	 * as parameters from Dataprovider
	 * 
	 * @Return: Void
	 */
	@Test(dataProviderClass = com.ec.calculator.dataProvider.CalculatorDataProvider.class, dataProvider = "getDataXls")
	public static void Test_CalcWithSendKeys(Object rowNumber, CalculatorData cd) throws Exception {

		// Creating webdriver instance
		WebDriver driver = CreateDriver.getDriver("Chrome");

		// Using below try finally to close the already opened browser
		try {

			// Creating an instance of CalculatorPO class which has got all the
			// page declarations of Calculator page
			CalculatorPO cPO = new CalculatorPO(driver);

			// Loading calculator web application UI
			cPO.loadCalculatorPage();

			// This method will perform the action specified in the xlsx file
			// using SendKeys
			// and returns the result as a string
			String actualResult = cPO.performActionWithSendKeys(cd.getNumber1(), cd.getNumber2(), cd.getAction());

			// Asserts actual and expected results
			Assert.assertEquals(actualResult, cd.getExpectedResult(), "Calculator failed to perform " + cd.getAction() + " for n1:" + cd.getNumber1() + "and n2:" + cd.getNumber2());

		} finally {
			driver.quit();
		}
	}

	/*
	 * @Param: This test case will take Row number, N1, N2, Operation and Result
	 * as parameters from Dataprovider
	 * 
	 * @Return: Void
	 */

	@Test(dataProviderClass = com.ec.calculator.dataProvider.CalculatorDataProvider.class, dataProvider = "getDataXls")
	public static void Test_CalcWithButtons(Object rowNumber, CalculatorData cd) throws Exception {
		// Creating webdriver instance
		WebDriver driver = CreateDriver.getDriver("Chrome");

		// Using below try finally to close the already opened browser
		try {

			// Creating an instance of CalculatorPO class which has got all the
			// page declarations of Calculator page
			CalculatorPO cPO = new CalculatorPO(driver);

			// Loading calculator web application UI
			cPO.loadCalculatorPage();

			// This method will perform the action specified in the xlsx file
			// using buttons available on calculator pad
			// and returns the result as a string
			String actualResult = cPO.performAction(cd.getNumber1(), cd.getNumber2(), cd.getAction());

			// Asserts actual and expected results
			Assert.assertEquals(actualResult, cd.getExpectedResult(), "Calculator failed to perform " + cd.getAction() + " for n1:" + cd.getNumber1() + "and n2:" + cd.getNumber2());

		} finally {
			driver.quit();
		}
	}

}
