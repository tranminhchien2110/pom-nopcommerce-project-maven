package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class WishListPageUser extends CommonPageUser {
	private final String WISHLIST_PAGE_TITLE = "//div[@class='page-title']/h1[text()='%s']";
	private final String ADD_TO_CART_CHECKBOX = "//input[@name='addtocart']";
	private final String WISHLIST_EMPTY_MESSAGE = "//div[contains(text(),'The wishlist is empty!')]";
	private final String SHARING_LINK_IN_WISHLIST = "//span[@class='share-label']/following-sibling::a";

	public WishListPageUser(WebDriver driver) {
		super(driver);
	}

	public void clickSharingLink() {
		clickToElement(SHARING_LINK_IN_WISHLIST);
		waitUntilPageReady();
	}

	public void checkAddToCartCheckbox() {
		checkToCheckbox(ADD_TO_CART_CHECKBOX);
	}

	public boolean isWishlistPageTitleDisplayed(String wishlistPageTitle) {
		return isElementDisplayed(WISHLIST_PAGE_TITLE, wishlistPageTitle);
	}

	public boolean isWishlistEmptyMessageDisplayed() {
		return isElementDisplayed(WISHLIST_EMPTY_MESSAGE);
	}

}
