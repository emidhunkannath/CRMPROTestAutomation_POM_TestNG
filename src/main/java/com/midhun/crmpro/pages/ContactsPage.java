package com.midhun.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.midhun.crmpro.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(how = How.XPATH, using = "//td[contains(text(), 'Contacts')]")
	WebElement lblContacts;

	public ContactsPage() {

		PageFactory.initElements(driver, this);
	}

	public boolean validateContactsLabel() {

		return lblContacts.isDisplayed();
	}

	public void selectContactByName(String name) {

		driver.findElement(By.xpath("//a[text()='" + name + "']/../preceding-sibling::td")).click();
		try {

			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}