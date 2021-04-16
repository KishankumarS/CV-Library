package com.repository;

import org.openqa.selenium.By;

import com.SeleRepository.SeleFun;
import com.driver.Driverclass;

public class CommonObjects {
	Driverclass cl = Driverclass.getInitiateDriverclass();
	SeleFun fun = new SeleFun();
	
	public void searchByKeyword(String keyword) {
		fun.implicityWait(30);
		cl.getDriver().findElement(By.id("keywords")).sendKeys(keyword);;
		cl.getDriver().findElement(By.id("hp-search-btn")).click();
		
	}
	
}
