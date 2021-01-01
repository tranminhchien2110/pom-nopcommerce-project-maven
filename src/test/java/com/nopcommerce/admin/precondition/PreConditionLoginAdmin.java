package com.nopcommerce.admin.precondition;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.base.BaseTest;
import com.nopcommerce.data.DataAdmin;
import com.nopcommerce.pages.admin.HomePageAdmin;
import com.nopcommerce.pages.admin.LoginPageAdmin;

public class PreConditionLoginAdmin extends BaseTest {
	HomePageAdmin homePageAdmin;
	LoginPageAdmin loginPageAdmin;

	@Parameters({ "browser" })
	@BeforeClass
	public void openHomePageAdmin(String browserName) {
		setUp(browserName, DataAdmin.NOP_COMMERCE_ADMIN_URL);

		loginPageAdmin = LoginPageAdmin.getLoginPageAdmin(getDriver());

		verifyTrue(loginPageAdmin.isLoginPageAdminTitleDisplayed());
		verifyTrue(loginPageAdmin.isLoginPageAdminWelcomeMessageDisplayed());

		loginPageAdmin.inputToEmailTextbox(DataAdmin.NOP_COMMERCE_ADMIN_USERNAME);
		loginPageAdmin.inputToPasswordTextbox(DataAdmin.NOP_COMMERCE_ADMIN_PASSWORD);
		homePageAdmin = loginPageAdmin.clickLogInButton();

		verifyTrue(homePageAdmin.isHomePageAdminTitleDisplayed());
	}
	
	@AfterClass
	public void quitBrowser() {
		tearDown();
	}

	public HomePageAdmin getHomePageAdmin() {
		return homePageAdmin;
	}

	public LoginPageAdmin getLoginPageAdmin() {
		return loginPageAdmin;
	}

}
