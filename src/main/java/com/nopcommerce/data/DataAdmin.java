package com.nopcommerce.data;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataAdmin {
	private Locale locale = new Locale("en");
	private Faker faker = new Faker(locale);

	public static DataAdmin getDataAdmin() {
		return new DataAdmin();
	}

	public static DataUser data = DataUser.getData();
	public static final String NOP_COMMERCE_ADMIN_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
	public static final String NOP_COMMERCE_ADMIN_USERNAME = "admin@yourstore.com";
	public static final String NOP_COMMERCE_ADMIN_PASSWORD = "admin";

	private int getRandomNumberInRange(int max, int min) {
		return (int) (Math.random() * (max - min) + min);
	}

	public String getFirstName() {
		return faker.name().firstName().replace("\'", "");
	}

	public String getLastName() {
		return faker.name().lastName().replace("\'", "");
	}

	public String getPassword() {
		return String.valueOf(getRandomNumberInRange(987654, 123456));
	}

	public String getCity() {
		return faker.address().cityName().replace("\'", "");
	}

	public String getAddress() {
		return faker.address().fullAddress().replace("\'", "");
	}

	public String getZipCode() {
		return faker.address().zipCode();
	}

	public String getPhoneNumber() {
		return faker.phoneNumber().subscriberNumber(10);
	}

	public String getFaxNumber() {
		return String.valueOf((int) (Math.random() * (999999 - 1) + 1));
	}

	public String getDateOfBirth() {
		String month = String.valueOf(getRandomNumberInRange(12, 1));
		String day = String.valueOf(getRandomNumberInRange(29, 1));
		String year = String.valueOf(getRandomNumberInRange(2010, 1990));
		return month + "/" + day + "/" + year;
	}

	public String getEmail() {
		int randomNumber = getRandomNumberInRange(999, 1);
		return faker.name().fullName().toLowerCase().replace(" ", "").replace("\'", "") + randomNumber + "@gmail.com";
	}

	public String getCompanyName() {
		return faker.company().name().replace("\'", "");
	}

}
