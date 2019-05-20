package com.midhun.crmpro.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.midhun.crmpro.base.TestBase;
import com.midhun.crmpro.pages.LoginPage;
import com.midhun.crmpro.pages.NewContactPage;

public class NewContactPageTest extends TestBase {

	NewContactPage newContactPage;
	private static String sheetName = "Contacts";

	@DataProvider
	public Object[][] getTestData() {

		Object[][] data = testUtil.getTestData(sheetName);
		return data;
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		newContactPage = new LoginPage().login(prop.getProperty("username"), prop.getProperty("password")).clickOnNewContactLink();
	}

	@Test(priority = 1, dataProvider = "getTestData", description = "Create new contact")
	public void createNewContactTest(String title, String firstName, String lastName, String company) {

		newContactPage.createNewContact(title, firstName, lastName, company);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		driver.quit();
	}
}