package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class ChangePasswordPageUser extends CommonPageUser {

	private final String CHANGE_PASS_PAGE_TITLE = "//h1[text()='My account - Change password']";
	private final String CHANGE_PASS_SUCCESS_MESSAGE = "//div[contains(text(),'Password was changed')]";
	private final String OLD_PASS_TEXTBOX = "//input[@id='OldPassword']";
	private final String NEW_PASS_TEXTBOX = "//input[@id='NewPassword']";
	private final String CONFIRM_NEW_PASS_TEXTBOX = "//input[@id='ConfirmNewPassword']";
	private final String CHANGE_PASS_BUTTON = "//input[@value='Change password']";

	public ChangePasswordPageUser(WebDriver driver) {
		super(driver);
	}

	public void clickChangePasswordButton() {
		clickToElement(CHANGE_PASS_BUTTON);
	}
	
	public boolean isChangePasswordPageTitleDisplayed() {
		return isElementDisplayed(CHANGE_PASS_PAGE_TITLE);
	}

	public boolean isChangePasswordSuccessMessageDisplayed() {
		return isElementDisplayed(CHANGE_PASS_SUCCESS_MESSAGE);
	}

	public void inputToOldPasswordTextbox(String oldPassword) {
		sendKeysToElement(OLD_PASS_TEXTBOX, oldPassword);
	}

	public void inputToNewPasswordTextbox(String newPassword) {
		sendKeysToElement(NEW_PASS_TEXTBOX, newPassword);
	}

	public void inputToConfirmNewPasswordTextbox(String newPassword) {
		sendKeysToElement(CONFIRM_NEW_PASS_TEXTBOX, newPassword);
	}

}
