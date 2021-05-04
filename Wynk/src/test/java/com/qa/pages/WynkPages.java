package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WynkPages {
	WebDriver driver;

	@FindBy(name = "searchinput")
	WebElement SearchInPut;
	
	public WebElement getSearchInPut() {
		return SearchInPut;
	}
	
	
	@FindBy(xpath="//body/app-root[1]/app-home[1]/app-top-nav[1]/nav[1]/div[1]/div[2]/div[4]/img[1]")
	WebElement Language;
	

	public WebElement getLanguage() {
		return Language;
	}
	
	@FindBy(xpath="/html/body/ngb-modal-window/div/div/app-language/div/div[1]/div[14]/div")
	WebElement Kannada;


	public WebElement getKannada() {
		return Kannada;
	}
	
	@FindAll(@FindBy(xpath="//div[@class=\"row mb-3 mt-3\"]"))
	List<WebElement> LanList;
	public List<WebElement> getLanList() {

		return LanList;
	}
	
	@FindAll(@FindBy(xpath="//a[@class=\"dark-text-color w-100 float-left text-truncate\"]"))
	List<WebElement> SongList;
	public List<WebElement> getSongList() {

		return SongList;
	}
	@FindBy(xpath="/html/body/app-root/app-home/div[2]/div/app-search-result/div/div[1]/app-single-horizontal-rail/div/div[1]/a[2]")
	WebElement SeeAllBtn;
	
	
	public WebElement getSeeAllBtn() {
		return SeeAllBtn;
	}


	@FindBy(xpath="/html/body/ngb-modal-window/div/div/app-language/div/div[3]/button[2]")
	WebElement SaveBtn;
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	@FindBy(xpath="//a[contains(text(),'Kooti Kanasugala')]")
	WebElement FstSong;



	public WebElement getFstSong() {
		return FstSong;
	}
	
	@FindBy(xpath="//body/app-root[1]/app-home[1]/div[2]/div[1]/song-info[1]/div[1]/div[1]/div[3]/div[2]/div[1]/button[1]")
	WebElement PlaySong;



	public WebElement getPlaySong() {
		return PlaySong;
	}



	public WynkPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



}
