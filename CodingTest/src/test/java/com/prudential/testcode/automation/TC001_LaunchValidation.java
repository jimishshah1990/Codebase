package com.prudential.testcode.automation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.prudential.testcode.config.ConfigReader;
import com.prudential.testcode.pageObjects.Search;

public class TC001_LaunchValidation {
	
	static
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
	}
	
	
	public static WebDriver driver=new ChromeDriver();
	public static WebDriverWait wait=new WebDriverWait(driver, 120);
	Search search=new Search(driver, wait);
	  
  @Test(priority=0)
  public void launchApplication() throws IOException, InterruptedException {

	  search.launchApplication();
	  
  }
  
  
  @Test(priority=1)
  public void testSearchFunctionality() throws InterruptedException, IOException
  {
	 SoftAssert m_assert=new SoftAssert();
	 search.initialValidation(m_assert);
	 m_assert.assertAll();
  }
  
  @AfterSuite
  public void afterSuite()
  {
	  driver.quit();
  }
  
  
  
  
}
