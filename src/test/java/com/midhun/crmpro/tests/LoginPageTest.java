package com.midhun.crmpro.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.midhun.crmpro.base.TestBase;
import com.midhun.crmpro.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1, description = "Validate login page title")
	public void validateLoginPageTitleTest() {

		String loginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "CRMPRO  - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2, description = "Validate CRMPRO logo")
	public void crmproLogoTest() {

		boolean flag = loginPage.validateCRMPROLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3, description = "Validate login")
	public void loginTest() {

		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		driver.quit();
	}
}