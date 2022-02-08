package com.practice.qa.utils;

import java.text.DecimalFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	WebDriver driver;

	public Utility(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @param element
	 */
	public void waitForElement(WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param element
	 */
	public void mouseHover(WebElement element) {

		try {
			Actions action = new Actions(driver);
			waitForElement(element);
			action.moveToElement(element).perform();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param element
	 */
	public void mouseHoverAndClick(WebElement element) {

		try {
			Actions action = new Actions(driver);
			waitForElement(element);
			action.moveToElement(element).click().build().perform();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param parentCategory
	 * @param subCategory
	 */
	public void mouseHoverAndClick(WebElement parentCategory, WebElement subCategory) {

		try {
			Actions action = new Actions(driver);
			waitForElement(parentCategory);
			action.moveToElement(parentCategory).build();
			action.moveToElement(subCategory).click().build().perform();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param unitPrice
	 * @param quantity
	 * @return
	 */
	public double calculateTotal(double unitPrice, int quantity) {
		double total = 0;
		try {
			total = Double.parseDouble(new DecimalFormat("##.##").format(unitPrice*quantity));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

}
