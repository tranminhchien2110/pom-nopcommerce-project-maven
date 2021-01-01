package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class RegisterPageUser extends CommonPageUser {

	private final String CONTINUE_BUTTON = "//input[@name='register-continue']";
	private final String REGISTER_BUTTON = "//input[@id='register-button']";
	private final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	// Message
	private final String REGISTER_PAGE_TITLE = "//h1[text()='Register']";
	private final String REGISTER_SUCCESS_MESSAGE = "//div[@class='result']";
	private final String FIRSTNAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
	private final String LASTNAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
	private final String PASSWORD_ERROR_MESSAGE = "//span[@id='Password-error']";
	private final String PASSWORD_6CHARS_ERROR_MESSAGE_1 = "//span[@id='Password-error']//p";
	private final String PASSWORD_6CHARS_ERROR_MESSAGE_2 = "//span[@id='Password-error']//li";
	private final String CONFIRM_PASSWORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";

	public RegisterPageUser(WebDriver driver) {
		super(driver);
	}

	public HomePageUser clickContinueButton() {
		clickToElement(CONTINUE_BUTTON);
		return new HomePageUser(getDriver());
	}

	public void clickRegisterButton() {
		clickToElement(REGISTER_BUTTON);
	}

	public void inputToConfirmPasswordTextbox(String data) {
		sendKeysToElement(CONFIRM_PASSWORD_TEXTBOX, data);
	}

	public boolean isRegisterPageTitleDisplayed() {
		return isElementDisplayed(REGISTER_PAGE_TITLE);
	}

	public boolean isFirstNameErrorMessageDisplayed() {
		return isElementDisplayed(FIRSTNAME_ERROR_MESSAGE);
	}

	public boolean isLastNameErrorMessageDisplayed() {
		return isElementDisplayed(LASTNAME_ERROR_MESSAGE);
	}

	public boolean isPasswordErrorMessageDisplayed() {
		return isElementDisplayed(PASSWORD_ERROR_MESSAGE);
	}

	public boolean isPassword6CharsErrorMessageDisplayed() {
		return isElementDisplayed(PASSWORD_6CHARS_ERROR_MESSAGE_1) && isElementDisplayed(PASSWORD_6CHARS_ERROR_MESSAGE_2);
	}

	public boolean isConfirmPasswordErrorMessageDisplayed() {
		return isElementDisplayed(CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public boolean isRegisterSuccessMessageDisplayed() {
		return isElementDisplayed(REGISTER_SUCCESS_MESSAGE);
	}

	public String getFirstNameErrorMessage() {
		return getTextElement(FIRSTNAME_ERROR_MESSAGE);
	}

	public String getLastNameErrorMessage() {
		return getTextElement(LASTNAME_ERROR_MESSAGE);
	}

	public String getPasswordErrorMessage() {
		return getTextElement(PASSWORD_ERROR_MESSAGE);
	}

	public String getConfirmPasswordErrorMessage() {
		return getTextElement(CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public String getPassword6CharsErrorMessage() {
		return getTextElement(PASSWORD_6CHARS_ERROR_MESSAGE_1) + getTextElement(PASSWORD_6CHARS_ERROR_MESSAGE_2);
	}

	public String getRegisterSuccessMessage() {
		return getTextElement(REGISTER_SUCCESS_MESSAGE);
	}

}
