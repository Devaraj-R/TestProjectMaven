/*package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPages {
	WebDriver driver;

	public Select getCategoryList() {
		return new Select(driver
				.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[1]/div/div/select")));
	}

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement searchItem;

	public WebElement getSearchItem() {
		return searchItem;
	}

	@FindAll(@FindBy(xpath = "//span[@class='a-price-whole']"))
	List<WebElement> price;

	public List<WebElement> getPrice() {
		return price;
	}

	@FindBy(xpath = "//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[1]")
	WebElement NoOfBooks;

	public WebElement getNoOfBooks() {
		return NoOfBooks;
		
	}
	@FindAll(@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']"))
	List<WebElement> title;
	
	public List<WebElement> getTitle() {
		return title;
	}
	@FindAll(@FindBy(xpath="//span[contains(text(),'The Da VinciCode)]"))
	List<WebElement> bookTitles;
	
	public List<WebElement> getBookTitles() {
		return bookTitles;
	}
	@FindBy(xpath="/html/body/div[1]/div/div/div[1]/div/div[2]/div/section/div/div[2]/div[2]/form/div[2]")
	WebElement searchBtn;

	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public AmazonPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}*/
package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPages {
	WebDriver driver;

	@FindBy(name = "url")
	WebElement category;

	public void getCategotyField(String item) {
		Select s = new Select(category);
		s.selectByVisibleText(item);

	}

	@FindBy(id = "nav-link-accountList")
	WebElement SigninLink;

	public WebElement getSigninLink() {

		return SigninLink;
	}

	@FindBy(id = "ap_email")
	WebElement Apemail;

	public WebElement getApemail() {

		return Apemail;
	}

	@FindBy(id = "continue")
	WebElement continueBtn;

	public WebElement getcontinueBtn() {

		return continueBtn;
	}

	@FindBy(id = "signInSubmit")
	WebElement AppSignin;

	public WebElement getAppSignin() {

		return AppSignin;
	}

	@FindBy(id = "ap_password")
	WebElement Apppassword;

	public WebElement getApppassword() {

		return Apppassword;
	}

	@FindBy(id = "twotabsearchtextbox")
	WebElement AmazonSearchBox;

	public WebElement getAmazonSearchBox() {

		return AmazonSearchBox;
	}

	@FindBy(id = "nav-search-submit-button")
	WebElement SearchButton;

	public WebElement getSearchButton() {

		return SearchButton;
	}

	@FindAll(@FindBy(xpath = "//a[@class='a-link-normal a-text-normal']"))
	List<WebElement> Items;

	public List<WebElement> getItems() {

		return Items;
	}

	@FindAll(@FindBy(xpath = "//span[@data-a-color='price']"))
	List<WebElement> priceList;

	public List<WebElement> getPrice() {

		return priceList;
	}

	@FindAll(@FindBy(xpath = "//body[1]/div[1]/div[5]/div[4]/ul/li/a"))
	List<WebElement> countryList;

	public List<WebElement> getCountryList() {
		return countryList;
	}

	public AmazonPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 * WebDriver driver;
	 * 
	 * @FindBy(xpath="//select[@id='searchDropdownBox']") WebElement SearchDropDown;
	 * 
	 * 
	 * @FindBy(xpath="//input[@id='twotabsearchtextbox']") WebElement searchBox;
	 * 
	 * @FindAll(@FindBy(xpath="//a[@class='a-link-normal a-text-normal']")) List
	 * <WebElement> ItemList;
	 * 
	 * @FindAll(@FindBy(className="a-price-whole")) List <WebElement> PriceList;
	 * 
	 * public AmazonPages(WebDriver driver) { this.driver = driver;
	 * PageFactory.initElements(driver, this);
	 * 
	 * }
	 * 
	 * public WebElement getSearchDropDown() { return SearchDropDown; }
	 * 
	 * public WebElement getSearchBox() { return searchBox; }
	 * 
	 * public List <WebElement> getItemList() { return ItemList; }
	 * 
	 * public List <WebElement> getPriceList() { return PriceList; }
	 * 
	 */

}
