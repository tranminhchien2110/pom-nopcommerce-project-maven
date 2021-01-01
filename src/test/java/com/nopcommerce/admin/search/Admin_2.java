package com.nopcommerce.admin.search;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.admin.precondition.PreConditionLoginAdmin;
import com.nopcommerce.data.DataAdmin;
import com.nopcommerce.pages.admin.AddNewAddressAdminPage;
import com.nopcommerce.pages.admin.AddNewCustomerPageAdmin;
import com.nopcommerce.pages.admin.CustomersPageAdmin;
import com.nopcommerce.pages.admin.EditAddressPageAdmin;
import com.nopcommerce.pages.admin.EditCustomerDetailsPageAdmin;
import com.nopcommerce.pages.admin.HomePageAdmin;

public class Admin_2 extends PreConditionLoginAdmin {

	@BeforeClass
	public void openCustomersPageAdmin() {
		homePageAdmin = getHomePageAdmin();
		homePageAdmin.clickToDynamicSubMenuTitleLink(subMenuTitle_customers);
		homePageAdmin.clickToDynamicSubMenuItemLink(subMenuItem_customers);

		customersPageAdmin = CustomersPageAdmin.getCustomersPageAdmin(getDriver());

		verifyTrue(customersPageAdmin.isCustomersPageAdminTitleDisplayed());
	}

	@Test
	public void Admin07_createNewCustomer() {
		customersPageAdmin.clickToAddNewButton();

		addNewCustomerPageAdmin = AddNewCustomerPageAdmin.getAddANewCustomerPageAdmin(getDriver());

		verifyTrue(addNewCustomerPageAdmin.isAddANewCustomerPageAdminTitleDisplayed());

		addNewCustomerPageAdmin.inputToEmailTextbox(email);
		addNewCustomerPageAdmin.inputToPasswordTextbox(password);
		addNewCustomerPageAdmin.inputToFirstNameTextbox(firstName);
		addNewCustomerPageAdmin.inputToLastNameTextbox(lastName);
		addNewCustomerPageAdmin.checkGenderMaleCheckbox();
		addNewCustomerPageAdmin.inputToDateOfBirthTextbox(dateOfBirth);
		addNewCustomerPageAdmin.inputToCompanyTextbox(companyName);
		addNewCustomerPageAdmin.checkActiveCheckbox();
		addNewCustomerPageAdmin.clickToCloseButtonOfItemCustomerRole(customerRole_item_registered);
		addNewCustomerPageAdmin.inputToCustomerRolesTextbox(customerRole_item_guests);
		addNewCustomerPageAdmin.inputToAdminCommentTextarea(adminComment);
		addNewCustomerPageAdmin.clickToSaveAndContinueButton();

		verifyTrue(addNewCustomerPageAdmin.isAddANewCustomerSuccessMessageDisplayed());

		addNewCustomerPageAdmin.clickBackToDynamicLink(backTo_customerList);

		customersPageAdmin = CustomersPageAdmin.getCustomersPageAdmin(getDriver());

		verifyTrue(customersPageAdmin.isCustomersPageAdminTitleDisplayed());

		customersPageAdmin.clickToCloseButtonOfItemCustomerRole(customerRole_item_registered);
		customersPageAdmin.inputToCustomerRolesTextbox(customerRole_item_guests);
		customersPageAdmin.clickToSearchButton();

		String[] columnNames = { columnName_name, columnName_customerRoles, columnName_companyName };
		String[] columnValues = { fullName, customerRole_item_guests, companyName };

		verifyTrue(customersPageAdmin.areAllValuesDisplayedOnOneRowByColumnNameAndValue(columnNames, columnValues));
	}

	@Test(dependsOnMethods = "Admin07_createNewCustomer")
	public void Admin08_searchCustomerWithEmail() {
		customersPageAdmin.inputToEmailTextbox(email);
		customersPageAdmin.clickToCloseButtonOfItemCustomerRole(customerRole_item_guests);
		customersPageAdmin.inputToCustomerRolesTextbox(customerRole_item_guests);
		customersPageAdmin.clickToSearchButton();

		String[] columnNames = { columnName_email, columnName_name, columnName_customerRoles, columnName_companyName };
		String[] columnValues = { customerRole_item_guest, fullName, customerRole_item_guests, companyName };

		verifyTrue(customersPageAdmin.isOnlyOneRowDisplayed());
		verifyTrue(customersPageAdmin.areAllValuesDisplayedOnOneRowByColumnNameAndValue(columnNames, columnValues));
	}

