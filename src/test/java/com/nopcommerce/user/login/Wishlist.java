package com.nopcommerce.user.login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopcommerce.data.DataUser;
import com.nopcommerce.pages.user.CartPageUser;
import com.nopcommerce.pages.user.CompareProductsPageUser;
import com.nopcommerce.pages.user.DetailProductPageUser;
import com.nopcommerce.pages.user.HomePageUser;
import com.nopcommerce.pages.user.RecentlyViewedProductPageUser;
import com.nopcommerce.pages.user.SearchPageUser;
import com.nopcommerce.pages.user.WishListPageUser;
import com.nopcommerce.user.precondition.PreConditionLoginUser;

public class Wishlist extends PreConditionLoginUser {

	@BeforeMethod
	public void openWishlistPageUser() {
		homePageUser = getHomePageUser();
		homePageUser.inputToSearchTextbox("macbook");

		searchPageUser = homePageUser.clickToSearchButton();
		searchPageUser.waitUntilPageReady();
		verifyTrue(searchPageUser.isSearchPageTitleDisplayed());
		verifyTrue(searchPageUser.areAllProductNameDisplayed());

		productName = searchPageUser.getProductNameByIndex(0);
		productPrice = searchPageUser.getProductPriceByIndex(0);

		detailProductPageUser = searchPageUser.clickToProductByIndex(0);
		detailProductPageUser.waitUntilPageReady();

		verifyTrue(detailProductPageUser.isDetailProductPageTitleDisplayed());

		detailProductPageUser.clickAddToWishListButton();

		verifyTrue(detailProductPageUser.isAddToWishlistSuccessMessageDisplayed());

		detailProductPageUser.clickCloseSuccessMessage();
		detailProductPageUser.waitAddToWishlistSuccessMessageDisappear();

		wishListPageUser = detailProductPageUser.clickWishlistLink();

		verifyTrue(wishListPageUser.isWishlistPageTitleDisplayed(wishlistPageTitle));
	}

	@Test(priority = 1)
	public void W01_addProductToWishlist() {
		verifyTrue(wishListPageUser.isProductNameInCartTableDisplayed(productName));
		verifyTrue(wishListPageUser.isProductPriceInCartTableDisplayedByProductName(productName, productPrice));

		wishListPageUser.clickSharingLink();

		verifyTrue(wishListPageUser.isWishlistPageTitleDisplayed(wishlistSharingLinkPageTitle));
		verifyTrue(wishListPageUser.isProductNameInCartTableDisplayed(productName));
		verifyTrue(wishListPageUser.isProductPriceInCartTableDisplayedByProductName(productName, productPrice));
	}

	@Test(priority = 2)
	public void W02_addProductToCartFromWishlist() {
		wishListPageUser.checkAddToCartCheckbox();
		wishListPageUser.clickAddToCartButton();

		cartPageUser = CartPageUser.getCartPageUser(getDriver());

		verifyTrue(cartPageUser.isCartPageTitleDisplayed());
		verifyTrue(cartPageUser.isProductNameInCartTableDisplayed(productName));
		verifyTrue(cartPageUser.isProductPriceInCartTableDisplayedByProductName(productName, productPrice));

		wishListPageUser = cartPageUser.clickWishlistLink();

		verifyTrue(wishListPageUser.isWishlistPageTitleDisplayed(wishlistPageTitle));
		verifyTrue(wishListPageUser.isWishlistEmptyMessageDisplayed());
	}

	@Test(priority = 3)
	public void W03_removeProductFromWishlist() {
		wishListPageUser.checkRemoveFromCartCheckboxByProductName(productName);
		wishListPageUser.clickUpdateCartButton();

		verifyTrue(wishListPageUser.isWishlistEmptyMessageDisplayed());
		verifyTrue(wishListPageUser.isProductNameInCartTableUndisplayed(productName));
		verifyTrue(wishListPageUser.isProductPriceInCartTableUndisplayedByProductName(productName, productPrice));
	}

	@Test(priority = 4)
	public void W04_addProductToCompareList() {
		wishListPageUser.inputToSearchTextbox("lenovo");
		searchPageUser = wishListPageUser.clickToSearchButton();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isSearchPageTitleDisplayed());
		verifyTrue(searchPageUser.areAllProductNameDisplayed());

		String lenovoName_0 = searchPageUser.getProductNameByIndex(0);
		String lenovoPrice_0 = searchPageUser.getProductPriceByIndex(0);

		String lenovoName_1 = searchPageUser.getProductNameByIndex(1);
		String lenovoPrice_1 = searchPageUser.getProductPriceByIndex(1);

		searchPageUser.clickAddToCompareListButtonByProductName(lenovoName_0);
		verifyTrue(searchPageUser.isAddToComparelistSuccessMessageDisplayed());
		searchPageUser.clickCloseSuccessMessage();
		searchPageUser.waitAddToComparelistSuccessMessageDisappear();

