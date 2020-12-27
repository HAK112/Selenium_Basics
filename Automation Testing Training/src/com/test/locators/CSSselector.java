package com.test.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSselector {
	
	private WebDriver driver;
	private String baseUrl="http://www.fb.com/";
	
	//Driver Setup
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "resource//drivers//chromedriver.exe");  
		WebDriver driver=new ChromeDriver();
		this.driver=driver;
		System.out.println("Web Driver Started");
	}
	
	//Using cssSelector to get the Email Tag input
	public void testCssSelector() {
	    // Launch Web Site  
		driver.get(baseUrl); 
	    System.out.println("Website Opened");
	    
	    // Finding Elements by cssSelector and Printing it in the Console
	    //<input type="text" id="email" name="email" class="myForm">
	    /*
	     * 	tagName[attribute='value'] or tagName#id for generating custox css(syntax)
		 *	tagName[attribute*='value'] css regular expression 
	     */
	    WebElement firstName = driver.findElement(By.cssSelector("input[name='email']"));
	    System.out.println(firstName);
	}
	
	//Closing all Windows
	public void tearDown() throws Exception {
		driver.quit();
	}
		
	public static void main(String[] args) throws Exception {
	   CSSselector cs = new CSSselector();
	   cs.setUp();
	   cs.testCssSelector();
	   cs.tearDown();
	}

}
