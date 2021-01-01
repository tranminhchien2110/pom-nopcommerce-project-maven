package com.nopcommerce.pages.user;

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nopcommerce.base.BasePage;

public class CommonPageUser extends BasePage {
	// Link
	private final String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
	private final String HOME_PAGE_LINK = "//div[@class='header-logo']/a";
	private final String LOG_OUT_LINK = "//a[@class='ico-logout']";
	private final String COMPUTERS_LINK = "//a[text()='Computers ']";
	private final String LOGIN_LINK = "//a[@class='ico-login']";
	private final String REGISTER_LINK = "//a[@class='ico-register']";
	private final String WISHLIST_LINK = "//a[@class='ico-wishlist']";
	private final String SHOPPING_CART_LINK = "//a[@class='ico-cart']";
	private final String COMPARE_PRODUCTS_LINK = "//a[text()='Compare products list']";
	private final String RECENTLY_VIEWED_PRODUCT_LINK = "//a[text()='Recently viewed products']";
	private final String SEARCH_LINK_ON_FOOTER = "//a[text()='Search']";
	// Box
	private final String SEARCH_TEXTBOX = "//input[@id='small-searchterms']";
	private final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
	private final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
	private final String EMAIL_TEXTBOX = "//input[@id='Email']";
	private final String COMPANYNAME_TEXTBOX = "//input[@id='Company']";
	private final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	private final String REMOVE_FROM_CART_CHECKBOX = "//a[text()='%s']/parent::td[@class='product']/preceding-sibling::td//input[@name='removefromcart']";
	private final String GENDER_MALE_SELECT = "//input[@id='gender-male']";
	private final String CURRENT_PAGE = "//li[@class='current-page']/span[text()='%s']";
	private final String NEXT_ICON = "//a[text()='Next']";
	private final String PREVIOUS_ICON = "//a[text()='Previous']";
	// Dropdown list
	private final String DOB_DAY = "//select[@name='DateOfBirthDay']";
	private final String DOB_MONTH = "//select[@name='DateOfBirthMonth']";
	private final String DOB_YEAR = "//select[@name='DateOfBirthYear']";
	private final String DISPLAY_DROPDOWN_LIST = "//select[@id='products-pagesize']";
	private final String DISPLAY_ITEM_SELECTED = "//select[@id='products-pagesize']//option[@selected and text()='%s']";
	private final String SORT_BY_DROPDOWN_LIST = "//select[@id='products-orderby']";
	private final String SORT_BY_ITEM_SELECTED = "//select[@id='products-orderby']//option[@selected and text()='%s']";
	// Text
	private final String PRODUCT_NAME_IN_ITEMBOX = "//div[@class='item-box']//h2//a";
	private final String PRODUCT_PRICE_IN_ITEMBOX = "//div[@class='item-box']//div[@class='prices']/span";
	private final String CART_TABLE_PRODUCT_NAME = "//td[@class='product']//a[text()='%s']";
	private final String CART_TABLE_PRODUCT_SKU = "//a[text()='%s']/preceding::td[@class='sku']/span[text()='%s']";
	private final String CART_TABLE_PRODUCT_ATTRIBUTES = "//a[text()='%s']/following-sibling::div[@class='attributes']";
	private final String CART_TABLE_PRODUCT_UNIT_PRICE = "//a[text()='%s']/ancestor::td[@class='product']/following-sibling::td[@class='unit-price']/span[text()='%s']";
	private final String CART_TABLE_PRODUCT_TOTAL_PRICE = "//a[text()='%s']/ancestor::td[@class='product']/following-sibling::td[contains(@class,'total')]/span[text()='%s']";
	private final String CART_TABLE_PRODUCT_QUANTITY = "//a[text()='%s']/ancestor::td[@class='product']/following-sibling::td[@class='quantity']/input[@value='%s']";
	private final String CART_TABLE_PRODUCT_QUANTITY_CHECKOUT = "//a[text()='%s']/ancestor::td[@class='product']/following-sibling::td[@class='quantity']/span[text()='%s']";
	private final String REVIEW_TITLE_COMMENT = "//div[@class='review-title']/strong[text()='%s']";
	private final String REVIEW_TEXT_COMMENT = "//div[contains(text(),'%s')]";
	private final String REVIEW_PRODUCT_COMMENT = "//div[contains(text(),'%s')]/following-sibling::div//a[text()='%s']";
	// Mini shopping cart
	private final String MINI_SHOPPING_CART_PRODUCT_AMOUNT = "//div[@class='count']/a[text()='%s item(s)']";
	private final String MINI_SHOPPING_CART_PRODUCT_NAME = "//div[@class='name']/a[text()='%s']";
	private final String MINI_SHOPPING_CART_PRODUCT_ATTRIBUTES = "//div[@class='name']/a[text()='%s']/parent::div/following-sibling::div[@class='attributes']";
	private final String MINI_SHOPPING_CART_PRODUCT_PRICE = "//div[@class='name']/a[text()='%s']/parent::div/following-sibling::div[@class='price']/span[text()='%s']";
	private final String MINI_SHOPPING_CART_PRODUCT_QUANTITY = "//div[@class='name']/a[text()='%s']/parent::div/following-sibling::div[@class='quantity']/span[text()='%s']";
	private final String MINI_SHOPPING_CART_PRODUCT_TOTAL_PRICE = "//div[@class='totals']/strong[text()='%s']";
	// Cart total
	private final String CART_TOTAL_SUB_TOTAL_PRICE = "//label[text()='Sub-Total:']/parent::td/following-sibling::td/span[text()='%s']";
	private final String CART_TOTAL_SHIPPING_PRICE = "//label[text()='Shipping:']/parent::td/following-sibling::td/span[text()='%s']";
	private final String CART_TOTAL_TAX = "//label[text()='Tax:']/parent::td/following-sibling::td/span[text()='%s']";
	private final String CART_TOTAL_TOTAL_PRICE = "//label[contains(text(),'Total:')]/parent::td/following-sibling::td//strong[text()='%s']";
	private final String CART_TOTAL_EARN_REWARD_POINTS = "//tr[@class='earn-reward-points']//span[text()='%s']";
	// Checkout (Order)
	private final String INFO_LIST_BILLING_ADDRESS = "//strong[text()='Billing Address']/parent::div/following-sibling::ul[@class='info-list']";
	private final String INFO_LIST_SHIPPING_ADDRESS = "//strong[text()='Shipping Address']/parent::div/following-sibling::ul[@class='info-list']";
	private final String METHOD_PAYMENT_BY_NAME_METHOD = "//span[contains(text(),'Payment Method:')]/parent::li/span[contains(text(),'%s')]";
	private final String METHOD_SHIPPING_BY_NAME_METHOD = "//span[contains(text(),'Shipping Method:')]/parent::li/span[contains(text(),'%s')]";
	private final String STATUS_PAYMENT_BY_NAME_METHOD = "//span[contains(text(),'Payment Status:')]/parent::li/span[contains(text(),'%s')]";
	private final String STATUS_SHIPPING_BY_NAME_METHOD = "//span[contains(text(),'Shipping Status:')]/parent::li/span[contains(text(),'%s')]";
	// Message
	private final String EMAIL_ERROR_MESSAGE = "//span[@id='Email-error']";
	private final String ERROR_MESSAGE = "//div[contains(@class,'message-error')]";
	private final String ERROR_MESSAGE_REASON = "//div[contains(@class,'message-error')]//li";
	private final String ADD_TO_WISHLIST_SUCCESS_MESSAGE = "//p[@class='content' and text()='The product has been added to your ']/a[text()='wishlist']";
	private final String ADD_TO_COMPARELIST_SUCCESS_MESSAGE = "//p[@class='content' and text()='The product has been added to your ']/a[text()='product comparison']";
	private final String ADD_TO_SHOPPING_CART_SUCCESS_MESSAGE = "//p[@class='content' and text()='The product has been added to your ']/a[text()='shopping cart']";
	private final String MESSAGE_GIFT_WARPPING_BY_NAME_SELECTED = "//div[contains(text(),'Gift wrapping: %s')]";
	// Button
	private final String SEARCH_BUTTON = "//input[contains(@class,'search-box-button')]";
	private final String CLOSE_SUCCESS_MESSAGE_BUTTON = "//span[@class='close']";
	private final String UPDATE_CART_BUTTON = "//input[@name='updatecart']";
	private final String ADD_TO_CART_BUTTON = "//input[@value='Add to cart']";

