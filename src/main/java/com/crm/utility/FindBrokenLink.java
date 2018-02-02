package com.crm.utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLink {
	public void findBrokenLink() {
		System.setProperty("webdriver.chrome.driver", "F:\\Docs\\Rupesh\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://m.redbus.in/");
		
		
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));
		System.out.println(links.size());
		
		List<WebElement> activeLink = new ArrayList<WebElement>();
		
		for(int i=0; i<links.size();i++)
		{
			if(links.get(i).getAttribute("href")!=null && (! links.get(i).getAttribute("href").contains("javascript"))) {
				activeLink.add(links.get(i));
			}
		}
		System.out.println("Active links=========>"+activeLink.size());
		
		for(int j = 0;j<activeLink.size();j++)
		{
			try {
				HttpURLConnection con =  (HttpURLConnection) new URL(activeLink.get(j).getAttribute("href")).openConnection();
				con.connect();
				String response = con.getResponseMessage();
				con.disconnect();
				System.out.println( "Response  message =========>"+response);
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.close();
		
		
	}
	


}
