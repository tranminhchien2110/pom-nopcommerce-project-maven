package com.nopcommerce.user.precondition;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.base.BaseTest;
import com.nopcommerce.data.DataUser;
import com.nopcommerce.pages.user.HomePageUser;

public class PreConditionRegisterUser extends BaseTest {
	private HomePageUser homePageUser;

	public HomePageUser getHomePageUser() {
		return homePageUser;
	}

	@Parameters({ "browser" })
	@BeforeClass
	public void BeforeClass(String browserName) {
		setUp(browserName, DataUser.NOP_COMMERCE_USER_URL);

		homePageUser = HomePageUser.getHomePage(getDriver());
		homePageUser.waitUntilPageReady();

		verifyTrue(homePageUser.isHomePageTitleDislayed());
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		tearDown();
	}
}
