package com.nopcommerce.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.github.javafaker.Faker;

public class DataUser {
	private Locale locale = new Locale("en");
	private Faker faker = new Faker(locale);

	public static DataUser getData() {
		return new DataUser();
	}

	public static DataUser data = DataUser.getData();
	public static final String NOP_COMMERCE_USER_URL = "https://demo.nopcommerce.com/";
	// Message
	public static final String FIRST_NAME_REQUIRED = "First name is required.";
	public static final String LAST_NAME_REQUIRED = "Last name is required.";
	public static final String EMAIL_REQUIRED = "Email is required.";
	public static final String PASSWORD_REQUIRED = "Password is required.";
	public static final String CONFIRM_PASSWORD_REQUIRED = "Password is required.";
	public static final String WRONG_EMAIL = "Wrong email";
	public static final String PASSWORD_MUST_HAVE_AT_LEAST_6_CHARS = "Password must meet the following rules:must have at least 6 characters";
	public static final String CONFIRM_PASSWORD_NOT_MATCH = "The password and confirmation password do not match.";
	public static final String YOUR_REGISTRATION_COMPLETED = "Your registration completed";
	public static final String EMAIL_ALREADY_EXISTS = "The specified email already exists";
	public static final String WELCOME_SIGN_IN = "Welcome, Please Sign In!";
	public static final String PLS_ENTER_EMAIL = "Please enter your email";
	public static final String LOGIN_WAS_UNSUCCESSFUL = "Login was unsuccessful. Please correct the errors and try again.";
	public static final String NO_CUSTOMER_ACCOUNT_FOUND = "No customer account found";
	public static final String CREDENTIALS_PROVIDED_ARE_INCORRECT = "The credentials provided are incorrect";
	// Data to test
	public static final String FIRSTNAME = data.getFirstName();
	public static final String LASTNAME = data.getLastName();
	public static final String DAY = data.getDay();
	public static final String MONTH = data.getMonth();
	public static final String YEAR = data.getYear();
	public static final String EMAIL = data.getEmail();
	public static final String COMPANY_NAME = data.getCompanyName();
	public static final String PASSWORD = "123456";
	public static final String NEW_PASSWORD = "new123456";
	// Update
	public static final String FIRSTNAME_UPDATE = "update" + data.getFirstName();
	public static final String LASTNAME_UPDATE = "update" + data.getLastName();
	public static final String EMAIL_UPDATE = "update" + data.getEmail();
	// Not exist
	public static final String EMAIL_NOT_EXIST = "notexist" + data.getEmail();
	public static final String PASSWORD_NOT_EXIST = "notexist123456";
	// Address
	public static final String ADDRESS_FIRSTNAME = data.getFirstName();
	public static final String ADDRESS_LASTNAME = data.getLastName();
	public static final String ADDRESS_EMAIL = data.getEmail();
	public static final String ADDRESS_COMPANY_NAME = data.getCompanyName();
	public static final String ADDRESS_COUNTRY = "Viet Nam";
	public static final String ADDRESS_CITY = data.getCity();
	public static final String ADDRESS_ADDRESS1 = data.getAddress();
	public static final String ADDRESS_PHONE_NUMBER = data.getPhoneNumber();
	public static final String ADDRESS_FAX_NUMBER = data.getFaxNumber();
	public static final String ADDRESS_ZIP_CODE = data.getZipCode();

	public String getFirstName() {
		return faker.name().firstName();
	}

	public String getLastName() {
		return faker.name().lastName();
	}

	public String getEmail() {
		int randomNumber = (int) (Math.random() * (999 - 1) + 1);
		return faker.name().fullName().toLowerCase().replace(" ", "").replace("\'", "") + randomNumber + "@gmail.com";
	}

	public String getCompanyName() {
		return faker.company().name();
	}

	public String getCity() {
		return faker.address().city();
	}

	public String getAddress() {
		return faker.address().state();
	}

	public String getPhoneNumber() {
		return faker.phoneNumber().subscriberNumber(10);
	}

	public String getZipCode() {
		return faker.address().zipCode();
	}

	public String getFaxNumber() {
		return String.valueOf((int) (Math.random() * (999999 - 1) + 1));
	}

	public String getDay() {
		return String.valueOf((int) (Math.random() * (31 - 1) + 1));
	}

	public String getMonth() {
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
		return months[(int) (Math.random() * (11 - 0))];
	}

	public String getYear() {
		return String.valueOf((int) (Math.random() * (2020 - 1910) + 1910));
	}

	public String getCardholderName(String firstName, String lastName) {
		return firstName.toUpperCase() + " " + lastName.toUpperCase();
	}

	public String getCardNumber() {
		return faker.finance().creditCard();
	}

	public String getExpireMonth() {
		String month = String.valueOf((int) (Math.random() * (12 - 1) + 1));
		if (month.length() == 1)
			month = "0" + month;
		return month;
	}

	public String getExpireYear() {
		return String.valueOf((int) (Math.random() * (2034 - 2021) + 2021));
	}

	public String getCardCode() {
		return String.valueOf((int) (Math.random() * (999 - 100) + 100));
	}

	public String getOrderDay() {
		Calendar calendar = Calendar.getInstance();
		String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		String dayName = days[calendar.get(Calendar.DAY_OF_WEEK) - 1];

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");

		// Expect: Tuesday, December 01, 2020
		return dayName + ", " + dateFormat.format(date);
	}
}
