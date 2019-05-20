package com.midhun.crmpro.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	public static String getTestMethodName(ITestResult result) {
		return result.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("Test started " + result.getMethod().getConstructorOrMethod().getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("Test passed " + result.getMethod().getConstructorOrMethod().getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("Test failed " + result.getMethod().getConstructorOrMethod().getName());
		TestUtil.takeScreenshot(getTestMethodName(result));
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println("Test skipped " + result.getMethod().getConstructorOrMethod().getName());
		TestUtil.takeScreenshot(getTestMethodName(result));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println("Test failed but has been annotated with success percentage " + result.getMethod().getConstructorOrMethod().getName());
	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("Test started " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("Test finished " + context.getName());
	}
}