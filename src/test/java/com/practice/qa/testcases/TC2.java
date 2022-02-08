package com.practice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.qa.base.TestBase;
import com.practice.qa.pages.LandingPage;
import com.practice.qa.pages.SearchPage;

public class TC2 extends TestBase {

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
		String searchCriteria = "Blouse,Faded Short Sleeve T-shirts,Printed Chiffon Dress";
		
		navigateToUrl();
		if (searchCriteria.contains(",")) {
			String[] products = searchCriteria.split(",");
			for (String p : products) {
				searchPage = landingPage.searchProduct(p);
				expectedOutcome = searchPage.getSearchResult(p);
				Assert.assertEquals(expectedOutcome, p,
						"Verifying First Result Matches the Search Criteria");
			}
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
