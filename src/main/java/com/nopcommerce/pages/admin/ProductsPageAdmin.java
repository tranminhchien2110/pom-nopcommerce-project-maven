package com.nopcommerce.pages.admin;

import org.openqa.selenium.WebDriver;

public class ProductsPageAdmin extends CommonPageAdmin {
	private final String PAGE_TITLE_PRODUCTS_PAGE = "//h1[contains(text(),'Products')]";
	private final String TEXTBOX_PRODUCT_NAME = "//input[@id='SearchProductName']";
	private final String TEXTBOX_GO_DIRECTLY_TO_SKU = "//input[@id='GoDirectlyToSku']";
	private final String DROPDOWN_LIST_CATEGORY = "//select[@id='SearchCategoryId']";
	private final String DROPDOWN_LIST_MANUFACTURER = "//select[@id='SearchManufacturerId']";
	private final String CHECKBOX_SEARCH_SUBCATEGORIES = "//input[@id='SearchIncludeSubCategories']";

	public ProductsPageAdmin(WebDriver driver) {
		super(driver);
	}

	public static ProductsPageAdmin getProductsPageAdmin(WebDriver driver) {
		return new ProductsPageAdmin(driver);
	}

	public void inputToProductNameTextbox(String inputValue) {
		sendKeysToElement(TEXTBOX_PRODUCT_NAME, inputValue);
	}

	public void inputToGoDirectlyToSKUTextbox(String inputValue) {
		sendKeysToElement(TEXTBOX_GO_DIRECTLY_TO_SKU, inputValue);
	}

	public void checkSearchSubCategoriesCheckbox() {
		checkToCheckbox(CHECKBOX_SEARCH_SUBCATEGORIES);
	}

	public void uncheckSearchSubCategoriesCheckbox() {
		uncheckToCheckbox(CHECKBOX_SEARCH_SUBCATEGORIES);
	}

	public void selectCategoryList(String itemCategory) {
		selectValueInDropdownList(DROPDOWN_LIST_CATEGORY, itemCategory);
	}

	public void selectManufacturerList(String itemManufacturer) {
		selectValueInDropdownList(DROPDOWN_LIST_MANUFACTURER, itemManufacturer);
	}

	public boolean isProductsPageAdminTitleDisplayed() {
		waitUntilPageReady();
		return isElementDisplayed(PAGE_TITLE_PRODUCTS_PAGE);
	}

}
