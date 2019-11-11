package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

@SuppressWarnings("rawtypes")
public class AddToCart extends BasePage {

	@FindBy(xpath="//div[@class='_1lBhq8']")
	public WebElement my_cart;
	
	@FindBy(xpath="//button[text()='+']")
	public WebElement add_btn;
	
	@FindBy(xpath="//div[@class='_3xFQAD']//span")
	public WebElement price;
	
	
	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(my_cart);
	}

	public AddToCart clickToAddAdditionalItem() {
		
		click("Increment Button", add_btn);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public AddToCart displayPrice() {
		System.out.println("The total price of mobiles are "+price.getText().substring(1));
		return this;
	}
}
