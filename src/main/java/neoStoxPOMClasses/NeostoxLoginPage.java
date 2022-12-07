package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeostoxLoginPage 

{
	
	@FindBy(xpath="(//input[@type='number'])[1]") private WebElement mobileNo;
	
	@FindBy(xpath = "(//a[text()='Sign In'])[2]") private WebElement signIN;
	
public NeostoxLoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);


}
public void enterMobileNo(String un)
{
	mobileNo.sendKeys(un);
	
	Reporter.log("entering MobileNo...", true);
}
public void clickOnSignInButton()
{
	signIN.click();
    Reporter.log("Click on signin button...", true);
}
	
	
}
