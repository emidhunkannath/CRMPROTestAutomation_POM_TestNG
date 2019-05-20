package com.midhun.crmpro.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.midhun.crmpro.base.TestBase;
import com.midhun.crmpro.pages.ContactsPage;
import com.midhun.crmpro.pages.LoginPage;

public class ContactsPageTest extends TestBase {

	ContactsPage contactsPage;

	@BeforeMethod
	public void setUp() {

		initialization();
		contactsPage = new LoginPage().login(prop.getProperty("username"), prop.getProperty("password")).clickOnContactsLink();
	}

	@Test(priority = 1, description = "Validate Contacts label")
	public void validateContactsLabelTest() {

		Assert.assertTrue(contactsPage.validateContactsLabel(), "Contacts label is not displayed");
	}

	@Test(priority = 2, description = "User select single contact")
	public void selectSingleContactTest() {

		contactsPage.selectContactByName("Midhun Kannath");
	}

	@Test(priority = 3, description = "User select multiple contacts")
	public void selectMultipleContactsTest() {

		contactsPage.selectContactByName("Midhun Kannath");
		contactsPage.selectContactByName("Harisankar Pariyarath");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		driver.quit();
	}
}