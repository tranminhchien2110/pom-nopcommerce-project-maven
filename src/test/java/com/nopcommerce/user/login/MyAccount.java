package com.nopcommerce.user.login;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.data.DataUser;
import com.nopcommerce.pages.user.AddressesPageUser;
import com.nopcommerce.pages.user.ChangePasswordPageUser;
import com.nopcommerce.pages.user.CustomerInfoPageUser;
import com.nopcommerce.pages.user.DetailProductPageUser;
import com.nopcommerce.pages.user.HomePageUser;
import com.nopcommerce.pages.user.LoginPageUser;
import com.nopcommerce.pages.user.MyAccountPageUser;
import com.nopcommerce.pages.user.MyProductReviewPageUser;
import com.nopcommerce.pages.user.ReviewProductPageUser;
import com.nopcommerce.pages.user.SearchPageUser;
import com.nopcommerce.user.precondition.PreConditionLoginUser;

public class MyAccount extends PreConditionLoginUser {
	LoginPageUser loginPageUser;
	HomePageUser homePageUser;
	MyAccountPageUser myAccountPageUser;
	CustomerInfoPageUser customerInfoPageUser;
	AddressesPageUser addressesPageUser;
	SearchPageUser searchPageUser;
	DetailProductPageUser detailProductPageUser;
	ReviewProductPageUser reviewProductPageUser;
	MyProductReviewPageUser myProductReviewPageUser;
	ChangePasswordPageUser changePasswordPageUser;

	@BeforeClass
	public void openMyAccountPage() {
		homePageUser = getHomePageUser();
		loginPageUser = getLoginPageUser();
		myAccountPageUser = homePageUser.clickMyAccountLink();
		myAccountPageUser.waitUntilPageReady();

		verifyTrue(myAccountPageUser.isMyAccountPageTitleDisplayed());
	}

	@Test(priority = 1)
	public void MA01_updateForCustomerInfor() {
		customerInfoPageUser = myAccountPageUser.clickCustomerInforLink();
		customerInfoPageUser.waitUntilPageReady();

		verifyTrue(customerInfoPageUser.isCustomerInforPageTitleDisplayed());
		verifyTrue(customerInfoPageUser.isFirstNameValueDisplayed(DataUser.FIRSTNAME));
		verifyTrue(customerInfoPageUser.isLastNameValueDisplayed(DataUser.LASTNAME));
		verifyTrue(customerInfoPageUser.isEmailValueDisplayed(DataUser.EMAIL));

		customerInfoPageUser.selectMaleGender();
		customerInfoPageUser.inputToFirstNameTextbox(DataUser.FIRSTNAME_UPDATE);
		customerInfoPageUser.inputToLastNameTextbox(DataUser.LASTNAME_UPDATE);
		customerInfoPageUser.selectDay(DataUser.DAY);
		customerInfoPageUser.selectMonth(DataUser.MONTH);
		customerInfoPageUser.selectYear(DataUser.YEAR);
		customerInfoPageUser.inputToEmailTextbox(DataUser.EMAIL_UPDATE);
		customerInfoPageUser.inputToCompanyNameTextbox(DataUser.COMPANY_NAME);
		customerInfoPageUser.clickSaveButton();
		customerInfoPageUser.waitUntilPageReady();

		verifyTrue(customerInfoPageUser.isMaleGenderSelected());
		verifyTrue(customerInfoPageUser.isFirstNameValueDisplayed(DataUser.FIRSTNAME_UPDATE));
		verifyTrue(customerInfoPageUser.isLastNameValueDisplayed(DataUser.LASTNAME_UPDATE));
		verifyTrue(customerInfoPageUser.isDaySelected(DataUser.DAY));
		verifyTrue(customerInfoPageUser.isMonthSelected(DataUser.MONTH));
		verifyTrue(customerInfoPageUser.isYearSelected(DataUser.YEAR));
		verifyTrue(customerInfoPageUser.isEmailValueDisplayed(DataUser.EMAIL_UPDATE));
		verifyTrue(customerInfoPageUser.isCompayNameValueDisplayed(DataUser.COMPANY_NAME));

		myAccountPageUser = customerInfoPageUser.clickMyAccountLink();
		myAccountPageUser.waitUntilPageReady();

		verifyTrue(myAccountPageUser.isMyAccountPageTitleDisplayed());
	}