	@Test(dependsOnMethods = "Admin07_createNewCustomer")
	public void Admin09_searchCustomerWithFirstAndLastName() {
		customersPageAdmin.inputToEmailTextbox("");
		customersPageAdmin.inputToFirstNameTextbox(firstName);
		customersPageAdmin.inputToLastNameTextbox(lastName);
		customersPageAdmin.clickToCloseButtonOfItemCustomerRole(customerRole_item_guests);
		customersPageAdmin.inputToCustomerRolesTextbox(customerRole_item_guests);
		customersPageAdmin.clickToSearchButton();

		String[] columnNames = { columnName_email, columnName_name, columnName_customerRoles, columnName_companyName };
		String[] columnValues = { customerRole_item_guest, fullName, customerRole_item_guests, companyName };

		verifyTrue(customersPageAdmin.isOnlyOneRowDisplayed());
		verifyTrue(customersPageAdmin.areAllValuesDisplayedOnOneRowByColumnNameAndValue(columnNames, columnValues));
	}

	@Test(dependsOnMethods = "Admin07_createNewCustomer")
	public void Admin10_searchCustomerWithCompayName() {
		customersPageAdmin.inputToEmailTextbox("");
		customersPageAdmin.inputToFirstNameTextbox("");
		customersPageAdmin.inputToLastNameTextbox("");
		customersPageAdmin.inputToCompanyTextbox(companyName);
		customersPageAdmin.clickToCloseButtonOfItemCustomerRole(customerRole_item_guests);
		customersPageAdmin.inputToCustomerRolesTextbox(customerRole_item_guests);
		customersPageAdmin.clickToSearchButton();

		String[] columnNames = { columnName_email, columnName_name, columnName_customerRoles, columnName_companyName };
		String[] columnValues = { customerRole_item_guest, fullName, customerRole_item_guests, companyName };

		verifyTrue(customersPageAdmin.isOnlyOneRowDisplayed());
		verifyTrue(customersPageAdmin.areAllValuesDisplayedOnOneRowByColumnNameAndValue(columnNames, columnValues));
	}

	@Test(dependsOnMethods = "Admin07_createNewCustomer")
	public void Admin11_searchCustomerWithFullData() {
		customersPageAdmin.inputToEmailTextbox(email);
		customersPageAdmin.inputToFirstNameTextbox(firstName);
		customersPageAdmin.inputToLastNameTextbox(lastName);

		String day = customersPageAdmin.getDayFromDateOfBirth(dateOfBirth);
		String month = customersPageAdmin.getMonthFromDateOfBirth(dateOfBirth);

		customersPageAdmin.selectDayOfBirthList(day);
		customersPageAdmin.selectMonthOfBirthList(month);
		customersPageAdmin.inputToCompanyTextbox(companyName);
		customersPageAdmin.clickToCloseButtonOfItemCustomerRole(customerRole_item_guests);
		customersPageAdmin.inputToCustomerRolesTextbox(customerRole_item_guests);
		customersPageAdmin.clickToSearchButton();

		String[] columnNames = { columnName_email, columnName_name, columnName_customerRoles, columnName_companyName };
		String[] columnValues = { customerRole_item_guest, fullName, customerRole_item_guests, companyName };

		verifyTrue(customersPageAdmin.isOnlyOneRowDisplayed());
		verifyTrue(customersPageAdmin.areAllValuesDisplayedOnOneRowByColumnNameAndValue(columnNames, columnValues));
	}

