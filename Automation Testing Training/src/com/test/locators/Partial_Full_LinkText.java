package com.test.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Partial_Full_LinkText {
	private WebDriver driver;
	private String baseUrl="http://www.fb.com/";
	
	//Driver Setup
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "resource//drivers//chromedriver.exe");  
		WebDriver driver=new ChromeDriver();
		this.driver=driver;
		System.out.println("Web Driver Started");
	}
	
	//Using Partial/Full Link Text to to find Email Tags to get the Log In Tag input
	public void testPartialAndFullLinkText() {
		// Launch Web Site  
		driver.get(baseUrl); 
		System.out.println("Website Opened");
	
		// Finding Elements by cssSelector and Printing it in the Console
		//<input type="text" id="email" name="email" class="myForm">
		WebElement linkText = driver.findElement(By.linkText("Log In"));
		WebElement partialLinkText = driver.findElement(By.partialLinkText("In"));
		System.out.println(linkText+"\n"+partialLinkText);
	}
		
	//Closing all Windows
	public void tearDown() throws Exception {
		driver.quit();
	}
	public static void main(String[] args) throws Exception {
		Partial_Full_LinkText pflt = new Partial_Full_LinkText();
		pflt.setUp();
		pflt.testPartialAndFullLinkText();
		pflt.tearDown();
	}

}
