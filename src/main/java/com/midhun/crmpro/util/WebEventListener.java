/*************************************** PURPOSE **********************************

 - This class implements the WebDriverEventListener, which is included under events.

 The purpose of implementing this interface is to override all the methods and define certain useful  Log statements

 which would be displayed/logged as the application under test is being run.

 Do not call any of these methods, instead these methods will be invoked automatically

 as an when the action done (click, findBy etc).

 */

package com.midhun.crmpro.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import com.midhun.crmpro.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {
	
	private Logger logger = LogManager.getLogger();

	public void beforeNavigateTo(String url, WebDriver driver) {

		logger.info("Before navigating to '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {

		logger.info("Navigated to '" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {

		logger.info("Value of the " + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {

		logger.info("Element value changed to " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {

		logger.info("Trying to click on " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {

		logger.info("Clicked on " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {

		logger.info("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {

		logger.info("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {

		logger.info("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {

		logger.info("Navigated forward to next page");
	}

	public void onException(Throwable throwable, WebDriver driver) {

		logger.error("Exception occured", throwable);
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {

		logger.info("Trying to find Element By " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {

		logger.info("Found Element By " + by.toString());
	}

	/*
	 * 
	 * non overridden methods of WebListener class
	 * 
	 */

	public void beforeScript(String script, WebDriver driver) {

	}

	public void afterScript(String script, WebDriver driver) {

	}

	public void beforeAlertAccept(WebDriver driver) {

	}

	public void afterAlertAccept(WebDriver driver) {

	}

	public void afterAlertDismiss(WebDriver driver) {

	}

	public void beforeAlertDismiss(WebDriver driver) {

	}

	public void beforeNavigateRefresh(WebDriver driver) {

	}

	public void afterNavigateRefresh(WebDriver driver) {

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {

	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {

	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {

	}

	public void beforeGetText(WebElement element, WebDriver driver) {

	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {

	}
}