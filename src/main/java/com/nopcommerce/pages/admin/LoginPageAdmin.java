package com.nopcommerce.pages.admin;

import org.openqa.selenium.WebDriver;

public class LoginPageAdmin extends CommonPageAdmin {
	private final String PAGE_TITLE_LOGIN_PAGE = "//h1[text()='Admin area demo']";
	private final String MESSAGE_WELCOME_LOGIN_PAGE = "//strong[text()='Welcome, please sign in!']";
	private final String BUTTON_LOG_IN = "//input[@value='Log in']";

	public LoginPageAdmin(WebDriver driver) {
		super(driver);
	}

	public static LoginPageAdmin getLoginPageAdmin(WebDriver driver) {
		return new LoginPageAdmin(driver);
	}

	public HomePageAdmin clickLogInButton() {
		clickToElement(BUTTON_LOG_IN);
		waitUntilPageReady();
		return new HomePageAdmin(getDriver());
	}

	public boolean isLoginPageAdminTitleDisplayed() {
		waitUntilPageReady();
		return isElementDisplayed(PAGE_TITLE_LOGIN_PAGE);
	}

	public boolean isLoginPageAdminWelcomeMessageDisplayed() {
		waitUntilPageReady();
		return isElementDisplayed(MESSAGE_WELCOME_LOGIN_PAGE);
	}
}
