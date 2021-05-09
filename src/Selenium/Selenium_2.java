package Selenium;

import java.io.File;
import java.sql.Driver;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Selenium_2 {

	
	
	public static void main(String[] args) {
		
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "Driver" + File.separator + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Step 1: Open Browser, maximize window"); //print out the text to console log
		
		String url = "https://rahulshettyacademy.com/angularpractice/"; //string for reuse
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		
		System.out.println("Step 2: Go to url and waiting for the page to fully loaded");
		
		WebElement elename;
		elename = driver.findElement(By.xpath("//input[@name='name']"));
		String name = "abc";
		elename.sendKeys(name);
		
		System.out.println("Step 3: input text into name text box");
		
		WebElement elemail = driver.findElement(By.xpath("//input[@name='email']"));
		Random ran = new Random(); //random characters
		int num = ran.nextInt(); //create 1 random number
		
		String email = "abc+" + num + "@gmail.com";
		
		elemail.sendKeys(email);
		
		System.out.println("Step 4: input valid email into email text box");
		
		WebElement elepass;
		elepass = driver.findElement(By.xpath("//*[@id='exampleInputPassword1']"));
		String passwd = "123456";
		elepass.sendKeys(passwd);
		
		WebElement elechk;
		elechk = driver.findElement(By.xpath("//*[@id='exampleCheck1']"));
		elechk.click();
		/*Boolean flagcheckbox = elechk.isSelected(); //return boolean value for check box true is checked, false is not checked
		//action compare and check the checkbox
		if (flagcheckbox == false) {
			elechk.click();
		}*/
		
		System.out.println("Step 5: input password into password text box, check to checkbox below password field");
		
		WebElement elegender;
		elegender = driver.findElement(By.xpath("//*[@id='exampleFormControlSelect1']"));
		Select dropgender = new Select(elegender);
		dropgender.selectByVisibleText("Female");
		
		System.out.println("Step 5.1: Select Gender is Female");
		
		WebElement elestatus;
		elestatus = driver.findElement(By.xpath("//*[@id='inlineRadio2']"));
		elestatus.click();
		
		System.out.println("Step 6: Select Employed on Status checkbox");
		
		WebElement elebirth;
		elebirth = driver.findElement(By.xpath("//input[@name='bday']"));
		String date = "03/12/1998";
		elebirth.sendKeys(date);
		
		System.out.println("Step 7: input date of birth");
		
		WebElement elesubmit;
		elesubmit = driver.findElement(By.xpath("//input[@type='submit']"));
		elesubmit.click();
		
		System.out.println("Step 8: Click to Submit button");
		
		WebElement elealert;
		elealert = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		String alertact = elealert.getText(); //get string from current element
		alertact = alertact.replace("\r",""); //replace separate line
		alertact = alertact.replace("\n", ""); 
		alertact = alertact.substring(1, alertact.length());
		
		String alertexp = "Success! The Form has been submitted successfully!.";
		
		Assert.assertEquals(alertact, alertexp);
		
		System.out.println("Step 9: Verify the text when submit form successfully");
		
		
		
		
		
		
		
		
		
		
		
		driver.close();
		
		
		
	}
}
