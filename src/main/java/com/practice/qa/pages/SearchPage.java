package com.practice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.qa.base.TestBase;

/**
 * @author adity
 *
 */
public class SearchPage extends TestBase {
	
	// Page Factory

		@FindBy(xpath = "//div[@id='center_column']/ul[@class='product_list grid row']/li")
		WebElement searchResult;
	
		// Initializing the Page Objects
		public SearchPage() {
			PageFactory.initElements(driver, this);
		}

		/**
		 * @param searchCriteria
		 * @return
		 */
		public String getSearchResult(String searchCriteria)
		{
			String productTitle = "";
			try {
				productTitle = searchResult.findElement(By.tagName("h5")).getText();
				System.out.println(productTitle);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return productTitle;
			
		}
}
