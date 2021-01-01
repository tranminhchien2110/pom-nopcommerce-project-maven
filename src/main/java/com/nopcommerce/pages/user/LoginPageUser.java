package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class LoginPageUser extends CommonPageUser{

	private final String LOGIN_BUTTON = "//input[@value='Log in']";
	private final String WELCOME_SIGN_IN_MESSAGE = "//div[@class='page-title']//h1";
	
	public LoginPageUser(WebDriver driver) {
		super(driver);
	}
	
	public static LoginPageUser getLoginPageUser(WebDriver driver) {
		return new LoginPageUser(driver);
	}

	public void clickLoginButton() {
		clickToElement(LOGIN_BUTTON);
	}
	
	public boolean isWelcomeSignInMessageDisplayed() {
		return isElementDisplayed(WELCOME_SIGN_IN_MESSAGE);
	}

	public String getWelcomeSignInMessage() {
		return getTextElement(WELCOME_SIGN_IN_MESSAGE);
	}
	
	
}
