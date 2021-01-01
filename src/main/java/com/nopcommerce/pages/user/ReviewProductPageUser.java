package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class ReviewProductPageUser extends CommonPageUser {

	private final String PRODUCT_REVIEW_TITLE = "//h1[text()='Product reviews for ']";
	private final String REVIEW_TITLE_TEXTBOX = "//input[@class='review-title']";
	private final String REVIEW_TEXT_TEXTAREA = "//textarea[@class='review-text']";
	private final String SUBMIT_REVIEW_BUTTON = "//input[@name='add-review']";
	private final String REIVEW_PRODUCT_SUCCESS_MESSAGE = "//div[contains(text(),'Product review is successfully added.')]";
	
	public ReviewProductPageUser(WebDriver driver) {
		super(driver);
	}

	public boolean isReviewProductPageTitleDisplayed() {
		return isElementDisplayed(PRODUCT_REVIEW_TITLE);
	}
	
	public void inputToReviewTitleTextbox(String data) {
		sendKeysToElement(REVIEW_TITLE_TEXTBOX, data);
	}

	public void inputToReviewTextTextarea(String data) {
		sendKeysToElement(REVIEW_TEXT_TEXTAREA, data);
	}

	public void clickSubmitReviewButton() {
		clickToElement(SUBMIT_REVIEW_BUTTON);
	}

	public boolean isReviewProductSuccessMessageDisplayed() {
		return isElementDisplayed(REIVEW_PRODUCT_SUCCESS_MESSAGE);
	}


	

}
