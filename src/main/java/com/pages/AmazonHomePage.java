package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.utils.DriverManager;

@SuppressWarnings("rawtypes")
public class AmazonHomePage extends BasePage {

	@FindBy(xpath="//span[@class='nav-sprite nav-logo-base']")
	public WebElement amazon_icon;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	public WebElement search_txt_box;
	
	@FindBy(xpath="//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")
	public WebElement search_btn;
	
	@Override
	public ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(amazon_icon);
	}

	@SuppressWarnings("unchecked")
	public AmazonHomePage open(String url) {

		DriverManager.getDriver().navigate().to(url);
		return (AmazonHomePage) openPage(AmazonHomePage.class);
	}

	
	@SuppressWarnings("unchecked")
	public MobilePageListAmazon mobileList(String mobile) {
		
		type("Search Box", mobile, search_txt_box);
		click("Search button",search_btn );		
		return (MobilePageListAmazon)openPage(MobilePageListAmazon.class);
	}
	
	
}
