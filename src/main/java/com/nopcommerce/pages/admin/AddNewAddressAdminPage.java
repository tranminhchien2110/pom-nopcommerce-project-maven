package com.nopcommerce.pages.admin;

import org.openqa.selenium.WebDriver;

public class AddNewAddressAdminPage extends CommonPageAdmin {
	private final String PAGE_TITLE_ADD_NEW_ADDRESS = "//h1[contains(.,'Add a new address')]";
	private final String MESSAGE_ADD_NEW_ADDRESS_SUCCESS = "//div[contains(.,'The new address has been added successfully.') and contains(@class,'alert')]";

	public AddNewAddressAdminPage(WebDriver driver) {
		super(driver);
	}

	public static AddNewAddressAdminPage getAddNewAddressPageAdmin(WebDriver driver) {
		return new AddNewAddressAdminPage(driver);
	}

	public boolean isAddNewAddressPageAdminTitleDisplayed() {
		return isElementDisplayed(PAGE_TITLE_ADD_NEW_ADDRESS);
	}

	public boolean isAddNewAddressSuccessMessageDisplayed() {
		return isElementDisplayed(MESSAGE_ADD_NEW_ADDRESS_SUCCESS);
	}

}