	@Test(dependsOnMethods = "Admin07_createNewCustomer")
	public void Admin12_editCustomerInfor() {
		customersPageAdmin.clickEditButtonOnTableByDynamicValueOnRow(fullName);

		editCustomerDetailsPageAdmin = EditCustomerDetailsPageAdmin.getEditCustomerDetailsPageAdmin(getDriver());

		verifyTrue(editCustomerDetailsPageAdmin.isEditCustomerDetailsPageAdminTitleDisplayed());

		editCustomerDetailsPageAdmin.clickOpenPanelHeadingByPanelName(panelName_customerInfo);
		editCustomerDetailsPageAdmin.inputToEmailTextbox(editEmail);
		editCustomerDetailsPageAdmin.inputToFirstNameTextbox(editFirstName);
		editCustomerDetailsPageAdmin.inputToLastNameTextbox(editLastName);
		editCustomerDetailsPageAdmin.inputToDateOfBirthTextbox(editDateOfBirth);
		editCustomerDetailsPageAdmin.inputToCompanyTextbox(editCompanyName);
		editCustomerDetailsPageAdmin.inputToAdminCommentTextarea(editAdminComment);
		editCustomerDetailsPageAdmin.clickToSaveAndContinueButton();

		verifyTrue(editCustomerDetailsPageAdmin.isEditCustomerSuccessMessageDisplayed());

		editCustomerDetailsPageAdmin.clickBackToDynamicLink(backTo_customerList);

		customersPageAdmin = CustomersPageAdmin.getCustomersPageAdmin(getDriver());

		verifyTrue(customersPageAdmin.isCustomersPageAdminTitleDisplayed());

		customersPageAdmin.inputToEmailTextbox(editEmail);
		customersPageAdmin.inputToFirstNameTextbox(editFirstName);
		customersPageAdmin.inputToLastNameTextbox(editLastName);

		String day = customersPageAdmin.getDayFromDateOfBirth(editDateOfBirth);
		String month = customersPageAdmin.getMonthFromDateOfBirth(editDateOfBirth);

		customersPageAdmin.selectDayOfBirthList(day);
		customersPageAdmin.selectMonthOfBirthList(month);
		customersPageAdmin.inputToCompanyTextbox(editCompanyName);
		customersPageAdmin.clickToCloseButtonOfItemCustomerRole(customerRole_item_registered);
		customersPageAdmin.inputToCustomerRolesTextbox(customerRole_item_guests);
		customersPageAdmin.clickToSearchButton();

		String[] columnNames = { columnName_email, columnName_name, columnName_customerRoles, columnName_companyName };
		String[] columnValues = { customerRole_item_guest, editFullName, customerRole_item_guests, editCompanyName };

		verifyTrue(customersPageAdmin.isOnlyOneRowDisplayed());
		verifyTrue(customersPageAdmin.areAllValuesDisplayedOnOneRowByColumnNameAndValue(columnNames, columnValues));
	}

