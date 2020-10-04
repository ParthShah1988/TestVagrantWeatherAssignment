package com.TestV.testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TestV.pageObjects.NDTVWeatherMapPage;

public class TC_001_NDTVWeatherDetails extends BaseClass {

	@Test	
	public void getNDTVWeatherDetails() throws InterruptedException
	{
		logger.info("***********Starting NDTV weather details************");
		
		logger.info("Opening the browser");
		
		Thread.sleep(2000);
		
		NDTVWeatherMapPage lp=new NDTVWeatherMapPage(driver);
		
		lp.enterCityName(cityName);//Entering city name in the search box on the map
		logger.info("Setting cityname");
		
		lp.enableCheckBoxCityName(cityName);//Checking the checkbox of the searched city name in the search box on the map
		Thread.sleep(5000);
		logger.info("Checkbox validation on City name is true");
		
		lp.validateCityNameOnMap(cityName);//Validating the city name searched in search box along with the city name visible on the map
		logger.info("Checking the city on the map");
		Thread.sleep(3000);
		
		logger.info("fetching the weather condition details from map \n");
		System.out.println("---------------------------------------------------------------");
		lp.weatherConditionDetails();//fetching weather condition details from the map
		
		lp.weatherWindDetails();//fetching wind speed details from the map
		
		lp.weatherHumidityDetails();//fetching humidity details from the map
		
		lp.weatherTempInCelciusDetails();//fetching temperature details in Celcius from the map
		
		lp.weatherTempInFerhDetails();//fetching temperature details in Fahrenheit  from the map
		System.out.println("---------------------------------------------------------------");
		Thread.sleep(3000);
		
		logger.info("***********NDTV weather details completed**********");
	}
	
}
