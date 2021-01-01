package com.nopcommerce.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nopcommerce.util.TestUtil;

public abstract class BasePage {
	private WebDriver driver;

	public BasePage(WebDriver driver) {
		super();
		if (this.driver != driver)
			this.driver = driver;
	}

	protected WebDriver getDriver() {
		return driver;
	}

	protected By byXpath(String locator) {
		return By.xpath(locator);
	}

	protected WebElement findElementByXpath(String locator) {
		return driver.findElement(byXpath(locator));
	}

	protected List<WebElement> findElementsByXpath(String locator) {
		return driver.findElements(byXpath(locator));
	}

	protected int countElement(String locator) {
		return findElementsByXpath(locator).size();
	}

	protected int countElement(String locator, String... data) {
		return findElementsByXpath(castToObject(locator, data)).size();
	}

	protected String getTextElement(String locator) {
		return findElementByXpath(locator).getText().trim();
	}

	protected String getTextElement(String locator, String... data) {
		return findElementByXpath(castToObject(locator, data)).getText().trim();
	}

	protected String getAttributeElement(String locator, String attribute) {
		return findElementByXpath(locator).getAttribute(attribute).trim();
	}

	protected String castToObject(String locator, String... data) {
		return String.format(locator, (Object[]) data);
	}

	protected String getTextFromAlert() {
		return driver.switchTo().alert().getText();
	}

	protected void clickToElement(String locator) {
		findElementByXpath(locator).click();
	}

	protected void hoverToElement(String locator) {
		(new Actions(driver)).moveToElement(findElementByXpath(locator)).perform();
		;
	}

	protected void clickToElement(String locator, String... data) {
		findElementByXpath(castToObject(locator, data)).click();
	}

	protected void sendKeysToElement(String locator, String keysToSend) {
		findElementByXpath(locator).clear();
		findElementByXpath(locator).sendKeys(keysToSend);
	}

	protected void sendEnterKeyFromKeyboard() {
		(new Actions(driver)).sendKeys(Keys.ENTER).perform();
	}

