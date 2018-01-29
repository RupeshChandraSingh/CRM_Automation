package com.crm.extentreport;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.ElementNotSelectableException;
import org.testng.IReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportListner  {
	
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public static ExtentHtmlReporter htmlReporter;
	
	
	@BeforeTest
	public void setUP()
	{
		
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/test-output/Extent_AutomationReports.html"));
		//htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extentConfig.xml"));
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Host Name", "Abhi_PC");
		reports.setSystemInfo("User", "Abhinav");
		
		
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("CRM Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setTheme(Theme.DARK);
		
		
	}
	
	@BeforeMethod
	public void register(Method method)
	{

		String testName = method.getName();
		reports.createTest(testName);
	}
	
		
	

	@Test
	public void test()
	{
		
		StartTestCase("!Login Page Validation!");
		
		
		if ("2"=="2")
		{
			WriteSteps("pass", "Username field is displayed.");
		}
		else 
		{
			WriteSteps("fail", "Username field is not displayed.");
		}
		
	}
	
	public void StartTestCase(String strTestDesc)
	{
		test = reports.createTest(strTestDesc);
	}
	
	public void WriteSteps(String strStatus, String strStep)
	{
		switch(strStatus.toLowerCase())
		{
		case "pass" : test.log(Status.PASS, strStep); break;
		case "fail" : test.log(Status.FAIL, strStep); break;
		case "info" : test.log(Status.INFO, strStep); break;
		}
	}
	@Test
	public void add()
	{
		//test = reports.createTest("Test1");
		
		
		int i=9/0;
		System.out.println(i);
	}
	
	@AfterMethod
	public void captureStatus(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			System.out.println(result.getName()+" is Passed");
		}
		else if (result.getStatus()==ITestResult.FAILURE) 
		{
			System.out.println(result.getName()+" is Failed");
		}else if (result.getStatus()==ITestResult.SKIP) 
		{
			System.out.println(result.getName()+" is Skipped");
		}
	}
	
	@AfterTest
	public void cleanUp()
	{
		reports.flush();
	}
	
	
}
