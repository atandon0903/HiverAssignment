package com.setup;

import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.utils.DriverFactory;
import com.utils.DriverManager;
import com.utils.PropertyFileManager;

public class BaseSetup {

	protected static Properties configProperty;
	protected static Properties ORProperty;
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> exTest = new ThreadLocal<ExtentTest>();

	@BeforeSuite
	public void initializeFramework() {

		DriverFactory.setChromeDriverExePath(System.getProperty("user.dir") + "//src//test//resources//executables//");
		DriverFactory.setIeDriverExePath(System.getProperty("user.dir") + "//src//test//resources//executables//");
		PropertyFileManager.setConfigPropFilePath(
				System.getProperty("user.dir") + "//src//test//resources//propertyFiles//config.properties");
		PropertyFileManager.setobjectRepoFilePath(
				System.getProperty("user.dir") + "//src//test//resources//propertyFiles//OR.properties");
		
		

	}
	

	

	@BeforeMethod
	public void beforeMethod() {

	WebDriver webDriver =null;
		
		if (webDriver == null) {
			
			configProperty = PropertyFileManager.createConfigPropertyInstance();
			DriverFactory.createInstance(configProperty.getProperty("browser"));
		} 

	}
	

	@AfterMethod
	public void afterMethod(ITestResult result, Method m) {
		
	
		DriverFactory.destroyDriverInstance(DriverManager.getDriver());
		
	}

	

	public boolean isElementPresent(WebElement element) {
		try {
		if (element.isDisplayed()){
			return true;
			
		}
		}catch(Exception e) {
		
		
			return false;
		
		}
		return false;
	}

	public void setExtentTest(ExtentTest et) {
		exTest.set(et);
	}

	public ExtentTest getExtentTest() {
		return exTest.get();
	}

	
	
}
