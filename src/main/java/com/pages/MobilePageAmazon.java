package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

@SuppressWarnings("rawtypes")
public class MobilePageAmazon extends BasePage {

	@FindBy(xpath="//span[@id='productTitle']")
	public WebElement product_title;
	
	@FindBy(xpath="//span[@id='priceblock_ourprice']")
	public WebElement mobile_price;
	
	@Override
	public ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(product_title);
	}

	public int mobile_price() {
		
		String price = mobile_price.getText();
		String priceSplit[] = price.split(" ");
		String splitWithDot[]=priceSplit[1].split("\\.");
		String splitwithcomma[]=splitWithDot[0].split("\\,");
		String actualPrice=splitwithcomma[0]+splitwithcomma[1];
		return Integer.parseInt(actualPrice);
	}
	
	
	
}
