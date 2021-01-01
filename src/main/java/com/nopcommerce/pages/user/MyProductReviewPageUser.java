package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class MyProductReviewPageUser extends CommonPageUser {

	private final String MY_PRODUCT_REVIEW_PAGE_TITLE = "//h1[text()='My account - My product reviews']";
	
	public MyProductReviewPageUser(WebDriver driver) {
		super(driver);
	}

	public boolean isMyProductReviewPageTitleDisplayed() {
		return isElementDisplayed(MY_PRODUCT_REVIEW_PAGE_TITLE);
	}

}
