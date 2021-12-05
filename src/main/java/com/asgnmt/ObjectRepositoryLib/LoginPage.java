package com.asgnmt.ObjectRepositoryLib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.asgnmt.GenericLib.CommonBasePage;


public class LoginPage {
	
	WebDriver driver;
	CommonBasePage cbp;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		cbp = new CommonBasePage(driver);
	}
	
	@FindBy(xpath = "//a[text()='Log in']")
	private WebElement logIn;
	
	@FindBy(xpath = "//h1[text()='Welcome, Please Sign In!']")
	private WebElement welcomeText;
	
	@FindBy(id = "Email")
	private WebElement email;
	
	@FindBy(xpath = "//label[text()='Password:']/following-sibling::input")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;
	
	public void clickLogin() {
		cbp.click(logIn);
	}
	
	public void enterEmail(String expectedEmail) {
		cbp.sendKeys(email, expectedEmail);
		 
	}
	
	public void enterPassword(String expectedPassword) {
		cbp.sendKeys(password, expectedPassword);
		
	}
	
	public void clickLoginButton() {
		cbp.click(loginButton);
		
	}
	
	public void verifyWelcomeText(String expected) {
		cbp.verifySearchResult(welcomeText, expected);
	}
	
}
