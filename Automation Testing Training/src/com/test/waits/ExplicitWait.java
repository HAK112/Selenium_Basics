package com.test.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExplicitWait {
	private WebDriver driver;
	private String baseUrl="https://google.com/ncr";

	//Driver Setup
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "resource//drivers//chromedriver.exe");  
		WebDriver driver=new ChromeDriver();
		this.driver=driver;
		System.out.println("Web Driver Started");
	}

	//Using explicit wait for element link to be clickable
	public void testExplicitWait() throws Exception {
		
		// Launch Web Site  
		driver.get(baseUrl);
	    System.out.println("Website Launched");
	    
	    //Google Search Cheese
		driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
		
		// Initialize and wait till element(link) became clickable - timeout in 10 seconds
		//If you put a wrong classname (xyz) here then the program will wait for 10 sec before returning an empty string
		Boolean firstResult = new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("hdtb-dd-b")),"More"));
		  
		// Print the first result
		System.out.println(firstResult);
	}

	//Closing all Windows
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	public static void main(String[] args) throws Exception {
		ExplicitWait ew = new ExplicitWait();
		ew.setUp();
		ew.testExplicitWait();
		ew.tearDown();
	}
}
