package com.midhun.crmpro.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	private static Logger logger = LogManager.getLogger();

	public static String getTestMethodName(ITestResult result) {

		return result.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onTestStart(ITestResult result) {

		logger.info("Test started " + result.getMethod().getConstructorOrMethod().getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		logger.info("Test passed " + result.getMethod().getConstructorOrMethod().getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		logger.error("Test failed " + result.getMethod().getConstructorOrMethod().getName(), result.getThrowable());
		TestUtil.takeScreenshot(getTestMethodName(result));
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		logger.info("Test skipped " + result.getMethod().getConstructorOrMethod().getName(), result.getThrowable());
		TestUtil.takeScreenshot(getTestMethodName(result));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		logger.info("Test failed but has been annotated with success percentage " + result.getMethod().getConstructorOrMethod().getName());
	}

	@Override
	public void onStart(ITestContext context) {

		logger.info("Test started " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {

		logger.info("Test finished " + context.getName());
	}
}