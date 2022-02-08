package com.practice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.qa.base.TestBase;
import com.practice.qa.utils.Utility;

/**
 * @author adity
 *
 */
public class LoginPage extends TestBase {
	
	//Page Factory
	
	@FindBy(xpath="//a[contains(@title,'Log in')]")
	WebElement signInLink;
	
	@FindBy(id="email")
	WebElement userNameField;
	
	@FindBy(id="passwd")
	WebElement passwordField;
	
	@FindBy(id="SubmitLogin")
	WebElement signInButton;
	
	// Initializing the Page Objects
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
	}

	// Actions
	
	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	public AccountPage Login(String userName, String password) {
		try {
			signInLink.click();
			new Utility(driver).waitForElement(signInButton);
			userNameField.sendKeys(userName);
			passwordField.sendKeys(password);
			signInButton.click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AccountPage();
	}
}
