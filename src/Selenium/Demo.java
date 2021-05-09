package Selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo {

	static WebDriver driver;

	@BeforeTest
	@Parameters({ "browser" }) // use for find parameter and run based on if else command

	public void driver_open(String browser) {
		browser = browser.toLowerCase(); // to all browser data to lower case
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "Driver" + File.separator + "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
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
	/*
	 * public Demo(WebDriver Globdriver) { this.driver = Globdriver; }
	 */

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Test(priority=1)
	public static void demo_robot() {
		System.out.println("Step 1: Open Browser, maximize window");
		String mainurl = "https://encodable.com/uploaddemo/";
		driver.get(mainurl);

		System.out.println("Step 2: Go to the testing page");

		driver.findElement(By.xpath("//input[@type='file']/parent::div")).click();

		String copypath = System.getProperty("user.dir") + File.separator + "Upload" + File.separator
				+ "upload_01.jpeg";
		StringSelection ss = new StringSelection(copypath); // encode string
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); // copy path into clipboard
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			Robot rb = new Robot();
			// simulator CTRL + V and ENTER KEY as below
			rb.keyPress(KeyEvent.VK_CONTROL); // hold Control
			rb.keyPress(KeyEvent.VK_V); // Hold V
			rb.keyRelease(KeyEvent.VK_V); // Release Control
			rb.keyRelease(KeyEvent.VK_CONTROL); // Releave V
			rb.delay(3000); // wait for 3 seconds
			rb.keyPress(KeyEvent.VK_ENTER); // hold Enter key
			rb.keyRelease(KeyEvent.VK_ENTER); // release Enter key

		} catch (AWTException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("Step 3: Select a file to upload on File 1 of 2");

		WebElement uploadto = driver.findElement(By.xpath("//select[@name='subdir1']"));
		Select dropupload = new Select(uploadto);
		dropupload.selectByValue("/");
		System.out.println("Step 4: Select foler to Upload to");

		Random ran = new Random();
		String foldername = "Upload" + ran.nextInt();

		WebElement subfolder = driver.findElement(By.xpath("//input[@type='text']"));
		subfolder.sendKeys(foldername);

		System.out.println("Step 5: Create a new subfolder to upload file");

		driver.findElement(By.xpath("//input[@type='button']")).click();
		System.out.println("Step 6: Click to Begin Upload");

		try { // waiting for some seconds
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Step 7: Waiting for the upload progress is completed");

		WebElement upcomplete = driver.findElement(By.xpath("//dt[@class='first']"));
		String expupcomplete = "Your upload is complete:";
		Assert.assertEquals(upcomplete.getText(), expupcomplete);
		System.out.println("Step 8: Verify the upload is completed");

		WebElement viewfiles = driver.findElement(By.xpath("//a[contains(@href, 'listfiles')]"));
		viewfiles.click();
		System.out.println("Step 9: View upload files page");

		driver.findElement(By.xpath(String.format("//a[text() = '%s']", foldername))).click();
		System.out.println("Step 10: Open upload folder");

		WebElement uppic = driver.findElement(By.xpath("//a[contains(@id, 'upload_01')]"));
		String expfile = "upload 01.jpeg";
		Assert.assertEquals(uppic.getText(), expfile);
		System.out.println("Step 11: Compare upload file name");
	}

	
	@Test(priority=2)
	public void demo_javascript() {

		System.out.println("Step 1: Open Browser, maximize window");
		driver.get("http://the-internet.herokuapp.com/dynamic_controls");
		sleep();
		System.out.println("Step 2: Go to the testing page");

		JavascriptExecutor js = (JavascriptExecutor) driver; // change driver to javascript executor
		WebElement enablebut = driver.findElement(By.xpath("//form[@id = 'input-example']/button"));

		js.executeScript("arguments[0].click();", enablebut); // execute java script for click, arguments[0] will be run
																// first and get the first argo
		sleep();

		System.out.println("Step 3: Click to Enable button");

		WebElement enabletext = driver.findElement(By.xpath("//input[@type = 'text']"));
		String inputstr = "testing";

		js.executeScript("arguments[0].value=arguments[1]", enabletext, inputstr); // send text value into text box
		sleep();
		System.out.println("Step 4: input text into the text box");

		// String textcontent = js.executeScript("return arguments[0].innerText;",
		// enabletext).toString();

		// Assert.assertEquals(textcontent, inputstr);

		WebElement mess = driver.findElement(By.id("message"));

		String enablemess = js.executeScript("return arguments[0].innerText;", mess).toString(); // get text value of an
																									// element and set
																									// it to String
																									// element

		// System.out.println("Step 5: get text on the text box and compare with the
		// text input on step #4");
		System.out.println("Step 5: Print out the enable text = " + enablemess);
	}
	/*
	 * public static void main(String[] args) { demo_javascript(); driver.close(); }
	 */
}
