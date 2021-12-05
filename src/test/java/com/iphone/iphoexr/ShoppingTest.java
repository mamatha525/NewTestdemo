package com.iphone.iphoexr;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.asgnmt.GenericLib.BaseClass;
import com.asgnmt.GenericLib.FileLib;
import com.asgnmt.GenericLib.CommonBasePage;
import com.asgnmt.ObjectRepositoryLib.LoginPage;
import com.asgnmt.ObjectRepositoryLib.ShoppingCartPage;
import com.asgnmt.ObjectRepositoryLib.CheckOutPage;
import com.asgnmt.ObjectRepositoryLib.HomePage;

public class ShoppingTest extends BaseClass {

	@Test
	public void verifyAddToCart() throws Throwable {
		HomePage hp = new HomePage(driver);
		FileLib fl = new FileLib();
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		String expectedUserAccountId= fl.getExcelData("Sheet1", 1, 1);
		hp.verifyUserAccountId(expectedUserAccountId);
		hp.selectBooks();
		hp.selectComputingAndInternetBook();
		String bookPrice = hp.getBookPrice();
		System.out.println("Book price is : "+bookPrice);
		//String expectedQuantity = fl.getExcelData("Sheet1", 1, 2);
		hp.enterQuantity("2");
		hp.clickOnAddToCart();
		String expProductAddedText = fl.getExcelData("Sheet1", 1, 3);
		hp.verifyProductAddedText(expProductAddedText);
		String expShoppingCartText = fl.getExcelData("Sheet1", 1, 4);
		hp.verifyShoppingCartText(expShoppingCartText);
		hp.clickShoppingCart();
		String subtotal = scp.getSubtotal();
		CheckOutPage cop = new CheckOutPage(driver);
		System.out.println("Subtotal : "+subtotal);
		scp.clickTermsOfService();
		scp.clickCheckout();
		cop.clickBillingAddress();
		String expText = fl.getExcelData("Sheet1", 1, 5);
		cop.selectByVisibleText(expText);
		
		
	}
}
