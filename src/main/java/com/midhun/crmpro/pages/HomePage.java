package com.midhun.crmpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.midhun.crmpro.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(how = How.XPATH, using = "//td[contains(text(), 'User: Midhun Kannath')]")
	WebElement lblUserName;

	//@FindBy(how = How.LINK_TEXT, using = "Contacts")
	@FindBy(how = How.XPATH, using = "//a[@title='Contacts']")
	WebElement lnkContacts;

	@FindBy(how = How.LINK_TEXT, using = "New Contact")
	WebElement lnkNewContact;

	@FindBy(how = How.LINK_TEXT, using = "Deals")
	WebElement lnkDeals;

	@FindBy(how = How.LINK_TEXT, using = "Tasks")
	WebElement lnkTasks;

	// Initializing the WebElements
	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle() {

		return driver.getTitle();
	}

	public boolean verifyLoggedInUserName() {

		testUtil.switchToFrame();
		return lblUserName.isDisplayed();
	}

	public ContactsPage clickOnContactsLink() {

		testUtil.switchToFrame();
		lnkContacts.click();
		try {

			Thread.sleep(15000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {

		lnkDeals.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {

		lnkTasks.click();
		return new TasksPage();
	}

	public NewContactPage clickOnNewContactLink() {

		testUtil.switchToFrame();
		Actions actions = new Actions(driver);
		actions.moveToElement(lnkContacts).perform();
		lnkNewContact.click();
		return new NewContactPage();
	}
}