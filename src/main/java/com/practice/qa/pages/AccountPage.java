package com.practice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.qa.base.TestBase;
import com.practice.qa.utils.Utility;

/**
 * @author adity
 *
 */
public class AccountPage extends TestBase {

	// Page Factory

	@FindBy(xpath = "//span[text()='My account']")
	WebElement myAccountBreadCrum;

	@FindBy(xpath = "//a[@title='Log me out']")
	WebElement signOutLink;

	@FindBy(xpath = "//a[@title='Add to cart']")
	WebElement addToCartButton;

	@FindBy(xpath = "//div[@id='center_column']/ul[@class='product_list grid row']/li")
	WebElement firstProduct;

	@FindBy(className = "clearfix")
	WebElement popUp;

	@FindBy(xpath = "//span[@title='Close window']")
	WebElement closePopUp;

	@FindBy(xpath = "//a[@title='View my shopping cart']")
	WebElement viewCart;
	
	@FindBy(xpath = "//div[@id='block_top_menu']/ul")
	WebElement categoryBreadCrum;
	
	@FindBy(xpath = "//h1[@class='page-heading product-listing']/span")
	WebElement pageHeading;
	
	

	Utility util;
	WebElement element;

	// Initializing the Page Objects

	public AccountPage() {
		PageFactory.initElements(driver, this);
		util = new Utility(driver);

	}

	// Actions

	/**
	 * @return
	 */
	public boolean verifyMyAccount() {
		boolean isPresent = false;
		try {
			util.waitForElement(myAccountBreadCrum);
			isPresent = myAccountBreadCrum.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isPresent;
	}

	/**
	 * Method to click on the category
	 * @param categoryName
	 * @return
	 */
	public String clickCategory(String categoryName) {
		String productName = "";
		try {
			element = categoryBreadCrum.findElement(By.xpath("li/a[@title='" +categoryName + "']"));
			switch (categoryName.toLowerCase()) {
			case "women":
				util.mouseHoverAndClick(element);
				break;
			case "dresses":
				util.mouseHoverAndClick(element);
				break;
			case "t-shirts":
				util.mouseHoverAndClick(element);
				break;

			default:
				break;
			}
			productName = firstProduct.findElement(By.xpath("//h5/a")).getText();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return productName;
	}

	/**
	 * Method to add product to cart
	 * @param productTitle
	 */
	public void addToCart(String productTitle) {
		WebElement productElement;

		try {
			productElement = firstProduct.findElement(By.xpath("//h5/a[@title='" + productTitle + "']"));
			util.mouseHover(productElement);
			addToCartButton.click();
			util.waitForElement(popUp);
			closePopUp.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to navigate cart
	 * @return
	 */
	public ShoppingCart viewCart() {

		try {
			viewCart.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ShoppingCart();
	}
	
	/**
	 * Method to navigate to category and sub category
	 * @param parentCategory
	 * @param subCategory
	 */
	public void navigateToCategory(String parentCategory, String subCategory) {
		WebElement subElement;
		try {
			element = categoryBreadCrum.findElement(By.xpath("li/a[@title='" +parentCategory + "']"));
			util.mouseHover(element);
			subElement = element.findElement(By.xpath("../ul[contains(@class,'submenu-container')]/li/a[@title='" +subCategory + "']"));
			util.mouseHoverAndClick(subElement);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Method to navigate to category
	 * @param categoryName
	 */
	public void navigateToCategory(String categoryName) {
		try {
			element = categoryBreadCrum.findElement(By.xpath("li/a[@title='" +categoryName + "']"));
			util.mouseHoverAndClick(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Method to get the page header
	 * @return
	 */
	public String getPageTitle() {
		String title = "";
		try {
			title = pageHeading.getText();
			System.out.println(title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return title.trim();
	}
	
}
