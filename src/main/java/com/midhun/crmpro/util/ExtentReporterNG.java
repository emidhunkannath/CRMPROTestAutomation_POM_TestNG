package com.midhun.crmpro.util;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter {

	private String screenshot;
	private ExtentReports extent;

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		extent = new ExtentReports(outputDirectory + File.separator + "extentreport.html", true);
		extent.loadConfig(new File(System.getProperty("user.dir") + "/src/main/java/com/midhun/crmpro/config/extent-config.xml"));
		for (ISuite suite : suites) {

			Map<String, ISuiteResult> result = suite.getResults();
			for (ISuiteResult r : result.values()) {

				ITestContext context = r.getTestContext();
				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}
		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {

		ExtentTest test;

		if (tests.size() > 0) {

			for (final ITestResult result : tests.getAllResults()) {

				test = extent.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);
				if (result.getThrowable() != null) {

					test.log(status, result.getThrowable());
					screenshot = TestUtil.getScreenshot(result);
					if (screenshot != null)
						test.log(status, test.addScreenCapture(screenshot));
				} else {

					if (status.toString().equals("pass"))
						test.log(status, "Test " + status.toString().toLowerCase() + "ed");
					else {

						test.log(status, result.getThrowable());
						screenshot = TestUtil.getScreenshot(result);
						if (screenshot != null)
							test.log(status, test.addScreenCapture(screenshot));
					}
				}
				extent.endTest(test);
			}
		}
	}

	private Date getTime(long millis) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}