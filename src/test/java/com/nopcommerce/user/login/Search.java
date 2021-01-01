package com.nopcommerce.user.login;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.pages.user.HomePageUser;
import com.nopcommerce.pages.user.SearchPageUser;
import com.nopcommerce.user.precondition.PreConditionLoginUser;

public class Search extends PreConditionLoginUser {
	HomePageUser homePageUser;
	SearchPageUser searchPageUser;
	String searchMacbookPro2050 = "Macbook pro 2050";
	String searchAppleMacbookPro = "Apple Macbook pro";
	String searchLenovo = "Lenovo";
	String appleLaptop = "Apple MacBook Pro 13-inch";
	String lenovoLaptop_1 = "Lenovo IdeaCentre 600 All-in-One PC";
	String lenovoLaptop_2 = "Lenovo Thinkpad X1 Carbon Laptop";
	String categoryComputers = "Computers";
	String manufacturerHP = "HP";
	String manufacturerApple = "Apple";

	@BeforeClass
	public void openSearchPageUser() {
		homePageUser = getHomePageUser();
		searchPageUser = homePageUser.clickToSearchLinkOnFooter();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isSearchPageTitleDisplayed());
	}

	@Test(priority = 1)
	public void S01_searchWithEmptyValue() {
		searchPageUser.clickSearchButtonOnSearchPage();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isSearchErrorMessageDisplayed());
	}

	@Test(priority = 2)
	public void S02_searchWithNoDataExist() {
		searchPageUser.inputToSearchTextboxOnSearchPage(searchMacbookPro2050);
		searchPageUser.clickSearchButtonOnSearchPage();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isProductsWereNotFoundMessageDisplayed());
	}

	@Test(priority = 3)
	public void S03_searchWithProductRelativeName() {
		searchPageUser.inputToSearchTextboxOnSearchPage(searchLenovo);
		searchPageUser.clickSearchButtonOnSearchPage();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.areAllProductNameDisplayed());
		verifyEquals(searchPageUser.getProductNameByIndex(0), lenovoLaptop_1);
		verifyEquals(searchPageUser.getProductNameByIndex(1), lenovoLaptop_2);
	}

	@Test(priority = 4)
	public void S04_searchWithProductAbsoluteName() {
		searchPageUser.inputToSearchTextboxOnSearchPage(lenovoLaptop_1);
		searchPageUser.clickSearchButtonOnSearchPage();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.areAllProductNameDisplayed());
		verifyEquals(searchPageUser.getProductNameByIndex(0), lenovoLaptop_1);
	}

	@Test(priority = 5)
	public void S05_advanceSearchWithParentCategories() {
		searchPageUser.inputToSearchTextboxOnSearchPage(searchAppleMacbookPro);
		searchPageUser.checkAdvanceSearchCheckbox();
		searchPageUser.selectCategory(categoryComputers);

		searchPageUser.uncheckAutomaticallySearchSubCategoryCheckbox();
		searchPageUser.clickSearchButtonOnSearchPage();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isCategoryItemSelected(categoryComputers));
		verifyTrue(searchPageUser.isProductsWereNotFoundMessageDisplayed());
	}

	@Test(priority = 6)
	public void S06_advanceSearchWithSubCategories() {
		searchPageUser.inputToSearchTextboxOnSearchPage(searchAppleMacbookPro);
		searchPageUser.checkAdvanceSearchCheckbox();
		searchPageUser.selectCategory(categoryComputers);

		searchPageUser.checkAutomaticallySearchSubCategoryCheckbox();
		searchPageUser.clickSearchButtonOnSearchPage();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isCategoryItemSelected(categoryComputers));
		verifyTrue(searchPageUser.areAllProductNameDisplayed());
		verifyEquals(searchPageUser.getProductNameByIndex(0), appleLaptop);
	}

	@Test(priority = 7)
	public void S07_advanceSearchWithIncorrectManufacturer() {
		searchPageUser.inputToSearchTextboxOnSearchPage(searchAppleMacbookPro);
		searchPageUser.checkAdvanceSearchCheckbox();
		searchPageUser.selectCategory(categoryComputers);

		searchPageUser.checkAutomaticallySearchSubCategoryCheckbox();
		searchPageUser.selectManufacturer(manufacturerHP);

		searchPageUser.clickSearchButtonOnSearchPage();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isCategoryItemSelected(categoryComputers));
		verifyTrue(searchPageUser.isItemManufacturerSelected(manufacturerHP));
		verifyTrue(searchPageUser.isProductsWereNotFoundMessageDisplayed());
	}

	@Test(priority = 8)
	public void S08_advanceSearchWithCorrectManufacturer() {
		searchPageUser.inputToSearchTextboxOnSearchPage(searchAppleMacbookPro);
		searchPageUser.checkAdvanceSearchCheckbox();
		searchPageUser.selectCategory(categoryComputers);

		searchPageUser.checkAutomaticallySearchSubCategoryCheckbox();
		searchPageUser.selectManufacturer(manufacturerApple);

		searchPageUser.clickSearchButtonOnSearchPage();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isCategoryItemSelected(categoryComputers));
		verifyTrue(searchPageUser.isItemManufacturerSelected(manufacturerApple));
		verifyTrue(searchPageUser.areAllProductNameDisplayed());
		verifyEquals(searchPageUser.getProductNameByIndex(0), appleLaptop);
	}

	@Test(priority = 9)
	public void S09_advanceSearchWithPriceRange() {
		searchPageUser.inputToSearchTextboxOnSearchPage(searchAppleMacbookPro);
		searchPageUser.checkAdvanceSearchCheckbox();
		searchPageUser.selectCategory(categoryComputers);
		searchPageUser.checkAutomaticallySearchSubCategoryCheckbox();
		searchPageUser.selectManufacturer(manufacturerApple);

		searchPageUser.inputToPriceFromTextbox("1000");
		searchPageUser.inputToPriceToTextbox("2000");
		searchPageUser.clickSearchButtonOnSearchPage();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isCategoryItemSelected(categoryComputers));
		verifyTrue(searchPageUser.isItemManufacturerSelected(manufacturerApple));
		verifyTrue(searchPageUser.areAllProductNameDisplayed());
		verifyEquals(searchPageUser.getProductNameByIndex(0), appleLaptop);
	}

	@Test(priority = 10)
	public void S10_advanceSearchWithPriceRangeLowerProductPrice() {
		searchPageUser.inputToSearchTextboxOnSearchPage(searchAppleMacbookPro);
		searchPageUser.checkAdvanceSearchCheckbox();
		searchPageUser.selectCategory(categoryComputers);

		searchPageUser.checkAutomaticallySearchSubCategoryCheckbox();
		searchPageUser.selectManufacturer(manufacturerApple);

		searchPageUser.inputToPriceFromTextbox("1000");
		searchPageUser.inputToPriceToTextbox("1700");
		searchPageUser.clickSearchButtonOnSearchPage();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isCategoryItemSelected(categoryComputers));
		verifyTrue(searchPageUser.isItemManufacturerSelected(manufacturerApple));
		verifyTrue(searchPageUser.isProductsWereNotFoundMessageDisplayed());
	}

	@Test(priority = 11)
	public void S11_advanceSearchWithPriceRangeHigherProductPrice() {
		searchPageUser.inputToSearchTextboxOnSearchPage(searchAppleMacbookPro);
		searchPageUser.checkAdvanceSearchCheckbox();
		searchPageUser.selectCategory(categoryComputers);

		searchPageUser.checkAutomaticallySearchSubCategoryCheckbox();
		searchPageUser.selectManufacturer(manufacturerApple);

		searchPageUser.inputToPriceFromTextbox("1900");
		searchPageUser.inputToPriceToTextbox("5000");
		searchPageUser.clickSearchButtonOnSearchPage();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isCategoryItemSelected(categoryComputers));
		verifyTrue(searchPageUser.isItemManufacturerSelected(manufacturerApple));
		verifyTrue(searchPageUser.isProductsWereNotFoundMessageDisplayed());
	}
}
