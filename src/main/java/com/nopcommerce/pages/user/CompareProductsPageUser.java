package com.nopcommerce.pages.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompareProductsPageUser extends CommonPageUser {
	private final String COMPARE_PRODUCTS_PAGE_TITLE = "//h1[text()='Compare products']";
	private final String PRODUCT_NAME = "//tr[@class='product-name']//a[text()='%s']";
	private final String PRODUCT_PRICE = "//tr[@class='product-price']//td[text()='%s']";
	private final String CLEAR_LIST_BUTTON = "//a[text()='Clear list']";
	private final String REMOVE_BUTTONS = "//tr[@class='remove-product']//input[@value='Remove']";
	private final String NO_ITEMS_TO_COMPARE_MESSAGE = "//div[@class='no-data' and text()='You have no items to compare.']";

	public CompareProductsPageUser(WebDriver driver) {
		super(driver);
	}

	public void clickClearListButton() {
		clickToElement(CLEAR_LIST_BUTTON);
		waitUntilPageReady();
	}

	public boolean isNoItemsToCompareMessageDisplayed() {
		return isElementDisplayed(NO_ITEMS_TO_COMPARE_MESSAGE);
	}

	public boolean isCompareProductsPageTitleDisplayed() {
		return isElementDisplayed(COMPARE_PRODUCTS_PAGE_TITLE);
	}

	public boolean areRemoveButtonsDisplayed() {
		List<WebElement> removeButtons = findElementsByXpath(REMOVE_BUTTONS);
		boolean status = false;
		for (int i = 0; i < removeButtons.size(); i++) {
			status = removeButtons.get(i).isDisplayed();
			if (status == false)
				break;
		}
		return status;
	}

	public boolean areProductNamesDisplayed(String... productNames) {
		boolean status = false;
		for (int i = 0; i < productNames.length; i++) {
			status = isElementDisplayed(PRODUCT_NAME, productNames[i]);
			if (status == false)
				break;
		}
		return status;
	}

	public boolean areProductPricesDisplayed(String... productPrices) {
		boolean status = false;
		for (int i = 0; i < productPrices.length; i++) {
			status = isElementDisplayed(PRODUCT_PRICE, productPrices[i]);
			if (status == false)
				break;
		}
		return status;
	}
}
