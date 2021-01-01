package com.nopcommerce.user.login;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopcommerce.data.DataUser;
import com.nopcommerce.pages.user.CartPageUser;
import com.nopcommerce.pages.user.CheckoutPageUser;
import com.nopcommerce.pages.user.DetailProductPageUser;
import com.nopcommerce.pages.user.HomePageUser;
import com.nopcommerce.pages.user.MyAccountPageUser;
import com.nopcommerce.pages.user.OrderInformationPageUser;
import com.nopcommerce.pages.user.OrdersPageUser;
import com.nopcommerce.pages.user.SearchPageUser;
import com.nopcommerce.pages.user.ThankYouPageUser;
import com.nopcommerce.user.precondition.PreConditionLoginUser;

public class Order extends PreConditionLoginUser {

	@BeforeClass
	public void openHomePageWithLogin() {
		homePageUser = getHomePageUser();
	}

	@BeforeMethod
	public void prepareDataForTest() {
		// Billing addresses
		billingFirstName = data.getFirstName();
		billingLastName = data.getLastName();
		billingEmail = data.getEmail();
		billingCountry = "Viet Nam";
		billingCity = data.getCity();
		billingAddressOne = data.getAddress();
		billingZipCode = data.getZipCode();
		billingPhoneNumber = data.getPhoneNumber();
		billingInfoListExpected = billingFirstName + " " + billingLastName + "Email: " + billingEmail + "Phone: " + billingPhoneNumber + "Fax:" + billingAddressOne + billingCity + "," + billingZipCode
				+ billingCountry;
		// Shipping addresses
		shippingFirstName = data.getFirstName();
		shippingLastName = data.getLastName();
		shippingEmail = data.getEmail();
		shippingCountry = "Viet Nam";
		shippingCity = data.getCity();
		shippingAddressOne = data.getAddress();
		shippingZipCode = data.getZipCode();
		shippingPhoneNumber = data.getPhoneNumber();
		shippingInfoListExpected = shippingFirstName + " " + shippingLastName + "Email: " + shippingEmail + "Phone: " + shippingPhoneNumber + "Fax:" + shippingAddressOne + shippingCity + ","
				+ shippingZipCode + shippingCountry;
		// Credit card
		dropdownlist_expireMonth = data.getExpireMonth();
		dropdownlist_expireYear = data.getExpireYear();
		cardHolderName = data.getCardholderName(billingFirstName, billingLastName);
		cardNumber = data.getCardNumber();
		cardCode = data.getCardCode();
	}

	@Test(groups = "addEditRemoveProductOnCart")
	public void Order01_addProductToCartAndCheckProductAddedInMiniShoppingCart() {
		homePageUser.inputToSearchTextbox(product_search_Order01);

		searchPageUser = homePageUser.clickToSearchButton();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isSearchPageTitleDisplayed());
		verifyTrue(searchPageUser.areAllProductNameDisplayed());

		productName = searchPageUser.getProductNameByIndex(0);

		detailProductPageUser = searchPageUser.clickAddToCartButtonByProductName(productName);

		verifyTrue(detailProductPageUser.isDetailProductPageTitleDisplayed());

		detailProductPageUser.selectProcessor(dropdownlist_processor_2point5GHz);
		detailProductPageUser.selectRam(dropdownlist_ram_8GB);
		detailProductPageUser.checkToCheckboxByNameBox(checkbox_hdd_400GB);
		detailProductPageUser.checkToCheckboxByNameBox(checkbox_os_vistaPremium);
		detailProductPageUser.checkToCheckboxByNameBox(checkbox_software_microsoftService);
		detailProductPageUser.checkToCheckboxByNameBox(checkbox_software_acrobatReader);
		detailProductPageUser.checkToCheckboxByNameBox(checkbox_software_totalCommander);
		productQuantity = detailProductPageUser.getQuantityValue();
		productPrice = detailProductPageUser.getPriceValue();
		productTotalPrice = detailProductPageUser.countTotalPriceWithProductQuantity(productPrice, productQuantity);
		detailProductPageUser.clickAddToCartButton();

		verifyTrue(detailProductPageUser.isAddToShoppingCartSuccessMessageDisplayed());

		detailProductPageUser.clickCloseSuccessMessage();
		detailProductPageUser.waitAddToShoppingCartSuccessMessageDisappear();
		detailProductPageUser.hoverToShoppingCartLink();

