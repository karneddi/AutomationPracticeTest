package com.practice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.CharMatcher;
import com.practice.qa.base.TestBase;
import com.practice.qa.utils.Utility;

/**
 * @author adity
 *
 */
public class ShoppingCart extends TestBase {

	// Page Factory

	@FindBy(xpath = "//span[@class='price']")
	WebElement unitPriceValue;

	@FindBy(id = "passwd")
	WebElement passwordField;

	@FindBy(id = "SubmitLogin")
	WebElement signInButton;

	@FindBy(xpath = "//table[@id='cart_summary']//td[@class='cart_description']")
	WebElement cartTable;

	
	Utility util;
	
	// Initializing the Page Objects

	public ShoppingCart() {
		PageFactory.initElements(driver, this);
		util = new Utility(driver);

	}

	// Actions
	
	
	/**
	 * @param productName
	 * @param quantity
	 */
	public void editQuantity(String productName, int quantity) {
		WebElement cartQuantity;
		try {
			cartQuantity = cartTable.findElement(By.xpath("p/a[text()='" + productName
					+ "']/../../following-sibling::td[contains(@class,'cart_quantity')]/input[@class='cart_quantity_input form-control grey']"));
			cartQuantity.clear();
			cartQuantity.click();
			cartQuantity.sendKeys(String.valueOf(quantity));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param productName
	 * @param quantity
	 * @return
	 */
	public double calculateAndVerifyTotal(String productName, int quantity) {
		WebElement cartUnit;
		double price = 0;
		double calculatedPrice = 0;
		try {
			cartUnit = cartTable.findElement(By
					.xpath("p/a[text()='" + productName + "']/../../following-sibling::td[@class='cart_unit']/span"));
			cartUnit.click();
			price = Double.parseDouble(CharMatcher.is('$').removeFrom(cartUnit.getText()));
			calculatedPrice = util.calculateTotal(price, quantity);
			System.out.println(calculatedPrice);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return calculatedPrice;
	}

	/**
	 * @param productName
	 * @return
	 */
	public double getActualTotal(String productName) {
		WebElement cartTotal;
		double actualPrice = 0;
		try {
			Thread.sleep(3000); // Added thread.sleep because there is some delay on UI during calculation
			cartTotal = cartTable.findElement(By
					.xpath("p/a[text()='" + productName + "']/../../following-sibling::td[@class='cart_total']/span"));
			 actualPrice = Double.parseDouble(CharMatcher.is('$').removeFrom(cartTotal.getText()));
			 System.out.println(actualPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actualPrice;
	}

}
