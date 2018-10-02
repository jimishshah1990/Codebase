package com.prudential.testcode.automation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.prudential.testcode.config.ConfigReader;
import com.prudential.testcode.pageObjects.Search;

public class TC003_ValidSearch {
	
	static
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
	}
	
	
	WebDriver driver=TC001_LaunchValidation.driver;
	WebDriverWait wait=TC001_LaunchValidation.wait;
	Search search=new Search(driver, wait);
	  
  @Test
  public void launchApplication() throws IOException, InterruptedException {

	  search.launchApplication();
	  
  }
  
  
  @Test
  public void testSearchFunctionality() throws InterruptedException, IOException
  {
	  SoftAssert m_assert=new SoftAssert();
	  search.searchCity("New York", true,m_assert);
	  m_assert.assertAll();
  }
  
  
  
  
}
