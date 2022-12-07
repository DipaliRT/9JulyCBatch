package neoStoxTestClass;



import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import neoStoxBase.Base;
import neoStoxPOMClasses.NeoStoxHomePage;
import neoStoxPOMClasses.NeostoxLoginPage;
import neoStoxPOMClasses.NeostoxPasswordPage;
import neoStoxUtility.Utility;

public class NeoStoxValidatingUN extends Base
{
     NeostoxLoginPage login;
     NeostoxPasswordPage password;
     NeoStoxHomePage home;
     String TCID ="2607";
     
@BeforeClass
public void openBrowser() throws IOException
{
       lunchBrowser();
       
       password =new NeostoxPasswordPage(driver);
       
       login = new NeostoxLoginPage(driver); 
       
       home = new NeoStoxHomePage(driver);
}
@BeforeMethod
public void loginToNeoStox() throws IOException, InterruptedException
{
	login.enterMobileNo(Utility.readDataFromPropertyFile("mobileNo"));
	
    login.clickOnSignInButton();
    
    Utility.waitt(driver, 2000);
    
    password.enterPassword(Utility.readDataFromPropertyFile("password"));
    
    Thread.sleep(1000);
    
    password.clickSubmitButton();
    
    Thread.sleep(1000);
    
    home.pophandle(driver); 
    
}
  @Test
  public void validateUserName() throws IOException  
  {
	 Assert.assertEquals(home.getActualUserName(), Utility.readDataFromPropertyFile("expectedUN"),"TC is Failed when actual and expected doesn't matched");
   
  }
  @Test
  public void validateAccBal() throws InterruptedException
  {
	  home.validateAccBal();
	   
  }
  @AfterMethod
  public void logouiFromNeoStox()
  {
	  home.logoutNeostox(driver);
  }
  
  @AfterClass
  public void closeBrowser()
 {
	  driver.close();
 }
}
