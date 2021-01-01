package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class CheckoutPageUser extends CommonPageUser {
	private final String PAGE_TITLE_CHECKOUT = "//div[@class='page-title']/h1[text()='Checkout']";
	private final String STEP_TITLE_CHECKOUT_ACTIVE = "//li[contains(@class,'active')]//span[text()='%s']/following-sibling::h2[text()='%s']";
	private final String CHECKBOX_SHIP_TO_SAME_ADDRESS = "//input[@id='ShipToSameAddress']";
	private final String CHECKBOX_GROUND = "//input[@id='shippingoption_0']";
	private final String CHECKBOX_NEXT_DAY_AIR = "//input[@id='shippingoption_1']";
	private final String CHECKBOX_MONEY_ORDER = "//input[@id='paymentmethod_0']";
	private final String CHECKBOX_CREDIT_CARD = "//input[@id='paymentmethod_1']";
	private final String DROPDOWN_LIST_CHECKOUT_ADDRESS = "//li[contains(@class,'active')]//label[contains(text(),'Select')]/parent::div//select";
	private final String DROPDOWN_LIST_CHECKOUT_COUNTRY = "//li[contains(@class,'active')]//label[text()='Country:']/following-sibling::select";
	private final String DROPDOWN_LIST_CHECKOUT_CREDIT_CARD_TYPE = "//select[@id='CreditCardType']";
	private final String DROPDOWN_LIST_CHECKOUT_EXPIRE_MONTH = "//select[@id='ExpireMonth']";
	private final String DROPDOWN_LIST_CHECKOUT_EXPIRE_YEAR = "//select[@id='ExpireYear']";
	private final String TEXTBOX_CHECKOUT_FIRSTNAME = "//li[contains(@class,'active')]//label[text()='First name:']/following-sibling::input";
	private final String TEXTBOX_CHECKOUT_LASTNAME = "//li[contains(@class,'active')]//label[text()='Last name:']/following-sibling::input";
	private final String TEXTBOX_CHECKOUT_EMAIL = "//li[contains(@class,'active')]//label[text()='Email:']/following-sibling::input";
	private final String TEXTBOX_CHECKOUT_CITY = "//li[contains(@class,'active')]//label[text()='City:']/following-sibling::input";
	private final String TEXTBOX_CHECKOUT_ADDRESS_1 = "//li[contains(@class,'active')]//label[text()='Address 1:']/following-sibling::input";
	private final String TEXTBOX_CHECKOUT_ZIP_CODE = "//li[contains(@class,'active')]//label[text()='Zip / postal code:']/following-sibling::input";
	private final String TEXTBOX_CHECKOUT_PHONE_NUMBER = "//li[contains(@class,'active')]//label[text()='Phone number:']/following-sibling::input";
	private final String TEXTBOX_CHECKOUT_CARDHOLDER_NAME = "//li[contains(@class,'active')]//label[text()='Cardholder name:']/parent::td/following-sibling::td/input";
	private final String TEXTBOX_CHECKOUT_CARD_NUMBER = "//li[contains(@class,'active')]//label[text()='Card number:']/parent::td/following-sibling::td/input";
	private final String TEXTBOX_CHECKOUT_CARD_CODE = "//li[contains(@class,'active')]//label[text()='Card code:']/parent::td/following-sibling::td/input";
	private final String METHOD_PAYMENT_MONEY_ORDER = "//label[contains(text(),'Money Order')]";
	private final String METHOD_PAYMENT_CREDIT_CARD = "//label[contains(text(),'Credit Card')]";
	private final String METHOD_SHIPPING_GROUND = "//label[contains(text(),'Ground')]";
	private final String METHOD_SHIPPING_NEXT_DAY_AIR = "//label[contains(text(),'Next Day Air')]";
	private final String CART_TOTAL_SHIPPING_BY_NAME_METHOD_AND_PRICE = "//label[text()='Shipping:']/following-sibling::span[text()='(" + "%s"
			+ ")']/parent::td/following-sibling::td/span[text()='%s']";
	private final String BUTTON_CONTINUE = "//li[contains(@class,'active')]//input[@value='Continue']";
	private final String BUTTON_CONFIRM = "//li[contains(@class,'active')]//input[@value='Confirm']";

	public CheckoutPageUser(WebDriver driver) {
		super(driver);
	}

	public ThankYouPageUser clickToCheckoutCofirmButton() {
		clickToElement(BUTTON_CONFIRM);
		waitUntilPageReady();
		return new ThankYouPageUser(getDriver());
	}

	public void uncheckToCheckoutShipToSameAddressCheckbox() {
		uncheckToCheckbox(CHECKBOX_SHIP_TO_SAME_ADDRESS);
		waitUntilPageReady();
	}

	public void inputToCheckoutFirstNameTextBox(String fistNameValue) {
		sendKeysToElement(TEXTBOX_CHECKOUT_FIRSTNAME, fistNameValue);
	}

	public void inputToCheckoutLastNameTextBox(String lastNameValue) {
		sendKeysToElement(TEXTBOX_CHECKOUT_LASTNAME, lastNameValue);
	}

	public void inputToCheckoutEmailTextBox(String emailValue) {
		sendKeysToElement(TEXTBOX_CHECKOUT_EMAIL, emailValue);
	}

	public void inputToCheckoutCityTextBox(String cityValue) {
		sendKeysToElement(TEXTBOX_CHECKOUT_CITY, cityValue);
	}

	public void inputToCheckoutAddressOneTextBox(String addressOneValue) {
		sendKeysToElement(TEXTBOX_CHECKOUT_ADDRESS_1, addressOneValue);
	}

	public void inputToCheckoutZipCodeTextBox(String zipCodeValue) {
		sendKeysToElement(TEXTBOX_CHECKOUT_ZIP_CODE, zipCodeValue);
	}

	public void inputToCheckoutPhoneNumberTextBox(String phoneNumberValue) {
		sendKeysToElement(TEXTBOX_CHECKOUT_PHONE_NUMBER, phoneNumberValue);
	}

	public void inputToCheckoutCardholderNameTextbox(String cardholderNamevalue) {
		sendKeysToElement(TEXTBOX_CHECKOUT_CARDHOLDER_NAME, cardholderNamevalue);
	}

	public void inputToCheckoutCardNumberTextbox(String cardNumberValue) {
		sendKeysToElement(TEXTBOX_CHECKOUT_CARD_NUMBER, cardNumberValue);
	}

	public void inputToCheckoutCardCodeTextbox(String cardCodeValue) {
		sendKeysToElement(TEXTBOX_CHECKOUT_CARD_CODE, cardCodeValue);
	}

	public void clickToCheckoutContinueButton() {
		clickToElement(BUTTON_CONTINUE);
		waitUntilPageReady();
	}

	public void selectCheckoutCountry(String countryValue) {
		selectValueInDropdownList(DROPDOWN_LIST_CHECKOUT_COUNTRY, countryValue);
	}

	public void selectCheckoutAddress(String addressValue) {
		selectValueInDropdownList(DROPDOWN_LIST_CHECKOUT_ADDRESS, addressValue);
	}

	public void selectCheckoutCreditCardType(String creditCardType) {
		selectValueInDropdownList(DROPDOWN_LIST_CHECKOUT_CREDIT_CARD_TYPE, creditCardType);
	}

	public void selectCheckoutExpireMonth(String expireMonth) {
		selectValueInDropdownList(DROPDOWN_LIST_CHECKOUT_EXPIRE_MONTH, expireMonth);
	}

	public void selectCheckoutExpireYear(String expireYear) {
		selectValueInDropdownList(DROPDOWN_LIST_CHECKOUT_EXPIRE_YEAR, expireYear);
	}

	public void checkToCheckoutGroundCheckbox() {
		checkToCheckbox(CHECKBOX_GROUND);
	}

	public void checkToCheckoutMoneyOrOrderMoneyCheckbox() {
		checkToCheckbox(CHECKBOX_MONEY_ORDER);
	}

	public void checkToCheckoutCreditCardCheckbox() {
		checkToCheckbox(CHECKBOX_CREDIT_CARD);
	}

	public void checkToCheckoutNextDayAirCheckbox() {
		checkToCheckbox(CHECKBOX_NEXT_DAY_AIR);
	}

	public void waitSeveralSecondsBeforePlacingANewOrder() {
		poll(4000);
	}

	public boolean isCheckoutPageTitleDisplayed() {
		return isElementDisplayed(PAGE_TITLE_CHECKOUT);
	}

	public boolean isCheckoutStepTitleDisplayed(String step, String titleOfStep) {
		return isElementDisplayed(STEP_TITLE_CHECKOUT_ACTIVE, step, titleOfStep);
	}

	public boolean isShippingMethodPriceInCartTotalDisplayed(String shippingMethod, String shippingMethodPrice) {
		return isElementDisplayed(CART_TOTAL_SHIPPING_BY_NAME_METHOD_AND_PRICE, shippingMethod, shippingMethodPrice);
	}

	public String getCheckoutShippingMethodGround() {
		return getTextElement(METHOD_SHIPPING_GROUND).replaceAll("[($0.00)]", "").trim();
	}

	public String getCheckoutShippingMethodGroundPrice() {
		String[] groundPrice = getTextElement(METHOD_SHIPPING_GROUND).split(" ");
		return groundPrice[groundPrice.length - 1].replace("(", "").replace(")", "").trim();
	}

	public String getCheckoutPaymentMethodMoneyOrder() {
		return getTextElement(METHOD_PAYMENT_MONEY_ORDER);
	}

	public String getCheckoutPaymentMethodCreditCard() {
		return getTextElement(METHOD_PAYMENT_CREDIT_CARD);
	}

	public String getCheckoutShippingMethodNextDayAir() {
		return getTextElement(METHOD_SHIPPING_NEXT_DAY_AIR).replaceAll("[($0.00)]", "").trim();
	}

	public String getCheckoutShippingMethodNextDayAirPrice() {
		String[] nextDayAirPrice = getTextElement(METHOD_SHIPPING_NEXT_DAY_AIR).split(" ");
		return nextDayAirPrice[nextDayAirPrice.length - 1].replace("(", "").replace(")", "").trim();
	}

}
