package com.TestV.BaseAPI;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import com.TestV.testCases.BaseClass;
import com.TestV.utilities.ReadConfig;
import com.TestV.utilities.ReadUserInputFromExcel;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIBaseClass 
{
	ReadConfig readconfig = new ReadConfig();

	public static Logger apilogger;
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public static JsonPath jsonPath;
	
	public String baseURI = readconfig.getBaseURI();//Fetching from config file, fixed value
	public String apiKey = readconfig.getApiToken();//Fetching from config file, fixed value
	
	public static String cityName =  ReadUserInputFromExcel.getUserCityName();//ReadUserInputFromExcel.userInputCityName;//Fetching from excel file, User input
	public static String units = ReadUserInputFromExcel.getUserUnits().trim();//Fetching from excel file, User input
	
	
	@BeforeClass
	public void setup()
	{
		apilogger = Logger.getLogger("TestVagrant_Coding_Assignment_V5");
    	PropertyConfigurator.configure(readconfig.getAPILog4jPath());
    	apilogger.setLevel(Level.DEBUG);
	}
}
