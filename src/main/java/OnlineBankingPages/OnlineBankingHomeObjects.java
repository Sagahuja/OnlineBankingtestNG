package OnlineBankingPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineBankingHomeObjects {

	WebDriver driver;
	 public OnlineBankingHomeObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	 }
	 
	 @FindBy(xpath = "//Select[@name='listAccounts']")
	 WebElement ViewAccountDetailsDropdown;
	 
	 public WebElement ViewAccountDetailsDropdown() {
		 return ViewAccountDetailsDropdown;
	 }
	  @FindBy (id = "btnGetAccount")
	  WebElement GoButton;
	  public WebElement GoButton() {
		  return GoButton;
	  }
		 
	  @FindBy (xpath = "//div/h1")
	  WebElement AccountHistoryInformation;
	  
	 public WebElement AccountHistoryInformation() {
		 return AccountHistoryInformation;
	 }
	 
	 
	 
	 @FindBy (xpath = "//td[contains(text(), 'Ending balance')]")
	 WebElement ContainsDate;
	 public WebElement ContainsDate() {
		 return ContainsDate;
	 }
		 
		 
	 
	
	
	
}
