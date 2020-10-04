package com.TestV.apiTestCases;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.TestV.BaseAPI.APIBaseClass;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetRequestWeather extends APIBaseClass
{
	
	public static String responseCityName, responseWeather;
	public static float responseWindSpeed,responseTemp,responseHumidity;
	
	
	@BeforeClass
	public void getWeatherDetails()
	{
		apilogger.info("Sending request to API");
		
		RestAssured.baseURI=baseURI;
		httpRequest = RestAssured.given();
		
		response = httpRequest.queryParam("q",cityName)
                .queryParam("appid", apiKey)
                .queryParam("units", units)
                .get("/weather");
		
		jsonPath = response.jsonPath();
	}
	
	//@Test
	public void checkResponseStatusCode()
	{
		apilogger.info("Checking response status code");
		int statusCode =response.getStatusCode();
		System.out.println("The response status code is: "+statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
//	@Test
	public void checkResponseStatusLine()
	{
		apilogger.info("Checking response status line");
		String statusLine = response.getStatusLine();
		System.out.println("The response status line is: "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	//@Test
	public void checkResponseTime()
	{
		apilogger.info("Checking response time");
		float responseTime = response.getTimeIn(TimeUnit.SECONDS);
		System.out.println("Response time is : "+responseTime+" secs");
		
		if(responseTime>5000)
		{
			apilogger.warn("The response time is more than 5 secs!!!");
		}
		
	}
	
	//@Test
	public void checkResponseBody()
	{
		apilogger.info("Checking response body");
		String responseBody=response.getBody().asString();
		System.out.println("The response body is: "+ responseBody);
		Assert.assertTrue(responseBody!=null);
	}
	
//	@Test
	public void fetchResponseCityName()
	{
		responseCityName=jsonPath.get("name");
		System.out.println("The name of the city is: "+responseCityName);
		Assert.assertEquals(responseCityName,cityName);
	}
	
//	@Test
	public void fetchResponseTemp()
	{
		String responseTemperature;
		responseTemperature=(jsonPath.get("main.temp").toString());
		
		if(APIBaseClass.units.equalsIgnoreCase("metric"))
		{			
			System.out.println("The temperature is: "+responseTemperature+"C");
			responseTemp=Float.parseFloat(responseTemperature);
		}
		
		else if(APIBaseClass.units.equalsIgnoreCase("Imperial"))
		{			
			System.out.println("The temperature is: "+responseTemperature+"F");
			responseTemp=Float.parseFloat(responseTemperature);
		}
		else
		{
			System.out.println("Temperature cannot be captured from API as Invalid unit value entered!!!");
		}
	}
	
//	@Test
	public void fetchResponseWeather()
	{
		responseWeather=response.jsonPath().get("weather[0].main").toString();
		System.out.println("The overall weather is: "+responseWeather);
		
		Assert.assertTrue(responseWeather!=null);
	}
	
//	@Test
	public void fetchResponseHumidity()
	{
		String responseHumid;
		responseHumid=jsonPath.get("main.humidity").toString();
		responseHumidity=Float.parseFloat(responseHumid);
		System.out.println("The humidity is: "+responseHumidity+"%");
	}
	
//	@Test
	public void fetchResponseWindSpeed()
	{
		String responseWind;
		responseWind =response.jsonPath().get("wind.speed").toString();
		if(APIBaseClass.units.equalsIgnoreCase("metric"))
		{			
			System.out.println("The wind speed is: "+responseWind+" meter/sec");
			responseWindSpeed=Float.parseFloat(responseWind);
			responseWindSpeed=(float) (responseWindSpeed*3.6);
			System.out.println("The wind speed after coversion is : "+responseWindSpeed+" Km/hour");
		}
		else if(APIBaseClass.units.equalsIgnoreCase("imperial"))
		{
			System.out.println("The wind speed is: "+responseWind+" miles/hour");
			responseWindSpeed=Float.parseFloat(responseWind);
			responseWindSpeed=(float) (responseWindSpeed*1.609);
			System.out.println("The wind speed after coversion is : "+responseWindSpeed+" Km/hour");
		}
		else
		{
			System.out.println("Wind speed cannot be captured from API as Invalid unit value entered!!!");
		}
			
	}
	
	@AfterClass
	void tearDown()
	{
		apilogger.info("Finished with GetWeatherAPI");
	}

}