	public CommonPageUser(WebDriver driver) {
		super(driver);
	}

	public HomePageUser clickHomePageLink() {
		clickToElement(HOME_PAGE_LINK);
		waitUntilPageReady();
		return new HomePageUser(getDriver());
	}

	public MyAccountPageUser clickMyAccountLink() {
		clickToElement(MY_ACCOUNT_LINK);
		return new MyAccountPageUser(getDriver());
	}

	public HomePageUser clickLogOutLink() {
		clickToElement(LOG_OUT_LINK);
		return new HomePageUser(getDriver());
	}

	public SearchPageUser clickToSearchButton() {
		clickToElement(SEARCH_BUTTON);
		return new SearchPageUser(getDriver());
	}

	public DetailProductPageUser clickToProductByIndex(int index) {
		findElementsByXpath(PRODUCT_NAME_IN_ITEMBOX).get(index).click();
		return new DetailProductPageUser(getDriver());
	}

	public SearchPageUser clickToSearchLinkOnFooter() {
		clickToElement(SEARCH_LINK_ON_FOOTER);
		return new SearchPageUser(getDriver());
	}

	public ComputersPageUser clickComputersLink() {
		clickToElement(COMPUTERS_LINK);
		return new ComputersPageUser(getDriver());
	}

	public LoginPageUser clickLoginLink() {
		clickToElement(LOGIN_LINK);
		return new LoginPageUser(getDriver());
	}

