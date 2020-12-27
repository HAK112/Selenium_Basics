package com.test.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassName {
	
	private WebDriver driver;
	private String baseUrl="http://www.fb.com/";
	
	//Driver Setup
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "resource//drivers//chromedriver.exe");  
		WebDriver driver=new ChromeDriver();
		this.driver=driver;
		System.out.println("Web Driver Started");
	}
	
	//Using Classname get the input Login Tags
	public void testClassName() throws Exception {
		// Launch Website  
		driver.get(baseUrl);
	    System.out.println("Website Opened");
	    
	    // Finding Elements by Classname and Printing it in the Console
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
		ClassName cn = new ClassName();
		cn.setUp();
		cn.testClassName();
		cn.tearDown();
	}
}
