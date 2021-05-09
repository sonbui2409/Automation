package Selenium;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_driver {
	static WebDriver driver;
	@BeforeTest
	@Parameters({ "browser" }) //use for find parameter and run based on if else command

	public void driver_open(String browser) {
		browser = browser.toLowerCase(); //to all browser data to lower case
	  if (browser.equalsIgnoreCase("Chrome")) {
		  System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "Driver" + File.separator + "chromedriver.exe");
			driver = new ChromeDriver();
	} 
	  else if (browser.equalsIgnoreCase("Firefox")){
		  System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + File.separator + "Driver" + File.separator + "geckodriver.exe");
			driver = new FirefoxDriver();
	  }
		
		driver.manage().window().maximize();		
  }
	@AfterTest
	public void driver_quit() {
		driver.close();
		
	}
}
