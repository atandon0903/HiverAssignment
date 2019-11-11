package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;



@SuppressWarnings("rawtypes")
public class MobilePage extends BasePage {

	@FindBy(xpath="//span[@class='_35KyD6']")
	public WebElement label;
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	public WebElement add_to_cart;
	
	@FindBy(xpath="//div[@class='_1vC4OE _3qQ9m1']")
	public WebElement flipkart_price;
	
	@FindBy(xpath="//input[@placeholder='Enter Delivery Pincode']")
	public WebElement pincode_txt_box;
	
	@FindBy(xpath="//span[text()='Change']")
	public WebElement change_btn;
	
	@FindBy(xpath="//span[text()='Check']")
	public WebElement check_btn;
	
	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
	public WebElement search_txt_box;
	
	@Override
	public ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(search_txt_box);
	}

	@SuppressWarnings("unchecked")
	public AddToCart clickOnAddToCart() {
		
		if(!(add_to_cart.isEnabled())) {
			
			click("Check Pincode Button", change_btn);
			pincode_txt_box.clear();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("document.getElementById('pincodeInputId').value='560098'", "");
			//type("Pincode text field", "560098", pincode_txt_box);
			click("Check Pincode Button", check_btn);
		}
		click("Add to cart", add_to_cart);
		return (AddToCart)openPage(AddToCart.class);
	}

	public int getPrice() {
		
		String price = flipkart_price.getText();
		String arr[] =price.substring(1).split("\\,");
		String actualPrice = arr[0]+arr[1];
		return Integer.parseInt(actualPrice);
}
}
