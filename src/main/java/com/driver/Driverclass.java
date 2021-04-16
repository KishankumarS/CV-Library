package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driverclass {
	private static Driverclass initiateDriverclass = null;
	
	private WebDriver driver;
	
	private Driverclass() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public static Driverclass getInitiateDriverclass() {
		if(initiateDriverclass==null)
			initiateDriverclass = new Driverclass();
		return initiateDriverclass;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
