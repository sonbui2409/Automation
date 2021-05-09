package Selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {

	
	public static void main(String[] args) {
	
	//webdriver to call browser
		WebDriver driver;
	//path to driver to open browser	
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "Driver" + File.separator + "geckodriver.exe");
	//variable to open browser	
		driver = new FirefoxDriver();
	//open a link page
		driver.navigate().to("http://demo.guru99.com/v4/");
	
	//maximize or minimize window, can use fullscreen	
		driver.manage().window().maximize();
	//wait for the browser to load all element
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		
	//find element
		WebElement eleuserid;
		eleuserid = driver.findElement(By.xpath("//input[@name=\"uid\"]"));
		eleuserid.sendKeys("mngr313511");
		WebElement elepass;
		elepass = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		WebElement elelogin;
		elelogin = driver.findElement(By.xpath("//input[@name=\"btnLogin\"]"));
		
	//input data
		eleuserid.sendKeys("mngr313511");
		elepass.sendKeys("ebuneqU");
		elelogin.click();
		
			
		
		
		
		
	}
}
