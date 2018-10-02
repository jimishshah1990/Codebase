package com.prudential.testcode.testbase;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	
	protected WebDriver driver;
	protected WebDriverWait wait;
	public TestBase(WebDriver driver, WebDriverWait wait) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.wait=wait;
	}
	
	protected void enterInputText(By element, String value )
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		driver.findElement(element).sendKeys(value);
	}
	
	protected void clickButton(By element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(element).click();
	}
	
	protected void explicitWait(By element) throws InterruptedException
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Thread.sleep(2500);
	}
	
	
	public boolean isElementPresent(By element)
	{
		try
		{
			driver.findElement(element);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
}
