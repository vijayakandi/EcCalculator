package com.ec.calculator.dataProvider;

public class CalculatorData {

	/*
	 * This class contains getters and setters for number1, number2, action and
	 * expectedResult variables
	 */
	String number1;
	String number2;
	String action;
	String expectedResult;

	public String getExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(String result) {
		this.expectedResult = result;
	}

	public String getNumber1() {
		return number1;
	}

	public void setNumber1(String number1) {
		this.number1 = number1;
	}

	public String getNumber2() {
		return number2;
	}

	public void setNumber2(String number2) {
		this.number2 = number2;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
