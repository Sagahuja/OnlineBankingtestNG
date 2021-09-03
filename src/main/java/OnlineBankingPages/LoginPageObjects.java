package OnlineBankingPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	
	WebDriver driver;
	
	public LoginPageObjects(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		}
	
	@FindBy( xpath ="//img[@src='/images/logo.gif']")
	WebElement AltoroMutual_logo_image;
	
	public WebElement AltoroMutual_logo_image()
	{
		return AltoroMutual_logo_image;
	}
	
	// //a[@id='AccountLink']
	@FindBy( xpath ="//a[@id='AccountLink']")
    WebElement Tab_ONLINE_BANKING_LOGIN;
	
	public WebElement Tab_Online_BANKING_lOGIN()
	{
		return  Tab_ONLINE_BANKING_LOGIN;
		
	}
	
	 
	@FindBy(xpath = "//a[@id='LinkHeader2']")
	WebElement Tab_PERSONAL;
	
	public WebElement Tab_PERSONAL() {
		return Tab_PERSONAL;
	}
    
	@FindBy(xpath = "//a[@id='LinkHeader3']")
	WebElement Tab_SMALL_BUSINESS;
	
	public WebElement Tab_SMALL_BUSINESS() {
		return Tab_SMALL_BUSINESS;
	}
    
	@FindBy(xpath = "//a[@id='LinkHeader4']")
	WebElement Tab_INSIDE_ALTORO_MUTUAL;
	
	public WebElement Tab_INSIDE_ALTORO_MUTUAL() {
		return Tab_INSIDE_ALTORO_MUTUAL;
	}
	
	@FindBy (name = "uid")
	WebElement Username;
	
	public WebElement Username() {
		return Username;
	}
	
	@FindBy (id = "passw")
	WebElement Password;
	
	public WebElement Password() {
		return Password;
	}
	
	@FindBy (name = "btnSubmit")
	WebElement LoginButton;
	
	public WebElement LoginButton() {
		return LoginButton;
	}
    
	@FindBy (id ="_ctl0__ctl0_Content_Main_message")
	WebElement InvalidLoginMessage;
	
	public WebElement InvalidLoginMessage() {
		return InvalidLoginMessage;
	}

	
	
	
	
	
	
	 
	
	
	
	
	
 
	
	
}
