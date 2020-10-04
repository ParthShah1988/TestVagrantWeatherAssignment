package com.TestV.utilities;

import org.testng.annotations.Test;

import com.TestV.BaseAPI.APIBaseClass;
import com.TestV.apiTestCases.GetRequestWeather;
import com.TestV.pageObjects.NDTVWeatherMapPage;

public class Comparator {
	
	public static float tempCelVariance=ReadUserInputFromExcel.getUserTempCelVariance();
	public static float tempferhVariance=ReadUserInputFromExcel.getUserTempFerhVariance();
	public static float windSpeedVariance=ReadUserInputFromExcel.getUserWindSpeedVariance();
	public static float humidityVariance=ReadUserInputFromExcel.getUserHumidityVariance();
		
	//@Test(priority = 1)
	public void compareCityName()
	{
		String NDTVCityName, APICityName;
		NDTVCityName = NDTVWeatherMapPage.weatherCityName.toLowerCase();
		System.out.println("City name in NDTV UI is: "+ NDTVCityName);
		APICityName = GetRequestWeather.responseCityName.toLowerCase();
		System.out.println("City name in API is: "+ APICityName);
		
		if(NDTVCityName.equalsIgnoreCase(APICityName))
			System.out.println("City name matches");
		else
			System.out.println("City name does not match");
	}
	
	//@Test(priority = 2)
	public void compareWeatherCondition()
	{
		String NDTVWeatherCondition, APIWeatherCondition;
		NDTVWeatherCondition = NDTVWeatherMapPage.weatherConditionValue.toLowerCase();
		System.out.println("Weather condition in NDTV UI is: "+ NDTVWeatherCondition);
		
		APIWeatherCondition = GetRequestWeather.responseWeather.toLowerCase();
		System.out.println("Weather condition in API is: "+APIWeatherCondition);
	
		if(NDTVWeatherCondition.contains(APIWeatherCondition))
			System.out.println("Weather condition matches");
		else
			System.out.println("Weather condition does not match!!");
	}
	
	//@Test(priority = 3)
	public void compareWindSpeed()
	{
		{
			float NDTVWindSpeed, APIWindSpeed;
					
			NDTVWindSpeed = Float.parseFloat(NDTVWeatherMapPage.weatherWindValue);
			System.out.println("This is NDTV Wind speed value: "+NDTVWindSpeed+"Km/hour");
				
			APIWindSpeed=GetRequestWeather.responseWindSpeed;

			System.out.println("This is API Wind speed value: "+APIWindSpeed+"Km/hour");
			
			float windSpeedDifference;
			
			if(NDTVWindSpeed>=APIWindSpeed)
			{
				windSpeedDifference=NDTVWindSpeed-APIWindSpeed;
				
				if(windSpeedDifference<=windSpeedVariance)
				{
					System.out.println("Wind speed difference is "+ windSpeedDifference+"km/hour, WITHIN variance range of "+ windSpeedVariance+"km/hour");
				}
				else
				{
					System.out.println("Wind speed difference is "+ windSpeedDifference+"km/hour, OUT OF variance range "+ windSpeedVariance+"km/hour");
				}
			}
			else
			{
				windSpeedDifference=APIWindSpeed-NDTVWindSpeed;
				if(windSpeedDifference<=windSpeedVariance)
				{
					System.out.println("Wind speed difference is "+ windSpeedDifference+"km/hour, WITHIN variance range of "+ windSpeedVariance+"km/hour");
				}
				else
				{
					System.out.println("Wind speed difference is "+ windSpeedDifference+"km/hour, OUT OF variance range "+ windSpeedVariance+"km/hour");
				}
			}
		}
	}
	
