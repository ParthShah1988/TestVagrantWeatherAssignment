package com.TestV.utilities;

import java.io.IOException;

import org.apache.commons.lang3.*;
import org.apache.commons.lang3.text.WordUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestV.pageObjects.NDTVWeatherMapPage;
import com.TestV.utilities.XLUtils;

public class ReadUserInputFromExcel {
	
	public static String path = "../TestVagrant_Coding_Assignment_V5/WeatherTest.xlsx";
	
	public static String userInputCityName,userInputUnits;
	public static float userInputTempCelVariance, userInputTempFerhVariance, userInputWindSpeedVariance, userInputHumidityVariance;
	
	//Returns city name value from Excel, user input
	@SuppressWarnings("deprecation")
	public static String getUserCityName()
	{
		try {
			int rownum,colcount;
			rownum = XLUtils.getRowCount(path, "Sheet1");
			colcount = XLUtils.getCellCount(path, "Sheet1", 1);
			
			userInputCityName = XLUtils.getCellData(path, "Sheet1", 1, 0);
			userInputCityName=WordUtils.capitalizeFully(userInputCityName);
			//System.out.println("This is "+userInputCityName);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return userInputCityName;
	}
	
	//Returns units value from Excel, user input
	public static String getUserUnits()
	{
		
		try {
			int rownum,colcount;
			rownum = XLUtils.getRowCount(path, "Sheet1");
			colcount = XLUtils.getCellCount(path, "Sheet1", 1);
			
			userInputUnits = XLUtils.getCellData(path, "Sheet1", 1, 1);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return userInputUnits;
	}
	
	//Returns temperature Celcius variance value from Excel, user input
	public static float getUserTempCelVariance()
	{
		try {
			int rownum,colcount;
			rownum = XLUtils.getRowCount(path, "Sheet1");
			
			colcount = XLUtils.getCellCount(path, "Sheet1", 1);
	
			String userTempCelValue = XLUtils.getCellData(path, "Sheet1", 1, 2);
			userInputTempCelVariance= Float.parseFloat(userTempCelValue);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return(userInputTempCelVariance);
	}
	
	//Returns temperature ferh variance value from Excel, user input
	public static float getUserTempFerhVariance()
	{
		try {
			int rownum,colcount;
			rownum = XLUtils.getRowCount(path, "Sheet1");
			
			colcount = XLUtils.getCellCount(path, "Sheet1", 1);
	
			String userTempCelValue = XLUtils.getCellData(path, "Sheet1", 1, 3);
			userInputTempFerhVariance= Float.parseFloat(userTempCelValue);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return(userInputTempFerhVariance);
	}
	
	//Returns wind speed variance value from Excel, user input
	public static float getUserWindSpeedVariance()
	{
		try {
			int rownum,colcount;
			rownum = XLUtils.getRowCount(path, "Sheet1");
			
			colcount = XLUtils.getCellCount(path, "Sheet1", 1);
	
			String userWindSpeedValue = XLUtils.getCellData(path, "Sheet1", 1, 4);
			userInputWindSpeedVariance= Float.parseFloat(userWindSpeedValue);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return(userInputWindSpeedVariance);
	}
	
	//Returns humidity variance value from Excel, user input
	public static float getUserHumidityVariance()
	{
		
		 try{
			int rownum,colcount;
			rownum = XLUtils.getRowCount(path, "Sheet1");
			
			colcount = XLUtils.getCellCount(path, "Sheet1", 1);
	
			String userHumidityValue = XLUtils.getCellData(path, "Sheet1", 1, 5);
			userInputHumidityVariance= Float.parseFloat(userHumidityValue);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return (userInputHumidityVariance);
	}
}