	public RegisterPageUser clickRegisterLink() {
		clickToElement(REGISTER_LINK);
		return new RegisterPageUser(getDriver());
	}

	public WishListPageUser clickWishlistLink() {
		clickToElement(WISHLIST_LINK);
		waitUntilPageReady();
		return new WishListPageUser(getDriver());
	}

	public CompareProductsPageUser clickCompareProductsLink() {
		clickToElement(COMPARE_PRODUCTS_LINK);
		waitUntilPageReady();
		return new CompareProductsPageUser(getDriver());
	}

	public RecentlyViewedProductPageUser clickRecentlyViewedProductsLink() {
		clickToElement(RECENTLY_VIEWED_PRODUCT_LINK);
		return new RecentlyViewedProductPageUser(getDriver());
	}

	public CartPageUser clickShoppingCartLink() {
		clickToElement(SHOPPING_CART_LINK);
		waitUntilPageReady();
		return new CartPageUser(getDriver());
	}

	public void waitUntilPageReady() {
		waitUntilJSReady();
		ajaxComplete();
		waitUntilJQueryReady();
	}

	public void inputToSearchTextbox(String data) {
		sendKeysToElement(SEARCH_TEXTBOX, data);
	}

	public void inputToFirstNameTextbox(String data) {
		sendKeysToElement(FIRSTNAME_TEXTBOX, data);
	}

	public void inputToLastNameTextbox(String data) {
		sendKeysToElement(LASTNAME_TEXTBOX, data);
	}

	public void inputToEmailTextbox(String data) {
		sendKeysToElement(EMAIL_TEXTBOX, data);
	}

	public void inputToPasswordTextbox(String data) {
		sendKeysToElement(PASSWORD_TEXTBOX, data);
	}

	public void inputToCompanyNameTextbox(String data) {
		sendKeysToElement(COMPANYNAME_TEXTBOX, data);
	}

	public void selectMaleGender() {
		checkToCheckbox(GENDER_MALE_SELECT);
	}

	public void selectDay(String data) {
		selectValueInDropdownList(DOB_DAY, data);
	}

	public void selectMonth(String data) {
		selectValueInDropdownList(DOB_MONTH, data);
	}

	public void selectYear(String data) {
		selectValueInDropdownList(DOB_YEAR, data);
	}

	public void selectSortBy(String typeSort) {
		selectValueInDropdownList(SORT_BY_DROPDOWN_LIST, typeSort);
	}

	public void selectDisplay(int typeDisplay) {
		selectValueInDropdownList(DISPLAY_DROPDOWN_LIST, String.valueOf(typeDisplay));
	}

	public void checkRemoveFromCartCheckboxByProductName(String productName) {
		checkToCheckbox(REMOVE_FROM_CART_CHECKBOX, productName);
	}

	public void clickToNextPage() {
		clickToElement(NEXT_ICON);
	}

	public void clickAddToCartButton() {
		clickToElement(ADD_TO_CART_BUTTON);
		waitUntilPageReady();
	}

