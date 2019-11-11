package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

@SuppressWarnings("rawtypes")
public class FlipkartHomePage extends BasePage {

	
	@Override
	public ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(flipkart_icon);
	}

	@FindBy(xpath="//img[@class='_1e_EAo']")
	public WebElement flipkart_icon;

	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
	public WebElement search_txt_box;

	@FindBy(xpath="//button[@class='vh79eN']")
	public WebElement search_btn;
	
	@SuppressWarnings("unchecked")
	public MobilePageList enterValueAndSearch(String text) {
		
		type("Seacrh Box", text, search_txt_box);
		click("Search Icon", search_btn);
		
		return (MobilePageList)openPage(MobilePageList.class);
	}
	
}
