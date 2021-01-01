package com.nopcommerce.pages.admin;

import org.openqa.selenium.WebDriver;

public class EditProductDetailsPageAdmin extends CommonPageAdmin {
	private final String PAGE_TITLE_EDIT_PRODUCT_DETAILS_PAGE_BY_PRODUCT_NAME = "//h1[contains(text(),'Edit product details - %s')]";

	public EditProductDetailsPageAdmin(WebDriver driver) {
		super(driver);
	}

	public static EditProductDetailsPageAdmin getEditProductDetailsPageAdmin(WebDriver driver) {
		return new EditProductDetailsPageAdmin(driver);
	}

	public boolean isEditProductDetailsPageAdminTitleDisplayed(String productName) {
		waitUntilPageReady();
		return isElementDisplayed(PAGE_TITLE_EDIT_PRODUCT_DETAILS_PAGE_BY_PRODUCT_NAME, productName);
	}
}
