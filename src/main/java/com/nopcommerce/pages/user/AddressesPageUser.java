package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class AddressesPageUser extends CommonPageUser {
	private final String ADDRESSES_PAGE_TITLE = "//h1[text()='My account - Addresses']";
	private final String ADD_NEW_BUTTON = "//input[@value='Add new']";
	private final String SAVE_BUTTON = "//input[contains(@class,'save-address-button')]";
	private final String ADD_NEW_ADDRESS_PAGE_TITLE = "//h1[text()='My account - Add new address']";
	private final String ADDRESS_FIRSTNAME_TEXTBOX = "//input[@id='Address_FirstName']";
	private final String ADDRESS_LASTNAME_TEXTBOX = "//input[@id='Address_LastName']";
	private final String ADDRESS_EMAIL_TEXTBOX = "//input[@id='Address_Email']";
	private final String ADDRESS_COUNTRY_DROPDOWN_LIST = "//select[@id='Address_CountryId']";
	private final String ADDRESS_CITY_TEXTBOX = "//input[@id='Address_City']";
	private final String ADDRESS_ADDRESS1_TEXTBOX = "//input[@id='Address_Address1']";
	private final String ADDRESS_ZIP_CODE_TEXTBOX = "//input[@id='Address_ZipPostalCode']";
	private final String ADDRESS_PHONE_NUMBER_TEXTBOX = "//input[@id='Address_PhoneNumber']";
	private final String ADDRESS_FAX_NUMBER_TEXTBOX = "//input[@id='Address_FaxNumber']";
	private final String ADDRESS_INFOR = "//strong[text()='%s']";
	private final String ADDRESS_NAME = "//li[text()='%s' and @class='name']";
	private final String ADDRESS_EMAIL = "//li[text()='%s' and @class='email']";
	private final String ADDRESS_PHONE = "//li[text()=' %s' and @class='phone']";
	private final String ADDRESS_FAX = "//li[text()=' %s' and @class='fax']";
	private final String ADDRESS_ADDRESS1 = "//li[text()='%s' and @class='address1']";
	private final String ADDRESS_CITY_STATE_ZIP = "//li[text()='%s' and @class='city-state-zip']";
	private final String ADDRESS_COUNTRY = "//li[text()='%s' and @class='country']";

	public AddressesPageUser(WebDriver driver) {
		super(driver);
	}

	public void clickAddNewButton() {
		clickToElement(ADD_NEW_BUTTON);
	}

	public void clickSaveButton() {
		clickToElement(SAVE_BUTTON);
	}

	public void inputToAddressFirstNameTextBox(String firstNameValue) {
		sendKeysToElement(ADDRESS_FIRSTNAME_TEXTBOX, firstNameValue);
	}

	public void inputToAddressLastNameTextBox(String lastNameValue) {
		sendKeysToElement(ADDRESS_LASTNAME_TEXTBOX, lastNameValue);
	}

	public void inputToAddressEmailTextBox(String emailValue) {
		sendKeysToElement(ADDRESS_EMAIL_TEXTBOX, emailValue);
	}

	public void selectAddressCountry(String countryValue) {
		selectValueInDropdownList(ADDRESS_COUNTRY_DROPDOWN_LIST, countryValue);
	}

	public void inputToAddressCityTextBox(String cityValue) {
		sendKeysToElement(ADDRESS_CITY_TEXTBOX, cityValue);
	}

	public void inputToAddressAddress1TextBox(String address1Value) {
		sendKeysToElement(ADDRESS_ADDRESS1_TEXTBOX, address1Value);
	}

	public void inputToAddressZipCodeTextBox(String zipCodeValue) {
		sendKeysToElement(ADDRESS_ZIP_CODE_TEXTBOX, zipCodeValue);
	}

	public void inputToAddressPhoneNumberTextBox(String phoneNumberValue) {
		sendKeysToElement(ADDRESS_PHONE_NUMBER_TEXTBOX, phoneNumberValue);
	}

	public void inputToAddressFaxNumberTextBox(String faxNumberValue) {
		sendKeysToElement(ADDRESS_FAX_NUMBER_TEXTBOX, faxNumberValue);
	}

	public boolean isAddressesPageTitleDisplayed() {
		return isElementDisplayed(ADDRESSES_PAGE_TITLE);
	}

	public boolean isAddNewAddressPageTitleDisplayed() {
		return isElementDisplayed(ADD_NEW_ADDRESS_PAGE_TITLE);
	}

	public boolean isAddressInforNameDisplayed(String inforName) {
		return isElementDisplayed(ADDRESS_INFOR, inforName);
	}

	public boolean isAddressNameDisplayed(String name) {
		return isElementDisplayed(ADDRESS_NAME, name);
	}

	public boolean isAddressEmailDisplayed(String email) {
		return isElementDisplayed(ADDRESS_EMAIL, email);
	}

	public boolean isAddressPhoneNumberDisplayed(String phone) {
		return isElementDisplayed(ADDRESS_PHONE, phone);
	}

	public boolean isAddressFaxNumberDisplayed(String fax) {
		return isElementDisplayed(ADDRESS_FAX, fax);
	}

	public boolean isAddressAddress1Displayed(String address1) {
		return isElementDisplayed(ADDRESS_ADDRESS1, address1);
	}

	public boolean isAddressCityStateZipDisplayed(String cityStateZip) {
		return isElementDisplayed(ADDRESS_CITY_STATE_ZIP, cityStateZip);
	}

	public boolean isAddressCountryDisplayed(String country) {
		return isElementDisplayed(ADDRESS_COUNTRY, country);
	}

}