	@Test(priority = 2)
	public void MA02_addNewAddressForCustomerInfor() {
		addressesPageUser = myAccountPageUser.clickAddressesLink();
		addressesPageUser.waitUntilPageReady();

		verifyTrue(addressesPageUser.isAddressesPageTitleDisplayed());

		addressesPageUser.clickAddNewButton();
		addressesPageUser.waitUntilPageReady();

		verifyTrue(addressesPageUser.isAddNewAddressPageTitleDisplayed());

		addressesPageUser.inputToAddressFirstNameTextBox(DataUser.ADDRESS_FIRSTNAME);
		addressesPageUser.inputToAddressLastNameTextBox(DataUser.ADDRESS_LASTNAME);
		addressesPageUser.inputToAddressEmailTextBox(DataUser.ADDRESS_EMAIL);
		addressesPageUser.selectAddressCountry(DataUser.ADDRESS_COUNTRY);
		addressesPageUser.inputToAddressCityTextBox(DataUser.ADDRESS_CITY);
		addressesPageUser.inputToAddressAddress1TextBox(DataUser.ADDRESS_ADDRESS1);
		addressesPageUser.inputToAddressZipCodeTextBox(DataUser.ADDRESS_ZIP_CODE);
		addressesPageUser.inputToAddressPhoneNumberTextBox(DataUser.ADDRESS_PHONE_NUMBER);
		addressesPageUser.inputToAddressFaxNumberTextBox(DataUser.ADDRESS_FAX_NUMBER);
		addressesPageUser.clickSaveButton();
		addressesPageUser.waitUntilPageReady();

		String fullName = DataUser.ADDRESS_FIRSTNAME + " " + DataUser.ADDRESS_LASTNAME;
		String cityAndZipCode = DataUser.ADDRESS_CITY + ", " + DataUser.ADDRESS_ZIP_CODE;

		verifyTrue(addressesPageUser.isAddressesPageTitleDisplayed());
		verifyTrue(addressesPageUser.isAddressInforNameDisplayed(fullName));
		verifyTrue(addressesPageUser.isAddressNameDisplayed(fullName));
		verifyTrue(addressesPageUser.isAddressEmailDisplayed(DataUser.ADDRESS_EMAIL));
		verifyTrue(addressesPageUser.isAddressPhoneNumberDisplayed(DataUser.ADDRESS_PHONE_NUMBER));
		verifyTrue(addressesPageUser.isAddressFaxNumberDisplayed(DataUser.ADDRESS_FAX_NUMBER));
		verifyTrue(addressesPageUser.isAddressAddress1Displayed(DataUser.ADDRESS_ADDRESS1));
		verifyTrue(addressesPageUser.isAddressCityStateZipDisplayed(cityAndZipCode));
		verifyTrue(addressesPageUser.isAddressCountryDisplayed(DataUser.ADDRESS_COUNTRY));

		myAccountPageUser = addressesPageUser.clickMyAccountLink();
		myAccountPageUser.waitUntilPageReady();

		verifyTrue(myAccountPageUser.isMyAccountPageTitleDisplayed());
	}

