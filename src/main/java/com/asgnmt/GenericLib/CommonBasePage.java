package com.asgnmt.GenericLib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class CommonBasePage {
	
	public WebDriver driver;
	
	public CommonBasePage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void switchToNewTab() {
		Set<String> set = BaseClass.driver.getWindowHandles();
		//System.out.println(set.size());
		Iterator<String> it = set.iterator();
		String parentId = it.next();
		String childId = it.next();
		BaseClass.driver.switchTo().window(childId);
	}
	
	public void switchToAnotherTab() {
		Set<String> set = BaseClass.driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String parentId = it.next();
		String childId1 = it.next();
		String childId2 = it.next();
		BaseClass.driver.switchTo().window(childId2);
	}
	
	public void explicitwait(WebDriver driver,int time,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void moveMouseCursor(WebDriver driver, WebElement element) {
		
		Actions action = new Actions(driver);
		action.moveToElement(element, 50, 0);
		action.click();
		action.perform();
		
	}
	
	public void click(WebElement element)
	{
		element.click();
		
	}
	
	public void sendKeys(WebElement toSend,CharSequence msg) 
	{
		try {		
				toSend.clear();
				toSend.sendKeys(msg);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
	}
	
	public String getText(WebElement element)
	{
		return element.getText();
	}
	
	public void verifySearchResult( WebElement searchResult,String expected)
	{	
		String actual=getText(searchResult);
		Assert.assertEquals(actual, expected);
		System.out.println("Verification  done  Actual data  is =" +actual+ " VS expected is "+expected );
		Reporter.log("Verification  done  Actual data  is =" +actual+ " VS expected is "+expected );  
	}
	
	public void verifySearchResultContains( WebElement searchResult,String expected)
	{
				String actual=getText(searchResult);
			  if(actual.toUpperCase().trim().contains(expected.toUpperCase().trim()))
			  {
				  Reporter.log("Verification  done  Actual data  is =" +actual+ " VS expected is "+expected );
			  }
			  else
			  {
				  Reporter.log("  Verification not done  Actual data  is =" +actual+ " But expected is "+expected );
				  Assert.fail("  Verification not done  Actual data  is =" +actual+ " But expected is "+expected);
			  }
		  
	}
	
	public void selectByText(WebElement element,String text)
	{
		try
				{
			    Thread.sleep(2000);
				Select sel=new Select (element);
				sel.selectByVisibleText(text);
				}
				catch(Exception e)
				{
					Reporter.log( "Selection TimeOUt " +e.getMessage());
				}
		
	}
	
	
	
}
