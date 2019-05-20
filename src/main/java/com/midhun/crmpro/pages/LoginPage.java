package com.midhun.crmpro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.midhun.crmpro.base.TestBase;

public class LoginPage extends TestBase {

	// initializing the WebElements
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// Page Factory - OR
	@FindBy(how = How.NAME, using = "username")
	@CacheLookup
	WebElement txtUsername;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(how = How.XPATH, using = "//img[@src='https://d3lh3kd7bj2evy.cloudfront.net/img/logo.png']")
	@CacheLookup
	WebElement imgLogo;

	@FindBy(how = How.LINK_TEXT, using = "Sign Up")
	@CacheLookup
	WebElement lnkSignUp;

	// Actions
	public String validateLoginPageTitle() {

		return driver.getTitle();
	}

	public boolean validateCRMPROLogo() {

		return imgLogo.isDisplayed();
	}

	public HomePage login(String username, String password) {

		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
		try {

			Thread.sleep(15000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return new HomePage();
	}
}