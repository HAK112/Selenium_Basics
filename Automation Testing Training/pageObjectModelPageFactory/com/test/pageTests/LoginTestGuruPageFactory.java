package com.test.pageTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.pages.HomePageGuruPageFactory;
import com.test.pages.LoginPageGuruPageFactory;

public class LoginTestGuruPageFactory {
	String driverPath = "resource//drivers//chromedriver.exe//";
    
    WebDriver driver;
    LoginPageGuruPageFactory objLogin;
    HomePageGuruPageFactory objHomePage;
    
    public void setup(){
    	System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }

    /**
     * This test case will login in http://demo.guru99.com/V4/
     * Verify login page title as guru99 bank
     * Login to application
     * Verify the home page using Dashboard message
     */
    
    public void tearDown() {
    	driver.quit();
    }

    public void test_Home_Page_Appear_Correct(){

    	//Create Login Page object
    	objLogin = new LoginPageGuruPageFactory(driver);
    	
    	//Verify login page title
    	String loginPageTitle = objLogin.getLoginTitle();
    	if(!loginPageTitle.toLowerCase().contains("guru99 bank")) {
    		System.out.println("Login Page Title Case Failed....You are not on Guru99");
    	};

    	//login to application
    	objLogin.loginToGuru99("mgr123", "mgr!23");
    
    	// go the next page
    	objHomePage = new HomePageGuruPageFactory(driver);

    	//Verify home page
    	if(!objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123")) {
    		System.out.println("You are on Guru99 but Home Page Verification Test Failed");
    	}
    	System.out.println("Home Page Verified");
    }
    
    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
 	    LoginTestGuru ltg = new LoginTestGuru();
 	    ltg.setup();
 	    ltg.test_Home_Page_Appear_Correct();
 	    ltg.tearDown();
	}
}
