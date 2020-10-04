package com.TestV.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() 
	{
		File src = new File("./Configurations\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("The exception is: "+ e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getBaseUrl()
	{
		String url = pro.getProperty("baseUrl");
		return url;
	}
	/*
	public String getCityName()
	{
		String cityName = pro.getProperty("cityName");
		return cityName;
	}*/
	
	public String getChromePath()
	{
		String chromePath = pro.getProperty("chromepath");
		return chromePath;
	}

	public String getFirefoxPath()
	{
		String ffPath = pro.getProperty("firefoxpath");
		return ffPath;
	}
	
	public String getIEPath()
	{
		String iePath = pro.getProperty("iepath");
		return iePath;
	}
	
	public String getNDTVLog4jPath()
	{
		String uiLog = pro.getProperty("log4jpath_NDTV_UI");
		return uiLog;
	}
	
	public String getAPILog4jPath()
	{
		String apiLog = pro.getProperty("log4jpath_API");
		return apiLog;
	}
	
	public String getBaseURI()
	{
		String uri = pro.getProperty("apiBaseURI");
		return uri;
	}
	public String getApiToken()
	{
		String key = pro.getProperty("apiToken");
		return key;
	}
	
	/*
	public String getApiUnits()
	{
		String units = pro.getProperty("units");
		return units;
	}*/
}
