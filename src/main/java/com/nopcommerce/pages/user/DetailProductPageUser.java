package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class DetailProductPageUser extends CommonPageUser {
	// Link
	private final String ADD_YOUR_REVIEW_LINK = "//a[text()='Add your review']";
	// Box
	private final String CHECKBOX_BY_NAME = "//label[text()='%s']/preceding-sibling::input";
	private final String PRODUCT_QUANTITY = "//input[contains(@class,'qty-input')]";
	private final String PRODUCT_PRICE = "//div[@class='product-price']/span";
	private final String PRODUCT_SKU = "//div[@class='sku']/span[@class='value']";
	// Dropdown list
	private final String DROPDOWN_LIST_PROCESSOR = "//select[@id='product_attribute_1']";
	private final String DROPDOWN_LIST_RAM = "//select[@id='product_attribute_2']";
	// Message
	private final String PRODUCT_NAME_AND_PAGE_TITLE = "//div[@class='product-name']//h1";
	// Button
	private final String ADD_TO_WISHLIST_BUTTON = "//div[@class='add-to-wishlist']/input";
	private final String UPDATE_BUTTON = "//input[@id='add-to-cart-button-1']";

	public DetailProductPageUser(WebDriver driver) {
		super(driver);
	}

	public ReviewProductPageUser clickAddYourReviewLink() {
		clickToElement(ADD_YOUR_REVIEW_LINK);
		return new ReviewProductPageUser(getDriver());
	}

	public SearchPageUser backToSearchPageUser() {
		navigateBack();
		waitUntilPageReady();
		return new SearchPageUser(getDriver());
	}

	public void clickAddToWishListButton() {
		clickToElement(ADD_TO_WISHLIST_BUTTON);
		waitUntilPageReady();
	}

	public void selectProcessor(String valueSelect) {
		selectValueInDropdownList(DROPDOWN_LIST_PROCESSOR, valueSelect);
		waitUntilPageReady();
	}

	public void selectRam(String valueSelect) {
		selectValueInDropdownList(DROPDOWN_LIST_RAM, valueSelect);
		waitUntilPageReady();
	}

	public void checkToCheckboxByNameBox(String nameBox) {
		checkToCheckbox(CHECKBOX_BY_NAME, nameBox);
		waitUntilPageReady();
	}

	public void uncheckToCheckboxByNameBox(String nameBox) {
		uncheckToCheckbox(CHECKBOX_BY_NAME, nameBox);
		waitUntilPageReady();
	}

	public void increaseProductQuantity(String quantityValue) {
		setAttribute(PRODUCT_QUANTITY, "value", quantityValue);
	}

	public void clickUpdateButton() {
		clickToElement(UPDATE_BUTTON);
		waitUntilPageReady();
	}

	public boolean isDetailProductPageTitleDisplayed() {
		return isElementDisplayed(PRODUCT_NAME_AND_PAGE_TITLE);
	}

	public String getQuantityValue() {
		return getAttributeElement(PRODUCT_QUANTITY, "value");
	}

	public String getProductName() {
		return getTextElement(PRODUCT_NAME_AND_PAGE_TITLE);
	}
	
	public String getPriceValue() {
		waitUntilPageReady();
		return getTextElement(PRODUCT_PRICE);
	}

	public String getSKUValue() {
		return getTextElement(PRODUCT_SKU);
	}

}
