package com.vtiger.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseClass;

@Listeners(com.vtiger.genericLib.ListenerImplementation.class)
public class CreateNewOrganization extends BaseClass {
	// create random number for organization name
	double num = Math.random();
	int otp = (int) (num * 1000000);
	
	// test case for creating new organization using new button
	@Test
	public void createNewOraganization() throws InterruptedException {
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("abc" + otp);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String createdOrganizationName = driver.findElement(By.xpath("//pan[contains(text(),'Organization Information')]")).getText();
		System.out.println(createdOrganizationName.substring(10, 17));
	}
}
