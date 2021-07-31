package com.DempProject.Base;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Demoproject.Utility.LoggerUtil;

public class TestBase {
	public WebDriver driver;
	WebDriverWait wait;

	public TestBase(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,40);
	}
	public static String getPathToSroreScreenshot(WebDriver driver, String ssName) throws IOException {
		String DName = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ss = (TakesScreenshot)driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		String destination_path = System.getProperty("user.dir")+"/Screenshots_Failure/"+ssName+"_"+DName+".png";
		File finaldestination = new File(destination_path);
		FileUtils.copyFile(source,finaldestination);
		return destination_path;
	}

	public boolean verifyifElementPresntOnPage(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		LoggerUtil.info("Element is Present!");
		return element.isDisplayed();

	}


}
