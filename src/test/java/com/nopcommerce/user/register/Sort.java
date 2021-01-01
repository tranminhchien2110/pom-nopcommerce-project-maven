package com.nopcommerce.user.register;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.pages.user.ComputersPageUser;
import com.nopcommerce.pages.user.HomePageUser;
import com.nopcommerce.pages.user.NotebooksPageUser;
import com.nopcommerce.user.precondition.PreConditionRegisterUser;

public class Sort extends PreConditionRegisterUser {
	HomePageUser homePage;
	ComputersPageUser computersPageUser;
	NotebooksPageUser notebooksPageUser;
	String sortNameAtoZ = "Name: A to Z";
	String sortNameZtoA = "Name: Z to A";
	String sortPriceLowtoHigh = "Price: Low to High";
	String sortPriceHightoLow = "Price: High to Low";
	int displayThree = 3;
	int displaySix = 6;
	int displayNine = 9;
	int pageOne = 1;
	int pageTwo = 2;

	@BeforeClass
	public void openNotebooksPage() {
		homePage = getHomePageUser();
		computersPageUser = homePage.clickComputersLink();
		computersPageUser.waitUntilPageReady();

		verifyTrue(computersPageUser.isComputersPageTitleDisplayed());

		notebooksPageUser = computersPageUser.clickNotebooksLink();
		notebooksPageUser.waitUntilPageReady();

		verifyTrue(notebooksPageUser.isNotebooksPageTitleDisplayed());
	}

	@Test(priority = 1)
	public void S01_sortByNameAscending() {
		notebooksPageUser.selectSortBy(sortNameAtoZ);
		notebooksPageUser.waitUntilPageReady();

		verifyTrue(notebooksPageUser.isSortItemSelected(sortNameAtoZ));
		verifyTrue(notebooksPageUser.isNameSortedAscending());
	}

	@Test(priority = 2)
	public void S02_sortByNameDescending() {
		notebooksPageUser.selectSortBy(sortNameZtoA);
		notebooksPageUser.waitUntilPageReady();

		verifyTrue(notebooksPageUser.isSortItemSelected(sortNameZtoA));
		verifyTrue(notebooksPageUser.isNameSortedDescending());
	}

	@Test(priority = 3)
	public void S03_sortByPriceAscending() {
		notebooksPageUser.selectSortBy(sortPriceLowtoHigh);
		notebooksPageUser.waitUntilPageReady();

		verifyTrue(notebooksPageUser.isSortItemSelected(sortPriceLowtoHigh));
		verifyTrue(notebooksPageUser.isPriceSortedAscending());
	}

	@Test(priority = 4)
	public void S04_sortByPriceDescending() {
		notebooksPageUser.selectSortBy(sortPriceHightoLow);
		notebooksPageUser.waitUntilPageReady();

		verifyTrue(notebooksPageUser.isSortItemSelected(sortPriceHightoLow));
		verifyTrue(notebooksPageUser.isPriceSortedDescending());
	}

	@Test(priority = 5)
	public void S05_sortDisplayThreeProductsOnAPage() {
		notebooksPageUser.selectDisplay(displayThree);
		notebooksPageUser.waitUntilPageReady();

		verifyTrue(notebooksPageUser.isDisplayItemSelected(displayThree));
		verifyTrue(notebooksPageUser.areAllProductNameDisplayed());
		verifyTrue(notebooksPageUser.isCurrentPageDisplayed(pageOne));
		verifyTrue(notebooksPageUser.isNextIconDisplayed());

		notebooksPageUser.clickToNextPage();
		notebooksPageUser.waitUntilPageReady();

		verifyTrue(notebooksPageUser.areAllProductNameDisplayed());
		verifyTrue(notebooksPageUser.isCurrentPageDisplayed(pageTwo));
		verifyTrue(notebooksPageUser.isPreviousIconDisplayed());
	}

	@Test(priority = 6)
	public void S06_sortDisplaySixProductsOnAPage() {
		notebooksPageUser.selectDisplay(displaySix);
		notebooksPageUser.waitUntilPageReady();

		verifyTrue(notebooksPageUser.isDisplayItemSelected(displaySix));
		verifyTrue(notebooksPageUser.areAllProductNameDisplayed());
		verifyTrue(notebooksPageUser.isCurrentPageUndisplayed(pageOne));
	}

	@Test(priority = 7)
	public void S07_sortDisplayNineProductsOnAPage() {
		notebooksPageUser.selectDisplay(displayNine);
		notebooksPageUser.waitUntilPageReady();

		verifyTrue(notebooksPageUser.isDisplayItemSelected(displayNine));
		verifyTrue(notebooksPageUser.areAllProductNameDisplayed());
		verifyTrue(notebooksPageUser.isCurrentPageUndisplayed(pageOne));
	}
}
