package com.practice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.qa.base.TestBase;

/**
 * @author adity
 *
 */
public class LandingPage extends TestBase {

	// Page Factory

	@FindBy(id = "search_query_top")
	WebElement searchField;

	@FindBy(name = "submit_search")
	WebElement searchButton;

	// Initializing the Page Objects
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	/**
	 * @param searchCriteria
	 * @return
	 */
	public SearchPage searchProduct(String searchCriteria) {
		try {
			searchField.clear();
			searchField.sendKeys(searchCriteria);
			searchButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SearchPage();
	}


}
