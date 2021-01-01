package com.nopcommerce.user.precondition;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.base.BaseTest;
import com.nopcommerce.data.DataUser;
import com.nopcommerce.pages.user.HomePageUser;
import com.nopcommerce.pages.user.LoginPageUser;
import com.nopcommerce.pages.user.RegisterPageUser;

public class PreConditionLoginUser extends BaseTest {
	private HomePageUser homePageUser;
	private RegisterPageUser registerPageUser;
	private LoginPageUser loginPageUser;

	@Parameters({ "browser" })
	@BeforeClass
	public void BeforeClass(String browserName) {
		setUp(browserName, DataUser.NOP_COMMERCE_USER_URL);

		homePageUser = HomePageUser.getHomePage(getDriver());
		homePageUser.waitUntilPageReady();

		verifyTrue(homePageUser.isHomePageTitleDislayed());

		registerPageUser = homePageUser.clickRegisterLink();
		registerPageUser.waitUntilPageReady();

		verifyTrue(registerPageUser.isRegisterPageTitleDisplayed());

		registerPageUser.inputToFirstNameTextbox(DataUser.FIRSTNAME);
		registerPageUser.inputToLastNameTextbox(DataUser.LASTNAME);
		registerPageUser.inputToEmailTextbox(DataUser.EMAIL);
		registerPageUser.inputToPasswordTextbox(DataUser.PASSWORD);
		registerPageUser.inputToConfirmPasswordTextbox(DataUser.PASSWORD);
		registerPageUser.clickRegisterButton();
		registerPageUser.waitUntilPageReady();

		if (registerPageUser.isErrorMessageReasonUndisplayed()) {
			verifyTrue(registerPageUser.isRegisterSuccessMessageDisplayed());
			verifyEquals(registerPageUser.getRegisterSuccessMessage(), DataUser.YOUR_REGISTRATION_COMPLETED);
			verifyTrue(registerPageUser.isMyAccountLinkDisplayed());
			verifyTrue(registerPageUser.isLogOutLinkDisplayed());

			homePageUser = registerPageUser.clickContinueButton();
		} else {
			verifyEquals(registerPageUser.getErrorMessageReason(), DataUser.EMAIL_ALREADY_EXISTS);

			loginPageUser = registerPageUser.clickLoginLink();
			loginPageUser.waitUntilPageReady();

			verifyTrue(loginPageUser.isWelcomeSignInMessageDisplayed());
			verifyEquals(loginPageUser.getWelcomeSignInMessage(), DataUser.WELCOME_SIGN_IN);

			loginPageUser.inputToEmailTextbox(DataUser.EMAIL);
			loginPageUser.inputToPasswordTextbox(DataUser.PASSWORD);
			loginPageUser.clickLoginButton();
		}
		homePageUser.waitUntilPageReady();
		
		verifyTrue(homePageUser.isHomePageTitleDislayed());
		verifyTrue(homePageUser.isMyAccountLinkDisplayed());
		verifyTrue(homePageUser.isLogOutLinkDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		tearDown();
	}

	public HomePageUser getHomePageUser() {
		return homePageUser;
	}

	public LoginPageUser getLoginPageUser() {
		return loginPageUser;
	}

}
