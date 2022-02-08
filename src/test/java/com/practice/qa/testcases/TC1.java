package com.practice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.qa.base.TestBase;
import com.practice.qa.pages.LandingPage;
import com.practice.qa.pages.SearchPage;

public class TC1 extends TestBase {

	LandingPage landingPage;
	SearchPage searchPage;

	@BeforeMethod
	public void setup() {
		initialize();
		landingPage = new LandingPage();
	}

	@Test
	public void navigateAndSearch() {
		String expectedOutcome = "";
		String searchCriteria = "Blouse";
		
		navigateToUrl();
		searchPage = landingPage.searchProduct(searchCriteria);
		expectedOutcome = searchPage.getSearchResult(searchCriteria);
		Assert.assertEquals(expectedOutcome, searchCriteria, "Verifying First Result Matches the Search Criteria");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
