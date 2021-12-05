package com.asgnmt.ObjectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.asgnmt.GenericLib.CommonBasePage;

public class CheckOutPage {
	
	WebDriver driver;
	CommonBasePage cbp;
	
	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		cbp = new CommonBasePage(driver);
	}

	@FindBy(name = "billing_address_id")
	private WebElement billingAddress;
	
	public void clickBillingAddress() {
		cbp.click(billingAddress);
	}
	
	public void selectByVisibleText(String expected) {
		cbp.selectByText(billingAddress, expected);
	}
	
	
	
	
	
	
}
