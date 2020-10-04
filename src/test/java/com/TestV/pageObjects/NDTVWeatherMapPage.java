package com.TestV.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestV.utilities.ReadConfig;

public class NDTVWeatherMapPage {
	WebDriver ldriver;
	WebElement checkboxCityName, cityNameOnMap;
	
	public static String weatherCityName;
	public static String weatherConditionKey, weatherConditionValue;
	public static String weatherWindKey, weatherWindValue;
	public static String weatherHumidityKey, weatherHumidityValue;
	public static String weatherTempInCelKey,weatherTempInCelValue;
	public static String weatherTempInFerhKey, weatherTempInFerhValue;
	
	public NDTVWeatherMapPage(WebDriver rDriver)
	{
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//input[@id='searchBox']")
	WebElement txtSearchBox;
	
	@FindBy(xpath = "//span[@class='heading'][1]")
	WebElement weatherCondition;
	
	@FindBy(xpath = "//span[@class='heading'][2]")
	WebElement weatherWind;
	
	@FindBy(xpath = "//span[@class='heading'][3]")
	WebElement weatherHumidity;
	
	@FindBy(xpath = "//span[@class='heading'][4]")
	WebElement weatherTempInCelcius;
	
	@FindBy(xpath = "//span[@class='heading'][5]")
	WebElement weatherTempInFerh;
	
	public void enterCityName(String CityName)
	{
		txtSearchBox.clear();
		txtSearchBox.sendKeys(CityName);
	}
	
	public void enableCheckBoxCityName(String CityName) throws InterruptedException
	{
		checkboxCityName = ldriver.findElement(By.xpath("//input[@id='"+CityName+"']"));
		Thread.sleep(5000);
		
		if(checkboxCityName.isSelected()==false)
		{
			checkboxCityName.click();
			Thread.sleep(2000);
		}
	}
	
	public void validateCityNameOnMap(String CityName) throws InterruptedException
	{
		
		cityNameOnMap = ldriver.findElement(By.xpath("//div[@class='cityText' and contains(text(),'"+CityName+"')]"));
		Thread.sleep(5000);
		weatherCityName = cityNameOnMap.getText();
		
		cityNameOnMap.click();
	}
	
	public void weatherConditionDetails()
	{
		String str=weatherCondition.getText();
		String[] conditionDetails = str.split(":");
	
		weatherConditionKey=conditionDetails[0];
		weatherConditionValue=conditionDetails[1].trim();
		
		System.out.println("NDTV weather - "+weatherConditionKey+" is "+weatherConditionValue);
		
	}
	
	
	public void weatherWindDetails()
	{
		String str=weatherWind.getText();
		String[] windDetails = str.split(":");
		
		weatherWindKey = windDetails[0];
		
		String [] windSpeed = windDetails[1].split("KPH");
		weatherWindValue=windSpeed[0].trim();
		
		System.out.println("NDTV weather - "+weatherWindKey+" is "+weatherWindValue+" KPH");
	}
	
	
	public void weatherHumidityDetails()
	{
		String str=weatherHumidity.getText();
		String[] humidityDetails = str.split(":");
		weatherHumidityKey = humidityDetails[0];
		
		String [] humidity = humidityDetails[1].split("%");
		weatherHumidityValue=humidity[0];
				
		System.out.println("NDTV weather - "+ weatherHumidityKey +" is "+weatherHumidityValue+"%");
	}
	
	
	public void weatherTempInCelciusDetails()
	{
		String str=weatherTempInCelcius.getText();
		String[] tempInCelciusDetails = str.split(":");
		
		weatherTempInCelKey=tempInCelciusDetails[0];
		weatherTempInCelValue=tempInCelciusDetails[1].trim();
		
		System.out.println("NDTV weather - "+ weatherTempInCelKey +" is "+weatherTempInCelValue+"C");
	}

	
	public void weatherTempInFerhDetails()
	{
		String str=weatherTempInFerh.getText();
		String[] tempInFerhDetails = str.split(":");
		
		weatherTempInFerhKey=tempInFerhDetails[0];
		weatherTempInFerhValue=tempInFerhDetails[1].trim();
		
		System.out.println("NDTV weather - "+ weatherTempInFerhKey +" is "+weatherTempInFerhValue+"F");
	}
	
}
