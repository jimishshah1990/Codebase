package com.prudential.testcode.objectRepository;

import org.openqa.selenium.By;

public class SearchResultObjectRepository {

	public static By searchButton=By.xpath("//form[@id='searchform'][contains(@onsubmit,'FindCity')]//button[@type='submit']");
	public static By noResultFound=By.xpath("//div[@id='forecast-list']//div[text()='Not found']");
	public static By searchResults=By.xpath("//div[@id='forecast-list']//a[contains(@href,'/city/')]");
	
}
