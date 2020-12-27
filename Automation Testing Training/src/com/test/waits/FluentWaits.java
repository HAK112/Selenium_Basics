package com.test.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaits {
	private WebDriver driver;
	private String baseUrl="https://google.com/ncr";

	//Driver Setup
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "resource//drivers//chromedriver.exe");  
		WebDriver driver=new ChromeDriver();
		this.driver=driver;
		System.out.println("Web Driver Started");
	}

	//Using fluent wait for element link to be present once every 5 sec in 30 sec
	//Element does not exist so the test will fail
	public void testFluentWait() throws Exception {
		
		// Launch Web Site  
		driver.get(baseUrl);
	    System.out.println("Website Launched");
	    
	    //Defining a wait of type fluent in max time of 30 sec and a frequency of 5 sec
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	    		  .withTimeout(Duration.ofSeconds(30))
	    		  .pollingEvery(Duration.ofSeconds(5))
	    		  .ignoring(NoSuchElementException.class);

	    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	    	public WebElement apply(WebDriver driver) {
	    		System.out.println("5 Sec Gone");
	    		return driver.findElement(By.id("foo"));
	    	}
	    });
	    System.out.println(foo);
	}

	//Closing all Windows
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	public static void main(String[] args) throws Exception {
		FluentWaits fw = new FluentWaits();
		fw.setUp();
		fw.testFluentWait();
		fw.tearDown();
	}
}
