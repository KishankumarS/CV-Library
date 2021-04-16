package com.SeleRepository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driver.Driverclass;

public class SeleFun {
	Driverclass cl = Driverclass.getInitiateDriverclass();
	
	public void implicityWait(long seconds) {
			cl.getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public void explicitWait(long seconds, By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(cl.getDriver(), seconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void takeScreeshot() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter form = DateTimeFormatter.ofPattern("dd-MM-yyy-HH-mm-ss");
		String formatdate = now.format(form);
		File screenshot = ((TakesScreenshot)cl.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("./src/main/resources/Screenshots/"+formatdate));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
