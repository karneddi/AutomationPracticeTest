package com.practice.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.practice.qa.utils.Constants;

public class TestBase {

	public static WebDriver driver;
	public static Properties properties;

	public TestBase() {

		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/practice/qa/config/config.properties");
			properties.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void initialize() {
		String browserName = properties.getProperty("browser");
		try {
			switch (browserName.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToUrl() {
		try {
			driver.get(properties.getProperty("url"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


}