	protected void scrollToBottomPageByJS() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, document.body.scrollHeight)");
	}

	protected void clickToElementByJS(String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", findElementByXpath(locator));
	}

	protected void waitForElementVisible(String locator) {
		(new WebDriverWait(driver, TestUtil.EXLICIT_WAIT)).until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));
	}

	protected void waitForElementsStaleness(String locator) {
		(new WebDriverWait(driver, TestUtil.EXLICIT_WAIT)).until(ExpectedConditions.stalenessOf(findElementByXpath(locator)));
	}

	protected void waitForElementsPresence(String locator) {
		(new WebDriverWait(driver, TestUtil.EXLICIT_WAIT)).until(ExpectedConditions.presenceOfElementLocated(byXpath(locator)));
	}

	protected void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	protected void ajaxComplete() {
		((JavascriptExecutor) driver).executeScript("var callback = arguments[arguments.length - 1];" + "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
				+ "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {" + "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
	}

	protected void waitUntilJSReady() {
		(new WebDriverWait(driver, TestUtil.EXLICIT_WAIT)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return (Boolean) ((JavascriptExecutor) d).executeScript("return document.readyState").toString().equals("complete");
			}
		});
	}

	protected void waitForJQueryLoad() {
		(new WebDriverWait(driver, TestUtil.EXLICIT_WAIT)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return (Boolean) ((JavascriptExecutor) d).executeScript("return !!window.jQuery && window.jQuery.active == 0");
			}
		});
	}

	protected void waitUntilJQueryReady() {
		Boolean jQueryDefined = (new WebDriverWait(driver, TestUtil.EXLICIT_WAIT)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return (Boolean) ((JavascriptExecutor) d).executeScript("return typeof jQuery != 'undefined'");
			}
		});

		if (jQueryDefined) {
			poll(300);
			waitForJQueryLoad();
			poll(300);
		}
	}

	protected void poll(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void checkToCheckbox(String locator) {
		if (!isElementSelected(locator))
			clickToElement(locator);
	}

	protected void checkToCheckbox(String locator, String... data) {
		if (!isElementSelected(castToObject(locator, data)))
			clickToElement(castToObject(locator, data));
	}

	protected void uncheckToCheckbox(String locator) {
		if (isElementSelected(locator))
			clickToElement(locator);
	}

	protected void uncheckToCheckbox(String locator, String... data) {
		if (isElementSelected(castToObject(locator, data)))
			clickToElement(castToObject(locator, data));
	}

	protected void selectValueInDropdownList(String locator, String data) {
		(new Select(findElementByXpath(locator))).selectByVisibleText(data);
	}

	protected void overrideImplicitTimeout(long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	protected void navigateBack() {
		driver.navigate().back();
	}

	protected void setAttribute(String locator, String attName, String attValue) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", findElementByXpath(locator), attName, attValue);
	}

	protected void setAttribute(String locator, String attName, String attValue, String... data) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", findElementByXpath(castToObject(locator, data)), attName, attValue);
	}

	protected boolean isElementDisplayed(String locator) {
		return findElementByXpath(locator).isDisplayed();
	}

	protected boolean isElementDisplayed(String locator, String... data) {
		return findElementByXpath(castToObject(locator, data)).isDisplayed();
	}

	protected boolean isElementUndisplayed(String locator) {
		overrideImplicitTimeout(TestUtil.IMPLICIT_SHORT_WAIT);

		List<WebElement> elements = findElementsByXpath(locator);

		if (elements.size() == 0) {
			overrideImplicitTimeout(TestUtil.IMPLICIT_WAIT);
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			overrideImplicitTimeout(TestUtil.IMPLICIT_WAIT);
			return true;
		} else {
			overrideImplicitTimeout(TestUtil.IMPLICIT_WAIT);
			return false;
		}
	}

	protected boolean isElementUndisplayed(String locator, String... data) {
		overrideImplicitTimeout(TestUtil.IMPLICIT_SHORT_WAIT);

		List<WebElement> elements = findElementsByXpath(castToObject(locator, data));

		if (elements.size() == 0) {
			overrideImplicitTimeout(TestUtil.IMPLICIT_WAIT);
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			overrideImplicitTimeout(TestUtil.IMPLICIT_WAIT);
			return true;
		} else {
			overrideImplicitTimeout(TestUtil.IMPLICIT_WAIT);
			return false;
		}
	}

	protected boolean isElementSelected(String locator) {
		return findElementByXpath(locator).isSelected();
	}

	protected boolean isElementSelected(String locator, String... data) {
		return findElementByXpath(castToObject(locator, data)).isSelected();
	}

	protected boolean isDataSortedAscending(String locator) {
		List<WebElement> elements = findElementsByXpath(locator);
		ArrayList<String> sortByWebAppList = new ArrayList<String>();
		ArrayList<String> sortByJavaList = new ArrayList<String>();

		for (WebElement e : elements) {
			sortByWebAppList.add(e.getText());
		}

		System.out.println("--------Dữ liệu trên UI(Asc):--------");

		for (String name : sortByWebAppList) {
			System.out.println(name);
		}

		System.out.println("--------Dữ liệu đã sort(Asc) trong code:--------");

		for (String sortByWebApp : sortByWebAppList) {
			sortByJavaList.add(sortByWebApp);
		}

		Collections.sort(sortByJavaList);

		for (String name : sortByJavaList) {
			System.out.println(name);
		}

		return sortByJavaList.equals(sortByWebAppList);
	}

	protected boolean isDataSortedDescending(String locator) {
		List<WebElement> elements = findElementsByXpath(locator);
		ArrayList<String> sortByWebAppList = new ArrayList<String>();
		ArrayList<String> sortByJavaList = new ArrayList<String>();

		for (WebElement e : elements) {
			sortByWebAppList.add(e.getText());
		}

		System.out.println("--------Dữ liệu trên UI(Desc):--------");

		for (String name : sortByWebAppList) {
			System.out.println(name);
		}

		System.out.println("--------Dữ liệu đã sort(Desc) trong code:--------");

		for (String sortByWebApp : sortByWebAppList) {
			sortByJavaList.add(sortByWebApp);
		}

		Collections.sort(sortByJavaList);
		Collections.reverse(sortByJavaList);

		for (String name : sortByJavaList) {
			System.out.println(name);
		}

		return sortByJavaList.equals(sortByWebAppList);
	}
}
