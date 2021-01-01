package com.nopcommerce.pages.admin;

import org.openqa.selenium.WebDriver;

public class EditAddressPageAdmin extends CommonPageAdmin {
	private final String PAGE_TITLE_EDIT_ADDRESS = "//h1[contains(.,'Edit address')]";
	private final String MESSAGE_EDIT_ADDRESS_SUCCESS = "//div[contains(.,'The address has been updated successfully.') and contains(@class,'alert')]";

	public EditAddressPageAdmin(WebDriver driver) {
		super(driver);
	}

	public static EditAddressPageAdmin getEditAddressPageAdmin(WebDriver driver) {
		return new EditAddressPageAdmin(driver);
	}

	public boolean isEditAddressPageAdminTitleDisplayed() {
		return isElementDisplayed(PAGE_TITLE_EDIT_ADDRESS);
	}

	public boolean isEditAddressSuccessMessageDisplayed() {
		return isElementDisplayed(MESSAGE_EDIT_ADDRESS_SUCCESS);
	}
}
