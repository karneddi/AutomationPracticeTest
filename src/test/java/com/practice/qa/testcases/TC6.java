package com.practice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.qa.base.TestBase;
import com.practice.qa.pages.AccountPage;
import com.practice.qa.pages.LoginPage;

public class TC6 extends TestBase {

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
		
		navigateToUrl();
		accountPage = login.Login(userName, password);
		accountPage.navigateToCategory("T-shirts");
		Assert.assertEquals(accountPage.getPageTitle(), "T-SHIRTS", "Verifying T-shirts page is loaded");
		accountPage.navigateToCategory("Dresses", "Casual Dresses");
		Assert.assertEquals(accountPage.getPageTitle(), "CASUAL DRESSES", "Verifying Casual Dresses page is loaded");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
