package com.qa.testbase;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.pages.AmazonPages;

//import com.qa.google.GooglePages;

import com.qa.pages.WynkPages;

public class TestBase {
	protected WebDriver driver;

	protected AmazonPages AmazonOR;

	protected WynkPages WynkOR;

	// AmazonCountryPage Cpage;
	// CityBankPages cBank;
	SoftAssert SAssert;

	@Parameters({ "Browser", "Url" })
	@BeforeClass
	public void setUp(String Browser, String Url) {

		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (Browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\selenium\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		AmazonOR = new AmazonPages(driver);

		WynkOR = new WynkPages(driver);

		driver.get(Url);
		// driver.get("https://www.online.citibank.co.in/");
		SAssert = new SoftAssert();

	}

	@AfterClass
	public void tearDown() {

		driver.close();
		// driver.quit();

	}

}