	public void clickUpdateCartButton() {
		clickToElement(UPDATE_CART_BUTTON);
		waitUntilPageReady();
	}

	public void clickCloseSuccessMessage() {
		clickToElement(CLOSE_SUCCESS_MESSAGE_BUTTON);
	}

	public void waitAddToWishlistSuccessMessageDisappear() {
		waitForElementsStaleness(ADD_TO_WISHLIST_SUCCESS_MESSAGE);
	}

	public void waitAddToComparelistSuccessMessageDisappear() {
		waitForElementsStaleness(ADD_TO_COMPARELIST_SUCCESS_MESSAGE);
	}

	public void waitAddToShoppingCartSuccessMessageDisappear() {
		waitForElementsStaleness(ADD_TO_SHOPPING_CART_SUCCESS_MESSAGE);
	}

	public void hoverToShoppingCartLink() {
		hoverToElement(SHOPPING_CART_LINK);
	}

	public boolean isEmailErrorMessageDisplayed() {
		return isElementDisplayed(EMAIL_ERROR_MESSAGE);
	}

	public boolean isErrorMessageDisplayed() {
		return isElementDisplayed(ERROR_MESSAGE);
	}

	public boolean isErrorMessageReasonDisplayed() {
		return isElementDisplayed(ERROR_MESSAGE_REASON);
	}

	public boolean isErrorMessageReasonUndisplayed() {
		return isElementUndisplayed(ERROR_MESSAGE_REASON);
	}

	public boolean isMyAccountLinkDisplayed() {
		return isElementDisplayed(MY_ACCOUNT_LINK);
	}

	public boolean isLogOutLinkDisplayed() {
		return isElementDisplayed(LOG_OUT_LINK);
	}

	public boolean isReviewCommentDisplayed(String reviewTitle, String reviewText) {
		return isElementDisplayed(REVIEW_TITLE_COMMENT, reviewTitle) && isElementDisplayed(REVIEW_TEXT_COMMENT, reviewText);
	}

	public boolean isReviewCommentDisplayed(String reviewTitle, String reviewText, String productName) {
		return isElementDisplayed(REVIEW_TITLE_COMMENT, reviewTitle) && isElementDisplayed(REVIEW_TEXT_COMMENT, reviewText) && isElementDisplayed(REVIEW_PRODUCT_COMMENT, reviewText, productName);
	}

	public boolean areAllProductNameDisplayed() {
		List<WebElement> count = findElementsByXpath(PRODUCT_NAME_IN_ITEMBOX);
		boolean status = true;
		for (int i = 0; i < count.size(); i++) {
			if (!count.get(i).isDisplayed())
				status = false;
		}
		return status;
	}

	public boolean isNameSortedAscending() {
		return isDataSortedAscending(PRODUCT_NAME_IN_ITEMBOX);
	}

	public boolean isNameSortedDescending() {
		return isDataSortedDescending(PRODUCT_NAME_IN_ITEMBOX);
	}

	public boolean isPriceSortedAscending() {
		return isDataSortedAscending(PRODUCT_PRICE_IN_ITEMBOX);
	}

	public boolean isPriceSortedDescending() {
		return isDataSortedDescending(PRODUCT_PRICE_IN_ITEMBOX);
	}

	public boolean isSortItemSelected(String sortItem) {
		return isElementDisplayed(SORT_BY_ITEM_SELECTED, sortItem);
	}

	public boolean isDisplayItemSelected(int typeDisplay) {
		return isElementDisplayed(DISPLAY_ITEM_SELECTED, String.valueOf(typeDisplay));
	}

	public boolean isCurrentPageDisplayed(int currentPage) {
		return isElementDisplayed(CURRENT_PAGE, String.valueOf(currentPage));
	}

	public boolean isCurrentPageUndisplayed(int currentPage) {
		return isElementUndisplayed(CURRENT_PAGE, String.valueOf(currentPage));
	}

	public boolean isNextIconDisplayed() {
		return isElementDisplayed(NEXT_ICON);
	}

	public boolean isPreviousIconDisplayed() {
		return isElementDisplayed(PREVIOUS_ICON);
	}

	public boolean isProductNameInCartTableDisplayed(String productName) {
		return isElementDisplayed(CART_TABLE_PRODUCT_NAME, productName);
	}

