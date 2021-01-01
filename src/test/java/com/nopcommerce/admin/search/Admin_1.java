package com.nopcommerce.admin.search;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.admin.precondition.PreConditionLoginAdmin;
import com.nopcommerce.pages.admin.EditProductDetailsPageAdmin;
import com.nopcommerce.pages.admin.HomePageAdmin;
import com.nopcommerce.pages.admin.ProductsPageAdmin;

public class Admin_1 extends PreConditionLoginAdmin {

	@BeforeClass
	public void openProductsPageAdmin() {
		homePageAdmin = getHomePageAdmin();
		homePageAdmin.clickToDynamicSubMenuTitleLink(subMenuTitle_catalog);
		homePageAdmin.clickToDynamicSubMenuItemLink(subMenuItem_products);

		productsPageAdmin = ProductsPageAdmin.getProductsPageAdmin(getDriver());

		verifyTrue(productsPageAdmin.isProductsPageAdminTitleDisplayed());
	}

	@Test
	public void Admin01_searchProductName() {
		productsPageAdmin.inputToProductNameTextbox(productName_lenovo600);
		productsPageAdmin.clickToSearchButton();

		verifyTrue(productsPageAdmin.isOnlyOneRowDisplayed());
		verifyTrue(productsPageAdmin.areAllValuesDisplayedOnOneRowByColumnNameAndValue(columnNames, columnValues));
	}

	@Test
	public void Admin02_searchProductNameWithParentCategory() {
		productsPageAdmin.inputToProductNameTextbox(productName_lenovo600);
		productsPageAdmin.selectCategoryList(category_item_computers);
		productsPageAdmin.uncheckSearchSubCategoriesCheckbox();
		productsPageAdmin.clickToSearchButton();
	}

	@Test
	public void Admin03_searchProductNameWithParentCategoryAndSearchSubCategories() {
		productsPageAdmin.inputToProductNameTextbox(productName_lenovo600);
		productsPageAdmin.selectCategoryList(category_item_computers);
		productsPageAdmin.checkSearchSubCategoriesCheckbox();
		productsPageAdmin.clickToSearchButton();

		verifyTrue(productsPageAdmin.isOnlyOneRowDisplayed());
		verifyTrue(productsPageAdmin.areAllValuesDisplayedOnOneRowByColumnNameAndValue(columnNames, columnValues));
	}

	@Test
	public void Admin04_searchProductNameWithChildCategory() {
		productsPageAdmin.inputToProductNameTextbox(productName_lenovo600);
		productsPageAdmin.selectCategoryList(category_item_computers_desktops);
		productsPageAdmin.uncheckSearchSubCategoriesCheckbox();
		productsPageAdmin.clickToSearchButton();

		verifyTrue(productsPageAdmin.isOnlyOneRowDisplayed());
		verifyTrue(productsPageAdmin.areAllValuesDisplayedOnOneRowByColumnNameAndValue(columnNames, columnValues));
	}

	@Test
	public void Admin05_searchProductNameWithManufacturer() {
		productsPageAdmin.inputToProductNameTextbox(productName_lenovo600);
		productsPageAdmin.selectCategoryList(category_item_all);
		productsPageAdmin.uncheckSearchSubCategoriesCheckbox();
		productsPageAdmin.selectManufacturerList(manufacturer_item_apple);
		productsPageAdmin.clickToSearchButton();

		verifyTrue(productsPageAdmin.isNoRowDisplayed());
		verifyTrue(productsPageAdmin.isNoDataAvailableInTableMessageDisplayed());
	}

	@Test
	public void Admin06_goDirectlyToProductSKU() {
		productsPageAdmin.inputToGoDirectlyToSKUTextbox(productSKU_lenovo600);
		productsPageAdmin.clickToGoButton();

		editProductDetailsPageAdmin = EditProductDetailsPageAdmin.getEditProductDetailsPageAdmin(getDriver());

		verifyTrue(editProductDetailsPageAdmin.isEditProductDetailsPageAdminTitleDisplayed(productName_lenovo600));

		editProductDetailsPageAdmin.clickToDynamicSubMenuItemLink(subMenuItem_products);

		productsPageAdmin = ProductsPageAdmin.getProductsPageAdmin(getDriver());

		verifyTrue(productsPageAdmin.isProductsPageAdminTitleDisplayed());
	}

	HomePageAdmin homePageAdmin;
	ProductsPageAdmin productsPageAdmin;
	EditProductDetailsPageAdmin editProductDetailsPageAdmin;
	// Product details
	String productName_lenovo600 = "Lenovo IdeaCentre 600 All-in-One PC";
	String productSKU_lenovo600 = "LE_IC_600";
	// SubMenu name
	String subMenuTitle_catalog = "Catalog";
	String subMenuItem_products = "Products";
	// Column name
	String columnName_productName = "Product name";
	String[] columnNames = { columnName_productName };
	String[] columnValues = { productName_lenovo600 };
	// Dropdown list / item in list
	String category_item_all = "All";
	String category_item_computers = "Computers";
	String category_item_computers_desktops = "Computers >> Desktops";
	String manufacturer_item_apple = "Apple";
}
