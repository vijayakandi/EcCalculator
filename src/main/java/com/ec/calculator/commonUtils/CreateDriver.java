package com.ec.calculator.commonUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriver {

	static String chromeDriverSystemProperty = "webdriver.chrome.driver";
	static String chromeDriverLocation = "/Applications/chromedriver";

	/*
	 * @Param: Accepts browser as a parameter using which it will return a
	 * respective browser driver handle example: "chrome" or "firefox"
	 */
	public static WebDriver getDriver(String browser) {
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(chromeDriverSystemProperty, chromeDriverLocation);
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		return driver;
	}

}
