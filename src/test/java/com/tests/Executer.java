package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.driver.Driverclass;
import com.repository.CommonObjects;

public class Executer {
	
	WebDriver driver;
	CommonObjects com;
	@BeforeClass
	public void launchBrowserAndApp() {
		com = new CommonObjects();
		Driverclass dc = Driverclass.getInitiateDriverclass();
		driver = dc.getDriver();
		driver.get("https://www.cv-library.co.uk/");
	}
	
	@Test(dataProvider = "datakeyword")
	public void searchJonUsingKeyword(String datakeyword) {
		com.searchByKeyword(datakeyword);
	}
	
	@DataProvider(name = "datakeyword")
	public Object[] datakeyword() {
		 Object data[]= new Object[3];
	      data[0]= "Make";
	      data[1]= "Selenium";
	      data[2]= "Easy";
	      return data;
	}
	
}
