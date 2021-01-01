package com.nopcommerce.pages.admin;

import org.openqa.selenium.WebDriver;

public class EditCustomerDetailsPageAdmin extends CommonPageAdmin {
	private final String PAGE_TITLE_EDIT_CUSTOMER_DETAILS = "//h1[contains(text(),'Edit customer details')]";
	private final String MESSAGE_EDIT_CUSTOMER_SUCCESS = "//div[contains(.,'The customer has been updated successfully.') and contains(@class,'alert')]";
	private final String BUTTON_ADD_NEW_ADDRESS = "//button[contains(.,'Add new address')]";

	public EditCustomerDetailsPageAdmin(WebDriver driver) {
		super(driver);
	}

	public static EditCustomerDetailsPageAdmin getEditCustomerDetailsPageAdmin(WebDriver driver) {
		return new EditCustomerDetailsPageAdmin(driver);
	}

	public AddNewAddressAdminPage clickAddNewButtonAddress() {
		clickToElement(BUTTON_ADD_NEW_ADDRESS);
		waitUntilPageReady();
		return new AddNewAddressAdminPage(getDriver());
	}

	public boolean isEditCustomerDetailsPageAdminTitleDisplayed() {
		waitUntilPageReady();
		return isElementDisplayed(PAGE_TITLE_EDIT_CUSTOMER_DETAILS);
	}

	public boolean isEditCustomerSuccessMessageDisplayed() {
		return isElementDisplayed(MESSAGE_EDIT_CUSTOMER_SUCCESS);
	}



}
