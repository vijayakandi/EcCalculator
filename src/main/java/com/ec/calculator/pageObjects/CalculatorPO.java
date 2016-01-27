package com.ec.calculator.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPO {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor to accept webDriver as parameter and set the local driver
	// variable to driver it receives
	public CalculatorPO(WebDriver webDriver) {
		this.driver = webDriver;
		wait = new WebDriverWait(driver, 10);
	}

	// Calculator application URL Location
	String calculatorURL = "http://web2.0calc.com/";

	// Page objects related to Calculator application
	public By b0 = By.id("Btn0");
	public By b1 = By.id("Btn1");
	public By b2 = By.id("Btn2");
	public By b3 = By.id("Btn3");
	public By b4 = By.id("Btn4");
	public By b5 = By.id("Btn5");
	public By b6 = By.id("Btn6");
	public By b7 = By.id("Btn7");
	public By b8 = By.id("Btn8");
	public By b9 = By.id("Btn9");
	public By bInputField = By.id("input");
	public By bPlus = By.id("BtnPlus");
	public By bMinus = By.id("BtnMinus");
	public By bMultiplication = By.id("BtnMult");
	public By bDivison = By.id("BtnDiv");
	public By bEquals = By.id("BtnCalc");
	public By result = By.id("result");

	// Loads calculator application page
	public void loadCalculatorPage() {
		driver.get(calculatorURL);
	}

	/*
	 * @Param: Number/action to be clicked on calculator pad
	 * 
	 * @Return: Void
	 */

	public void clickButton(Character buttonToBeClicked) {

		switch (buttonToBeClicked) {
		case '0':
			driver.findElement(b0).click();
			break;
		case '1':
			driver.findElement(b1).click();
			break;
		case '2':
			driver.findElement(b2).click();
			break;
		case '3':
			driver.findElement(b3).click();
			break;
		case '4':
			driver.findElement(b4).click();
			break;
		case '5':
			driver.findElement(b5).click();
			break;
		case '6':
			driver.findElement(b6).click();
			break;
		case '7':
			driver.findElement(b7).click();
			break;
		case '8':
			driver.findElement(b8).click();
			break;
		case '9':
			driver.findElement(b9).click();
			break;
		case '+':
			driver.findElement(bPlus).click();
			break;
		case '-':
			driver.findElement(bMinus).click();
			break;
		case '*':
			driver.findElement(bMultiplication).click();
			break;
		case '/':
			driver.findElement(bDivison).click();
			break;
		case '=':
			driver.findElement(bEquals).click();
			break;

		}

	}

	// @Param: Takes number to be entered in the calculator input field
	public void enterValue(String valueToBeEntered) {
		char[] numbers = valueToBeEntered.toCharArray();
		for (char number : numbers) {
			clickButton(number);
		}
	}

	// @Param: Accepts number to be entered in Input field of Calculator pad and
	// uses sendKeys to enter number than clicking on Calculator Pad
	public void enterNumberInInputField(String number) {

		driver.findElement(bInputField).sendKeys(number);
	}

	// @Param: takes action as a parameter and performs respective action
	// Example: Addition
	public void performOperation(String operation) {

		// Converts input to lower case to avoid case sensitive issues if any in
		// the xlsx
		operation = operation.toLowerCase();
		switch (operation) {
		case "addition":
			clickButton('+');
			break;
		case "subtraction":
			clickButton('-');
			break;
		case "multiplication":
			clickButton('*');
			break;
		case "division":
			clickButton('/');
			break;
		case "equals":
			clickButton('=');
		}
	}

	/*
	 * @Param: Takes n1,n2 and operation as parameter and clicks button to
	 * perform actions
	 * 
	 * @Return: String with the value available on calculator application input
	 * field
	 */
	public String performAction(String n1, String n2, String op) throws InterruptedException {
		enterValue(n1);
		performOperation(op);
		enterValue(n2);
		performOperation("equals");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(result)));
		return driver.findElement(bInputField).getAttribute("value");
	}

	/*
	 * @Param: Takes n1,n2 and operation as parameter and uses sendkeys to
	 * perform actions
	 * 
	 * @Return: String with the value available on calculator application input
	 * field
	 */
	public String performActionWithSendKeys(String n1, String n2, String op) throws InterruptedException {
		enterNumberInInputField(n1);
		performOperation(op);
		enterNumberInInputField(n2);
		performOperation("equals");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(result)));
		return driver.findElement(bInputField).getAttribute("value");
	}
}
