package neoStoxPOMClasses;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Reporter;

import neoStoxUtility.Utility;

public class NeoStoxHomePage 
{
	
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement okButton;
	
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closeButton;
	
    @FindBy(id = "lbl_username")private WebElement userName;
    
    @FindBy(xpath = "(//span[@class='righttopmenu1'])[2]") private WebElement accountBal;
    
    @FindBy(xpath = "//a[@data-toggle='dropdown']") private WebElement dropdown;
    
    @FindBy(id = "lnk_logout") private WebElement logout;
    
    @FindBy (xpath = "(//a[text()='Create Basket'])[1]") private WebElement createbasket;
    
    @FindBy (xpath = "(//div[@id='analyserDropDown'])[1]") private WebElement straetrgyDropdown;
    
    @FindBy (xpath = "//span[text()='Baskets']") private WebElement basket;
   
    public NeoStoxHomePage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);

    }
    
    public String clickOnStratergyOption(WebDriver driver)
    {
    	straetrgyDropdown.click();
    	Utility.waitt(driver, 200);
    	Reporter.log("Click on Stratergies Option...", true);
    	basket.click();
    	Utility.waitt(driver, 500);
    	return createbasket.getText();
    	
    }
    
    
    
    
    
    
    public void pophandle(WebDriver driver) throws InterruptedException 
    {
    	Utility.waitt(driver, 500);
    	okButton.click();
    	Utility.waitt(driver, 500);
    	closeButton.click();
    	Reporter.log("Handling the pop...", true);
    	Thread.sleep(1000);
    
    }
    public String validateAccBal() throws InterruptedException
    {
    	Thread.sleep(500);
    	String bal = accountBal.getText();
    	Reporter.log("Validating Acc Bal = "+bal, true);
		return bal;

    	
    }
    public void logoutNeostox(WebDriver driver)
    {
    	Utility.waitt(driver, 1000);
    	dropdown.click();
    	Utility.waitt(driver, 1000);
    	logout.click();
    	Reporter.log("Logout from NeoStox...", true);
    }
    public String getActualUserName()
    {
    	String actualUserName = userName.getText();
    	
    	Reporter.log("Getting ActualUserName...", true);
		
    	return actualUserName;
    	
    }
	
    }

