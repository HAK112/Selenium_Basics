package com.test.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {

	private WebDriver driver;
	private String baseUrl="http://www.fb.com/";
	
	//Driver Setup
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "resource//drivers//chromedriver.exe");  
		WebDriver driver=new ChromeDriver();
		this.driver=driver;
		System.out.println("Web Driver Started");
	}
	
	//Using xpath both relative and absolute to get form tag name
	public void testXpath() {
		// Launch Web Site  
		driver.get(baseUrl); 
		System.out.println("Website Opened");
	
		/*
		//tagName[@attribute='value'] for generating custox xpath(syntax)
		//tagName[contains(@attribute,'value')] xpath expression
		 */
	
		// Finding Element by relative xpath and Printing it in the Console
		//tag[@attributeName='attributeValues']
		System.out.println(driver.findElement(By.xpath("//form[@id='u_0_a']")).getTagName());
	
		// Finding Element by absolute xpath and Printing it in the Console
		//tag[@attributeName='attributeValues']		
		System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form")).getTagName());		    
	}
		
	//Closing all Windows
	public void tearDown() throws Exception {
			driver.quit();
	}
	
	
	public static void main(String[] args) throws Exception{
		Xpath xp = new Xpath();
		xp.setUp();
		xp.testXpath();
		xp.tearDown();
	}

}
