package com.TestV.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter{
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void onStart(ITestContext testContest)
	{
		
		htmlReporter = new ExtentHtmlReporter("../TestVagrant_Coding_Assignment_V5/Reports/testReport.html");//Specify location
		
		
		htmlReporter.config().setDocumentTitle("Automation Report");//Title of the report
		htmlReporter.config().setReportName("Weather Comparison Report");//Name of the report
		htmlReporter.config().setTheme(Theme.DARK);//Page theme is set to dark
	
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "parth");		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName());//create new entry in the report
		test.log(Status.PASS, "Test case PASSED is: "+ result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName());//create new entry in the report
		test.log(Status.FAIL, "Test case FAILED is: "+ result.getName());//To add name in the extent report
		test.log(Status.FAIL, "Test case FAILED is: "+ result.getThrowable());//To add error/exceptions in the extent report
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName());//create new entry in the report
		test.log(Status.SKIP, "Test case SKIPPED is: "+ result.getName());//To add name in the extent report
	}

	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

}