	public boolean isProductNameInCartTableUndisplayed(String productName) {
		return isElementUndisplayed(CART_TABLE_PRODUCT_NAME, productName);
	}

	public boolean isProductSKUInCartTableDisplayedByProductName(String productName, String productSKU) {
		return isElementDisplayed(CART_TABLE_PRODUCT_SKU, productName, productSKU);
	}

	public boolean isProductPriceInCartTableDisplayedByProductName(String productName, String productPrice) {
		return isElementDisplayed(CART_TABLE_PRODUCT_UNIT_PRICE, productName, productPrice);
	}

	public boolean isProductPriceInCartTableUndisplayedByProductName(String productName, String productPrice) {
		return isElementUndisplayed(CART_TABLE_PRODUCT_UNIT_PRICE, productName, productPrice);
	}

	public boolean isProductQuantityInCartTableDisplayedByProductName(String productName, String productQuantity) {
		return isElementDisplayed(CART_TABLE_PRODUCT_QUANTITY, productName, productQuantity);
	}

	public boolean isProductQuantityInCartTableCheckoutDisplayedByProductName(String productName, String productQuantity) {
		return isElementDisplayed(CART_TABLE_PRODUCT_QUANTITY_CHECKOUT, productName, productQuantity);
	}

	public boolean isProductTotalPriceInCartTableDisplayedByProductName(String productName, String productTotalPrice) {
		return isElementDisplayed(CART_TABLE_PRODUCT_TOTAL_PRICE, productName, productTotalPrice);
	}

	public boolean isAddToWishlistSuccessMessageDisplayed() {
		return isElementDisplayed(ADD_TO_WISHLIST_SUCCESS_MESSAGE);
	}

	public boolean isAddToComparelistSuccessMessageDisplayed() {
		return isElementDisplayed(ADD_TO_COMPARELIST_SUCCESS_MESSAGE);
	}

	public boolean isAddToShoppingCartSuccessMessageDisplayed() {
		return isElementDisplayed(ADD_TO_SHOPPING_CART_SUCCESS_MESSAGE);
	}

	public boolean isAmountProductDisplayedInMiniShoppingCart(String amountExptected) {
		return isElementDisplayed(MINI_SHOPPING_CART_PRODUCT_AMOUNT, amountExptected);
	}

	public boolean isNameDisplayedInMiniShoppingCart(String productName) {
		return isElementDisplayed(MINI_SHOPPING_CART_PRODUCT_NAME, productName);
	}

	public boolean isAttributesDisplayedInMiniShoppingCartByProductName(String productName) {
		return isElementDisplayed(MINI_SHOPPING_CART_PRODUCT_ATTRIBUTES, productName);
	}

	public boolean isAttributesDisplayedInCartTableByProductName(String productName) {
		return isElementDisplayed(CART_TABLE_PRODUCT_ATTRIBUTES, productName);
	}

	public boolean isPriceDisplayedInMiniShoppingCartByProductName(String productName, String productPrice) {
		return isElementDisplayed(MINI_SHOPPING_CART_PRODUCT_PRICE, productName, productPrice);
	}

	public boolean isQuantityDisplayedInMiniShoppingCartByProductName(String productName, String productQuantity) {
		return isElementDisplayed(MINI_SHOPPING_CART_PRODUCT_QUANTITY, productName, productQuantity);
	}

	public boolean isTotalPriceDisplayedInMiniShoppingCart(String productToalPrice) {
		return isElementDisplayed(MINI_SHOPPING_CART_PRODUCT_TOTAL_PRICE, productToalPrice);
	}

	public boolean isSubTotalPriceInCartTotalDisplayed(String subTotalPrice) {
		return isElementDisplayed(CART_TOTAL_SUB_TOTAL_PRICE, subTotalPrice);
	}

	public boolean isShippingPriceInCartTotalDisplayed(String shippingPrice) {
		return isElementDisplayed(CART_TOTAL_SHIPPING_PRICE, shippingPrice);
	}

	public boolean isTaxPriceInCartTotalDisplayed(String taxPrice) {
		return isElementDisplayed(CART_TOTAL_TAX, taxPrice);
	}

	public boolean isTotalPriceInCartTotalDisplayed(String totalPrice) {
		return isElementDisplayed(CART_TOTAL_TOTAL_PRICE, totalPrice);
	}

