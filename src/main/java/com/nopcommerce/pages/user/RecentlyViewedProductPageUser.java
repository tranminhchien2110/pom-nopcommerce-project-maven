package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class RecentlyViewedProductPageUser extends CommonPageUser {
	private final String RECENTLY_VIEWED_PRODUCTS_PAGE_TITLE = "//h1[text()='Recently viewed products']";
	
	public RecentlyViewedProductPageUser(WebDriver driver) {
		super(driver);
	}
	
	public boolean isRecentlyViewdProductsPageTitleDisplayed() {
		return isElementDisplayed(RECENTLY_VIEWED_PRODUCTS_PAGE_TITLE);
	}

}
