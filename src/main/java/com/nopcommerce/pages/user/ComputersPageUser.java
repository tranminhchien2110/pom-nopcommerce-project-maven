package com.nopcommerce.pages.user;

import org.openqa.selenium.WebDriver;

public class ComputersPageUser extends CommonPageUser {

	private final String COMPUTERS_PAGE_TITLE = "//div[@class='page-title']/h1[text()='Computers']";
	private final String NOTEBOOKS_LINK = "//li[@class='inactive']/a[text()='Notebooks ']";
	
	public ComputersPageUser(WebDriver driver) {
		super(driver);
	}
	
	public NotebooksPageUser clickNotebooksLink() {
		clickToElement(NOTEBOOKS_LINK);
		return new NotebooksPageUser(getDriver());
	}

	public boolean isComputersPageTitleDisplayed() {
		return isElementDisplayed(COMPUTERS_PAGE_TITLE);
	}

}
