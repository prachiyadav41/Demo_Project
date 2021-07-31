package com.Demoproject.Pages;

import java.util.List;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Demoproject.Utility.LoggerUtil;
import com.DempProject.Base.TestBase;

public class GoogleHomePage extends TestBase{

	public WebDriver driver;

	@FindBy(name="q")
	WebElement SearchBar;

	@FindBy(xpath="//[text()='Google'")
	WebElement Title;

	@FindAll({
		@FindBy(xpath="//a//h3")
	})
	List<WebElement> links;

	public GoogleHomePage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public GoogleHomePage SearchContent(String SearchContent) {
		verifyifElementPresntOnPage(SearchBar);
		SearchBar.clear();
		SearchBar.sendKeys(SearchContent);
		SearchBar.submit();
		LoggerUtil.info("Searched Content on search engine page!");
		return this;
	}

	public GoogleHomePage validateExpectedContent(String ExpectedContent) {
		Assert.assertEquals(links.get(0).getText(), ExpectedContent, "First term is not displaying as expected");
		LoggerUtil.info("Validated first displayed term with expected!");
		return this;
	}


}
