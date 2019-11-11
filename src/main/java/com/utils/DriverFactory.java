package com.utils;

import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	private static String gridURL;
	private static String chromeDriverExePath;
	private static String ieDriverExePath;

	public static String getGridURL() {
		return gridURL;
	}

	public static void setGridURL(String gridURL) {
		DriverFactory.gridURL = gridURL;
	}

	public static String getChromeDriverExePath() {
		return chromeDriverExePath;
	}

	public static void setChromeDriverExePath(String chromeDriverExePath) {
		DriverFactory.chromeDriverExePath = chromeDriverExePath;
	}

	public static String getIeDriverExePath() {
		return ieDriverExePath;
	}

	public static void setIeDriverExePath(String ieDriverExePath) {
		DriverFactory.ieDriverExePath = ieDriverExePath;
	}

	public static WebDriver createInstance(String browserName) {
		
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
			DriverManager.setWebDriver(driver);
			
			DriverManager.maximizeBrowser(DriverManager.getDriver());
			DriverManager.setImplicitWait(driver,20);
			return driver;
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", getIeDriverExePath() + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			DriverManager.setWebDriver(driver);
			DriverManager.maximizeBrowser(DriverManager.getDriver());
			DriverManager.setImplicitWait(driver,20);
			return driver;
		} else if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", getChromeDriverExePath()+"chromedriver.exe");
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			// chromePrefs.put("profile.default_content_settings.popups", 0);
			// chromePrefs.put("download.default_directory", downloadFilepath);

			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments(Arrays.asList("--start-maximized"));
			options.addArguments(Arrays.asList("--ssl-protocol=any"));
			options.addArguments(Arrays.asList("--ignore-ssl-errors=true"));
			options.addArguments(Arrays.asList("--disable-extensions"));
			options.addArguments(Arrays.asList("--ignore-certificate-errors"));
			options.setExperimentalOption("prefs", chromePrefs);

			DesiredCapabilities crcapabilities = DesiredCapabilities.chrome();
			crcapabilities.setCapability("chrome.binary", getChromeDriverExePath());
			crcapabilities.setCapability(ChromeOptions.CAPABILITY, options);
			crcapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new ChromeDriver(crcapabilities);
			DriverManager.setWebDriver(driver);
			DriverManager.maximizeBrowser(DriverManager.getDriver());
			DriverManager.setImplicitWait(driver,20);
			return driver;

		} else
			return driver;

	}

	public static void destroyDriverInstance(WebDriver driver) {
		try {
			if (driver != null) {
				driver.close();
				driver.quit();
			}
		} catch (Exception ex) {

		}
	}
	
	public static void closeDriverInstance(WebDriver driver) {
		try {
			if (driver != null) {
				driver.close();
				
			}
		} catch (Exception ex) {

		}
	}
	

}
