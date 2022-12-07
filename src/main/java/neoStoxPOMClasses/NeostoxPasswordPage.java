package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeostoxPasswordPage 
{
	
	@FindBy(xpath = "//input[@maxlength='4']") private WebElement password;
	
	@FindBy(xpath = "//a[text()='Submit']") private WebElement submitButton;
	
	public NeostoxPasswordPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	public void enterPassword(String pass)
	
	{
	    password.sendKeys(pass);
	    
	    Reporter.log("entring password...", true);
	}
 public void clickSubmitButton()
 {
	 submitButton.click();
	 
	 Reporter.log("Click on submit Button", true);
 }
}
