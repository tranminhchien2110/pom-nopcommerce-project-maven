package com.nopcommerce.user.register;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.data.DataUser;
import com.nopcommerce.pages.user.HomePageUser;
import com.nopcommerce.pages.user.RegisterPageUser;
import com.nopcommerce.user.precondition.PreConditionRegisterUser;

public class Register extends PreConditionRegisterUser {

	@BeforeClass
	public void openRegisterPageUser() {
		homePageUser = getHomePageUser();
		registerPageUser = homePageUser.clickRegisterLink();
		registerPageUser.waitUntilPageReady();

		verifyTrue(registerPageUser.isRegisterPageTitleDisplayed());
	}

	@Test(priority = 1)
	public void R01_registerWithEmptyData() {
		registerPageUser.clickRegisterButton();

		verifyTrue(registerPageUser.isFirstNameErrorMessageDisplayed());
		verifyTrue(registerPageUser.isLastNameErrorMessageDisplayed());
		verifyTrue(registerPageUser.isEmailErrorMessageDisplayed());
		verifyTrue(registerPageUser.isPasswordErrorMessageDisplayed());
		verifyTrue(registerPageUser.isConfirmPasswordErrorMessageDisplayed());

		verifyEquals(registerPageUser.getFirstNameErrorMessage(), DataUser.FIRST_NAME_REQUIRED);
		verifyEquals(registerPageUser.getLastNameErrorMessage(), DataUser.LAST_NAME_REQUIRED);
		verifyEquals(registerPageUser.getEmailErrorMessage(), DataUser.EMAIL_REQUIRED);
		verifyEquals(registerPageUser.getPasswordErrorMessage(), DataUser.PASSWORD_REQUIRED);
		verifyEquals(registerPageUser.getConfirmPasswordErrorMessage(), DataUser.CONFIRM_PASSWORD_REQUIRED);
	}

	@Test(priority = 2)
	public void R02_registerWithInvalidEmail() {
		registerPageUser.inputToEmailTextbox("automation");
		registerPageUser.clickRegisterButton();
		verifyTrue(registerPageUser.isEmailErrorMessageDisplayed());
		verifyEquals(registerPageUser.getEmailErrorMessage(), DataUser.WRONG_EMAIL);

		registerPageUser.inputToEmailTextbox("automation@");
		registerPageUser.clickRegisterButton();
		verifyTrue(registerPageUser.isEmailErrorMessageDisplayed());
		verifyEquals(registerPageUser.getEmailErrorMessage(), DataUser.WRONG_EMAIL);

		registerPageUser.inputToEmailTextbox("automation@g.");
		registerPageUser.clickRegisterButton();
		verifyTrue(registerPageUser.isEmailErrorMessageDisplayed());
		verifyEquals(registerPageUser.getEmailErrorMessage(), DataUser.WRONG_EMAIL);
	}

	@Test(priority = 3)
	public void R03_registerWithPasswordLessThan6Chars() {
		registerPageUser.inputToPasswordTextbox("12345");
		registerPageUser.clickRegisterButton();
		verifyTrue(registerPageUser.isPassword6CharsErrorMessageDisplayed());
		verifyEquals(registerPageUser.getPassword6CharsErrorMessage(), DataUser.PASSWORD_MUST_HAVE_AT_LEAST_6_CHARS);
	}

	@Test(priority = 4)
	public void R04_registerWithConfirmPasswordNotMatchWithPassword() {
		registerPageUser.inputToPasswordTextbox("123456");
		registerPageUser.inputToConfirmPasswordTextbox("12345");
		registerPageUser.clickRegisterButton();
		verifyTrue(registerPageUser.isConfirmPasswordErrorMessageDisplayed());
		verifyEquals(registerPageUser.getConfirmPasswordErrorMessage(), DataUser.CONFIRM_PASSWORD_NOT_MATCH);
	}

	@Test(priority = 5)
	public void R05_registerWithValidValue() {
		registerPageUser.inputToFirstNameTextbox(DataUser.FIRSTNAME);
		registerPageUser.inputToLastNameTextbox(DataUser.LASTNAME);
		registerPageUser.inputToEmailTextbox(DataUser.EMAIL);
		registerPageUser.inputToPasswordTextbox(DataUser.PASSWORD);
		registerPageUser.inputToConfirmPasswordTextbox(DataUser.PASSWORD);
		registerPageUser.clickRegisterButton();
		registerPageUser.waitUntilPageReady();

		verifyTrue(registerPageUser.isRegisterSuccessMessageDisplayed());
		verifyEquals(registerPageUser.getRegisterSuccessMessage(), DataUser.YOUR_REGISTRATION_COMPLETED);

		verifyTrue(registerPageUser.isMyAccountLinkDisplayed());
		verifyTrue(registerPageUser.isLogOutLinkDisplayed());

		homePageUser = registerPageUser.clickContinueButton();
		homePageUser.waitUntilPageReady();

		verifyTrue(homePageUser.isHomePageTitleDislayed());

		homePageUser.clickLogOutLink();
		homePageUser.waitUntilPageReady();

		verifyTrue(homePageUser.isHomePageTitleDislayed());
	}

	@Test(priority = 6, dependsOnMethods = { "R05_registerWithValidValue" })
	public void R06_registerWithExistEmail() {
		registerPageUser = homePageUser.clickRegisterLink();
		registerPageUser.waitUntilPageReady();
		registerPageUser.inputToFirstNameTextbox(DataUser.FIRSTNAME);
		registerPageUser.inputToLastNameTextbox(DataUser.LASTNAME);
		registerPageUser.inputToEmailTextbox(DataUser.EMAIL);
		registerPageUser.inputToPasswordTextbox(DataUser.PASSWORD);
		registerPageUser.inputToConfirmPasswordTextbox(DataUser.PASSWORD);
		registerPageUser.clickRegisterButton();

		verifyTrue(registerPageUser.isErrorMessageReasonDisplayed());
		verifyEquals(registerPageUser.getErrorMessageReason(), DataUser.EMAIL_ALREADY_EXISTS);
	}
	
	RegisterPageUser registerPageUser;
	HomePageUser homePageUser;

}