	public boolean isEarnPointsRewardInCartTotalDisplayed(String pointsReward) {
		return isElementDisplayed(CART_TOTAL_EARN_REWARD_POINTS, pointsReward);
	}

	public boolean isCheckoutBillingAddressInfoListDisplayed() {
		return isElementDisplayed(INFO_LIST_BILLING_ADDRESS);
	}

	public boolean isCheckoutShippingAddressInfoListDisplayed() {
		return isElementDisplayed(INFO_LIST_SHIPPING_ADDRESS);
	}

	public boolean isCheckoutPaymentMethodDisplayed(String methodPayment) {
		return isElementDisplayed(METHOD_PAYMENT_BY_NAME_METHOD, methodPayment);
	}

	public boolean isCheckoutShippingMethodDisplayed(String methodShipping) {
		return isElementDisplayed(METHOD_SHIPPING_BY_NAME_METHOD, methodShipping);
	}

	public boolean isCheckoutPaymentStatusDisplayed(String statusPayment) {
		return isElementDisplayed(STATUS_PAYMENT_BY_NAME_METHOD, statusPayment);
	}

	public boolean isCheckoutShippingStatusDisplayed(String statusShipping) {
		return isElementDisplayed(STATUS_SHIPPING_BY_NAME_METHOD, statusShipping);
	}

	public boolean isCheckoutGiftWrappingMessageDisplayed(String itemGiftWrapping) {
		return isElementDisplayed(MESSAGE_GIFT_WARPPING_BY_NAME_SELECTED, itemGiftWrapping);
	}

	public String getEmailErrorMessage() {
		return getTextElement(EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessage() {
		return getTextElement(ERROR_MESSAGE);
	}

	public String getErrorMessageReason() {
		return getTextElement(ERROR_MESSAGE_REASON);
	}

	public String getProductNameByIndex(int index) {
		return findElementsByXpath(PRODUCT_NAME_IN_ITEMBOX).get(index).getText();
	}

	public String getProductPriceByIndex(int index) {
		return findElementsByXpath(PRODUCT_PRICE_IN_ITEMBOX).get(index).getText();
	}

	public String getAttributesInMiniShoppingCartByProductName(String productName) {
		return getTextElement(MINI_SHOPPING_CART_PRODUCT_ATTRIBUTES, productName).replaceAll("[\\r\\n]", "");
	}

	public String getAttributesInCartTableByProductName(String productName) {
		return getTextElement(CART_TABLE_PRODUCT_ATTRIBUTES, productName).replaceAll("[\\r\\n]", "");
	}

	public String getCheckoutBillingAddressInfoList() {
		return getTextElement(INFO_LIST_BILLING_ADDRESS).replaceAll("[\\r\\n]", "");
	}

	public String getCheckoutShippingAddressInfoList() {
		return getTextElement(INFO_LIST_SHIPPING_ADDRESS).replaceAll("[\\r\\n]", "");
	}

	public String countTotalPriceWithProductQuantity(String productPrice, String productQuantity) {
		String productPriceRemoved = productPrice.replaceAll("[$,]", "");
		double totalPrice = Double.parseDouble(productPriceRemoved) * Double.parseDouble(productQuantity);
		DecimalFormat f = new DecimalFormat("##.00");
		f.setGroupingUsed(true);
		f.setGroupingSize(3);
		return "$" + f.format(totalPrice);
	}

	public String countTotalPriceWithProductShippingAndTaxPrice(String productSubTotalPrice, String productShippingPrice, String productTaxPrice) {
		String productSubTotalPriceRemoved = productSubTotalPrice.replaceAll("[$,]", "");
		String productShippingPriceRemoved = productShippingPrice.replaceAll("[$,]", "");
		String productTaxPriceRemoved = productTaxPrice.replaceAll("[$,]", "");
		double totalPrice = Double.parseDouble(productSubTotalPriceRemoved) - (Double.parseDouble(productShippingPriceRemoved) + Double.parseDouble(productTaxPriceRemoved));
		DecimalFormat f = new DecimalFormat("##.00");
		f.setGroupingUsed(true);
		f.setGroupingSize(3);
		return "$" + f.format(totalPrice);
	}

	public String countPointsRewardWithProductTotalPrice(String productTotalPrice) {
		String productPriceRemoved = productTotalPrice.replaceAll("[$,.]", "");
		return (Integer.parseInt(productPriceRemoved) / 1000) + " points";
	}

}
