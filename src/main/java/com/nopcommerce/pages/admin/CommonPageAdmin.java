package com.nopcommerce.pages.admin;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.base.BasePage;

public class CommonPageAdmin extends BasePage {
	private final String LINK_DYNAMIC_SUBMENU_TITLE = "//span[text()='%s']/parent::a";
	private final String LINK_DYNAMIC_SUBMENU_ITEM = "//span[text()='%s' and @class='menu-item-title']/parent::a";
	private final String LINK_DYNAMIC_BACK_TO_LIST = "//a[text()='back to %s']";
	private final String TEXTBOX_EMAIL = "//input[contains(@name,'Email') and not(contains(@type,'hidden'))]";
	private final String TEXTBOX_PASSWORD = "//input[contains(@name,'Password') and not(contains(@type,'hidden'))]";
	private final String TEXTBOX_FIRSTNAME = "//input[contains(@name,'FirstName') and not(contains(@type,'hidden'))]";
	private final String TEXTBOX_LASTNAME = "//input[contains(@name,'LastName') and not(contains(@type,'hidden'))]";
	private final String TEXTBOX_COMPANY_NAME = "//input[contains(@name,'Company') and not(contains(@type,'hidden'))]";
	private final String TEXTBOX_CUSTOMER_ROLES = "//input[@aria-describedby='SelectedCustomerRoleIds_taglist']";
	private final String TEXTBOX_DATE_OF_BIRTH = "//input[@id='DateOfBirth']";
	private final String TEXTBOX_CITY = "//input[contains(@name,'City') and not(contains(@type,'hidden'))]";
	private final String TEXTBOX_ADDRESS_1 = "//input[contains(@name,'Address1') and not(contains(@type,'hidden'))]";
	private final String TEXTBOX_ADDRESS_2 = "//input[contains(@name,'Address2') and not(contains(@type,'hidden'))]";
	private final String TEXTBOX_ZIP_CODE = "//input[contains(@name,'Zip') and not(contains(@type,'hidden'))]";
	private final String TEXTBOX_PHONE_NUMBER = "//input[contains(@name,'PhoneNumber') and not(contains(@type,'hidden'))]";
	private final String TEXTBOX_FAX_NUMBER = "//input[contains(@name,'FaxNumber') and not(contains(@type,'hidden'))]";
	private final String TEXTAREA_ADMIN_COMMENT = "//textarea[@id='AdminComment']";
	private final String CHECKBOX_GENDER_MALE = "//input[@id='Gender_Male']";
	private final String CHECKBOX_ACTIVE = "//input[@id='Active']";
	private final String BUTTON_CLOSE_ITEM_CUSTOMER_ROLE_BY_ITEM_NAME = "//span[text()='%s']/following-sibling::span";
	private final String BUTTON_SEARCH = "//button[contains(.,'Search')]";
	private final String BUTTON_GO = "//button[contains(.,'Go')]";
	private final String BUTTON_ADD_NEW = "//a[contains(.,'Add new')]";
	private final String BUTTON_SAVE = "//button[contains(.,'Save') and not(contains(@name,'save-continue'))]";
	private final String BUTTON_SAVE_AND_CONTINUE = "//button[contains(.,'Save and Continue Edit')]";
	private final String TABLE_COLUMN_INDEX_BY_COLUMN_NAME = "//div[@class='dataTables_scrollHeadInner']//th[text()='%s']/preceding-sibling::th";
	private final String TABLE_ROW_VALUE_BY_COLUMN_INDEX = "//div[@class='dataTables_scrollBody']//tbody//tr[%s]";
	private final String TABLE_NUMBER_OF_ROW = "//div[@class='dataTables_scrollBody']//tbody//tr[not(contains(.,'No data available'))]";
	private final String TABLE_NUMBER_OF_ROW_BY_PANEL_HEADING_NAME = "//div[span[text()='%s']]/following-sibling::div//div[@class='dataTables_scrollBody']//tbody//tr[not(contains(.,'No data available'))]";
	private final String TABLE_BUTTON_EDIT_BY_DYNAMIC_VALUE_ON_ROW = "//div[@class='dataTables_scrollBody']//tbody//tr[td[text()='%s']]//a[contains(.,'Edit')]";
	private final String TABLE_BUTTON_DELELTE_BY_DYNAMIC_VALUE_ON_ROW = "//div[@class='dataTables_scrollBody']//tbody//tr[td[text()='%s']]//a[contains(.,'Delete')]";
	private final String TABLE_MESSAGE_NO_DATA_AVAILABLE = "//div[@class='dataTables_scrollBody']//tbody//tr[contains(.,'No data available in table')]";
	private final String TABLE_MESSAGE_NO_DATA_AVAILABLE_BY_PANEL_HEADING_NAME = "//div[span[text()='%s']]/following-sibling::div//div[@class='dataTables_scrollBody']//tbody//tr[contains(.,'No data available in table')]";
	private final String PANEL_HEADING_DYNAMIC_NAME = "//div[@class='panel-heading' and span[text()='%s']]";
	private final String PANEL_HEADING_OPENED_DYNAMIC_NAME = "//div[(@class='panel-heading opened' or @class='opened panel-heading') and span[text()='%s']]";
	private final String DROPDOWN_LIST_COUNTRY = "//select[@id='Address_CountryId']";
	private final String MESSAGE_DELETE_ADDRESS = "Are you sure you want to delete this item?";

