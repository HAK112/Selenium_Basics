package com.test.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagName {
	private WebDriver driver;
	private String baseUrl="http://www.fb.com/";
	
	//Driver Setup
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "resource//drivers//chromedriver.exe");  
		WebDriver driver=new ChromeDriver();
		this.driver=driver;
		System.out.println("Web Driver Started");
	}
	
	//Using tagName to get a button
	public void testTagName() {
		// Launch Web Site  
		driver.get(baseUrl); 
		System.out.println("Website Opened");
	
		// Finding Element by tag name and Printing it in the Console
		System.out.println(driver.findElement(By.tagName("button")).getAttribute("name"));
	}
		
	//Closing all Windows
	public void tearDown() throws Exception {
		driver.quit();
	}
	public static void main(String[] args) throws Exception {
		TagName tn = new TagName();
		tn.setUp();
		tn.testTagName();
		tn.tearDown();
	}
}