	@Test(dependsOnMethods = "Admin12_editCustomerInfor")
	public void Admin13_addNewAddressForCustomerInfor() {
		customersPageAdmin.clickEditButtonOnTableByDynamicValueOnRow(editFullName);

		editCustomerDetailsPageAdmin = EditCustomerDetailsPageAdmin.getEditCustomerDetailsPageAdmin(getDriver());

		verifyTrue(editCustomerDetailsPageAdmin.isEditCustomerDetailsPageAdminTitleDisplayed());

		editCustomerDetailsPageAdmin.clickOpenPanelHeadingByPanelName(panelName_addresses);

		addNewAddressPageAdmin = editCustomerDetailsPageAdmin.clickAddNewButtonAddress();

		verifyTrue(addNewAddressPageAdmin.isAddNewAddressPageAdminTitleDisplayed());

		addNewAddressPageAdmin.inputToFirstNameTextbox(addressFirstName);
		addNewAddressPageAdmin.inputToLastNameTextbox(addressLastName);
		addNewAddressPageAdmin.inputToEmailTextbox(addressEmail);
		addNewAddressPageAdmin.inputToCompanyTextbox(addressCompanyName);
		addNewAddressPageAdmin.selectCountryList(addressCountry);
		addNewAddressPageAdmin.inputToCityTextbox(addressCity);
		addNewAddressPageAdmin.inputToAddressOneTextbox(addressAddressOne);
		addNewAddressPageAdmin.inputToAddressTwoTextbox(addressAddressTwo);
		addNewAddressPageAdmin.inputToZipCodeTextbox(addressZipCode);
		addNewAddressPageAdmin.inputToPhoneNumberTextbox(addressPhoneNumber);
		addNewAddressPageAdmin.inputToFaxNumberTextbox(addressFaxNumber);
		addNewAddressPageAdmin.clickToSaveButton();

		verifyTrue(addNewAddressPageAdmin.isAddNewAddressSuccessMessageDisplayed());

		addNewAddressPageAdmin.clickBackToDynamicLink(backTo_customerDetails);

		editCustomerDetailsPageAdmin = EditCustomerDetailsPageAdmin.getEditCustomerDetailsPageAdmin(getDriver());

		verifyTrue(editCustomerDetailsPageAdmin.isEditCustomerDetailsPageAdminTitleDisplayed());

		editCustomerDetailsPageAdmin.clickOpenPanelHeadingByPanelName(panelName_addresses);

		String[] columnNames = { columnName_firstName, columnName_lastName, columnName_email, columnName_phoneNumber, columnName_faxNumber, columnName_address };
		String[] columnValues = { addressFirstName, addressLastName, addressEmail, addressPhoneNumber, addressFaxNumber, addressTotalValue };

		verifyTrue(editCustomerDetailsPageAdmin.areAllValuesDisplayedOnOneRowByColumnNameAndValue(columnNames, columnValues));
	}

	@Test(dependsOnMethods = "Admin13_addNewAddressForCustomerInfor")
	public void Admin14_editAddressForCustomerInfor() {
		editCustomerDetailsPageAdmin.clickOpenPanelHeadingByPanelName(panelName_addresses);
		editCustomerDetailsPageAdmin.clickEditButtonOnTableByDynamicValueOnRow(addressEmail);

		editAddressPageAdmin = EditAddressPageAdmin.getEditAddressPageAdmin(getDriver());

		editAddressPageAdmin.inputToFirstNameTextbox(editAddressFirstName);
		editAddressPageAdmin.inputToLastNameTextbox(editAddressLastName);
		editAddressPageAdmin.inputToEmailTextbox(editAddressEmail);
		editAddressPageAdmin.inputToCompanyTextbox(editAddressCompanyName);
		editAddressPageAdmin.selectCountryList(editAddressCountry);
		editAddressPageAdmin.inputToCityTextbox(editAddressCity);
		editAddressPageAdmin.inputToAddressOneTextbox(editAddressAddressOne);
		editAddressPageAdmin.inputToAddressTwoTextbox(editAddressAddressTwo);
		editAddressPageAdmin.inputToZipCodeTextbox(editAddressZipCode);
		editAddressPageAdmin.inputToPhoneNumberTextbox(editAddressPhoneNumber);
		editAddressPageAdmin.inputToFaxNumberTextbox(editAddressFaxNumber);
		editAddressPageAdmin.clickToSaveButton();

		verifyTrue(editAddressPageAdmin.isEditAddressSuccessMessageDisplayed());

		editAddressPageAdmin.clickBackToDynamicLink(backTo_customerDetails);

		editCustomerDetailsPageAdmin = EditCustomerDetailsPageAdmin.getEditCustomerDetailsPageAdmin(getDriver());

		verifyTrue(editCustomerDetailsPageAdmin.isEditCustomerDetailsPageAdminTitleDisplayed());

		editCustomerDetailsPageAdmin.clickOpenPanelHeadingByPanelName(panelName_addresses);

		String[] columnNames = { columnName_firstName, columnName_lastName, columnName_email, columnName_phoneNumber, columnName_faxNumber, columnName_address };
		String[] columnValues = { editAddressFirstName, editAddressLastName, editAddressEmail, editAddressPhoneNumber, editAddressFaxNumber, editAddressTotalValue };

		verifyTrue(editCustomerDetailsPageAdmin.areAllValuesDisplayedOnOneRowByColumnNameAndValue(columnNames, columnValues));
	}

