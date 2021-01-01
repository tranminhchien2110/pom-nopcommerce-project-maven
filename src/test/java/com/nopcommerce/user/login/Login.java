package com.nopcommerce.user.login;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.data.DataUser;
import com.nopcommerce.pages.user.HomePageUser;
import com.nopcommerce.pages.user.LoginPageUser;
import com.nopcommerce.user.precondition.PreConditionLoginUser;

public class Login extends PreConditionLoginUser {
	private HomePageUser homePageUser;
	private LoginPageUser loginPageUser;

	@BeforeClass
	public void openLoginPageUser() {
		homePageUser = getHomePageUser();
		if (homePageUser.isLogOutLinkDisplayed()) {
			homePageUser.clickLogOutLink();
			homePageUser.waitUntilPageReady();
		}
		loginPageUser = homePageUser.clickLoginLink();
		loginPageUser.waitUntilPageReady();

		verifyTrue(loginPageUser.isWelcomeSignInMessageDisplayed());
		verifyEquals(loginPageUser.getWelcomeSignInMessage(), DataUser.WELCOME_SIGN_IN);
	}

	@Test(priority = 1)
	public void L01_loginWithEmptyEmail() {
		loginPageUser.clickLoginButton();
		verifyTrue(loginPageUser.isEmailErrorMessageDisplayed());
		verifyEquals(loginPageUser.getEmailErrorMessage(), DataUser.PLS_ENTER_EMAIL);
	}

	@Test(priority = 2)
	public void L02_loginWithInvalidEmail() {
		loginPageUser.inputToEmailTextbox("automation");
		verifyTrue(loginPageUser.isEmailErrorMessageDisplayed());
		verifyEquals(loginPageUser.getEmailErrorMessage(), DataUser.WRONG_EMAIL);

		loginPageUser.inputToEmailTextbox("automation@");
		verifyTrue(loginPageUser.isEmailErrorMessageDisplayed());
		verifyEquals(loginPageUser.getEmailErrorMessage(), DataUser.WRONG_EMAIL);

		loginPageUser.inputToEmailTextbox("automation@g.");
		verifyTrue(loginPageUser.isEmailErrorMessageDisplayed());
		verifyEquals(loginPageUser.getEmailErrorMessage(), DataUser.WRONG_EMAIL);
	}

	@Test(priority = 3)
	public void L03_loginWithEmailNotExist() {
		loginPageUser.inputToEmailTextbox(DataUser.EMAIL_NOT_EXIST);
		loginPageUser.inputToPasswordTextbox(DataUser.PASSWORD);
		loginPageUser.clickLoginButton();
		loginPageUser.waitUntilPageReady();

		verifyTrue(loginPageUser.isErrorMessageDisplayed());
		verifyEquals(loginPageUser.getErrorMessage(), DataUser.LOGIN_WAS_UNSUCCESSFUL + "\n" + DataUser.NO_CUSTOMER_ACCOUNT_FOUND);
	}

	@Test(priority = 4)
	public void L04_loginWithValidEmailAndEmptyPassword() {
		loginPageUser.inputToEmailTextbox(DataUser.EMAIL);
		loginPageUser.inputToPasswordTextbox("");
		loginPageUser.clickLoginButton();
		loginPageUser.waitUntilPageReady();

		verifyTrue(loginPageUser.isErrorMessageDisplayed());
		verifyEquals(loginPageUser.getErrorMessage(), DataUser.LOGIN_WAS_UNSUCCESSFUL + "\n" + DataUser.CREDENTIALS_PROVIDED_ARE_INCORRECT);
	}

	@Test(priority = 5)
	public void L05_LoginWithValidEmailAndInvalidPassword() {
		loginPageUser.inputToEmailTextbox(DataUser.EMAIL);
		loginPageUser.inputToPasswordTextbox(DataUser.PASSWORD_NOT_EXIST);
		loginPageUser.clickLoginButton();
		loginPageUser.waitUntilPageReady();

		verifyTrue(loginPageUser.isErrorMessageDisplayed());
		verifyEquals(loginPageUser.getErrorMessage(), DataUser.LOGIN_WAS_UNSUCCESSFUL + "\n" + DataUser.CREDENTIALS_PROVIDED_ARE_INCORRECT);
	}

	@Test(priority = 6)
	public void L06_loginWithValidEmailAndPassword() {
		loginPageUser.inputToEmailTextbox(DataUser.EMAIL);
		loginPageUser.inputToPasswordTextbox(DataUser.PASSWORD);
		loginPageUser.clickLoginButton();
		loginPageUser.waitUntilPageReady();

		verifyTrue(homePageUser.isHomePageTitleDislayed());
		verifyTrue(homePageUser.isMyAccountLinkDisplayed());
		verifyTrue(homePageUser.isLogOutLinkDisplayed());
	}
}
