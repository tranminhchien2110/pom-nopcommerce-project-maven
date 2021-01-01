package com.nopcommerce.pages.admin;

import org.openqa.selenium.WebDriver;

public class AddNewCustomerPageAdmin extends CommonPageAdmin {
	private final String PAGE_TITLE_ADD_A_NEW_CUSTOMER = "//h1[contains(text(),'Add a new customer')]";
	private final String MESSAGE_ADD_A_NEW_CUSTOMER_SUCCESS = "//div[contains(.,'The new customer has been added successfully.') and contains(@class,'alert')]";

	public AddNewCustomerPageAdmin(WebDriver driver) {
		super(driver);
	}

	public static AddNewCustomerPageAdmin getAddANewCustomerPageAdmin(WebDriver driver) {
		return new AddNewCustomerPageAdmin(driver);
	}

	public boolean isAddANewCustomerPageAdminTitleDisplayed() {
		return isElementDisplayed(PAGE_TITLE_ADD_A_NEW_CUSTOMER);
	}

	public boolean isAddANewCustomerSuccessMessageDisplayed() {
		return isElementDisplayed(MESSAGE_ADD_A_NEW_CUSTOMER_SUCCESS);
	}

}
