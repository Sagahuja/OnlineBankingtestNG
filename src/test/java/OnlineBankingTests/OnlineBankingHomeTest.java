package OnlineBankingTests;

import java.io.IOException;
import java.lang.reflect.Array;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import OnlineBankingPages.LoginPageObjects;
import OnlineBankingPages.OnlineBankingHomeObjects;
import OnlineBankingUtilities.BaseClass;
import OnlineBankingUtilities.ConfigPropertyDataDriven;

public class OnlineBankingHomeTest extends BaseClass {

	WebDriver driver;
	OnlineBankingHomeObjects obho;
	LoginPageObjects LPT;
	ConfigPropertyDataDriven cptdd;
	@AfterClass
	void closeBrowser() {

		driver.close();

	}

	// Select a bank account in View Account Details dropdown and click on GO button
	@Test(priority = 0)
	public void View_Account_Details_Dropdown() throws IOException {
		driver = Initialize_driver();
		cptdd = new ConfigPropertyDataDriven();
		driver.get(cptdd.getProperty("Url"));
		LPT = new LoginPageObjects(driver);
		LPT.Username().sendKeys(cptdd.getProperty("UserName"));
		LPT.Password().sendKeys(cptdd.getProperty("Password"));
		LPT.LoginButton().click();
		obho = new OnlineBankingHomeObjects(driver);
		
		Select dropdown = new Select(obho.ViewAccountDetailsDropdown()); // Select is a class for selecting values from drop down
		dropdown.selectByValue("800003");
		obho.GoButton().click();
		
		
		
		
		

	}

	// Verify Account Information page is displayed. Also verify that account number
	// displayed in heading Account
	// History - <Account no.> is same as bank account selected in above step
	@Test(priority = 1)
	public void Validate_Account_Information_Page() {
		 if(obho.AccountHistoryInformation().isDisplayed()) {
			 System.out.println("Account Information page is displayed");
		 }
		 else {
			 System.out.println("Account Information page is not displayed");
			 
		 }
		 // we could use assert here
		 if (obho.AccountHistoryInformation().getText().contains("800003")) {
	         System.out.println("The Account number displayed in heading account history is same as bank account selected in above step");
	         
			 
		 }
		 else {
			 System.out.println("The Account number displayed in heading account history is not same as bank account selected in above step");
		 }
		 
		

	}
	// Verify that current date is displayed in Balance Detail table (Ending balance as of <Date>)
	@Test(priority =2)
	public void CurrentDate() {
		String BalanceDetailTableText = obho.ContainsDate().getText();
		System.out.println(BalanceDetailTableText);//Ending balance as of 8/19/21 7:29 AM
		if(BalanceDetailTableText.contains("9/1/21")) {
			System.out.println("Current Date is  displayed ");
		}
		
		else {
			System.out.println("Current date is not being displayed");
			
		}
				
		
		
	
		
	}
	
	

}
