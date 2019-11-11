package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.AmazonHomePage;
import com.pages.FlipkartHomePage;
import com.pages.MobilePage;
import com.pages.MobilePageAmazon;
import com.pages.MobilePageList;
import com.pages.MobilePageListAmazon;
import com.pages.SignInPage;
import com.setup.BaseSetup;

public class Assignment2Test extends BaseSetup {

	int amazonMobPrice=0;
	int flipkartMobPrice=0;
	@Test(priority=1)
	public void amazonPrice() {
	
		AmazonHomePage amazonPage = new AmazonHomePage().open(configProperty.getProperty("testSiteURL1"));
		MobilePageListAmazon mobileList = amazonPage.mobileList(configProperty.getProperty("mobileSearch"));
		MobilePageAmazon mobPage = mobileList.verifyAndClickFromList(configProperty.getProperty("mobileSearch"));
		amazonMobPrice = mobPage.mobile_price();
		System.out.println("The price at Amazon is "+amazonMobPrice);
	}
	
	@Test(priority=2)
	public void flipkartPrice() {
		
		SignInPage signInPage = new SignInPage().open(configProperty.getProperty("testSiteURL"));
		FlipkartHomePage home_page = signInPage.clickOnCancel();
		MobilePageList mob_page_list = home_page.enterValueAndSearch(configProperty.getProperty("mobileSearch"));
		MobilePage mob_page = mob_page_list.clickOnFirstElement();
		 flipkartMobPrice=mob_page.getPrice();
		 System.out.println("The price at Flipkart is "+flipkartMobPrice);
		 if(amazonMobPrice>flipkartMobPrice) 
				System.out.println("The price in amazon is higher");
			else if(amazonMobPrice<flipkartMobPrice)
				System.out.println("The price in flipkart is higher");
			else
				System.out.println("The price in amazon and flipkart are same");
		}
	

	
		
}