	@Test(priority = 3, dependsOnMethods = { "MA01_updateForCustomerInfor" })
	public void MA03_changePasswordAndLoginWithNewPassword() {
		changePasswordPageUser = myAccountPageUser.clickChangePasswordLink();
		changePasswordPageUser.waitUntilPageReady();

		verifyTrue(changePasswordPageUser.isChangePasswordPageTitleDisplayed());

		changePasswordPageUser.inputToOldPasswordTextbox(DataUser.PASSWORD);
		changePasswordPageUser.inputToNewPasswordTextbox(DataUser.NEW_PASSWORD);
		changePasswordPageUser.inputToConfirmNewPasswordTextbox(DataUser.NEW_PASSWORD);
		changePasswordPageUser.clickChangePasswordButton();
		changePasswordPageUser.waitUntilPageReady();

		verifyTrue(changePasswordPageUser.isChangePasswordSuccessMessageDisplayed());

		homePageUser = changePasswordPageUser.clickLogOutLink();
		homePageUser.waitUntilPageReady();

		verifyTrue(homePageUser.isHomePageTitleDislayed());

		loginPageUser = homePageUser.clickLoginLink();
		loginPageUser.waitUntilPageReady();

		verifyTrue(loginPageUser.isWelcomeSignInMessageDisplayed());

		loginPageUser.inputToEmailTextbox(DataUser.EMAIL_UPDATE);
		loginPageUser.inputToPasswordTextbox(DataUser.PASSWORD);
		loginPageUser.clickLoginButton();

		verifyTrue(loginPageUser.isErrorMessageDisplayed());
		verifyEquals(loginPageUser.getErrorMessage(), DataUser.LOGIN_WAS_UNSUCCESSFUL + "\n" + DataUser.CREDENTIALS_PROVIDED_ARE_INCORRECT);

		loginPageUser.inputToEmailTextbox(DataUser.EMAIL_UPDATE);
		loginPageUser.inputToPasswordTextbox(DataUser.NEW_PASSWORD);
		loginPageUser.clickLoginButton();

		homePageUser.waitUntilPageReady();

		verifyTrue(homePageUser.isHomePageTitleDislayed());
		verifyTrue(homePageUser.isMyAccountLinkDisplayed());
		verifyTrue(homePageUser.isLogOutLinkDisplayed());

		myAccountPageUser = homePageUser.clickMyAccountLink();
		myAccountPageUser.waitUntilPageReady();

		verifyTrue(myAccountPageUser.isMyAccountPageTitleDisplayed());
	}

	@Test(priority = 4)
	public void MA04_reviewProductAndCheckMyProductReview() {
		myAccountPageUser.inputToSearchTextbox("mac");
		searchPageUser = myAccountPageUser.clickToSearchButton();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isSearchPageTitleDisplayed());
		verifyTrue(searchPageUser.areAllProductNameDisplayed());

		detailProductPageUser = searchPageUser.clickToProductByIndex(0);
		detailProductPageUser.waitUntilPageReady();

		verifyTrue(detailProductPageUser.isDetailProductPageTitleDisplayed());

		String productName = detailProductPageUser.getProductName();

		reviewProductPageUser = detailProductPageUser.clickAddYourReviewLink();
		reviewProductPageUser.waitUntilPageReady();

		verifyTrue(reviewProductPageUser.isReviewProductPageTitleDisplayed());

		String reviewTitle = "New review title " + getRandomNumber();
		String reviewText = "New review text " + getRandomNumber();

		reviewProductPageUser.inputToReviewTitleTextbox(reviewTitle);
		reviewProductPageUser.inputToReviewTextTextarea(reviewText);
		reviewProductPageUser.clickSubmitReviewButton();
		reviewProductPageUser.waitUntilPageReady();

		verifyTrue(reviewProductPageUser.isReviewProductSuccessMessageDisplayed());
		verifyTrue(reviewProductPageUser.isReviewCommentDisplayed(reviewTitle, reviewText));

		myAccountPageUser = reviewProductPageUser.clickMyAccountLink();
		myAccountPageUser.waitUntilPageReady();

		verifyTrue(myAccountPageUser.isMyAccountPageTitleDisplayed());

		myProductReviewPageUser = myAccountPageUser.clickMyProductReviewLink();
		myProductReviewPageUser.waitUntilPageReady();

		verifyTrue(myProductReviewPageUser.isMyProductReviewPageTitleDisplayed());
		verifyTrue(myProductReviewPageUser.isReviewCommentDisplayed(reviewTitle, reviewText, productName));

		myAccountPageUser = myProductReviewPageUser.clickMyAccountLink();
		myAccountPageUser.waitUntilPageReady();

		verifyTrue(myAccountPageUser.isMyAccountPageTitleDisplayed());
	}
}
