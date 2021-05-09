package Selenium;

import org.openqa.selenium.WebDriver;

public class summary {

	
	public static void main(String[] args) {
		driver driv = new driver(); // creating a class element for driver
		//create a constructor on the class which will be use above driver on driver.java and the driver must return a value
		/* the example for creating a constructor driver on Demo.class
		 * public Demo(WebDriver Globdriver) {   
		  this.driver = Globdriver;
		  }
		*/
		WebDriver Globdriver = driv.driver(); //command to set Globdriver = return value of driver.java class
	
		//Demo demo = new Demo(Globdriver); //creating a class element to use it later on another class
		//demo.demo_javascript();
		Globdriver.close();
	}
}
