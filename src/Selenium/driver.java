package Selenium;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driver {

	static WebDriver driver;

	public static WebDriver driver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "Driver" + File.separator + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		return driver;
	}
}