	public CommonPageAdmin(WebDriver driver) {
		super(driver);
	}

	public void waitUntilPageReady() {
		waitUntilJSReady();
		ajaxComplete();
		waitUntilJQueryReady();
	}

	public void clickEditButtonOnTableByDynamicValueOnRow(String dynamicValueOnRow) {
		clickToElement(TABLE_BUTTON_EDIT_BY_DYNAMIC_VALUE_ON_ROW, dynamicValueOnRow);
	}

	public void clickDeleteButtonOnTableByDynamicValueOnRow(String dynamicValueOnRow) {
		clickToElement(TABLE_BUTTON_DELELTE_BY_DYNAMIC_VALUE_ON_ROW, dynamicValueOnRow);
	}

	public void clickToSearchButton() {
		clickToElement(BUTTON_SEARCH);
		waitUntilPageReady();
	}

	public void clickToGoButton() {
		clickToElement(BUTTON_GO);
		waitUntilPageReady();
	}

	public void clickToAddNewButton() {
		clickToElement(BUTTON_ADD_NEW);
		waitUntilPageReady();
	}

	public void clickToSaveButton() {
		clickToElement(BUTTON_SAVE);
		waitUntilPageReady();
	}

	public void clickToSaveAndContinueButton() {
		clickToElement(BUTTON_SAVE_AND_CONTINUE);
		waitUntilPageReady();
	}

	public void clickToDynamicSubMenuTitleLink(String subMenuTitle) {
		clickToElement(LINK_DYNAMIC_SUBMENU_TITLE, subMenuTitle);
		waitUntilPageReady();
	}

	public void clickToDynamicSubMenuItemLink(String subMenuItem) {
		clickToElement(LINK_DYNAMIC_SUBMENU_ITEM, subMenuItem);
		waitUntilPageReady();
	}

	public void clickToCloseButtonOfItemCustomerRole(String itemCustomerRoleName) {
		clickToElement(BUTTON_CLOSE_ITEM_CUSTOMER_ROLE_BY_ITEM_NAME, itemCustomerRoleName);
	}

	public void clickBackToDynamicLink(String pageList) {
		clickToElement(LINK_DYNAMIC_BACK_TO_LIST, pageList);
	}

	public void clickOpenPanelHeadingByPanelName(String panelName) {
		if (isElementUndisplayed(PANEL_HEADING_OPENED_DYNAMIC_NAME, panelName))
			clickToElement(PANEL_HEADING_DYNAMIC_NAME, panelName);
	}

	public void checkGenderMaleCheckbox() {
		checkToCheckbox(CHECKBOX_GENDER_MALE);
	}

	public void checkActiveCheckbox() {
		checkToCheckbox(CHECKBOX_ACTIVE);
	}

	public void inputToEmailTextbox(String emailValue) {
		sendKeysToElement(TEXTBOX_EMAIL, emailValue);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		sendKeysToElement(TEXTBOX_PASSWORD, passwordValue);
	}

	public void inputToCustomerRolesTextbox(String customerRolesValue) {
		sendKeysToElement(TEXTBOX_CUSTOMER_ROLES, customerRolesValue);
		waitUntilPageReady();
		sendEnterKeyFromKeyboard();
		waitUntilPageReady();
	}

	public void inputToFirstNameTextbox(String firstNamevalue) {
		sendKeysToElement(TEXTBOX_FIRSTNAME, firstNamevalue);
	}

