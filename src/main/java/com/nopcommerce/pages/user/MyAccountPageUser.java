package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class MyAccountPageUser extends CommonPageUser {

	private final String MY_ACCOUNT_TITLE = "//div[@class='block block-account-navigation']//strong[text()='My account']";
	private final String LINK_ADDRESSES = "//div[@class='listbox']//a[text()='Addresses']";
	private final String LINK_ORDERS = "//div[@class='listbox']//a[contains(text(),'Orders')]";
	private final String LINK_CUSTOMER_INFOR = "//div[@class='listbox']//a[text()='Customer info']";
	private final String LINK_CHANGE_PASSWORD = "//a[text()='Change password']";
	private final String LINK_MY_PRODUCT_REVIEW = "//a[contains(text(),'My product reviews')]";

	public MyAccountPageUser(WebDriver driver) {
		super(driver);
	}

	public boolean isMyAccountPageTitleDisplayed() {
		return isElementDisplayed(MY_ACCOUNT_TITLE);
	}

	public CustomerInfoPageUser clickCustomerInforLink() {
		clickToElement(LINK_CUSTOMER_INFOR);
		return new CustomerInfoPageUser(getDriver());
	}

	public AddressesPageUser clickAddressesLink() {
		clickToElement(LINK_ADDRESSES);
		return new AddressesPageUser(getDriver());
	}

	public OrdersPageUser clickOrdersLink() {
		clickToElement(LINK_ORDERS);
		waitUntilPageReady();
		return new OrdersPageUser(getDriver());
	}

	public ChangePasswordPageUser clickChangePasswordLink() {
		clickToElement(LINK_CHANGE_PASSWORD);
		return new ChangePasswordPageUser(getDriver());
	}

	public MyProductReviewPageUser clickMyProductReviewLink() {
		clickToElement(LINK_MY_PRODUCT_REVIEW);
		return new MyProductReviewPageUser(getDriver());
	}

}