	public void compareHumidity()
	{
		float NDTVHumidity; float APIHumidity;
				
		NDTVHumidity = Float.parseFloat(NDTVWeatherMapPage.weatherHumidityValue);
		System.out.println("This is NDTV humidity value: "+NDTVHumidity+"%");
		
		APIHumidity=GetRequestWeather.responseHumidity;
		System.out.println("This is API humidity value: "+APIHumidity+"%");
		
		float humidityDifference;
		
		if(NDTVHumidity>=APIHumidity)
		{
			humidityDifference=NDTVHumidity-APIHumidity;
			if(humidityDifference<=humidityVariance)
			{
				System.out.println("Humidity difference is "+ humidityDifference+"%, WITHIN variance range of "+ humidityVariance+"%");
			}
			else
			{
				System.out.println("Humidity difference is "+ humidityDifference+"%, OUT OF variance range "+ humidityVariance+"%");
			}
		}
		else
		{
			humidityDifference=APIHumidity-NDTVHumidity;
			if(humidityDifference<=humidityVariance)
			{
				System.out.println("Humidity difference is "+ humidityDifference+"%, WITHIN variance range of "+ humidityVariance+"%");
			}
			else
			{
				System.out.println("Humidity difference is "+ humidityDifference+"%, OUT OF variance range "+ humidityVariance+"%");
			}
		}
	}
	

	public void compareTemp()
	{
		
		if(APIBaseClass.units.equalsIgnoreCase("metric"))
		{
			float NDTVTemp, APITemp;
					
			NDTVTemp = Float.parseFloat(NDTVWeatherMapPage.weatherTempInCelValue);
			System.out.println("This is NDTV temperature in celcius value: "+NDTVTemp+"C");
			
			APITemp=GetRequestWeather.responseTemp;
			System.out.println("This is API temperature in celcius value: "+APITemp+"C");
			
			float tempDifference;
			
			if(NDTVTemp>=APITemp)
			{
				tempDifference=	NDTVTemp-APITemp;
				if(tempDifference<=tempCelVariance)
				{
					System.out.println("Temperature difference is "+ tempDifference+"C, WITHIN variance range of "+ tempCelVariance+"C");
				}
				else
				{
					System.out.println("Temperature difference is "+ tempDifference+"C, OUT OF variance range "+ tempCelVariance+"C");
				}
			}
			else
			{
				tempDifference=	APITemp-NDTVTemp;
				if(tempDifference<=tempCelVariance)
				{
					System.out.println("Temperature difference is "+ tempDifference+"C, WITHIN variance range of "+ tempCelVariance+"C");
				}
				else
				{
					System.out.println("Temperature difference is "+ tempDifference+"C, OUT OF variance range "+ tempCelVariance+"C");
				}
			}
		}
		
		else if(APIBaseClass.units.equalsIgnoreCase("Imperial"))
		{
			float NDTVTemp, APITemp;
			
			NDTVTemp = Float.parseFloat(NDTVWeatherMapPage.weatherTempInFerhValue);
			System.out.println("This is NDTV temperature in Fahrenheit value: "+NDTVTemp+"F");
			
			APITemp=GetRequestWeather.responseTemp;
			System.out.println("This is API temperature in Fahrenheit value: "+APITemp+"F");
			
			float tempDifference;
			
			if(NDTVTemp>=APITemp)
			{
				tempDifference=	NDTVTemp-APITemp;
				if(tempDifference<=tempferhVariance)
				{
					System.out.println("Temperature difference is "+ tempDifference+"F, WITHIN variance range of "+ tempferhVariance+"F");
				}
				else
				{
					System.out.println("Temperature difference is "+ tempDifference+"F, OUT OF variance range "+ tempferhVariance+"F");
				}
			}
			else
			{
				tempDifference=	APITemp-NDTVTemp;
				if(tempDifference<=tempferhVariance)
				{
					System.out.println("Temperature difference is "+ tempDifference+"F, WITHIN variance range of "+ tempferhVariance+"F");
				}
				else
				{
					System.out.println("Temperature difference is "+ tempDifference+"F, OUT OF variance range "+ tempferhVariance+"F");
				}
			}
		}
		else
		{
			System.out.println("Temperature cannot be captured from API as Invalid unit value entered!!!");
		}
	}
}
