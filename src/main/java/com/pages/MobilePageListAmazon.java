package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

@SuppressWarnings("rawtypes")
public class MobilePageListAmazon extends BasePage {

	@FindBy(xpath="//span[contains(text(),'Apple iPhone 6s (32GB) - Space Grey')]")
	public WebElement iphone_element;
	
	@FindBy(xpath="//span[contains(text(),'Apple iPhone 6s (32GB) - Space Grey')]//parent::a")
	public WebElement mobile_lnk;
	
	@Override
	public ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(iphone_element);
	}

	@SuppressWarnings("unchecked")
	public MobilePageAmazon verifyAndClickFromList(String mobiletxt) {
		
		if(iphone_element.getText().contains(mobiletxt)) {
			
			click("Searched Mobile", mobile_lnk);
		
		}
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
			
			return (MobilePageAmazon)openPage(MobilePageAmazon.class);
	}
}
