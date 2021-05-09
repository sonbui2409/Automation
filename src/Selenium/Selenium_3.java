package Selenium;

import java.io.File;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sun.javafx.runtime.SystemProperties;

public class Selenium_3 {
	
	static  WebDriver driver;
	
	public static void driver_open() {
		System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "Driver" + File.separator + "chromedriver.exe");
			driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void driver_quit() {
		driver.close();

	}
	@Test
	public static void selenium_1() {
		//webdriver to call browser
				//WebDriver driver;
			//path to driver to open browser	
				//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "Driver" + File.separator + "geckodriver.exe");
			//variable to open browser	
				//driver = new FirefoxDriver();
			//open a link page
				//driver.navigate().to("http://demo.guru99.com/v4/");
			
			//maximize or minimize window, can use fullscreen	
				//driver.manage().window().maximize();
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

	public static void selenium_2() {
		
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
		
		
		//driver.close();
	}
	
	public static void selenium_3() {
	
		System.out.println("Step 1: Open Browser, maximize window");
		
		String url = "http://demo.guru99.com/v4/"; 
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		
		System.out.println("Step 2: go to the testing page");
		
		WebElement register = driver.findElement(By.xpath("//*[contains(text(),'here')]"));
		register.click();
		
		System.out.println("Step 3: Click to Visit - here");
		
		WebElement email = driver.findElement(By.xpath("//input[@name='emailid']"));
		Random ran = new Random();
		int num = ran.nextInt();
		String mail = "shin" + num + "@gmail.com";
		email.sendKeys(mail);
		WebElement submit = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		submit.click();
		
		System.out.println("Step 4: Enter an email name and click to submit button");
		
		WebElement uid = driver.findElement(By.xpath("//*[contains(text(),'User ID :')]/following-sibling::td"));
		String uidt = uid.getText();
		WebElement upass = driver.findElement(By.xpath("//*[contains(text(),'Password :')]/following-sibling::td"));
		String upasst = upass.getText();
		
		System.out.println("Step 5: Take note about new user name and password");
		
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		
		System.out.println("Step 6: go back to testing page");
		
		WebElement userid = driver.findElement(By.xpath("//input[@name='uid']"));
		userid.sendKeys(uidt);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(upasst);
		
		System.out.println("Step 7: enter previous userID and password of step #5");
		
		WebElement login = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		login.click();
		
		System.out.println("Step 8: Click to Login button");
		
		WebElement manid = driver.findElement(By.xpath("//tr[@class='heading3']"));
		String acttext = manid.getText();
		String exptext = "Manger Id : " + uidt;
		
		Assert.assertEquals(acttext, exptext);
		
		System.out.println("Step 9: Checking Manger ID");
		
		
		//driver.close();
	}

	public static void selenium_4_iframe_1() {
		
		System.out.println("Step 1: Open Browser, maximize window");
		
		String url = "https://demoqa.com/frames"; 
		driver.get(url);
		
		System.out.println("Step 2: go to the testing page");
		
		driver.switchTo().frame("frame2"); //switch to iframe by ID, can be use xpath but need to set element first
		WebElement iframe = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		
		System.out.println("Step 3: get the content of Iframe 2");
		System.out.println("The content will be as below: ");
		System.out.println(iframe.getText());
		
		//driver.close();
		
	}
	
	public static void selenium_4_iframe_2() {
		
		System.out.println("Step 1: Open Browser, maximize window");
		
		String url = "http://the-internet.herokuapp.com/iframe"; 
		driver.get(url);
		
		System.out.println("Step 2: go to the testing page");
		
		driver.switchTo().frame("mce_0_ifr"); //switch to iframe by ID, can be use xpath but need to set element first
		WebElement iframe = driver.findElement(By.xpath("//body[@id='tinymce']"));
		String content = "Hoc Automation.";
		iframe.clear();
		iframe.sendKeys(content);
		
		System.out.println("Step 3: Input content into Text box");
		System.out.println("The Content of textbox will be as below:");
		System.out.println(iframe.getText());
		
		//driver.close();
		
	}
	
	public static void selenium_4_iframe_3() {
		
		System.out.println("Step 1: Open Browser, maximize window");
		
		String url = "https://demoqa.com/nestedframes"; 
		driver.get(url);
		
		System.out.println("Step 2: go to the testing page");
		
		
		driver.switchTo().frame("frame1");
		
		WebElement cframe = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(cframe);
		
		WebElement cfcontent = driver.findElement(By.xpath("//body"));
		
		System.out.println("Step 3: get content of Child frame");
		System.out.println("===================================");
		System.out.println(cfcontent.getText());
		System.out.println("===================================");
		
		driver.switchTo().parentFrame(); //switch to parent frame from child frame, if switch to main screen should use driver.switchTo().defaultContent();
		
		WebElement pfcontent = driver.findElement(By.xpath("//body"));
		
		System.out.println("Step 4: get content of Parent frame");
		System.out.println("===================================");
		System.out.println(pfcontent.getText());
		System.out.println("===================================");
		
		
		//driver.close();
		
		
	}
	
	public static void selenium_5_window() {
		System.out.println("Step 1: Open Browser, maximize window");
		String mainurl = "http://live.guru99.com/index.php/";
		driver.get(mainurl);
		
		System.out.println("Step 2: Go to the testing page");
		
		WebElement mobi = driver.findElement(By.xpath("//li[@class = 'level0 nav-1 first']"));
		mobi.click();
		System.out.println("Step 3: Go to Mobile tab");
		
		
		String mobilewindow = driver.getWindowHandle(); //get current window ID and saved it as string
		
		String xpacombutton = "//a[@title='%s']/following-sibling::div//a[@class='link-compare']"; //set string changing following product name
		/* %s : String
		%d : int number : 5
		%f: float number: 5.5
		 */
		
		WebElement comsony = driver.findElement(By.xpath(String.format(xpacombutton, "Xperia"))); //set string format and provide input value.
		comsony.click();
		System.out.println("Step 4: Add Sony Xperia to compare list");
		
		WebElement comsam = driver.findElement(By.xpath(String.format(xpacombutton, "Samsung Galaxy")));
		comsam.click();
		System.out.println("Step 5: Add Samsung Galaxy to compare list");
		
		WebElement compare = driver.findElement(By.xpath("//div/button[@title = 'Compare']"));
		compare.click();
		System.out.println("Step 6: Click to Compare button");
		
		String compareurl = "http://live.demoguru99.com/index.php/catalog/product_compare/index/";
		
		Set <String> windows = driver.getWindowHandles(); //Set<String> = get a list of item as string format
		
		for (String winchange : windows) { //for fomular to create winchange element as string format on windows element list above.
			driver.switchTo().window(winchange); //switch to new window and loop as it is in for fomular.
			
			if (driver.getCurrentUrl().equalsIgnoreCase(compareurl)) { // if fomular to compare the current url on new window is match with expected.
			break; //exit for current for which break is in (same class)
			}
		}
		System.out.println("Step 7: Swith from current mobile window to compare window");
		
		WebElement comtitle = driver.findElement(By.xpath("//div[contains(@class, 'title-buttons')]/h1"));
		String exptitle = "COMPARE PRODUCTS";
		Assert.assertEquals(comtitle.getText(), exptitle);
		System.out.println("Step 8: Compare the title on the new window");
		
		driver.close();
		System.out.println("Step 9: Close the compare window");
		
		driver.switchTo().window(mobilewindow);
		String actualwindow = driver.getWindowHandle();
		Assert.assertEquals(actualwindow, mobilewindow);
		
		System.out.println("Step 10: Switch to Parent window and compare");
		
	}
	
	public static void selenium_6() {
		System.out.println("Step 1: Open Browser, maximize window");
		String mainurl = "https://encodable.com/uploaddemo/";
		driver.get(mainurl);
		
		System.out.println("Step 2: Go to the testing page");
		
		WebElement uploadfile = driver.findElement(By.xpath("//input[@type='file']"));
		uploadfile.sendKeys(System.getProperty("user.dir") + File.separator + "Upload" + File.separator + "upload_01.jpeg");
		System.out.println("Step 3: Select a file to upload on File 1 of 2");
		
		WebElement uploadto = driver.findElement(By.xpath("//select[@name='subdir1']"));
		Select dropupload = new Select (uploadto);
		dropupload.selectByValue("/sumiati/");
		System.out.println("Step 4: Select foler to Upload to");
		
		Random ran = new Random();
		String foldername = "Upload" + ran.nextInt();
		
		WebElement subfolder = driver.findElement(By.xpath("//input[@type='text']"));
		subfolder.sendKeys(foldername);
		
		System.out.println("Step 5: Create a new subfolder to upload file");
		
		WebElement upload = driver.findElement(By.xpath("//input[@type='button']"));
		upload.click();
		System.out.println("Step 6: Click to Begin Upload");
		
		try {   //waiting for some seconds
			Thread.sleep(9000);
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
		
		driver.findElement(By.xpath("//a[text() = 'sumiati']")).click();
		
		WebElement uploadfolder = driver.findElement(By.xpath(String.format("//a[text() = '%s']", foldername)));
		uploadfolder.click();
		System.out.println("Step 10: Open upload folder");
		
		WebElement uppic = driver.findElement(By.xpath("//a[contains(@id, 'upload_01')]"));
		String expfile = "upload 01.jpeg";
		Assert.assertEquals(uppic.getText(), expfile);
		System.out.println("Step 11: Compare upload file name");
		
		
	}
	
	public static void main(String[] args) {
		driver_open();
		
		driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
		WebElement drop = driver.findElement(By.xpath("//div[@id='mydropzone']"));
		int lox = drop.getLocation().getX();
		int loy = drop.getLocation().getY();
		System.out.println(lox + loy);
		//driver.close();
	
		
		
	}
}
