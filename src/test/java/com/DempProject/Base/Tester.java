package com.DempProject.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Tester {

	public static Properties property;
	public static WebDriver driver;


	public WebDriver getDriver() throws IOException {
		FileInputStream fp = new FileInputStream("src/test/java/com/Demoproject/Config/Config.properties");
		property = new Properties();
		property.load(fp);
		String browserName = property.getProperty("browser");

		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

}
