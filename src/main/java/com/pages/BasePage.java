package com.pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.setup.BaseSetup;
import com.utils.DriverManager;

public abstract class BasePage<T> extends BaseSetup {

	protected WebDriver driver;
	private int LOAD_TIMEOUT = 5;
	private int REFRESH_RATE = 2;
	private int AJAX_ELEMENT_TIMEOUT = 20;

	public BasePage() {
		this.driver = DriverManager.getDriver();
	}

	@SuppressWarnings("rawtypes")
	public T openPage(Class<T> clazz) {
		T page = null;
		try {

			driver = DriverManager.getDriver();
			AjaxElementLocatorFactory ajaxElemFactory = new AjaxElementLocatorFactory(driver, AJAX_ELEMENT_TIMEOUT);
			page = PageFactory.initElements(driver, clazz);
			PageFactory.initElements(ajaxElemFactory, page);
			ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
			waitForPageToLoad(pageLoadCondition);
		} catch (NoSuchElementException ex) {
		}
		return page;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
		Wait wait = new FluentWait(DriverManager.getDriver()).withTimeout(LOAD_TIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(REFRESH_RATE, TimeUnit.SECONDS);
		wait.until(pageLoadCondition);

	}

	@SuppressWarnings("rawtypes")
	public abstract ExpectedCondition getPageLoadCondition();

	public static void click(String nameOfElement, WebElement element) {
		
		element.click();

	}

	public void type(String nameOfElement, String value, WebElement element) {
		element.clear();
		element.sendKeys(value);
		

	}


}
