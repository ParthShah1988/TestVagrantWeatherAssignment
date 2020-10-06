package com.TestV.utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.*;
import org.apache.commons.lang3.text.WordUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestV.pageObjects.NDTVWeatherMapPage;
import com.TestV.utilities.XLUtils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReadUserInputFromExcel2 {
	
	public static String path = "../TestVagrant_Coding_Assignment_V5/WeatherTest.xlsx";
	
	public static String userInputCityName,userInputUnits;
	public static float userInputTempCelVariance, userInputTempFerhVariance, userInputWindSpeedVariance, userInputHumidityVariance;
	
	
	@DataProvider(name="weathervalues")
	public String[][] getUserWeatherDetails() throws IOException
	{
		String path = "../TestVagrant_Coding_Assignment_V5/WeatherTest.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		System.out.println(rownum);
		System.out.println(colcount);
		
		String weatherDetails[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)//i representing rows of excel sheet
		{
			for(int j=0;j<colcount;j++)//j representing columns of excel sheet
			{
				weatherDetails[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return (weatherDetails);
	}
	
	@Test(dataProvider = "weathervalues")
	public void getWeatherDetails(String cityValue, String unitValue, String tempCelVarianceValue, String tempFerhVarianceValue, String windSpeedVarianceValue, String humidityVarianceValue)
	{
		
		userInputCityName=cityValue;
		userInputUnits=unitValue;
		userInputTempCelVariance=Float.parseFloat(tempCelVarianceValue);
		userInputTempFerhVariance=Float.parseFloat(tempFerhVarianceValue);
		userInputWindSpeedVariance=Float.parseFloat(windSpeedVarianceValue);
		userInputHumidityVariance=Float.parseFloat(humidityVarianceValue);
		
		System.out.print(userInputCityName+"\t");
		System.out.print(userInputUnits+"\t");
		System.out.print(userInputTempCelVariance+"\t");
		System.out.print(userInputTempFerhVariance+"\t");
		System.out.print(userInputWindSpeedVariance+"\t");
		System.out.print(userInputHumidityVariance+"\t");
		System.out.println("\n-----------------------------------");
			
	}
	
	@Test
	public String getUserCityName()
	{
		System.out.print("This is cityname:"+userInputCityName);
		return userInputCityName;
		
	}
}
