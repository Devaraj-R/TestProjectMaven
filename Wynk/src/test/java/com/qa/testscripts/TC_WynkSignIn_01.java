package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.testbase.TestBase;
import com.qa.utility.ExcelUtility;

public class TC_WynkSignIn_01 extends TestBase {

	@Test(dataProvider = "supplyData", priority = 1)
	public void WynkSignIn(String type) throws InterruptedException {
		WynkOR.getLanguage().click();
		List<WebElement> Langlist = WynkOR.getLanList();
		for (WebElement ele : Langlist) {
			Reporter.log(ele.getText(), true);
		}
		Thread.sleep(3000);
		WynkOR.getKannada().click();
		/*Thread.sleep(2000);*/
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		WynkOR.getSaveBtn().click();
		WynkOR.getSearchInPut().clear();
		WynkOR.getSearchInPut().sendKeys(type, Keys.ARROW_DOWN, Keys.ENTER);
		WynkOR.getSearchInPut().click();
		System.out.println("******************************************");
		/*List<WebElement> elements = driver.findElements(By.xpath("//input[@id='searchinput']"));

		System.out.println(elements.size());

		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase(type)) {
				element.click();
				break;
			}

		}*/

		WynkOR.getSearchInPut().click();
		Thread.sleep(2000);
		List<WebElement> Songlist = WynkOR.getSongList();
		for (WebElement ele1 : Songlist) {
			Reporter.log(ele1.getText(), true);
		}
		
	 //WynkOR.getFstSong().click();
	 //WynkOR.getPlaySong().click();
		 

		Thread.sleep(2000);
	}
	
	/*@DataProvider
	public String[][] supplyData(){
		String[][] data = new String[3][1];
		data[0][0]="Koti kanasugala";
		data[1][0]="Tum hi ho";
		data[2][0]="API Testing";
		
		return data;
		
	}*/

	@DataProvider
	public String[][] supplyData() throws IOException{
		String xlPath="G:\\Virtusa\\TestData1.xlsx";
		
		String xlSheet = "Sheet1";
		
		int rowCount =ExcelUtility.getRowCount(xlPath, xlSheet);
		
		int cellCount=ExcelUtility.getCellCount(xlPath, xlSheet, rowCount);
		
		String[][] data=new String[rowCount][cellCount];
		
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				data[i-1][j] = ExcelUtility.getCellData(xlPath, xlSheet, i, j);

			}
		}

		return data;
		
	}
}
