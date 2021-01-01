package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class ThankYouPageUser extends CommonPageUser {
	private final String PAGE_TITLE_THANK_YOU = "//div[@class='page-title']/h1[text()='Thank you']";
	private final String MESSAGE_ORDER_SUCCESS = "//strong[text()='Your order has been successfully processed!']";
	private final String MESSAGE_ORDER_NUMBER = "//div[@class='order-number']/strong";

	public ThankYouPageUser(WebDriver driver) {
		super(driver);
	}

	public boolean isThankYouPageTitleDisplayed() {
		return isElementDisplayed(PAGE_TITLE_THANK_YOU);
	}

	public boolean isOrderSuccessMessageDisplayed() {
		return isElementDisplayed(MESSAGE_ORDER_SUCCESS);
	}

	public boolean isOrderNumberDisplayed() {
		return isElementDisplayed(MESSAGE_ORDER_NUMBER);
	}

	public String getOrderNumberValue() {
		return getTextElement(MESSAGE_ORDER_NUMBER).split("\\:")[1].trim();
	}
}
