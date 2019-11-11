package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.utils.DriverManager;

@SuppressWarnings("rawtypes")
public class SignInPage extends BasePage {
	
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	public WebElement cancel_btn;
	
	
	@SuppressWarnings("unchecked")
	public SignInPage open(String url) {

		DriverManager.getDriver().navigate().to(url);
		return (SignInPage) openPage(SignInPage.class);
	}
	
	@SuppressWarnings("unchecked")
	public FlipkartHomePage clickOnCancel() {
		if(cancel_btn.isDisplayed())
		click("Cancel Button", cancel_btn);
		
		return (FlipkartHomePage)openPage(FlipkartHomePage.class);
	}
	
	

	@Override
	public ExpectedCondition getPageLoadCondition() {

			return ExpectedConditions.visibilityOf(cancel_btn);
	}
	
	
	
	

}
