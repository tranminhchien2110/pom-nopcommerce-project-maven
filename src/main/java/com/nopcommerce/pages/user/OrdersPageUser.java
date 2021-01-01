package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class OrdersPageUser extends CommonPageUser {
	private final String PAGE_TITLE_ORDERS = "//div[@class='page-title']/h1[text()='My account - Orders']";
	private final String MESSAGE_ORDER_NUMBER_BY_VALUE = "//strong[text()='Order Number: %s']";
	private final String BUTTON_DETAILS_BY_MESSAGE_ORDER_NUMBER_BY_VALUE = "//strong[text()='Order Number: %s']/parent::div/following-sibling::div/input[@value='Details']";

	public OrdersPageUser(WebDriver driver) {
		super(driver);
	}

	public OrderInformationPageUser clickDetailsButtonByOrderNumberValue(String orderNumberValue) {
		clickToElement(BUTTON_DETAILS_BY_MESSAGE_ORDER_NUMBER_BY_VALUE, orderNumberValue);
		waitUntilPageReady();
		return new OrderInformationPageUser(getDriver());
	}

	public boolean isOrdersPageTitleDisplayed() {
		return isElementDisplayed(PAGE_TITLE_ORDERS);
	}

	public boolean isOrderNumberByValueDisplayed(String orderNumberValue) {
		return isElementDisplayed(MESSAGE_ORDER_NUMBER_BY_VALUE, orderNumberValue);
	}

}
