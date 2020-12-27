package com.test.cases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterAllFailTestCase {

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
	public void testWebElements() {
		//Declaration and Initialization of Variables
		List<WebElement> actualErrorsWebElements = new ArrayList<>();
		List<String> actualErrorsString = new ArrayList<>();
		List<String> expectedErrorsString = Arrays.asList("What's your name?","What's your name?","You'll use this when you log in and if you ever need to reset your password.","Enter a combination of at least six numbers, letters and punctuation marks (such as ! and &amp;).");
		
		// Launch Web Site  
		driver.get(baseUrl); 
		System.out.println("Website Opened");
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Web Driver Started");
						    
		// Launch Website  
		driver.get("http://www.fb.com/"); 
		System.out.println("Website Launched");
				    
		//Click Create New Account
		driver.findElement(By.id("u_0_2")).click();;
				    
		//Click SignUP
		driver.findElement(By.name("websubmit")).click();
		System.out.println("Sign-Up Clicked");
				    
		List<WebElement> formElements = driver.findElements(By.xpath("//input[contains(@name,'firstname') or contains(@name,'lastname') or contains(@name,'reg_email__') or contains(@name,'reg_passwd__')]"));
		if(formElements.isEmpty()) {
			System.out.println("Form Element List is Empty");
		}
		
		//Error Fields are Hidden so we need to iterate the form once to activate all the dynamic fields to spawn in the HTML body
		for(int i = 0;i<formElements.size();i++) {
			WebElement element = formElements.get(i);
			element.sendKeys(Keys.TAB);	    	
		}
		
		actualErrorsWebElements = driver.findElements(By.xpath("//div[contains(@class,'_5633') and contains(@class,'_5634') and contains(@class,'_53ij')]"));
		
		//Now we print the actual errors
		for(WebElement element : actualErrorsWebElements) {
			actualErrorsString.add(element.getAttribute("innerHTML"));
			System.out.println(element.getTagName()+" => "+ element.getAttribute("textContent"));
		}
		
		//Comparing both list
		if(!actualErrorsString.containsAll(expectedErrorsString)) {
			System.out.println("Test Case Fails as Actual Result is not equal to the Expected Results");
		}
		System.out.println("Test Case has Passed.");
	}
			
	//Closing all Windows
	public void tearDown() throws Exception {
				driver.quit();
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
 	    RegisterAllFailTestCase raftc = new RegisterAllFailTestCase();
 	    raftc.setUp();
 	    raftc.testWebElements();
 	    raftc.tearDown();
	}

}
