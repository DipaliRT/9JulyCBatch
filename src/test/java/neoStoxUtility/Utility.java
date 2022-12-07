package neoStoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;


public class Utility 
{
	public static String readDataFromPropertyFile(String key) throws IOException
	  {
		  // cereat an object of property
		  
		  Properties prop = new Properties();
		  
		  // cerate an object of input file stream
		  
		  FileInputStream myFile = new FileInputStream("C:\\Users\\drthi\\eclipse-workspace\\seleniumProject\\neostoxMyproperty.properties");	  
	  
	     prop.load(myFile);
	  
	    String value = prop.getProperty(key);
	    Reporter.log("Reading "+key+" from PropertyFile...", true);
		return value;
	    
	  }
	 public static void scrollintoview(WebDriver driver, WebElement element) throws InterruptedException
	  
	  {
		  Thread.sleep(2000);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  
		  js.executeScript("arguments[0]", "scrollIntoView()", element);
		  
		  Reporter.log("Scrolling to element...", true);
	  }
	  
	  public static void waitt(WebDriver driver, int waitTime)
	  {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));  
		
		Reporter.log("Waiting for " +waitTime+ "Millis", true);
	  }
	  
	  public static void screenShotMethod(WebDriver driver, String TCID) throws IOException, InterruptedException
	  {
		  
		  Thread.sleep(2000);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
		File desc = new File("D:\\Velocity Group\\Automation 9jluy\\ScreenShotbySelenium\\"+TCID+".jpg");  
		  
		FileHandler.copy(src, desc);
		Reporter.log("Taking ScreenShot", false);
	  }
  
}
