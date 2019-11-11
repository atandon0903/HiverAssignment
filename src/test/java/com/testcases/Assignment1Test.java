package com.testcases;

import org.testng.annotations.Test;

import com.pages.AddToCart;
import com.pages.FlipkartHomePage;
import com.pages.MobilePage;
import com.pages.MobilePageList;
import com.pages.SignInPage;
import com.setup.BaseSetup;

public class Assignment1Test extends BaseSetup {

	@Test
	public void addMobileToCart() {
		
		SignInPage signInPage = new SignInPage().open(configProperty.getProperty("testSiteURL"));
		FlipkartHomePage home_page = signInPage.clickOnCancel();
		MobilePageList mob_page_list = home_page.enterValueAndSearch(configProperty.getProperty("mobileSearch"));
		MobilePage mob_page = mob_page_list.clickOnFirstElement(); 
		AddToCart add_cart =mob_page.clickOnAddToCart();
		add_cart.clickToAddAdditionalItem();
		add_cart.displayPrice();
	
	}
	
}
