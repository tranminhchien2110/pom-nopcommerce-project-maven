package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class NotebooksPageUser extends CommonPageUser {

	private final String NOTEBOOKS_PAGE_TITLE = "//div[@class='page-title']/h1[text()='Notebooks']";

	public NotebooksPageUser(WebDriver driver) {
		super(driver);
	}

	public boolean isNotebooksPageTitleDisplayed() {
		return isElementDisplayed(NOTEBOOKS_PAGE_TITLE);
	}












}
