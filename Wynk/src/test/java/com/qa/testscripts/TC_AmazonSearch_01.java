
/*package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.testbase.TestBase;
import com.qa.utility.ExcelUtility;




public class TC_AmazonSearch_01 extends TestBase {

	@Test(dataProvider = "getData")
	public void searchItemsInAmazon(String type, String item) throws InterruptedException {
		AmazonOR.getSearchItem().clear();
		AmazonOR.getCategoryList().selectByVisibleText(type);
		AmazonOR.getSearchItem().sendKeys(item);
		AmazonOR.getSearchBtn().click();
		Thread.sleep(2000);
		if (driver.getCurrentUrl().contains(item)) {
			for (int i = 0; i < AmazonOR.getTitle().size(); i++) {
				System.out.println(AmazonOR.getTitle().get(i).getText() + ":  ");
				System.out.println("Rs: " + AmazonOR.getPrice().get(i).getText());

			//}
		System.out.println("jsnssjsaa");
		}
		}
		
		String pagesearch = driver.getCurrentUrl();

	       List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));
	       System.out.println(findElements.size());

	       for(int i=0;i<findElements.size();i++){
	           findElements= driver.findElements(By.xpath("//*[@id='rso']//h3/a"));                
	           findElements.get(i).click(); 

	           driver.navigate().to(pagesearch);
	           JavascriptExecutor jse = (JavascriptExecutor) driver;
	           //Scroll vertically downward by 250 pixels
	           jse.executeScript("window.scrollBy(0,250)", "");
	       }

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "Books";
		data[0][1] = "DaVinciCode";
		data[1][0] = "Electronics";
		data[1][1] = "MobilePhone";
		data[2][0] = "Furniture";
		data[2][1] = "WoodenFurniture";
		return data;

	}
	
	@DataProvider
	public String [][]getData()throws IOException{
		String xlPath="G:\\Virtusa\\TestData.xlsx";
		String xlSheet="Sheet1";
		int rowCount= ExcelUtility.getRowCount(xlPath,xlSheet);
		int cellCount = ExcelUtility.getCellCount(xlPath,xlSheet,rowCount);
		String[][] data = new String[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++) {
				data[i-1][j]= ExcelUtility.getCellData(xlPath,xlSheet,i,j);
				
			}
		}
		
		return data;
		
	}


}*/

package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import com.qa.testbase.TestBase;
import com.qa.utility.ExcelUtility;

public class TC_AmazonSearch_01 extends TestBase {

	@Test(dataProvider = "supplyData")
	public void searchItem(String Input1,String Input2) throws InterruptedException {
		
		AmazonOR.getCategotyField(Input1);		
		AmazonOR.getAmazonSearchBox().clear();
		Thread.sleep(1000);
		AmazonOR.getAmazonSearchBox().sendKeys(Input2);
		AmazonOR.getSearchButton().click();
//		Reporter.log(driver.getTitle(),true);
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		
		List<WebElement> resultList = AmazonOR.getItems();
		List<WebElement> priceList = AmazonOR.getPrice();
		
		for (int i = 0; i < resultList.size(); i++) {
			Reporter.log(resultList.get(i).getText(), true);
			Reporter.log(priceList.get(i).getText(), true);
		}
		System.out.println("********************************************************************");
		/*int count = resultList.size();
		System.out.println("Size : "+count);
		for (WebElement ele : resultList) {
			Reporter.log(ele.getText(),true);
		}*/
		/*for (WebElement ele1 : priceList) {
			Reporter.log(ele1.getText(),true);
		}*/
		
	}
	/*@DataProvider
	public String[][] supplyData(){
		String[][] data = new String[3][2];
		data[0][0]="Books";
		data[0][1]="harry potor";
		data[1][0]="Furniture";
		data[1][1]="wooden";
		data[2][0]="Electronics";
		data[2][1]="mobiles";
		
		return data;
		
	}*/

	@DataProvider
	public String[][] supplyData() throws IOException{
		String xlPath="G:\\Virtusa\\TestData.xlsx";
		
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
	/*@Test(dataProvider = "getData", priority = 1)
	public void AmazonSearch(String input1, String input2) throws InterruptedException {
		
		Select sel = new Select(AmazonOR.getSearchDropDown());
		sel.selectByVisibleText(input1);
		
		AmazonOR.getSearchBox().sendKeys(input2);
		AmazonOR.getSearchBox().submit();
		Thread.sleep(3000);

		List<WebElement> itemlists = AmazonOR.getItemList();
		for (WebElement ele : itemlists) {
			Reporter.log(ele.getText(), true);

		}
		List<WebElement> pricelist = AmazonOR.getPriceList();
		for (WebElement ele : pricelist) {
			Reporter.log(ele.getText(), true);
		}
		AmazonOR.getSearchDropDown().clear();

	}
	@DataProvider
	public String [][]getData()throws IOException{
		String xlPath="G:\\Virtusa\\TestData.xlsx";
		String xlSheet="Sheet1";
		int rowCount= ExcelUtility.getRowCount(xlPath,xlSheet);
		int cellCount = ExcelUtility.getCellCount(xlPath,xlSheet,rowCount);
		String[][] data = new String[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++) {
				data[i-1][j]= ExcelUtility.getCellData(xlPath,xlSheet,i,j);
				
			}
		}
		
		return data;
		
	}*/
	


