package com.nopcommerce.extentreport;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.nopcommerce.base.BaseTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportListener extends BaseTest implements ITestListener {
	private ExtentReports report;
	private ExtentTest logger;

	public void onStart(ITestContext context) {
		System.out.println("---------- " + context.getName() + " STARTED suite ----------");
		String workingDir = System.getProperty("user.dir");
		report = new ExtentReports(workingDir + "\\ExtentReports\\ExtentReportResults_" + getCurrentTime() + ".html", true);
	}

	public void onFinish(ITestContext context) {
		System.out.println("---------- " + context.getName() + " FINISHED suite ----------");
		report.flush();
		report.close();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("---------- " + result.getName() + " STARTED test ----------");
		logger = report.startTest(result.getMethod().getMethodName(), result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("---------- " + result.getName() + " SUCCESS test ----------");
		logger.log(LogStatus.PASS, "Test Passed");
		report.endTest(logger);
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("---------- " + result.getName() + " FAILED test ----------");
		Object testClass = result.getInstance();
		WebDriver driver = ((BaseTest) testClass).getDriver();
		String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		logger.log(LogStatus.FAIL, "Test Failed", logger.addBase64ScreenShot(base64Screenshot));
		report.endTest(logger);
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("---------- " + result.getName() + " SKIPPED test ----------");
		logger.log(LogStatus.SKIP, "Test Skipped");
		report.endTest(logger);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("---------- " + result.getName() + " FAILED WITH SUCCESS PERCENTAGE test ----------");
	}

	private String getCurrentTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("MMMM_dd_yyyy_hh_mm_ss");
		return df.format(date);
	}
}
