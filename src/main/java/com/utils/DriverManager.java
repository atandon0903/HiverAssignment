package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	
	public static void setWebDriver(WebDriver webDriver)
	{
		
		driver.set(webDriver);
		
	}
	
	public static void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public static void setImplicitWait(WebDriver driver,long time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	}
	

}
