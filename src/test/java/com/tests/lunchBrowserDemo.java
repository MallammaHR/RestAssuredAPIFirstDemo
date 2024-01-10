package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class lunchBrowserDemo
{
	static
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Mallukinnis\\eclipse-workspace\\RestAssuredAPIDemo\\RestAssuredDemo\\src\\main\\resources\\geckodriver.exe");
	}
	WebDriver driver=null;
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new FirefoxDriver();
		
		
	}
	
	@Test
	public void lunchBrowser() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Google"),"Title did not match");
		driver.close();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
