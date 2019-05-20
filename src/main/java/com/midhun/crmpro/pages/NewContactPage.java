package com.midhun.crmpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.midhun.crmpro.base.TestBase;

public class NewContactPage extends TestBase {

	@FindBy(how = How.NAME, using = "title")
	WebElement ddlTitle;

	@FindBy(how = How.ID, using = "first_name")
	WebElement txtFirstName;

	@FindBy(how = How.ID, using = "surname")
	WebElement txtLastName;

	@FindBy(how = How.NAME, using = "client_lookup")
	WebElement txtCompany;

	@FindBy(how = How.XPATH, using = "//input[@value='Save']")
	WebElement btnSave;

	public NewContactPage() {

		PageFactory.initElements(driver, this);
	}

	public void createNewContact(String title, String firstName, String lastName, String company) {

		Select select = new Select(ddlTitle);
		select.selectByVisibleText(title);
		txtFirstName.sendKeys(firstName);
		txtLastName.sendKeys(lastName);
		txtCompany.sendKeys(company);
		btnSave.click();
	}
}