package neoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxUtility.Utility;

public class Base 

{
    protected WebDriver driver;
	
	public void lunchBrowser() throws IOException
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Velocity Group\\Automation 9jluy\\Selenium\\chromedriver.exe");	

		driver = new ChromeDriver();
		driver.get(Utility.readDataFromPropertyFile("url"));
	    driver.manage().window().maximize();    
		Utility.waitt(driver, 1000);
		Reporter.log("Lunching Browser...", true);
		
	}
	
	
	
	
}
