package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class HomePageUser extends CommonPageUser {

	private final String PAGE_TITLE_HOMEPAGE = "//h2[text()='Welcome to our store']";

	public HomePageUser(WebDriver driver) {
		super(driver);
	}

	public static HomePageUser getHomePage(WebDriver driver) {
		return new HomePageUser(driver);
	}

	public boolean isHomePageTitleDislayed() {
		return isElementDisplayed(PAGE_TITLE_HOMEPAGE);
	}

}