	@Test(dependsOnMethods = "Admin14_editAddressForCustomerInfor")
	public void Admin15_deleteAddressForCustomerInfor() {
		editCustomerDetailsPageAdmin.clickOpenPanelHeadingByPanelName(panelName_addresses);
		editCustomerDetailsPageAdmin.clickDeleteButtonOnTableByDynamicValueOnRow(editAddressEmail);
		editCustomerDetailsPageAdmin.acceptDeleteAddressAlert();

		verifyTrue(editCustomerDetailsPageAdmin.isNoRowDisplayed(panelName_addresses));
		verifyTrue(editCustomerDetailsPageAdmin.isNoDataAvailableInTableMessageDisplayed(panelName_addresses));
	}

	HomePageAdmin homePageAdmin;
	CustomersPageAdmin customersPageAdmin;
	AddNewCustomerPageAdmin addNewCustomerPageAdmin;
	EditCustomerDetailsPageAdmin editCustomerDetailsPageAdmin;
	AddNewAddressAdminPage addNewAddressPageAdmin;
	EditAddressPageAdmin editAddressPageAdmin;
	DataAdmin data = DataAdmin.getDataAdmin();
	// Customer infor
	String email = data.getEmail();
	String password = data.getPassword();
	String firstName = data.getFirstName();
	String lastName = data.getLastName();
	String fullName = firstName + " " + lastName;
	String dateOfBirth = data.getDateOfBirth();
	String companyName = data.getCompanyName();
	String adminComment = "Text admin comment " + password;
	String customerRole_item_registered = "Registered";
	String customerRole_item_guests = "Guests";
	String customerRole_item_guest = "Guest";
	// Edit customer infor
	String editEmail = data.getEmail();
	String editFirstName = data.getFirstName();
	String editLastName = data.getLastName();
	String editFullName = editFirstName + " " + editLastName;
	String editDateOfBirth = data.getDateOfBirth();
	String editCompanyName = data.getCompanyName();
	String editAdminComment = "Edit Text admin comment " + password;
	// Address customer infor
	String addressEmail = data.getEmail();
	String addressFirstName = data.getFirstName();
	String addressLastName = data.getLastName();
	String addressCompanyName = data.getCompanyName();
	String addressCountry = "Viet Nam";
	String addressCity = data.getCity();
	String addressAddressOne = data.getAddress();
	String addressAddressTwo = data.getAddress();
	String addressZipCode = data.getZipCode();
	String addressPhoneNumber = data.getPhoneNumber();
	String addressFaxNumber = data.getFaxNumber();
	String addressTotalValue = addressCompanyName + addressAddressOne + addressAddressTwo + addressCity + "," + addressZipCode + addressCountry;
	// Edit address customer infor
	String editAddressEmail = data.getEmail();
	String editAddressFirstName = data.getFirstName();
	String editAddressLastName = data.getLastName();
	String editAddressCompanyName = data.getCompanyName();
	String editAddressCountry = "Thailand";
	String editAddressCity = data.getCity();
	String editAddressAddressOne = data.getAddress();
	String editAddressAddressTwo = data.getAddress();
	String editAddressZipCode = data.getZipCode();
	String editAddressPhoneNumber = data.getPhoneNumber();
	String editAddressFaxNumber = data.getFaxNumber();
	String editAddressTotalValue = editAddressCompanyName + editAddressAddressOne + editAddressAddressTwo + editAddressCity + "," + editAddressZipCode + editAddressCountry;
	// Submenu name
	String subMenuTitle_customers = "Customers";
	String subMenuItem_customers = "Customers";
	// Panel name
	String panelName_customerInfo = "Customer info";
	String panelName_addresses = "Addresses";
	// Link
	String backTo_customerList = "customer list";
	String backTo_customerDetails = "customer details";
	// Column name
	String columnName_email = "Email";
	String columnName_name = "Name";
	String columnName_firstName = "First name";
	String columnName_lastName = "Last name";
	String columnName_customerRoles = "Customer roles";
	String columnName_companyName = "Company name";
	String columnName_phoneNumber = "Phone number";
	String columnName_faxNumber = "Fax number";
	String columnName_address = "Address";
}
