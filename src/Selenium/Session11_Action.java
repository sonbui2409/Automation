package Selenium;

import java.io.File;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Session11_Action {
	
	static WebDriver driver;
	Actions act; //set variable for act by using Actions library

	@BeforeTest
	public void browser() {
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "Driver" + File.separator + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		act = new Actions(driver); // set new act variable in driver variable
	}
	@AfterTest
	public void quit() {
		driver.close();
	}
	
	@Test
	public void exercise_action_1() {
		driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
		WebElement drag1 = driver.findElement(By.xpath("//span[text()='Draggable 1']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='mydropzone']"));
		int lox = drop.getLocation().getX();
		int loy = drop.getLocation().getY();	
		act.moveToElement(drag1)
		.clickAndHold(drag1)
		.moveByOffset(lox, loy)
		.pause(Duration.ofSeconds(2))
		.release()
		.build()
		.perform();	
		
	}
	@Test
	public void demo_action_1() {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droptarget']"));
		act.dragAndDrop(drag, drop)
		.build()
		.perform();
		String actual = drop.getText();
		Assert.assertEquals(actual, "You did great!");
	}
	@Test
	public void demo_action_2() {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		int num1 = new Random().nextInt(12 - 1) + 1;
		int num2 = new Random().nextInt(11 - 1) + 1;
		WebElement drag = driver.findElement(By.xpath(String.format("//li[text()='%d']", num1)));
		WebElement drag2 = driver.findElement(By.xpath(String.format("//li[text()='%d']", num2)));
		act.moveToElement(drag)
		.clickAndHold(drag)
		.moveToElement(drag2)
		.release(drag2)
		.build()
		.perform();
		
	}
}
