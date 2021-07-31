package com.Demoproject.Tests;

import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Demoproject.Pages.GoogleHomePage;
import com.Demoproject.Utility.ExcelUtils;
import com.DempProject.Base.Tester;

public class SearchTest {
	public WebDriver driver;
	@BeforeClass(groups= {"smoke","regression"})
	public void beforeClass() {
		try {
			ExcelUtils.getExcelData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

	@BeforeMethod(groups= {"smoke","regression"})
	public void setup() throws IOException {
		Tester tester = new Tester();
		driver=tester.getDriver();
	}

	@DataProvider(name="data-provider")
	public Object[][] dpMethod(){
		Object[][] myArray = new Object[ExcelUtils.datalist.size()][1];
		int i=0;
		for (Map<String,String> m : ExcelUtils.datalist) {
			myArray[i][0]=m;
			i++;}
		return myArray;

	}

	@Test(dataProvider="data-provider",groups= {"regression"})
	public void googleSearchTest_1(Map<String,String> map) {
		driver.get(map.get("URL"));	
		GoogleHomePage hp = new GoogleHomePage(driver);
		hp.SearchContent(map.get("SearchContent"))
		.validateExpectedContent(map.get("ExpectedContent"));
	}

	@Test(dataProvider="data-provider",groups= {"smoke"})
	public void googleSearchTest_2(Map<String,String> map) {
		driver.get(map.get("URL"));
		GoogleHomePage hp = new GoogleHomePage(driver);
		hp.SearchContent(map.get("SearchContent"))
		.validateExpectedContent(map.get("ExpectedContent"));
	}

	@AfterMethod(groups= {"smoke","regression"})
	public void teardwn() {
		driver.quit();
	}

}
