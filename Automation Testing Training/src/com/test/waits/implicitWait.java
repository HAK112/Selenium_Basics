package com.test.waits;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class implicitWait {

	private WebDriver driver;
	private String baseUrl="http://www.fb.com/";

	//Driver Setup
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "resource//drivers//chromedriver.exe");  
		WebDriver driver=new ChromeDriver();
		this.driver=driver;
		System.out.println("Web Driver Started");
	}

	//Using implicit wait to increase loading time for finding web elements 
	public void testImplicitWait() throws Exception {
		//Adding implicit wait of 10 sec before to check the DOM to find any element
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Launch Web Site  
		driver.get(baseUrl);
	    System.out.println("Website Launched");
	    
		// Finding Elements by Classname and Printing it in the Console
	    //If you put a wrong classname (xyz) here then the program will wait for 10 sec before returning an empty string
	    List<WebElement> webelements = driver.findElements(By.className("inputtext"));
	    if(webelements.isEmpty()) {
	    	System.out.println("List Empty");
	    }
	    for(WebElement element : webelements) {
            System.out.println("=> "+element.getAttribute("placeholder"));
        }	
		
	}

	//Closing all Windows
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	public static void main(String[] args) throws Exception {
		implicitWait im = new implicitWait();
		im.setUp();
		im.testImplicitWait();
		im.tearDown();
	}
}
