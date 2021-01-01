package com.nopcommerce.pages.admin;

import org.openqa.selenium.WebDriver;

public class CustomersPageAdmin extends CommonPageAdmin {
	private final String PAGE_TITLE_CUSTOMERS_PAGE = "//h1[contains(text(),'Customers')]";
	private final String DROPDOWN_LIST_MONTH_OF_BIRTH = "//select[@id='SearchMonthOfBirth']";
	private final String DROPDOWN_LIST_DAY_OF_BIRTH = "//select[@id='SearchDayOfBirth']";

	public CustomersPageAdmin(WebDriver driver) {
		super(driver);
	}

	public static CustomersPageAdmin getCustomersPageAdmin(WebDriver driver) {
		return new CustomersPageAdmin(driver);
	}

	public boolean isCustomersPageAdminTitleDisplayed() {
		waitUntilPageReady();
		return isElementDisplayed(PAGE_TITLE_CUSTOMERS_PAGE);
	}

	public String getDayFromDateOfBirth(String dateOfBirth_MMMM_dd_yyyy) {
		return dateOfBirth_MMMM_dd_yyyy.split("\\/")[1];
	}

	public String getMonthFromDateOfBirth(String dateOfBirth_MMMM_dd_yyyy) {
		return dateOfBirth_MMMM_dd_yyyy.split("\\/")[0];
	}

	public void selectDayOfBirthList(String dayOfBirth) {
		selectValueInDropdownList(DROPDOWN_LIST_DAY_OF_BIRTH, dayOfBirth);
	}

	public void selectMonthOfBirthList(String monthOfBirth) {
		selectValueInDropdownList(DROPDOWN_LIST_MONTH_OF_BIRTH, monthOfBirth);
	}
}
