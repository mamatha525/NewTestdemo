package com.asgnmt.GenericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.asgnmt.ObjectRepositoryLib.LoginPage;


public class BaseClass {
	public static WebDriver driver;
	FileLib flib = new FileLib();
	@BeforeClass
	public void configBC() throws Throwable {
		
		String BROWSER = flib.getPropertyKeyValue("browser");
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")){
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}

	}
	
	@BeforeMethod
	public void configBM() throws Throwable {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		FileLib fl = new FileLib();
		String url = fl.getPropertyKeyValue("url");
		driver.get(url);
		String username =fl.getPropertyKeyValue("username");
		String password =fl.getPropertyKeyValue("password");
		String welcomeText = fl.getExcelData("Sheet1", 1, 0);
		LoginPage lp =new LoginPage(driver)	;
		lp.clickLogin();
		lp.verifyWelcomeText(welcomeText);
		lp.enterEmail(username);
		Thread.sleep(3);
		lp.enterPassword(password);
		lp.clickLoginButton();
	
	 
	}
	
	@AfterMethod
	public void configAM() {
		driver.close();
	}
	
	@AfterClass
	public void configAC() {
		
		driver.quit();
	}
}


