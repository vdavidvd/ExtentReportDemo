package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.basePackage.BaseClass;
import com.extentManager.ExtentManager;

public class OrangeHRMTest extends BaseClass{
	
	@Test
	public void loginPageTest() {
		WebElement img = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		Assert.assertTrue(img.isDisplayed());
	}
	
	@Test
	public void loginTest() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM1"); //expected --> OrangeHRM
	}
	
	@Test
	public void sampleTest() {
		ExtentManager.test.createNode("Validation1");
		Assert.assertTrue(true);
		ExtentManager.test.createNode("Validation2");
		Assert.assertTrue(true);
		ExtentManager.test.createNode("Validation3");
		Assert.assertTrue(true);
		ExtentManager.test.createNode("Validation4");
		Assert.assertTrue(true);
	}

}
