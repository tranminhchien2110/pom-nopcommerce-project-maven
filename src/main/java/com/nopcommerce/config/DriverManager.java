package com.nopcommerce.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private WebDriver driver;
	
	public static DriverManager getDriverManager() {
		return new DriverManager();
	}

	public WebDriver getBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome"))
			driver = createChromeDriver();
		if (browserName.equalsIgnoreCase("firefox"))
			driver = createFirefoxDriver();
		return driver;
	}

	public WebDriver createChromeDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}

	public WebDriver createFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

}