	public void inputToLastNameTextbox(String lastNamevalue) {
		sendKeysToElement(TEXTBOX_LASTNAME, lastNamevalue);
	}

	public void inputToDateOfBirthTextbox(String value) {
		sendKeysToElement(TEXTBOX_DATE_OF_BIRTH, value);
	}

	public void inputToAdminCommentTextarea(String value) {
		sendKeysToElement(TEXTAREA_ADMIN_COMMENT, value);
	}

	public void inputToCompanyTextbox(String companyNamevalue) {
		sendKeysToElement(TEXTBOX_COMPANY_NAME, companyNamevalue);
	}

	public void inputToCityTextbox(String cityValue) {
		sendKeysToElement(TEXTBOX_CITY, cityValue);
	}

	public void inputToAddressOneTextbox(String address1Value) {
		sendKeysToElement(TEXTBOX_ADDRESS_1, address1Value);
	}

	public void inputToAddressTwoTextbox(String address2Value) {
		sendKeysToElement(TEXTBOX_ADDRESS_2, address2Value);
	}

	public void inputToZipCodeTextbox(String zipCodeValue) {
		sendKeysToElement(TEXTBOX_ZIP_CODE, zipCodeValue);
	}

	public void inputToPhoneNumberTextbox(String phoneNumberValue) {
		sendKeysToElement(TEXTBOX_PHONE_NUMBER, phoneNumberValue);
	}

	public void inputToFaxNumberTextbox(String faxNumberValue) {
		sendKeysToElement(TEXTBOX_FAX_NUMBER, faxNumberValue);
	}

	public void selectCountryList(String countryName) {
		selectValueInDropdownList(DROPDOWN_LIST_COUNTRY, countryName);
	}

	public void acceptDeleteAddressAlert() {
		if (getTextFromAlert().equals(MESSAGE_DELETE_ADDRESS)) {
			acceptAlert();
			waitUntilPageReady();
		}
	}

	public boolean isOnlyOneRowDisplayed() {
		if (countElement(TABLE_NUMBER_OF_ROW) == 1)
			return isElementDisplayed(TABLE_NUMBER_OF_ROW);
		return false;
	}
	
	public boolean isNoRowDisplayed() {
		return isElementUndisplayed(TABLE_NUMBER_OF_ROW);
	}

	public boolean isNoRowDisplayed(String panelHeadingName) {
		return isElementUndisplayed(TABLE_NUMBER_OF_ROW_BY_PANEL_HEADING_NAME, panelHeadingName);
	}

	public boolean areAllValuesDisplayedOnOneRowByColumnNameAndValue(String[] columnNames, String[] columnValues) {
		String columnIndex = "";
		String result = "";
		String resultTemp = "";
		String valueOnRowByColumnIndexAndValue = "td[position()=%s and contains(.,'%s')]";

		if (columnNames.length != columnValues.length) {
			System.out.println("List column names are not equal List column values");
			return false;
		}

		for (int i = 0; i < columnNames.length; i++) {
			if (i == 0) {
				if (isElementUndisplayed(TABLE_COLUMN_INDEX_BY_COLUMN_NAME, columnNames[i])) {
					columnIndex = "1";
				} else {
					columnIndex = String.valueOf(countElement(TABLE_COLUMN_INDEX_BY_COLUMN_NAME, columnNames[i]) + 1);
				}
			} else {
				columnIndex = String.valueOf(countElement(TABLE_COLUMN_INDEX_BY_COLUMN_NAME, columnNames[i]) + 1);
			}

			resultTemp = String.format(valueOnRowByColumnIndexAndValue, columnIndex, columnValues[i]);

			if (i == 0) {
				result = result + resultTemp;
			} else {
				result = result + " and " + resultTemp;
			}
		}

		return isElementDisplayed(TABLE_ROW_VALUE_BY_COLUMN_INDEX, result);
	}
	
	public boolean isNoDataAvailableInTableMessageDisplayed() {
		return isElementDisplayed(TABLE_MESSAGE_NO_DATA_AVAILABLE);
	}

	public boolean isNoDataAvailableInTableMessageDisplayed(String panelHeadingName) {
		return isElementDisplayed(TABLE_MESSAGE_NO_DATA_AVAILABLE_BY_PANEL_HEADING_NAME, panelHeadingName);
	}

}
