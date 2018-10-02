package com.prudential.testcode.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.prudential.testcode.config.ConfigReader;
import com.prudential.testcode.objectRepository.SearchObjectRepository;
import com.prudential.testcode.objectRepository.SearchResultObjectRepository;
import com.prudential.testcode.testbase.TestBase;

public class Search extends TestBase {
	

	public Search(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}

	
	public void launchApplication() throws InterruptedException, IOException
	{
		driver.manage().window().maximize();
		Thread.sleep(1500);
		driver.get(new ConfigReader().getPropertyValue("URL"));
		explicitWait(SearchObjectRepository.searchButton);
	}
	
	
	
	public void initialValidation(SoftAssert m_assert)
	{
		m_assert.assertEquals(driver.getTitle(), "Сurrent weather and forecast - OpenWeatherMap","Title is incorrect");
		m_assert.assertEquals(isElementPresent(SearchObjectRepository.searchCityInput), true,"Search City Input Box is not displayed");
		m_assert.assertEquals(isElementPresent(SearchObjectRepository.searchButton), true,"Search Button is not displayed");
		m_assert.assertEquals(isElementPresent(SearchObjectRepository.currentLocationButton), true,"Current Location is not displayed");
		m_assert.assertEquals(isElementPresent(By.linkText("Weather")), true,"Weather Link is not displayed");
		m_assert.assertEquals(isElementPresent(By.partialLinkText("Maps")), true,"Maps Link is not displayed");
		m_assert.assertEquals(isElementPresent(By.linkText("API")), true,"API Link is not displayed");
		m_assert.assertEquals(isElementPresent(By.linkText("Price")), true,"Price Link is not displayed");
		m_assert.assertEquals(isElementPresent(By.linkText("Partners")), true,"Partners Link is not displayed");
		m_assert.assertEquals(isElementPresent(By.linkText("Stations")), true,"Stations Link is not displayed");
		m_assert.assertEquals(isElementPresent(By.linkText("Widgets")), true,"Widgets Link is not displayed");
		m_assert.assertEquals(isElementPresent(By.linkText("Blog")), true,"Blog Link is not displayed");

	}
	
	
	public void searchCity(String cityName, boolean validCity, SoftAssert m_assert) throws InterruptedException, IOException
	{
		driver.findElement(By.linkText("Weather")).click();
		explicitWait(SearchObjectRepository.searchButton);
		
		enterInputText(SearchObjectRepository.searchCityInput, cityName);
		clickButton(SearchObjectRepository.searchButton);
		
		if(validCity==false)
		{
			m_assert.assertEquals(isElementPresent(SearchResultObjectRepository.noResultFound), true, "Not Found is not displayed");
		}
		else
		{
			List<WebElement> elements=driver.findElements(SearchResultObjectRepository.searchResults);
			for(WebElement el:elements)
			{
				m_assert.assertEquals(el.getText().toLowerCase().contains(cityName.toLowerCase()), true, "Search Result - "+el.getText()+" doesnt contain search string - "+cityName);
			}
		}
		
		
		
		
	}
	
	
	public void currentLocation(SoftAssert m_assert) throws InterruptedException, IOException
	{
		searchCity("New York", true,m_assert);
		clickButton(SearchResultObjectRepository.searchResults);
		explicitWait(SearchObjectRepository.searchButton);
		clickButton(SearchObjectRepository.currentLocationButton);
		explicitWait(SearchObjectRepository.searchButton);
		m_assert.assertEquals(driver.findElement(By.xpath("//h2[@class='weather-widget__city-name']")).getText().equals("Weather in "+(new ConfigReader().getPropertyValue("CurrentLocation"))), true,"Current Location functionality is not working");
		
	}

	
	public void wrongData() throws InterruptedException
	{
		clickButton(SearchObjectRepository.wrongDataButton);
		enterInputText(SearchObjectRepository.wrongData_email, "jimish.shah1990@gmail.com");
		enterInputText(SearchObjectRepository.wrongData_subject, "Subject Test");
		enterInputText(SearchObjectRepository.wrongData_description, "Description Test");
		clickButton(SearchObjectRepository.wrongData_sendButton);
		explicitWait(SearchObjectRepository.searchButton);
	}
	
}
