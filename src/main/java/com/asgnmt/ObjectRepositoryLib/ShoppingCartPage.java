package com.asgnmt.ObjectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.asgnmt.GenericLib.CommonBasePage;

public class ShoppingCartPage {

	WebDriver driver;
	CommonBasePage cbp;
	
	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		cbp = new CommonBasePage(driver);
	}
	
	@FindBy(xpath = "//span[@class='product-subtotal']")
	private WebElement subtotal;
	
	@FindBy(xpath = "//div[@class='terms-of-service']/input")
	private WebElement termsOfService;
	
	@FindBy(xpath = "//div[@class='checkout-buttons']/button[contains(text(),'Checkout')]")
	private WebElement checkout;
	
	public String getSubtotal() {
		return cbp.getText(subtotal);
	}
	
	public void clickTermsOfService() {
		cbp.click(termsOfService);
	}
	
	public void clickCheckout() {
		cbp.click(checkout);
	}
	
	
	
	
	
}
