package com.practice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.qa.base.TestBase;
import com.practice.qa.pages.AccountPage;
import com.practice.qa.pages.LoginPage;
import com.practice.qa.pages.ShoppingCart;

public class TC5 extends TestBase {

	LoginPage login;
	AccountPage accountPage;
	ShoppingCart shoppingCart;

	@BeforeMethod
	public void setup() {
		initialize();
		login = new LoginPage();
	}

	@Test
	public void addtoCartAndVerifyTotal() {
		double expectedCost = 0;
		double actualCost = 0;
		String productName ="Faded Short Sleeve T-shirts";
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		navigateToUrl();
		accountPage = login.Login(userName, password);
		accountPage.clickCategory("T-shirts");
		accountPage.addToCart(productName);
		shoppingCart = accountPage.viewCart();
		shoppingCart.editQuantity(productName, 5);
		expectedCost = shoppingCart.calculateAndVerifyTotal(productName, 5);
		actualCost = shoppingCart.getActualTotal(productName);
		Assert.assertEquals(actualCost, expectedCost , "Verifying the actual cost and the expected cost");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
