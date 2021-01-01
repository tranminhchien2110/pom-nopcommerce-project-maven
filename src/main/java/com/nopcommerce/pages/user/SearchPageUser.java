package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class SearchPageUser extends CommonPageUser {
	// Box
	private final String PRICE_FROM_TEXTBOX = "//input[@id='pf']";
	private final String PRICE_TO_TEXTBOX = "//input[@id='pt']";
	private final String SEARCH_TEXTBOX_ON_SEARCH_PAGE = "//input[@id='q']";
	private final String ADVANCE_SEARCH_CHECKBOX = "//input[@id='adv']";
	private final String AUTOMATICALLY_SEARCH_SUB_CATEGORY_CHECKBOX = "//input[@id='isc']";
	// Dropdown list
	private final String CATEGORY_DROPDOWN_LIST = "//select[@id='cid']";
	private final String CATEGORY_ITEM_SELECTED = "//select[@id='cid']//option[@selected and text()='%s']";
	private final String MANUFACTURER_DROPDOWN_LIST = "//select[@id='mid']";
	private final String MANUFACTURER_ITEM_SELECTED = "//select[@id='mid']//option[@selected and text()='%s']";
	// Text
	private final String SEARCH_PAGE_TITLE = "//h1[text()='Search']";
	private final String SEARCH_ERROR_MESSAGE = "//div[@class='warning' and text()='Search term minimum length is 3 characters']";
	private final String PRODUCTS_WERE_NOT_FOUND_MESSAGE = "//div[@class='no-result' and text()='No products were found that matched your criteria.']";
	// Button
	private final String SEARCH_BUTTON_ON_SEARCH_PAGE = "//div[@class='buttons']/input[@value='Search']";
	private final String ADD_TO_COMPARELIST_BUTTON_BY_NAME = "//a[text()='%s']/parent::h2/following-sibling::div//input[@value='Add to compare list']";
	private final String ADD_TO_CART_BUTTON_BY_NAME = "//a[text()='%s']/parent::h2/following-sibling::div//input[@value='Add to cart']";

	public SearchPageUser(WebDriver driver) {
		super(driver);
	}

	public DetailProductPageUser clickAddToCartButtonByProductName(String productName) {
		clickToElement(ADD_TO_CART_BUTTON_BY_NAME, productName);
		waitUntilPageReady();
		return new DetailProductPageUser(getDriver());
	}

	public void clickAddToCompareListButtonByProductName(String productName) {
		clickToElement(ADD_TO_COMPARELIST_BUTTON_BY_NAME, productName);
		waitUntilPageReady();
	}

	public void inputToSearchTextboxOnSearchPage(String text) {
		sendKeysToElement(SEARCH_TEXTBOX_ON_SEARCH_PAGE, text);
	}

	public void selectCategory(String nameItem) {
		selectValueInDropdownList(CATEGORY_DROPDOWN_LIST, nameItem);
	}

	public void selectManufacturer(String manufacturerName) {
		selectValueInDropdownList(MANUFACTURER_DROPDOWN_LIST, manufacturerName);
	}

	public void inputToPriceFromTextbox(String price) {
		sendKeysToElement(PRICE_FROM_TEXTBOX, price);
	}

	public void inputToPriceToTextbox(String price) {
		sendKeysToElement(PRICE_TO_TEXTBOX, price);
	}

	public void checkAdvanceSearchCheckbox() {
		checkToCheckbox(ADVANCE_SEARCH_CHECKBOX);
	}

	public void clickSearchButtonOnSearchPage() {
		clickToElement(SEARCH_BUTTON_ON_SEARCH_PAGE);
	}

	public void uncheckAutomaticallySearchSubCategoryCheckbox() {
		uncheckToCheckbox(AUTOMATICALLY_SEARCH_SUB_CATEGORY_CHECKBOX);
	}

	public void checkAutomaticallySearchSubCategoryCheckbox() {
		checkToCheckbox(AUTOMATICALLY_SEARCH_SUB_CATEGORY_CHECKBOX);
	}

	public boolean isItemManufacturerSelected(String manufacturerName) {
		return isElementDisplayed(MANUFACTURER_ITEM_SELECTED, manufacturerName);
	}

	public boolean isCategoryItemSelected(String nameItem) {
		return isElementDisplayed(CATEGORY_ITEM_SELECTED, nameItem);
	}

	public boolean isProductsWereNotFoundMessageDisplayed() {
		return isElementDisplayed(PRODUCTS_WERE_NOT_FOUND_MESSAGE);
	}

	public boolean isSearchPageTitleDisplayed() {
		return isElementDisplayed(SEARCH_PAGE_TITLE);
	}

	public boolean isSearchErrorMessageDisplayed() {
		return isElementDisplayed(SEARCH_ERROR_MESSAGE);
	}

}
