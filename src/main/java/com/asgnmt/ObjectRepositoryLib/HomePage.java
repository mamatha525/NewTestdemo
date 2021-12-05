package com.asgnmt.ObjectRepositoryLib;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.asgnmt.GenericLib.CommonBasePage;

public class HomePage {

	WebDriver driver;
	CommonBasePage cbp;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		cbp = new CommonBasePage(driver);
	}
	
	@FindBy(xpath = "//a[text()='testdemowebshop@gmail.com']")
	private WebElement userAccountId;
	
	@FindBy(xpath = "//div[@class='listbox']/ul/li/a[contains(text(),'Books')]")
	private WebElement books;
	
	@FindBy(xpath = "(//a[text()='Computing and Internet'])[2]")
	private WebElement computingAndInternetBook;
	
	@FindBy(xpath = "//span[@itemprop='price']")
	private WebElement price;
	
	@FindBy(xpath = "//input[@class='qty-input']")
	private WebElement quantity;
	
	@FindBy(xpath = "//div[@class='add-to-cart-panel']/input[@value='Add to cart']")
	private WebElement addToCart;
	
	@FindBy(xpath = "//p[text()='The product has been added to your ']")
	private WebElement addedToCartText;
	
	@FindBy(xpath = "//a[text()='shopping cart']")
	private WebElement shoppingCartText;
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingCart;
	
	
	public void verifyUserAccountId(String expected) {
		cbp.verifySearchResult(userAccountId, expected);
	}
	
	public void selectBooks() {
		cbp.click(books);
	}
	
	public void selectComputingAndInternetBook() {
		cbp.click(computingAndInternetBook);
	}
	
	public String getBookPrice() {
		return cbp.getText(price);
	}
	
	public void enterQuantity(String expected) {
		cbp.sendKeys(quantity, expected);
	}
	
	public void clickOnAddToCart() {
		cbp.click(addToCart);
	}
	
	public void verifyProductAddedText(String expected) {
		cbp.verifySearchResultContains(addedToCartText, expected);
	}
	
	public void verifyShoppingCartText(String expected) {
		cbp.verifySearchResultContains(shoppingCartText, expected);
	}
	
	public void clickShoppingCart() {
		cbp.click(shoppingCart);
	}
	

	
}
