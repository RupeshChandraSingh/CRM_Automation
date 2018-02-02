package com.crm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.utility.Utility;

public class WebDriverBase 
{
	//static Logger log = LoggerFactory.getLogger(WebDriverBase.class);
	public static Properties prop;
	public static WebDriver driver;
	public static String browserName;
	public static String url;
	public static String userName;
	public static String password;
	//private static SimpleDateFormat dateFormat;
	
	//For Extent Report

	public WebDriverBase()
	{
		try 
		{
			//PropertyConfigurator.configure("log4j.properties");
			prop = new Properties();
			FileInputStream fi = new FileInputStream("./src/main/java/com/crm/configuration/config.properties");
			prop.load(fi);
			browserName = prop.getProperty("browser");
			url = prop.getProperty("url");
			userName = prop.getProperty("userName");		
			password = prop.getProperty("password");		
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	 
	public static void initialization(String browserName, String appURL)
	{

		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Docs\\Rupesh\\chromedriver.exe");
			driver = new ChromeDriver();
			//log.info("Running on Chrome driver instance....");
		}else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\Docs\\Rupesh\\geckodriver.exe");
			driver = new FirefoxDriver();
			//log.info("Running on Firefox driver instance....");
		}
		
		if (!browserName.equals("firefox")) {
			driver.manage().window().maximize();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.page_Load_Time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.implicit_Wait, TimeUnit.SECONDS);
		driver.get(appURL);
		//log.info("Launched the url.... "+driver.getCurrentUrl());
	}
	
	
/*	static {

		dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
		
		PropertyConfigurator.configure("log4j.properties");
	}*/


}
