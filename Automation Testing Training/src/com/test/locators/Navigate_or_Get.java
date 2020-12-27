package com.test.locators;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 

public class Navigate_or_Get {
	
	private WebDriver driver;
	private String baseUrl="http://www.google.com/";
	
	//Driver Setup
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "resource//drivers//chromedriver.exe");  
		WebDriver driver=new ChromeDriver();
		this.driver=driver;
		System.out.println("Web Driver Started");
	}
	
	//Using get/navigate to invoke a website and then sending some key input with button invoke as well
	public void testIdLocator() {
		// Launch Website  
	    //Driver.get open an URL and it will wait till the whole page gets loaded. 
	    //WebDriver will wait until the page has fully loaded before returning control to your test or script
	    driver.get(baseUrl);
	    //While driver.navigate.to() method navigates to an URL and It will not wait till the whole page gets loaded. 
	    //It maintains the browser history and cookies, so we can use forward and backward button to navigate between 
	    //the pages during the coding of Test Case.
	    //driver.navigate().to("http://www.google.com/");  
	    System.out.println("Website Opened");

	    
	    // Click on the search text box and send value  
	    driver.findElement(By.name("q")).sendKeys("javatpoint tutorials");  
	          
	    // Click on the search button  
	    driver.findElement(By.name("btnK")).submit(); 
	}
		
	//Closing all Windows
	public void tearDown() throws Exception {
			driver.quit();
	}

	public static void main(String[] args) throws Exception {
	    Navigate_or_Get ng = new Navigate_or_Get();
	    ng.setUp();
	    ng.testIdLocator();
	    ng.tearDown();
	    
	}
}