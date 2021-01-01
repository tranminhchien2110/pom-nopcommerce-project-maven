package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class OrderInformationPageUser extends CommonPageUser {
	private final String PAGE_TITLE_ORDER_INFORMATION = "//div[@class='page-title']/h1[text()='Order information']";
	private final String MESSAGE_ORDER_BY_VALUE = "//div[@class='order-number']/strong[text()='Order #" + "%s" + "']";
	private final String MESSAGE_ORDER_DATE_BY_VALUE = "//li[@class='order-date' and text()='Order Date: %s']";
	private final String MESSAGE_ORDER_STATUS_BY_VALUE = "//li[@class='order-status' and text()='Order Status: %s']";
	private final String MESSAGE_ORDER_TOTAL_BY_VALUE = "//li[@class='order-total' and contains(text(),'Order Total: ')]/strong[text()='%s']";
	private final String BUTTON_RE_ORDER = "//input[@value='Re-order']";

	public OrderInformationPageUser(WebDriver driver) {
		super(driver);
	}

	public CartPageUser clickReOrderButton() {
		clickToElement(BUTTON_RE_ORDER);
		waitUntilPageReady();
		return new CartPageUser(getDriver());
	}

	public boolean isOrderInforPageTitleDisplayed() {
		return isElementDisplayed(PAGE_TITLE_ORDER_INFORMATION);
	}

	public boolean isOrderNumberDisplayed(String orderNumberValue) {
		return isElementDisplayed(MESSAGE_ORDER_BY_VALUE, orderNumberValue);
	}

	public boolean isOrderDateDisplayed(String orderDateValue) {
		return isElementDisplayed(MESSAGE_ORDER_DATE_BY_VALUE, orderDateValue);
	}

	public boolean isOrderStatusDisplayed(String orderStatusValue) {
		return isElementDisplayed(MESSAGE_ORDER_STATUS_BY_VALUE, orderStatusValue);
	}

	public boolean isOrderTotalDisplayed(String orderTotalValue) {
		return isElementDisplayed(MESSAGE_ORDER_TOTAL_BY_VALUE, orderTotalValue);
	}

}
