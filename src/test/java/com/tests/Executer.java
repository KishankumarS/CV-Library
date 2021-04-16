package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.IOfileRepository.ReadExcel;
import com.driver.Driverclass;
import com.repository.CommonObjects;

public class Executer {
	
	WebDriver driver;
	CommonObjects com;
	ReadExcel data;
	@BeforeClass
	public void launchBrowserAndApp() {
		com = new CommonObjects();
		data = new ReadExcel();
		Driverclass dc = Driverclass.getInitiateDriverclass();
		driver = dc.getDriver();
		driver.get("https://www.cv-library.co.uk/");
	}
	
	/*
	 * @Test(dataProvider = "datakeyword") public void searchJonUsingKeyword(String
	 * datakeyword) { com.searchByKeyword(datakeyword); }
	 */
	
	@Test
	public void searchJonUsingKeyword1() {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(data.getData("./src/main/resources/Data.xls", name, "Keyword"));
		com.searchByKeyword(data.getData("./src/main/resources/Data.xls", name, "Keyword"));
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
