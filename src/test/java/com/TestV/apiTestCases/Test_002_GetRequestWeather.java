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


public class Test_002_GetRequestWeather extends GetRequestWeather
{
	@Test
	public void getAPIWeatherDetails()
	{
		apilogger.info("***Starting TC-02 Get Weather details from API***");
		System.out.println("---------------------------------------------------------------");
		checkResponseStatusCode();//checking the status code of the response
		System.out.println("---------------------------------------------------------------");
		checkResponseStatusLine();//checking the status line of the response
		System.out.println("---------------------------------------------------------------");
		checkResponseTime();//checking the response time
		System.out.println("---------------------------------------------------------------");
		checkResponseBody();//checking the response body
		System.out.println("---------------------------------------------------------------");
		fetchResponseCityName();//fetching name of the city
		fetchResponseTemp();//fetching temperature of the city
		fetchResponseWeather();//fetching weather condition of the city
		fetchResponseHumidity();//fetching humidity details of the city
		fetchResponseWindSpeed();//fetching wind speed of the city
		System.out.println("---------------------------------------------------------------");
	}

}
