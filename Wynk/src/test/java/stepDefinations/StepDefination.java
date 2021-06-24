package stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import com.qa.pages.AmazonPages;
import com.qa.testbase.TestBase;

@RunWith(Cucumber.class)
public class StepDefination extends TestBase {
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@When("^User login into application with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_login_into_application_with_username_something_and_password_something(String strArg1,
			String strArg2) throws Throwable {
		AmazonOR.getApemail().sendKeys(strArg1);
		AmazonOR.getcontinueBtn().click();
		AmazonOR.getApppassword().sendKeys(strArg2);
		AmazonOR.getAppSignin().click();
	}

	@Then("^Search for the products by (.+) and (.+)$")
	public void search_for_the_products_by_and(String category, String product) throws Throwable {
		AmazonOR.getCategotyField(category);
		AmazonOR.getAmazonSearchBox().clear();
		Thread.sleep(1000);
		AmazonOR.getAmazonSearchBox().sendKeys(product);
		AmazonOR.getSearchButton().click();
	}

	@And("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);
	}

	@And("^Click on the login link to land on secure login page$")
	public void click_on_the_login_link_to_land_on_secure_login_page() throws Throwable {
		AmazonOR = new AmazonPages(driver);
		AmazonOR.getSigninLink().click();
	}

	@And("^fetch all the items with price$")
	public void fetch_all_the_items_with_price() throws Throwable {
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");
		List<WebElement> resultList = AmazonOR.getItems();
		List<WebElement> priceList = AmazonOR.getPrice();
		for (int i = 0; i < resultList.size(); i++) {
			Reporter.log(resultList.get(i).getText(), true);
			Reporter.log(priceList.get(i).getText(), true);
		}

	}

	@And("^Close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();

	}

}
