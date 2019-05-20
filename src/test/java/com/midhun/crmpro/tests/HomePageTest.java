package com.midhun.crmpro.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.midhun.crmpro.base.TestBase;
import com.midhun.crmpro.pages.HomePage;
import com.midhun.crmpro.pages.LoginPage;

public class HomePageTest extends TestBase {

	HomePage homePage;

	@BeforeMethod
	public void setUp() {

		initialization();
		homePage = new LoginPage().login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1, description = "Validate home page title")
	public void validateHomePageTitleTest() {

		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title mismatch");
	}

	@Test(priority = 2, description = "Validate logged in username")
	public void validateLoggedInUserNameTest() {

		Assert.assertTrue(homePage.verifyLoggedInUserName(), "Logged in user name is not displayed/incorrect");
	}

	@Test(priority = 3, description = "Validate Contacts link")
	public void validateContactsLink() {

		homePage.clickOnContactsLink();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		driver.quit();
	}
}