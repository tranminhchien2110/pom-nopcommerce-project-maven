package com.nopcommerce.pages.admin;

import org.openqa.selenium.WebDriver;

public class HomePageAdmin extends CommonPageAdmin {
	private final String PAGE_TITLE_HOME_PAGE = "//h1[contains(text(),'Dashboard')]";

	public HomePageAdmin(WebDriver driver) {
		super(driver);
	}
	
	public static HomePageAdmin getHomePageAdmin(WebDriver driver) {
		return new HomePageAdmin(driver);
	}
	
	public boolean isHomePageAdminTitleDisplayed() {
		waitUntilPageReady();
		return isElementDisplayed(PAGE_TITLE_HOME_PAGE);
	}
	

}
