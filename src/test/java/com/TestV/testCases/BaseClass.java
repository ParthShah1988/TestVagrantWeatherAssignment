package com.TestV.testCases;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.TestV.utilities.ReadConfig;
import com.TestV.utilities.ReadUserInputFromExcel;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	//static ReadUserInputFromExcel readExcel = new ReadUserInputFromExcel();
	public static String cityName = ReadUserInputFromExcel.getUserCityName();
    String baseUrl = readconfig.getBaseUrl();
        
    WebDriver driver;
    WebDriverWait wait;
    public static Logger logger;
    
    @Parameters("browser")
    @BeforeClass
    public void setup(String br)
    {
    	   	
    	logger = Logger.getLogger("TestVagrant_Coding_Assignment_V5");
    	PropertyConfigurator.configure(readconfig.getNDTVLog4jPath());
    	
    	if(br.equalsIgnoreCase("chrome"))
    	{
    		
	    	System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
	    	ChromeOptions options = new ChromeOptions();    
	    	options.setExperimentalOption("useAutomationExtension", false);
	    	options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
	    	
	    	driver = new ChromeDriver(options);
	    	
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
    	}
    	
    	if(br.equalsIgnoreCase("firefox"))
    	{
	    	System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
	    	driver = new FirefoxDriver();
    	}
    	
    	if(br.equalsIgnoreCase("ie"))
    	{
	    	System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
	    	driver = new InternetExplorerDriver();
    	}
    	driver.manage().window().maximize();
    	driver.get(baseUrl);
    }

    @AfterClass
    public void teardown()
    {
    	driver.quit();
    }
}
