package com.practice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.qa.base.TestBase;
import com.practice.qa.pages.AccountPage;
import com.practice.qa.pages.LoginPage;

public class TC4 extends TestBase {

	LoginPage login;
	AccountPage accountPage;

	@BeforeMethod
	public void setup() {
		initialize();
		login = new LoginPage();
	}

	@Test
	public void navigateAndSearch() {
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		boolean result = false;
		
		navigateToUrl();
		accountPage = login.Login(userName, password);
		result = accountPage.verifyMyAccount();
		Assert.assertTrue(result);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
