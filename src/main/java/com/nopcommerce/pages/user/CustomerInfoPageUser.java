package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class CustomerInfoPageUser extends CommonPageUser {

	private final String CUSTOMER_INFOR_PAGE_TITLE = "//h1[text()='My account - Customer info']";
	private final String MALE_GENDER_VALUE = "//input[@value='M'and @id='gender-male']";
	private final String FIRSTNAME_VALUE = "//input[@value='%s' and @id='FirstName']";
	private final String LASTNAME_VALUE = "//input[@value='%s' and @id='LastName']";
	private final String DROPDOWN_LIST_VALUE_SELECTED = "//option[text()='%s' and @selected]";
	private final String EMAIL_VALUE = "//input[@value='%s' and @id='Email']";
	private final String COMPANY_NAME_VALUE = "//input[@value='%s' and @id='Company']";
	private final String SAVE_BUTTON = "//input[@id='save-info-button']";

	public CustomerInfoPageUser(WebDriver driver) {
		super(driver);
	}

	public void clickSaveButton() {
		clickToElement(SAVE_BUTTON);
	}

	public boolean isMaleGenderSelected() {
		return isElementSelected(MALE_GENDER_VALUE);
	}

	public boolean isFirstNameValueDisplayed(String firstNameValue) {
		return isElementDisplayed(FIRSTNAME_VALUE, firstNameValue);
	}

	public boolean isLastNameValueDisplayed(String lastNameValue) {
		return isElementDisplayed(LASTNAME_VALUE, lastNameValue);
	}

	public boolean isDaySelected(String day) {
		return isElementDisplayed(DROPDOWN_LIST_VALUE_SELECTED, day);
	}

	public boolean isMonthSelected(String month) {
		return isElementDisplayed(DROPDOWN_LIST_VALUE_SELECTED, month);
	}

	public boolean isYearSelected(String year) {
		return isElementDisplayed(DROPDOWN_LIST_VALUE_SELECTED, year);
	}

	public boolean isEmailValueDisplayed(String emailValue) {
		return isElementDisplayed(EMAIL_VALUE, emailValue);
	}

	public boolean isCompayNameValueDisplayed(String companyNameValue) {
		return isElementDisplayed(COMPANY_NAME_VALUE, companyNameValue);
	}

	public boolean isCustomerInforPageTitleDisplayed() {
		return isElementDisplayed(CUSTOMER_INFOR_PAGE_TITLE);
	}

}
