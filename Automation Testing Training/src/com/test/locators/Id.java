package com.test.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Id {
	
	private WebDriver driver;
	private String baseUrl="http://www.fb.com/";
	
	//Driver Setup
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "resource//drivers//chromedriver.exe");  
		WebDriver driver=new ChromeDriver();
		this.driver=driver;
		System.out.println("Web Driver Started");
	}
	
	//Using id-Locator to get the Email Tag input
	public void testIdLocator() {
		// Launch Web Site  
		driver.get(baseUrl); 
		System.out.println("Website Opened");
	
		// Finding Element by ID and Printing it in the Console
		WebElement className =  driver.findElement(By.id("email"));
		System.out.println(className);
	}
		
	//Closing all Windows
	public void tearDown() throws Exception {
			driver.quit();
	}

	public static void main(String[] args) throws Exception {
		Id id = new Id();
		id.setUp();
		id.testIdLocator();
		id.tearDown();
	}

}
