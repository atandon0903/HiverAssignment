package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

@SuppressWarnings("rawtypes")
public class MobilePageList extends BasePage {

	@FindBy(xpath="//div[contains(text(),'Apple iPhone 6s (Space Grey, 32 GB)')]")
	public WebElement mobile_display;
	
	@FindBy(xpath="//img[@class='_1e_EAo']")
	public WebElement flipkart_icon;
	@Override
	public ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(mobile_display);
	}

	
	
	@SuppressWarnings("unchecked")
	public MobilePage clickOnFirstElement() {
		
		click("Mobile", mobile_display);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
		return (MobilePage)openPage(MobilePage.class);
	}
	
}
