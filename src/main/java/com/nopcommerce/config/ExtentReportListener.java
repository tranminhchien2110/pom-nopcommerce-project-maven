package com.nopcommerce.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportListener implements IReporter {
	private ExtentReports report;
	private ExtentTest logger;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		report = new ExtentReports(System.getProperty("user.dir") + "/ExtentReportV2/ExtentReport" + getCurrentTime() + ".html", true);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}
		report.flush();
		report.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		if (tests.size() > 0) {
			Set<ITestResult> allResultsSet = tests.getAllResults();
			List<ITestResult> allResultsList = new ArrayList<ITestResult>(allResultsSet);// set -> list
			// Sort the list
			Collections.sort(allResultsList);
			allResultsSet = new LinkedHashSet<ITestResult>(allResultsList); // list -> set

			for (ITestResult result : allResultsSet) {

				logger = report.startTest(result.getMethod().getMethodName());

				logger.setStartedTime(getTime(result.getStartMillis()));
				logger.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					logger.assignCategory(group);

				if (result.getThrowable() != null) {
					logger.log(status, result.getThrowable());
				} else {
					logger.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}

				report.endTest(logger);
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	private String getCurrentTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("MMMM_dd_yyyy_hh_mm_ss");
		return df.format(date);
	}

	public void extendLog(String message) {
		logger.log(LogStatus.INFO, message);
		Reporter.log(message);
	}
}
