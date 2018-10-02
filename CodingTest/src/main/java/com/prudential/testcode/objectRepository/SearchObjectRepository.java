package com.prudential.testcode.objectRepository;

import org.openqa.selenium.By;

public class SearchObjectRepository {
	
	
	public static By searchCityInput=By.xpath("//form[@id='searchform']//input[@placeholder='Your city name']");
	public static By searchButton=By.xpath("//form[@id='searchform']//button[@type='submit']");
	public static By currentLocationButton=By.xpath("//form[@id='searchform']//button[contains(text(),'Current location')]");
	public static By wrongDataButton=By.xpath("//button[text()='Wrong data?']");
	public static By wrongData_email=By.id("user_email");
	public static By wrongData_subject=By.id("subject");
	public static By wrongData_description=By.id("description");
	public static By wrongData_sendButton=By.xpath("//button[text()='Send']");
	
	
}