		searchPageUser.clickAddToCompareListButtonByProductName(lenovoName_1);
		verifyTrue(searchPageUser.isAddToComparelistSuccessMessageDisplayed());
		searchPageUser.clickCloseSuccessMessage();
		searchPageUser.waitAddToComparelistSuccessMessageDisappear();

		compareProductsPageUser = searchPageUser.clickCompareProductsLink();

		verifyTrue(compareProductsPageUser.isCompareProductsPageTitleDisplayed());
		verifyTrue(compareProductsPageUser.areRemoveButtonsDisplayed());
		verifyTrue(compareProductsPageUser.areProductNamesDisplayed(lenovoName_0, lenovoName_1));
		verifyTrue(compareProductsPageUser.areProductPricesDisplayed(lenovoPrice_0, lenovoPrice_1));

		compareProductsPageUser.clickClearListButton();

		verifyTrue(compareProductsPageUser.isNoItemsToCompareMessageDisplayed());
	}

	@Test(priority = 5)
	public void W05_viewRecentProducts() {
		// View product 1
		wishListPageUser.inputToSearchTextbox("digital");
		searchPageUser = wishListPageUser.clickToSearchButton();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isSearchPageTitleDisplayed());
		verifyTrue(searchPageUser.areAllProductNameDisplayed());

		detailProductPageUser = searchPageUser.clickToProductByIndex(0);
		detailProductPageUser.waitUntilPageReady();

		verifyTrue(detailProductPageUser.isDetailProductPageTitleDisplayed());
		// View product 2
		searchPageUser = detailProductPageUser.backToSearchPageUser();
		detailProductPageUser = searchPageUser.clickToProductByIndex(1);
		detailProductPageUser.waitUntilPageReady();

		verifyTrue(detailProductPageUser.isDetailProductPageTitleDisplayed());
		// View product 3
		detailProductPageUser.inputToSearchTextbox("HTC");
		searchPageUser = detailProductPageUser.clickToSearchButton();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isSearchPageTitleDisplayed());
		verifyTrue(searchPageUser.areAllProductNameDisplayed());

		detailProductPageUser = searchPageUser.clickToProductByIndex(0);
		detailProductPageUser.waitUntilPageReady();

		verifyTrue(detailProductPageUser.isDetailProductPageTitleDisplayed());

		String productName_3 = detailProductPageUser.getProductName();
		// View product 4
		searchPageUser = detailProductPageUser.backToSearchPageUser();
		detailProductPageUser = searchPageUser.clickToProductByIndex(1);
		detailProductPageUser.waitUntilPageReady();

		verifyTrue(detailProductPageUser.isDetailProductPageTitleDisplayed());

		String productName_4 = detailProductPageUser.getProductName();
		// View product 5
		detailProductPageUser.inputToSearchTextbox("mac");
		searchPageUser = detailProductPageUser.clickToSearchButton();
		searchPageUser.waitUntilPageReady();

		verifyTrue(searchPageUser.isSearchPageTitleDisplayed());
		verifyTrue(searchPageUser.areAllProductNameDisplayed());

		detailProductPageUser = searchPageUser.clickToProductByIndex(0);
		detailProductPageUser.waitUntilPageReady();

		verifyTrue(detailProductPageUser.isDetailProductPageTitleDisplayed());

		String productName_5 = detailProductPageUser.getProductName();
		// Verify three last products are displayed
		recentlyViewedProductPageUser = detailProductPageUser.clickRecentlyViewedProductsLink();
		recentlyViewedProductPageUser.waitUntilPageReady();

		verifyTrue(recentlyViewedProductPageUser.isRecentlyViewdProductsPageTitleDisplayed());
		verifyTrue(recentlyViewedProductPageUser.areAllProductNameDisplayed());
		verifyEquals(recentlyViewedProductPageUser.getProductNameByIndex(0), productName_5);
		verifyEquals(recentlyViewedProductPageUser.getProductNameByIndex(1), productName_4);
		verifyEquals(recentlyViewedProductPageUser.getProductNameByIndex(2), productName_3);
	}

	HomePageUser homePageUser;
	SearchPageUser searchPageUser;
	DetailProductPageUser detailProductPageUser;
	WishListPageUser wishListPageUser;
	CartPageUser cartPageUser;
	RecentlyViewedProductPageUser recentlyViewedProductPageUser;
	CompareProductsPageUser compareProductsPageUser;
	String fullName = DataUser.FIRSTNAME + " " + DataUser.LASTNAME;
	String wishlistPageTitle = "Wishlist";
	String wishlistSharingLinkPageTitle = "Wishlist of " + fullName;
	String productName, productPrice;
}
