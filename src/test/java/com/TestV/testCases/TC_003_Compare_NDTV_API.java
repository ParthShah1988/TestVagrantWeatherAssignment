package com.TestV.testCases;

import org.testng.annotations.Test;

import com.TestV.utilities.Comparator;

public class TC_003_Compare_NDTV_API extends Comparator{

	@Test
	public void compareNDTV_API()
	{
		System.out.println("------------------------------------------------------------------------------");
		BaseClass.logger.info("***Starting comparison on NDTV UI values and API values***");
		System.out.println("------------------------------------------------------------------------------");
		
		BaseClass.logger.info("***Comparing City names on NDTV UI and API***");
		System.out.println("------------------------------------------------------------------------------");
		compareCityName();//Comparing City names on NDTV UI and API
		System.out.println("------------------------------------------------------------------------------");
		
		BaseClass.logger.info("***Comparing weather conditions on NDTV UI and API***");
		System.out.println("------------------------------------------------------------------------------");
		compareWeatherCondition();//Comparing City names on NDTV UI and API
		System.out.println("------------------------------------------------------------------------------");
		
		BaseClass.logger.info("***Comparing wind speed on NDTV UI and API***");
		System.out.println("------------------------------------------------------------------------------");
		compareWindSpeed();//Comparing wind speed on NDTV UI and API
		System.out.println("------------------------------------------------------------------------------");
		
		BaseClass.logger.info("***Comparing humidity on NDTV UI and API***");
		System.out.println("------------------------------------------------------------------------------");
		compareHumidity();//Comparing humidity on NDTV UI and API
		System.out.println("------------------------------------------------------------------------------");
		
		BaseClass.logger.info("***Comparing temperature on NDTV UI and API***");
		System.out.println("------------------------------------------------------------------------------");
		compareTemp();//Comparing temperature on NDTV UI and API
		System.out.println("------------------------------------------------------------------------------");
		BaseClass.logger.info("***Finished comparison on NDTV UI values and API values***");
	}
}
