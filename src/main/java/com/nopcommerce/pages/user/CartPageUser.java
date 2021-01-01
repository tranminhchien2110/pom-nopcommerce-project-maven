package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class CartPageUser extends CommonPageUser {
	private final String LINK_EDIT = "//a[text()='Edit']";
	private final String CART_PAGE_TITLE = "//div[@class='page-title']/h1[text()='Shopping cart']";
	private final String DROPDOWN_LIST_GIFT_WRAPPING = "//select[@id='checkout_attribute_1']";
	private final String CHECKBOX_TERMS_OF_SERVICE = "//input[@id='termsofservice']";
	private final String CART_EMPTY_MESSAGE = "//div[contains(text(),'Your Shopping Cart is empty!')]";
	private final String CART_TABLE_PRODUCT_QUANTITY_BY_PRODUCTNAME = "//a[text()='%s']/ancestor::td[@class='product']/following-sibling::td[@class='quantity']/input";
	private final String BUTTON_CHECKOUT = "//button[@id='checkout']";

	public CartPageUser(WebDriver driver) {
		super(driver);
	}

	public static CartPageUser getCartPageUser(WebDriver driver) {
		return new CartPageUser(driver);
	}

	public DetailProductPageUser clickEditLink() {
		clickToElement(LINK_EDIT);
		return new DetailProductPageUser(getDriver());
	}

	public CheckoutPageUser clickToCheckoutButton() {
		clickToElement(BUTTON_CHECKOUT);
		waitUntilPageReady();
		return new CheckoutPageUser(getDriver());
	}

	public boolean isCartPageTitleDisplayed() {
		return isElementDisplayed(CART_PAGE_TITLE);
	}

	public boolean isCartEmptyMessageDisplayed() {
		return isElementDisplayed(CART_EMPTY_MESSAGE);
	}

	public void incearseProductQuantityInCartTableByProductname(String productName, String quantityValue) {
		setAttribute(CART_TABLE_PRODUCT_QUANTITY_BY_PRODUCTNAME, "value", quantityValue, productName);
	}

	public void selectGiftWrapping(String itemGiftWrapping) {
		selectValueInDropdownList(DROPDOWN_LIST_GIFT_WRAPPING, itemGiftWrapping);
	}

	public void checkToTermsOfServiceCheckbox() {
		checkToCheckbox(CHECKBOX_TERMS_OF_SERVICE);
	}

}
