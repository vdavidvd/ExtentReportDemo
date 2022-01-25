package com.basePackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.extentManager.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	

	@BeforeSuite
	public void beforeSuite() {
		ExtentManager.setExtent();
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
	}
	
	public static String screenShot(WebDriver driver, String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\ScreenShot\\"+filename+getCurrentTime()+".png";
		File finalDestination = new File(destination);
		
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.getMessage();
		}
		return destination;
	}
	
	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

	@AfterMethod
	public void closure() {
		driver.quit();
	}
}