		verifyTrue(detailProductPageUser.isAmountProductDisplayedInMiniShoppingCart(productQuantity));
		verifyTrue(detailProductPageUser.isNameDisplayedInMiniShoppingCart(productName));
		verifyTrue(detailProductPageUser.isAttributesDisplayedInMiniShoppingCartByProductName(productName));
		verifyTrue(detailProductPageUser.isPriceDisplayedInMiniShoppingCartByProductName(productName, productPrice));
		verifyTrue(detailProductPageUser.isQuantityDisplayedInMiniShoppingCartByProductName(productName, productQuantity));
		verifyTrue(detailProductPageUser.isTotalPriceDisplayedInMiniShoppingCart(productTotalPrice));
		verifyEquals(detailProductPageUser.getAttributesInMiniShoppingCartByProductName(productName), attributes_exptected_1);
	}

	@Test(dependsOnMethods = { "Order01_addProductToCartAndCheckProductAddedInMiniShoppingCart" }, groups = "addEditRemoveProductOnCart")
	public void Order02_editProductAddedInShoppingCart() {
		cartPageUser = detailProductPageUser.clickShoppingCartLink();

		verifyTrue(cartPageUser.isCartPageTitleDisplayed());

		detailProductPageUser = cartPageUser.clickEditLink();

		verifyTrue(detailProductPageUser.isDetailProductPageTitleDisplayed());

		productName = detailProductPageUser.getProductName();

		detailProductPageUser.selectProcessor(dropdownlist_processor_2point2GHz);
		detailProductPageUser.selectRam(dropdownlist_ram_4GB);
		detailProductPageUser.checkToCheckboxByNameBox(checkbox_hdd_320GB);
		detailProductPageUser.checkToCheckboxByNameBox(checkbox_os_vistaHome);
		detailProductPageUser.checkToCheckboxByNameBox(checkbox_software_microsoftService);
		detailProductPageUser.uncheckToCheckboxByNameBox(checkbox_software_acrobatReader);
		detailProductPageUser.uncheckToCheckboxByNameBox(checkbox_software_totalCommander);
		detailProductPageUser.increaseProductQuantity("2");
		productQuantity = detailProductPageUser.getQuantityValue();
		productPrice = detailProductPageUser.getPriceValue();
		productTotalPrice = detailProductPageUser.countTotalPriceWithProductQuantity(productPrice, productQuantity);
		detailProductPageUser.clickUpdateButton();

		verifyTrue(detailProductPageUser.isAddToShoppingCartSuccessMessageDisplayed());

		detailProductPageUser.clickCloseSuccessMessage();
		detailProductPageUser.waitAddToShoppingCartSuccessMessageDisappear();
		detailProductPageUser.hoverToShoppingCartLink();

		verifyTrue(detailProductPageUser.isAmountProductDisplayedInMiniShoppingCart(productQuantity));
		verifyTrue(detailProductPageUser.isNameDisplayedInMiniShoppingCart(productName));
		verifyTrue(detailProductPageUser.isAttributesDisplayedInMiniShoppingCartByProductName(productName));
		verifyTrue(detailProductPageUser.isPriceDisplayedInMiniShoppingCartByProductName(productName, productPrice));
		verifyTrue(detailProductPageUser.isQuantityDisplayedInMiniShoppingCartByProductName(productName, productQuantity));
		verifyTrue(detailProductPageUser.isTotalPriceDisplayedInMiniShoppingCart(productTotalPrice));
		verifyEquals(detailProductPageUser.getAttributesInMiniShoppingCartByProductName(productName), attributes_exptected_2);

		cartPageUser = detailProductPageUser.clickShoppingCartLink();

		verifyTrue(cartPageUser.isCartPageTitleDisplayed());
		verifyTrue(cartPageUser.isProductNameInCartTableDisplayed(productName));
		verifyTrue(cartPageUser.isAttributesDisplayedInCartTableByProductName(productName));
		verifyTrue(cartPageUser.isProductPriceInCartTableDisplayedByProductName(productName, productPrice));
		verifyTrue(cartPageUser.isProductQuantityInCartTableDisplayedByProductName(productName, productQuantity));
		verifyTrue(cartPageUser.isProductTotalPriceInCartTableDisplayedByProductName(productName, productTotalPrice));
		verifyEquals(cartPageUser.getAttributesInCartTableByProductName(productName), attributes_exptected_2);
	}

	@Test(dependsOnMethods = { "Order02_editProductAddedInShoppingCart" }, groups = "addEditRemoveProductOnCart")
	public void Order03_removeProductAddedInShoppingCart() {
		cartPageUser.checkRemoveFromCartCheckboxByProductName(productName);
		cartPageUser.clickUpdateCartButton();

		verifyTrue(cartPageUser.isCartEmptyMessageDisplayed());
		verifyTrue(cartPageUser.isProductNameInCartTableUndisplayed(productName));
		verifyTrue(cartPageUser.isProductPriceInCartTableUndisplayedByProductName(productName, productPrice));

		homePageUser = cartPageUser.clickHomePageLink();

		verifyTrue(homePageUser.isHomePageTitleDislayed());
	}

	@Test(dependsOnGroups = "addEditRemoveProductOnCart", alwaysRun = true)
	public void Order04_addProductToCartWith5Quantity() {
		homePageUser.inputToSearchTextbox(product_search_Order04);

		searchPageUser = homePageUser.clickToSearchButton();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isSearchPageTitleDisplayed());
		verifyTrue(searchPageUser.areAllProductNameDisplayed());

		productName = searchPageUser.getProductNameByIndex(0);

		detailProductPageUser = searchPageUser.clickToProductByIndex(0);
		detailProductPageUser.waitUntilPageReady();

		verifyTrue(detailProductPageUser.isDetailProductPageTitleDisplayed());

		detailProductPageUser.increaseProductQuantity("5");
		productQuantity = detailProductPageUser.getQuantityValue();
		productPrice = detailProductPageUser.getPriceValue();
		productTotalPrice = detailProductPageUser.countTotalPriceWithProductQuantity(productPrice, productQuantity);
		detailProductPageUser.clickAddToCartButton();

		verifyTrue(detailProductPageUser.isAddToShoppingCartSuccessMessageDisplayed());

		detailProductPageUser.clickCloseSuccessMessage();
		detailProductPageUser.waitAddToShoppingCartSuccessMessageDisappear();
		detailProductPageUser.hoverToShoppingCartLink();

		verifyTrue(detailProductPageUser.isAmountProductDisplayedInMiniShoppingCart(productQuantity));
		verifyTrue(detailProductPageUser.isNameDisplayedInMiniShoppingCart(productName));
		verifyTrue(detailProductPageUser.isPriceDisplayedInMiniShoppingCartByProductName(productName, productPrice));
		verifyTrue(detailProductPageUser.isQuantityDisplayedInMiniShoppingCartByProductName(productName, productQuantity));
		verifyTrue(detailProductPageUser.isTotalPriceDisplayedInMiniShoppingCart(productTotalPrice));

		cartPageUser = detailProductPageUser.clickShoppingCartLink();

		verifyTrue(cartPageUser.isCartPageTitleDisplayed());
		verifyTrue(cartPageUser.isProductNameInCartTableDisplayed(productName));
		verifyTrue(cartPageUser.isProductPriceInCartTableDisplayedByProductName(productName, productPrice));
		verifyTrue(cartPageUser.isProductQuantityInCartTableDisplayedByProductName(productName, productQuantity));
		verifyTrue(cartPageUser.isProductTotalPriceInCartTableDisplayedByProductName(productName, productTotalPrice));

		cartPageUser.checkRemoveFromCartCheckboxByProductName(productName);
		cartPageUser.clickUpdateCartButton();

		verifyTrue(cartPageUser.isCartEmptyMessageDisplayed());
		verifyTrue(cartPageUser.isProductNameInCartTableUndisplayed(productName));
		verifyTrue(cartPageUser.isProductPriceInCartTableUndisplayedByProductName(productName, productPrice));

		homePageUser = cartPageUser.clickHomePageLink();

		verifyTrue(homePageUser.isHomePageTitleDislayed());
	}

	@Test(dependsOnGroups = "addEditRemoveProductOnCart", alwaysRun = true)
	public void Order05_orderProductAndCheckoutWithMoneyOrder() {
		homePageUser.inputToSearchTextbox(product_search_Order05);

		searchPageUser = homePageUser.clickToSearchButton();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isSearchPageTitleDisplayed());
		verifyTrue(searchPageUser.areAllProductNameDisplayed());

		productName = searchPageUser.getProductNameByIndex(0);

		detailProductPageUser = searchPageUser.clickToProductByIndex(0);
		detailProductPageUser.waitUntilPageReady();

		verifyTrue(detailProductPageUser.isDetailProductPageTitleDisplayed());

		productSKU = detailProductPageUser.getSKUValue();
		productQuantity = detailProductPageUser.getQuantityValue();
		productPrice = detailProductPageUser.getPriceValue();
		productSubTotalPrice = detailProductPageUser.countTotalPriceWithProductQuantity(productPrice, productQuantity);
		productTotalPrice = productSubTotalPrice;
		productPointsReward = detailProductPageUser.countPointsRewardWithProductTotalPrice(productTotalPrice);
		detailProductPageUser.clickAddToCartButton();

		verifyTrue(detailProductPageUser.isAddToShoppingCartSuccessMessageDisplayed());

		detailProductPageUser.clickCloseSuccessMessage();
		detailProductPageUser.waitAddToShoppingCartSuccessMessageDisappear();
		detailProductPageUser.hoverToShoppingCartLink();

		verifyTrue(detailProductPageUser.isAmountProductDisplayedInMiniShoppingCart(productQuantity));
		verifyTrue(detailProductPageUser.isNameDisplayedInMiniShoppingCart(productName));
		verifyTrue(detailProductPageUser.isPriceDisplayedInMiniShoppingCartByProductName(productName, productPrice));
		verifyTrue(detailProductPageUser.isQuantityDisplayedInMiniShoppingCartByProductName(productName, productQuantity));
		verifyTrue(detailProductPageUser.isTotalPriceDisplayedInMiniShoppingCart(productTotalPrice));

		cartPageUser = detailProductPageUser.clickShoppingCartLink();

		verifyTrue(cartPageUser.isCartPageTitleDisplayed());
		verifyTrue(cartPageUser.isProductNameInCartTableDisplayed(productName));
		verifyTrue(cartPageUser.isProductSKUInCartTableDisplayedByProductName(productName, productSKU));
		verifyTrue(cartPageUser.isProductPriceInCartTableDisplayedByProductName(productName, productPrice));
		verifyTrue(cartPageUser.isProductQuantityInCartTableDisplayedByProductName(productName, productQuantity));
		verifyTrue(cartPageUser.isProductTotalPriceInCartTableDisplayedByProductName(productName, productTotalPrice));

		cartPageUser.selectGiftWrapping(dropdownlist_giftWrapping_No);
		cartPageUser.checkToTermsOfServiceCheckbox();

		verifyTrue(cartPageUser.isSubTotalPriceInCartTotalDisplayed(productSubTotalPrice));
		verifyTrue(cartPageUser.isShippingPriceInCartTotalDisplayed(productShippingPrice));
		verifyTrue(cartPageUser.isTaxPriceInCartTotalDisplayed(productTaxPrice));
		verifyTrue(cartPageUser.isTotalPriceInCartTotalDisplayed(productTotalPrice));
		verifyTrue(cartPageUser.isEarnPointsRewardInCartTotalDisplayed(productPointsReward));

		checkoutPageUser = cartPageUser.clickToCheckoutButton();

		verifyTrue(checkoutPageUser.isCheckoutPageTitleDisplayed());
		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("1", stepTitle_billingAddress));

		checkoutPageUser.uncheckToCheckoutShipToSameAddressCheckbox();
		checkoutPageUser.inputToCheckoutFirstNameTextBox(billingFirstName);
		checkoutPageUser.inputToCheckoutLastNameTextBox(billingLastName);
		checkoutPageUser.inputToCheckoutEmailTextBox(billingEmail);
		checkoutPageUser.selectCheckoutCountry(billingCountry);
		checkoutPageUser.inputToCheckoutCityTextBox(billingCity);
		checkoutPageUser.inputToCheckoutAddressOneTextBox(billingAddressOne);
		checkoutPageUser.inputToCheckoutZipCodeTextBox(billingZipCode);
		checkoutPageUser.inputToCheckoutPhoneNumberTextBox(billingPhoneNumber);
		checkoutPageUser.clickToCheckoutContinueButton();

		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("2", stepTitle_shippingAddress));

		checkoutPageUser.selectCheckoutAddress(dropdownlist_selectAddress_newAddress);
		checkoutPageUser.inputToCheckoutFirstNameTextBox(shippingFirstName);
		checkoutPageUser.inputToCheckoutLastNameTextBox(shippingLastName);
		checkoutPageUser.inputToCheckoutEmailTextBox(shippingEmail);
		checkoutPageUser.selectCheckoutCountry(shippingCountry);
		checkoutPageUser.inputToCheckoutCityTextBox(shippingCity);
		checkoutPageUser.inputToCheckoutAddressOneTextBox(shippingAddressOne);
		checkoutPageUser.inputToCheckoutZipCodeTextBox(shippingZipCode);
		checkoutPageUser.inputToCheckoutPhoneNumberTextBox(shippingPhoneNumber);
		checkoutPageUser.clickToCheckoutContinueButton();

		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("3", stepTitle_shippingMethod));

		checkoutPageUser.checkToCheckoutGroundCheckbox();
		productShippingMethod = checkoutPageUser.getCheckoutShippingMethodGround();
		productShippingMethodPrice = checkoutPageUser.getCheckoutShippingMethodGroundPrice();
		checkoutPageUser.clickToCheckoutContinueButton();

		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("4", stepTitle_paymentMethod));

		checkoutPageUser.checkToCheckoutMoneyOrOrderMoneyCheckbox();
		productPaymentMethod = checkoutPageUser.getCheckoutPaymentMethodMoneyOrder();
		checkoutPageUser.clickToCheckoutContinueButton();

		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("5", stepTitle_paymentInfo));

		checkoutPageUser.clickToCheckoutContinueButton();

		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("6", stepTitle_confirmOrder));

		verifyTrue(checkoutPageUser.isCheckoutBillingAddressInfoListDisplayed());
		verifyTrue(checkoutPageUser.isCheckoutPaymentMethodDisplayed(productPaymentMethod));

		verifyTrue(checkoutPageUser.isCheckoutShippingAddressInfoListDisplayed());
		verifyTrue(checkoutPageUser.isCheckoutShippingMethodDisplayed(productShippingMethod));

		verifyEquals(checkoutPageUser.getCheckoutBillingAddressInfoList(), billingInfoListExpected);
		verifyEquals(checkoutPageUser.getCheckoutShippingAddressInfoList(), shippingInfoListExpected);

		verifyTrue(checkoutPageUser.isProductNameInCartTableDisplayed(productName));
		verifyTrue(checkoutPageUser.isProductSKUInCartTableDisplayedByProductName(productName, productSKU));
		verifyTrue(checkoutPageUser.isProductPriceInCartTableDisplayedByProductName(productName, productPrice));
		verifyTrue(checkoutPageUser.isProductQuantityInCartTableCheckoutDisplayedByProductName(productName, productQuantity));
		verifyTrue(checkoutPageUser.isProductTotalPriceInCartTableDisplayedByProductName(productName, productTotalPrice));

		verifyTrue(checkoutPageUser.isCheckoutGiftWrappingMessageDisplayed(dropdownlist_giftWrapping_No));

		verifyTrue(checkoutPageUser.isSubTotalPriceInCartTotalDisplayed(productSubTotalPrice));
		verifyTrue(checkoutPageUser.isShippingMethodPriceInCartTotalDisplayed(productShippingMethod, productShippingMethodPrice));
		verifyTrue(checkoutPageUser.isTaxPriceInCartTotalDisplayed(productTaxPrice));

		productTotalPrice = checkoutPageUser.countTotalPriceWithProductShippingAndTaxPrice(productSubTotalPrice, productShippingPrice, productTaxPrice);
		productPointsReward = checkoutPageUser.countPointsRewardWithProductTotalPrice(productTotalPrice);

		verifyTrue(checkoutPageUser.isTotalPriceInCartTotalDisplayed(productTotalPrice));
		verifyTrue(checkoutPageUser.isEarnPointsRewardInCartTotalDisplayed(productPointsReward));

		thankYouPageUser = checkoutPageUser.clickToCheckoutCofirmButton();

		verifyTrue(thankYouPageUser.isThankYouPageTitleDisplayed());
		verifyTrue(thankYouPageUser.isOrderSuccessMessageDisplayed());
		verifyTrue(thankYouPageUser.isOrderNumberDisplayed());

		productOrderNumberValue = thankYouPageUser.getOrderNumberValue();

		myAccountPageUser = thankYouPageUser.clickMyAccountLink();
		myAccountPageUser.waitUntilPageReady();

		verifyTrue(myAccountPageUser.isMyAccountPageTitleDisplayed());

		ordersPageUser = myAccountPageUser.clickOrdersLink();

		verifyTrue(ordersPageUser.isOrdersPageTitleDisplayed());
		verifyTrue(ordersPageUser.isOrderNumberByValueDisplayed(productOrderNumberValue));

		orderInforPageUser = ordersPageUser.clickDetailsButtonByOrderNumberValue(productOrderNumberValue);

		verifyTrue(orderInforPageUser.isOrderInforPageTitleDisplayed());

		verifyTrue(orderInforPageUser.isOrderNumberDisplayed(productOrderNumberValue));
		verifyTrue(orderInforPageUser.isOrderDateDisplayed(productOrderDay));
		verifyTrue(orderInforPageUser.isOrderStatusDisplayed(paymentStatus_pending));
		verifyTrue(orderInforPageUser.isOrderTotalDisplayed(productTotalPrice));

		verifyTrue(orderInforPageUser.isCheckoutBillingAddressInfoListDisplayed());
		verifyEquals(orderInforPageUser.getCheckoutBillingAddressInfoList(), billingInfoListExpected);
		verifyTrue(orderInforPageUser.isCheckoutPaymentMethodDisplayed(productPaymentMethod));
		verifyTrue(orderInforPageUser.isCheckoutPaymentStatusDisplayed(paymentStatus_pending));

		verifyTrue(orderInforPageUser.isCheckoutShippingAddressInfoListDisplayed());
		verifyEquals(orderInforPageUser.getCheckoutShippingAddressInfoList(), shippingInfoListExpected);
		verifyTrue(orderInforPageUser.isCheckoutShippingMethodDisplayed(productShippingMethod));
		verifyTrue(orderInforPageUser.isCheckoutShippingStatusDisplayed(shippingStatus_notYetShipped));

		verifyTrue(orderInforPageUser.isProductNameInCartTableDisplayed(productName));
		verifyTrue(orderInforPageUser.isProductSKUInCartTableDisplayedByProductName(productName, productSKU));
		verifyTrue(orderInforPageUser.isProductPriceInCartTableDisplayedByProductName(productName, productPrice));
		verifyTrue(orderInforPageUser.isProductQuantityInCartTableCheckoutDisplayedByProductName(productName, productQuantity));
		verifyTrue(orderInforPageUser.isProductTotalPriceInCartTableDisplayedByProductName(productName, productTotalPrice));

		verifyTrue(orderInforPageUser.isCheckoutGiftWrappingMessageDisplayed(dropdownlist_giftWrapping_No));

		verifyTrue(orderInforPageUser.isSubTotalPriceInCartTotalDisplayed(productSubTotalPrice));
		verifyTrue(orderInforPageUser.isShippingPriceInCartTotalDisplayed(productShippingPrice));
		verifyTrue(orderInforPageUser.isTaxPriceInCartTotalDisplayed(productTaxPrice));

		productTotalPrice = orderInforPageUser.countTotalPriceWithProductShippingAndTaxPrice(productSubTotalPrice, productShippingPrice, productTaxPrice);

		verifyTrue(orderInforPageUser.isTotalPriceInCartTotalDisplayed(productTotalPrice));

		homePageUser = orderInforPageUser.clickHomePageLink();

		verifyTrue(homePageUser.isHomePageTitleDislayed());
	}

	@Test(dependsOnMethods = { "Order05_orderProductAndCheckoutWithMoneyOrder" })
	public void Order06_orderProductAndCheckoutWithCreditCard() {
		homePageUser.inputToSearchTextbox(product_search_Order06);

		searchPageUser = homePageUser.clickToSearchButton();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isSearchPageTitleDisplayed());
		verifyTrue(searchPageUser.areAllProductNameDisplayed());

		productName = searchPageUser.getProductNameByIndex(0);

		detailProductPageUser = searchPageUser.clickToProductByIndex(0);
		detailProductPageUser.waitUntilPageReady();

		verifyTrue(detailProductPageUser.isDetailProductPageTitleDisplayed());

		productSKU = detailProductPageUser.getSKUValue();
		productQuantity = detailProductPageUser.getQuantityValue();
		productPrice = detailProductPageUser.getPriceValue();
		productSubTotalPrice = detailProductPageUser.countTotalPriceWithProductQuantity(productPrice, productQuantity);
		productTotalPrice = productSubTotalPrice;
		productPointsReward = detailProductPageUser.countPointsRewardWithProductTotalPrice(productTotalPrice);
		detailProductPageUser.clickAddToCartButton();

		verifyTrue(detailProductPageUser.isAddToShoppingCartSuccessMessageDisplayed());

		detailProductPageUser.clickCloseSuccessMessage();
		detailProductPageUser.waitAddToShoppingCartSuccessMessageDisappear();
		detailProductPageUser.hoverToShoppingCartLink();

		verifyTrue(detailProductPageUser.isAmountProductDisplayedInMiniShoppingCart(productQuantity));
		verifyTrue(detailProductPageUser.isNameDisplayedInMiniShoppingCart(productName));
		verifyTrue(detailProductPageUser.isPriceDisplayedInMiniShoppingCartByProductName(productName, productPrice));
		verifyTrue(detailProductPageUser.isQuantityDisplayedInMiniShoppingCartByProductName(productName, productQuantity));
		verifyTrue(detailProductPageUser.isTotalPriceDisplayedInMiniShoppingCart(productTotalPrice));

		cartPageUser = detailProductPageUser.clickShoppingCartLink();

		verifyTrue(cartPageUser.isCartPageTitleDisplayed());
		verifyTrue(cartPageUser.isProductNameInCartTableDisplayed(productName));
		verifyTrue(cartPageUser.isProductSKUInCartTableDisplayedByProductName(productName, productSKU));
		verifyTrue(cartPageUser.isProductPriceInCartTableDisplayedByProductName(productName, productPrice));
		verifyTrue(cartPageUser.isProductQuantityInCartTableDisplayedByProductName(productName, productQuantity));
		verifyTrue(cartPageUser.isProductTotalPriceInCartTableDisplayedByProductName(productName, productTotalPrice));

		cartPageUser.selectGiftWrapping(dropdownlist_giftWrapping_No);
		cartPageUser.checkToTermsOfServiceCheckbox();

		verifyTrue(cartPageUser.isSubTotalPriceInCartTotalDisplayed(productSubTotalPrice));
		verifyTrue(cartPageUser.isShippingPriceInCartTotalDisplayed(productShippingPrice));
		verifyTrue(cartPageUser.isTaxPriceInCartTotalDisplayed(productTaxPrice));
		verifyTrue(cartPageUser.isTotalPriceInCartTotalDisplayed(productTotalPrice));
		verifyTrue(cartPageUser.isEarnPointsRewardInCartTotalDisplayed(productPointsReward));

		checkoutPageUser = cartPageUser.clickToCheckoutButton();

		verifyTrue(checkoutPageUser.isCheckoutPageTitleDisplayed());
		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("1", stepTitle_billingAddress));

		checkoutPageUser.uncheckToCheckoutShipToSameAddressCheckbox();

		checkoutPageUser.selectCheckoutAddress(dropdownlist_selectAddress_newAddress);
		checkoutPageUser.inputToCheckoutFirstNameTextBox(billingFirstName);
		checkoutPageUser.inputToCheckoutLastNameTextBox(billingLastName);
		checkoutPageUser.inputToCheckoutEmailTextBox(billingEmail);
		checkoutPageUser.selectCheckoutCountry(billingCountry);
		checkoutPageUser.inputToCheckoutCityTextBox(billingCity);
		checkoutPageUser.inputToCheckoutAddressOneTextBox(billingAddressOne);
		checkoutPageUser.inputToCheckoutZipCodeTextBox(billingZipCode);
		checkoutPageUser.inputToCheckoutPhoneNumberTextBox(billingPhoneNumber);
		checkoutPageUser.clickToCheckoutContinueButton();

		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("2", stepTitle_shippingAddress));

		checkoutPageUser.selectCheckoutAddress(dropdownlist_selectAddress_newAddress);
		checkoutPageUser.inputToCheckoutFirstNameTextBox(shippingFirstName);
		checkoutPageUser.inputToCheckoutLastNameTextBox(shippingLastName);
		checkoutPageUser.inputToCheckoutEmailTextBox(shippingEmail);
		checkoutPageUser.selectCheckoutCountry(shippingCountry);
		checkoutPageUser.inputToCheckoutCityTextBox(shippingCity);
		checkoutPageUser.inputToCheckoutAddressOneTextBox(shippingAddressOne);
		checkoutPageUser.inputToCheckoutZipCodeTextBox(shippingZipCode);
		checkoutPageUser.inputToCheckoutPhoneNumberTextBox(shippingPhoneNumber);
		checkoutPageUser.clickToCheckoutContinueButton();

		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("3", stepTitle_shippingMethod));

		checkoutPageUser.checkToCheckoutGroundCheckbox();
		productShippingMethod = checkoutPageUser.getCheckoutShippingMethodGround();
		productShippingMethodPrice = checkoutPageUser.getCheckoutShippingMethodGroundPrice();
		checkoutPageUser.clickToCheckoutContinueButton();

		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("4", stepTitle_paymentMethod));

		checkoutPageUser.checkToCheckoutCreditCardCheckbox();
		productPaymentMethod = checkoutPageUser.getCheckoutPaymentMethodCreditCard();
		checkoutPageUser.clickToCheckoutContinueButton();

		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("5", stepTitle_paymentInfo));

		checkoutPageUser.selectCheckoutCreditCardType(dropdownlist_creditCardType_visa);
		checkoutPageUser.inputToCheckoutCardholderNameTextbox(cardHolderName);
		checkoutPageUser.selectCheckoutExpireMonth(dropdownlist_expireMonth);
		checkoutPageUser.selectCheckoutExpireYear(dropdownlist_expireYear);
		checkoutPageUser.inputToCheckoutCardNumberTextbox(cardNumber);
		checkoutPageUser.inputToCheckoutCardCodeTextbox(cardCode);
		checkoutPageUser.clickToCheckoutContinueButton();

		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("6", stepTitle_confirmOrder));

		verifyTrue(checkoutPageUser.isCheckoutBillingAddressInfoListDisplayed());
		verifyTrue(checkoutPageUser.isCheckoutPaymentMethodDisplayed(productPaymentMethod));

		verifyTrue(checkoutPageUser.isCheckoutShippingAddressInfoListDisplayed());
		verifyTrue(checkoutPageUser.isCheckoutShippingMethodDisplayed(productShippingMethod));

		verifyEquals(checkoutPageUser.getCheckoutBillingAddressInfoList(), billingInfoListExpected);
		verifyEquals(checkoutPageUser.getCheckoutShippingAddressInfoList(), shippingInfoListExpected);

		verifyTrue(checkoutPageUser.isProductNameInCartTableDisplayed(productName));
		verifyTrue(checkoutPageUser.isProductSKUInCartTableDisplayedByProductName(productName, productSKU));
		verifyTrue(checkoutPageUser.isProductPriceInCartTableDisplayedByProductName(productName, productPrice));
		verifyTrue(checkoutPageUser.isProductQuantityInCartTableCheckoutDisplayedByProductName(productName, productQuantity));
		verifyTrue(checkoutPageUser.isProductTotalPriceInCartTableDisplayedByProductName(productName, productTotalPrice));

		verifyTrue(checkoutPageUser.isCheckoutGiftWrappingMessageDisplayed(dropdownlist_giftWrapping_No));

		verifyTrue(checkoutPageUser.isSubTotalPriceInCartTotalDisplayed(productSubTotalPrice));
		verifyTrue(checkoutPageUser.isShippingMethodPriceInCartTotalDisplayed(productShippingMethod, productShippingMethodPrice));
		verifyTrue(checkoutPageUser.isTaxPriceInCartTotalDisplayed(productTaxPrice));

		productTotalPrice = checkoutPageUser.countTotalPriceWithProductShippingAndTaxPrice(productSubTotalPrice, productShippingPrice, productTaxPrice);
		productPointsReward = checkoutPageUser.countPointsRewardWithProductTotalPrice(productTotalPrice);

		verifyTrue(checkoutPageUser.isTotalPriceInCartTotalDisplayed(productTotalPrice));
		verifyTrue(checkoutPageUser.isEarnPointsRewardInCartTotalDisplayed(productPointsReward));

		checkoutPageUser.waitSeveralSecondsBeforePlacingANewOrder();
		thankYouPageUser = checkoutPageUser.clickToCheckoutCofirmButton();

		verifyTrue(thankYouPageUser.isThankYouPageTitleDisplayed());
		verifyTrue(thankYouPageUser.isOrderSuccessMessageDisplayed());
		verifyTrue(thankYouPageUser.isOrderNumberDisplayed());

		productOrderNumberValue = thankYouPageUser.getOrderNumberValue();

		myAccountPageUser = thankYouPageUser.clickMyAccountLink();
		myAccountPageUser.waitUntilPageReady();

		verifyTrue(myAccountPageUser.isMyAccountPageTitleDisplayed());

		ordersPageUser = myAccountPageUser.clickOrdersLink();

		verifyTrue(ordersPageUser.isOrdersPageTitleDisplayed());
		verifyTrue(ordersPageUser.isOrderNumberByValueDisplayed(productOrderNumberValue));

		orderInforPageUser = ordersPageUser.clickDetailsButtonByOrderNumberValue(productOrderNumberValue);

		verifyTrue(orderInforPageUser.isOrderInforPageTitleDisplayed());

		verifyTrue(orderInforPageUser.isOrderNumberDisplayed(productOrderNumberValue));
		verifyTrue(orderInforPageUser.isOrderDateDisplayed(productOrderDay));
		verifyTrue(orderInforPageUser.isOrderStatusDisplayed(paymentStatus_pending));
		verifyTrue(orderInforPageUser.isOrderTotalDisplayed(productTotalPrice));

		verifyTrue(orderInforPageUser.isCheckoutBillingAddressInfoListDisplayed());
		verifyEquals(orderInforPageUser.getCheckoutBillingAddressInfoList(), billingInfoListExpected);
		verifyTrue(orderInforPageUser.isCheckoutPaymentMethodDisplayed(productPaymentMethod));
		verifyTrue(orderInforPageUser.isCheckoutPaymentStatusDisplayed(paymentStatus_pending));

		verifyTrue(orderInforPageUser.isCheckoutShippingAddressInfoListDisplayed());
		verifyEquals(orderInforPageUser.getCheckoutShippingAddressInfoList(), shippingInfoListExpected);
		verifyTrue(orderInforPageUser.isCheckoutShippingMethodDisplayed(productShippingMethod));
		verifyTrue(orderInforPageUser.isCheckoutShippingStatusDisplayed(shippingStatus_notYetShipped));

		verifyTrue(orderInforPageUser.isProductNameInCartTableDisplayed(productName));
		verifyTrue(orderInforPageUser.isProductSKUInCartTableDisplayedByProductName(productName, productSKU));
		verifyTrue(orderInforPageUser.isProductPriceInCartTableDisplayedByProductName(productName, productPrice));
		verifyTrue(orderInforPageUser.isProductQuantityInCartTableCheckoutDisplayedByProductName(productName, productQuantity));
		verifyTrue(orderInforPageUser.isProductTotalPriceInCartTableDisplayedByProductName(productName, productTotalPrice));

		verifyTrue(orderInforPageUser.isCheckoutGiftWrappingMessageDisplayed(dropdownlist_giftWrapping_No));

		verifyTrue(orderInforPageUser.isSubTotalPriceInCartTotalDisplayed(productSubTotalPrice));
		verifyTrue(orderInforPageUser.isShippingPriceInCartTotalDisplayed(productShippingPrice));
		verifyTrue(orderInforPageUser.isTaxPriceInCartTotalDisplayed(productTaxPrice));

		productTotalPrice = orderInforPageUser.countTotalPriceWithProductShippingAndTaxPrice(productSubTotalPrice, productShippingPrice, productTaxPrice);

		verifyTrue(orderInforPageUser.isTotalPriceInCartTotalDisplayed(productTotalPrice));

		homePageUser = orderInforPageUser.clickHomePageLink();

		verifyTrue(homePageUser.isHomePageTitleDislayed());
	}

	@Test(dependsOnMethods = { "Order06_orderProductAndCheckoutWithCreditCard" })
	public void Order07_reOderProductWith10Quantity() {
		myAccountPageUser = homePageUser.clickMyAccountLink();
		myAccountPageUser.waitUntilPageReady();

		verifyTrue(myAccountPageUser.isMyAccountPageTitleDisplayed());

		ordersPageUser = myAccountPageUser.clickOrdersLink();

		verifyTrue(ordersPageUser.isOrdersPageTitleDisplayed());

		orderInforPageUser = ordersPageUser.clickDetailsButtonByOrderNumberValue(productOrderNumberValue);

		verifyTrue(orderInforPageUser.isOrderInforPageTitleDisplayed());

		cartPageUser = orderInforPageUser.clickReOrderButton();

		verifyTrue(cartPageUser.isCartPageTitleDisplayed());

		productQuantity = "10";
		productSubTotalPrice = cartPageUser.countTotalPriceWithProductQuantity(productPrice, productQuantity);
		productTotalPrice = productSubTotalPrice;
		productPointsReward = cartPageUser.countPointsRewardWithProductTotalPrice(productTotalPrice);

		cartPageUser.incearseProductQuantityInCartTableByProductname(productName, productQuantity);
		cartPageUser.clickUpdateCartButton();

		verifyTrue(cartPageUser.isProductNameInCartTableDisplayed(productName));
		verifyTrue(cartPageUser.isProductSKUInCartTableDisplayedByProductName(productName, productSKU));
		verifyTrue(cartPageUser.isProductPriceInCartTableDisplayedByProductName(productName, productPrice));
		verifyTrue(cartPageUser.isProductQuantityInCartTableDisplayedByProductName(productName, productQuantity));
		verifyTrue(cartPageUser.isProductTotalPriceInCartTableDisplayedByProductName(productName, productTotalPrice));

		cartPageUser.selectGiftWrapping(dropdownlist_giftWrapping_No);
		cartPageUser.checkToTermsOfServiceCheckbox();

		verifyTrue(cartPageUser.isSubTotalPriceInCartTotalDisplayed(productSubTotalPrice));
		verifyTrue(cartPageUser.isShippingPriceInCartTotalDisplayed(productShippingPrice));
		verifyTrue(cartPageUser.isTaxPriceInCartTotalDisplayed(productTaxPrice));
		verifyTrue(cartPageUser.isTotalPriceInCartTotalDisplayed(productTotalPrice));
		verifyTrue(cartPageUser.isEarnPointsRewardInCartTotalDisplayed(productPointsReward));

		checkoutPageUser = cartPageUser.clickToCheckoutButton();

		verifyTrue(checkoutPageUser.isCheckoutPageTitleDisplayed());
		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("1", stepTitle_billingAddress));

		checkoutPageUser.uncheckToCheckoutShipToSameAddressCheckbox();

		checkoutPageUser.selectCheckoutAddress(dropdownlist_selectAddress_newAddress);
		checkoutPageUser.inputToCheckoutFirstNameTextBox(billingFirstName);
		checkoutPageUser.inputToCheckoutLastNameTextBox(billingLastName);
		checkoutPageUser.inputToCheckoutEmailTextBox(billingEmail);
		checkoutPageUser.selectCheckoutCountry(billingCountry);
		checkoutPageUser.inputToCheckoutCityTextBox(billingCity);
		checkoutPageUser.inputToCheckoutAddressOneTextBox(billingAddressOne);
		checkoutPageUser.inputToCheckoutZipCodeTextBox(billingZipCode);
		checkoutPageUser.inputToCheckoutPhoneNumberTextBox(billingPhoneNumber);
		checkoutPageUser.clickToCheckoutContinueButton();

		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("2", stepTitle_shippingAddress));

		checkoutPageUser.selectCheckoutAddress(dropdownlist_selectAddress_newAddress);
		checkoutPageUser.inputToCheckoutFirstNameTextBox(shippingFirstName);
		checkoutPageUser.inputToCheckoutLastNameTextBox(shippingLastName);
		checkoutPageUser.inputToCheckoutEmailTextBox(shippingEmail);
		checkoutPageUser.selectCheckoutCountry(shippingCountry);
		checkoutPageUser.inputToCheckoutCityTextBox(shippingCity);
		checkoutPageUser.inputToCheckoutAddressOneTextBox(shippingAddressOne);
		checkoutPageUser.inputToCheckoutZipCodeTextBox(shippingZipCode);
		checkoutPageUser.inputToCheckoutPhoneNumberTextBox(shippingPhoneNumber);
		checkoutPageUser.clickToCheckoutContinueButton();

		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("3", stepTitle_shippingMethod));

		checkoutPageUser.checkToCheckoutNextDayAirCheckbox();
		productShippingMethod = checkoutPageUser.getCheckoutShippingMethodNextDayAir();
		productShippingMethodPrice = checkoutPageUser.getCheckoutShippingMethodNextDayAirPrice();
		checkoutPageUser.clickToCheckoutContinueButton();

		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("4", stepTitle_paymentMethod));

		checkoutPageUser.checkToCheckoutCreditCardCheckbox();
		productPaymentMethod = checkoutPageUser.getCheckoutPaymentMethodCreditCard();
		checkoutPageUser.clickToCheckoutContinueButton();

		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("5", stepTitle_paymentInfo));

		checkoutPageUser.selectCheckoutCreditCardType(dropdownlist_creditCardType_visa);
		checkoutPageUser.inputToCheckoutCardholderNameTextbox(cardHolderName);
		checkoutPageUser.selectCheckoutExpireMonth(dropdownlist_expireMonth);
		checkoutPageUser.selectCheckoutExpireYear(dropdownlist_expireYear);
		checkoutPageUser.inputToCheckoutCardNumberTextbox(cardNumber);
		checkoutPageUser.inputToCheckoutCardCodeTextbox(cardCode);
		checkoutPageUser.clickToCheckoutContinueButton();

		verifyTrue(checkoutPageUser.isCheckoutStepTitleDisplayed("6", stepTitle_confirmOrder));

		verifyTrue(checkoutPageUser.isCheckoutBillingAddressInfoListDisplayed());
		verifyTrue(checkoutPageUser.isCheckoutPaymentMethodDisplayed(productPaymentMethod));

		verifyTrue(checkoutPageUser.isCheckoutShippingAddressInfoListDisplayed());
		verifyTrue(checkoutPageUser.isCheckoutShippingMethodDisplayed(productShippingMethod));

		verifyEquals(checkoutPageUser.getCheckoutBillingAddressInfoList(), billingInfoListExpected);
		verifyEquals(checkoutPageUser.getCheckoutShippingAddressInfoList(), shippingInfoListExpected);

		verifyTrue(checkoutPageUser.isProductNameInCartTableDisplayed(productName));
		verifyTrue(checkoutPageUser.isProductSKUInCartTableDisplayedByProductName(productName, productSKU));
		verifyTrue(checkoutPageUser.isProductPriceInCartTableDisplayedByProductName(productName, productPrice));
		verifyTrue(checkoutPageUser.isProductQuantityInCartTableCheckoutDisplayedByProductName(productName, productQuantity));
		verifyTrue(checkoutPageUser.isProductTotalPriceInCartTableDisplayedByProductName(productName, productTotalPrice));

		verifyTrue(checkoutPageUser.isCheckoutGiftWrappingMessageDisplayed(dropdownlist_giftWrapping_No));

		verifyTrue(checkoutPageUser.isSubTotalPriceInCartTotalDisplayed(productSubTotalPrice));
		verifyTrue(checkoutPageUser.isShippingMethodPriceInCartTotalDisplayed(productShippingMethod, productShippingMethodPrice));
		verifyTrue(checkoutPageUser.isTaxPriceInCartTotalDisplayed(productTaxPrice));

		productTotalPrice = checkoutPageUser.countTotalPriceWithProductShippingAndTaxPrice(productSubTotalPrice, productShippingPrice, productTaxPrice);
		productPointsReward = checkoutPageUser.countPointsRewardWithProductTotalPrice(productTotalPrice);

		verifyTrue(checkoutPageUser.isTotalPriceInCartTotalDisplayed(productTotalPrice));
		verifyTrue(checkoutPageUser.isEarnPointsRewardInCartTotalDisplayed(productPointsReward));

		checkoutPageUser.waitSeveralSecondsBeforePlacingANewOrder();
		thankYouPageUser = checkoutPageUser.clickToCheckoutCofirmButton();

		verifyTrue(thankYouPageUser.isThankYouPageTitleDisplayed());
		verifyTrue(thankYouPageUser.isOrderSuccessMessageDisplayed());
		verifyTrue(thankYouPageUser.isOrderNumberDisplayed());

		productOrderNumberValue = thankYouPageUser.getOrderNumberValue();

		myAccountPageUser = thankYouPageUser.clickMyAccountLink();
		myAccountPageUser.waitUntilPageReady();

		verifyTrue(myAccountPageUser.isMyAccountPageTitleDisplayed());

		ordersPageUser = myAccountPageUser.clickOrdersLink();

		verifyTrue(ordersPageUser.isOrdersPageTitleDisplayed());
		verifyTrue(ordersPageUser.isOrderNumberByValueDisplayed(productOrderNumberValue));

		orderInforPageUser = ordersPageUser.clickDetailsButtonByOrderNumberValue(productOrderNumberValue);

		verifyTrue(orderInforPageUser.isOrderInforPageTitleDisplayed());

		verifyTrue(orderInforPageUser.isOrderNumberDisplayed(productOrderNumberValue));
		verifyTrue(orderInforPageUser.isOrderDateDisplayed(productOrderDay));
		verifyTrue(orderInforPageUser.isOrderStatusDisplayed(paymentStatus_pending));
		verifyTrue(orderInforPageUser.isOrderTotalDisplayed(productTotalPrice));

		verifyTrue(orderInforPageUser.isCheckoutBillingAddressInfoListDisplayed());
		verifyEquals(orderInforPageUser.getCheckoutBillingAddressInfoList(), billingInfoListExpected);
		verifyTrue(orderInforPageUser.isCheckoutPaymentMethodDisplayed(productPaymentMethod));
		verifyTrue(orderInforPageUser.isCheckoutPaymentStatusDisplayed(paymentStatus_pending));

		verifyTrue(orderInforPageUser.isCheckoutShippingAddressInfoListDisplayed());
		verifyEquals(orderInforPageUser.getCheckoutShippingAddressInfoList(), shippingInfoListExpected);
		verifyTrue(orderInforPageUser.isCheckoutShippingMethodDisplayed(productShippingMethod));
		verifyTrue(orderInforPageUser.isCheckoutShippingStatusDisplayed(shippingStatus_notYetShipped));

		verifyTrue(orderInforPageUser.isProductNameInCartTableDisplayed(productName));
		verifyTrue(orderInforPageUser.isProductSKUInCartTableDisplayedByProductName(productName, productSKU));
		verifyTrue(orderInforPageUser.isProductPriceInCartTableDisplayedByProductName(productName, productPrice));
		verifyTrue(orderInforPageUser.isProductQuantityInCartTableCheckoutDisplayedByProductName(productName, productQuantity));
		verifyTrue(orderInforPageUser.isProductTotalPriceInCartTableDisplayedByProductName(productName, productTotalPrice));

		verifyTrue(orderInforPageUser.isCheckoutGiftWrappingMessageDisplayed(dropdownlist_giftWrapping_No));

		verifyTrue(orderInforPageUser.isSubTotalPriceInCartTotalDisplayed(productSubTotalPrice));
		verifyTrue(orderInforPageUser.isShippingPriceInCartTotalDisplayed(productShippingPrice));
		verifyTrue(orderInforPageUser.isTaxPriceInCartTotalDisplayed(productTaxPrice));

		productTotalPrice = orderInforPageUser.countTotalPriceWithProductShippingAndTaxPrice(productSubTotalPrice, productShippingPrice, productTaxPrice);

		verifyTrue(orderInforPageUser.isTotalPriceInCartTotalDisplayed(productTotalPrice));

		homePageUser = orderInforPageUser.clickHomePageLink();

		verifyTrue(homePageUser.isHomePageTitleDislayed());
	}

	HomePageUser homePageUser;
	CartPageUser cartPageUser;
	SearchPageUser searchPageUser;
	CheckoutPageUser checkoutPageUser;
	ThankYouPageUser thankYouPageUser;
	OrdersPageUser ordersPageUser;
	OrderInformationPageUser orderInforPageUser;
	MyAccountPageUser myAccountPageUser;
	DetailProductPageUser detailProductPageUser;
	DataUser data = DataUser.getData();
	String productName, productSKU, productQuantity, productPrice, productSubTotalPrice, productTotalPrice, productPointsReward;
	String productShippingMethod, productShippingMethodPrice, productPaymentMethod, productOrderNumberValue;
	String productOrderDay = data.getOrderDay();
	String productShippingPrice = "$0.00";
	String productTaxPrice = "$0.00";
	String product_search_Order01 = "Build your own computer";
	String product_search_Order04 = "Lenovo IdeaCentre 600 All-in-One PC";
	String product_search_Order05 = "Apple MacBook Pro 13-inch";
	String product_search_Order06 = "HTC One M8 Android L 5.0 Lollipop";
	String dropdownlist_processor_2point5GHz = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
	String dropdownlist_processor_2point2GHz = "2.2 GHz Intel Pentium Dual-Core E2200";
	String dropdownlist_ram_8GB = "8GB [+$60.00]";
	String dropdownlist_ram_4GB = "4GB [+$20.00]";
	String checkbox_hdd_400GB = "400 GB [+$100.00]";
	String checkbox_hdd_320GB = "320 GB";
	String checkbox_os_vistaHome = "Vista Home [+$50.00]";
	String checkbox_os_vistaPremium = "Vista Premium [+$60.00]";
	String checkbox_software_microsoftService = "Microsoft Office [+$50.00]";
	String checkbox_software_acrobatReader = "Acrobat Reader [+$10.00]";
	String checkbox_software_totalCommander = "Total Commander [+$5.00]";
	String dropdownlist_giftWrapping_No = "No";
	String dropdownlist_selectAddress_newAddress = "New Address";
	// Steps title
	String stepTitle_billingAddress = "Billing address";
	String stepTitle_shippingAddress = "Shipping address";
	String stepTitle_shippingMethod = "Shipping method";
	String stepTitle_paymentMethod = "Payment method";
	String stepTitle_paymentInfo = "Payment information";
	String stepTitle_confirmOrder = "Confirm order";
	// Billing address
	String billingFirstName, billingLastName, billingEmail, billingCountry, billingCity, billingAddressOne, billingZipCode, billingPhoneNumber, billingInfoListExpected;
	// Shipping address
	String shippingFirstName, shippingLastName, shippingEmail, shippingCountry, shippingCity, shippingAddressOne, shippingZipCode, shippingPhoneNumber, shippingInfoListExpected;
	// Status billing and shipping
	String paymentStatus_pending = "Pending";
	String shippingStatus_notYetShipped = "Not yet shipped";
	// Credit card
	String dropdownlist_creditCardType_visa = "Visa";
	String dropdownlist_expireMonth, dropdownlist_expireYear;
	String cardHolderName, cardNumber, cardCode;
	// Attributes of product
	String attribute_processor_2point5GHz = "Processor: " + dropdownlist_processor_2point5GHz;
	String attribute_processor_2point2GHz = "Processor: " + dropdownlist_processor_2point2GHz;
	String attribute_ram_8GB = "RAM: " + dropdownlist_ram_8GB;
	String attribute_ram_4GB = "RAM: " + dropdownlist_ram_4GB;
	String attribute_hdd_320GB = "HDD: " + checkbox_hdd_320GB;
	String attribute_hdd_400GB = "HDD: " + checkbox_hdd_400GB;
	String attribute_os_vistaHome = "OS: " + checkbox_os_vistaHome;
	String attribute_os_vistaPremium = "OS: " + checkbox_os_vistaPremium;
	String attribute_software_microsoftService = "Software: " + checkbox_software_microsoftService;
	String attribute_software_acrobatReader = "Software: " + checkbox_software_acrobatReader;
	String attribute_software_totalCommander = "Software: " + checkbox_software_totalCommander;
	// Expected Attributes of product
	String attributes_exptected_1 = attribute_processor_2point5GHz + attribute_ram_8GB + attribute_hdd_400GB + attribute_os_vistaPremium + attribute_software_microsoftService
			+ attribute_software_acrobatReader + attribute_software_totalCommander;
	String attributes_exptected_2 = attribute_processor_2point2GHz + attribute_ram_4GB + attribute_hdd_320GB + attribute_os_vistaHome + attribute_software_microsoftService;

}
