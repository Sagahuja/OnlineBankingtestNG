package OnlineBankingTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import OnlineBankingPages.LoginPageObjects;
import OnlineBankingPages.OnlineBankingHomeObjects;
import OnlineBankingPages.TransferFundPageObjects;
import OnlineBankingUtilities.BaseClass;
import OnlineBankingUtilities.ConfigPropertyDataDriven;

public class TransferFundPageTest extends BaseClass {

	WebDriver driver;
	LoginPageObjects LPT;
	ConfigPropertyDataDriven cptdd;
	OnlineBankingHomeObjects obho;
	TransferFundPageObjects TFPO;
	
	@AfterClass
	void closeBrowser() {

		driver.close();

	}

	@Test(priority = 0)
	// Click on Transfer Funds link in left hand navigation section, verify that
	// Transfer Funds page is displayed
	public void TransferFundslinkClick() throws IOException {

		driver = Initialize_driver();
		cptdd = new ConfigPropertyDataDriven();
		driver.get(cptdd.getProperty("Url"));
		LPT = new LoginPageObjects(driver);
		LPT.Username().sendKeys(cptdd.getProperty("UserName"));
		LPT.Password().sendKeys(cptdd.getProperty("Password"));
		LPT.LoginButton().click();
		obho = new OnlineBankingHomeObjects(driver);
		Select dropdown = new Select(obho.ViewAccountDetailsDropdown());
		dropdown.selectByValue("800003");
		obho.GoButton().click();

		TFPO = new TransferFundPageObjects(driver);
		TFPO.TransferFundsLink().click();
		System.out.println(driver.getCurrentUrl());

		if (driver.getCurrentUrl().equals(cptdd.getProperty("TransferFundsPageURL"))) {
			System.out.println("Transfer Funds Page is getting displayed");
		}

		else {
			System.out.println("Transfer Funds Page is not being displayed");
		}

	}
	
	
     @Test(priority = 1)
     // Select From Account, To Account and Amount to Transfer and click on Transfer Money button
     public void TransferMoneyProcess() throws IOException {
    	 Select dropdown = new Select(TFPO.FromAccountDropdown());
    	 dropdown.selectByValue("800003");
    	 Select dropdown1 = new Select(TFPO.ToAccountDropdown());
    	 dropdown1.selectByValue("4539082039396288");
    	 
    	 TFPO.AmountToTransferValue().sendKeys(cptdd.getProperty("TransferAmount"));
    	 TFPO.TransferMoneyButton().click();
    	 
     }
     
     @Test(priority =2)
     
	// Verify that a message is displayed with correct amount and from/to account details
    public void ValidateMessageTransferAccountDetails() throws IOException {
    	 System.out.println(TFPO.ValidateMessageTransferAccountDetails().getText());
    	 if(TFPO.ValidateMessageTransferAccountDetails().getText().contains(cptdd.getProperty("TransferAmount"))) {
    		System.out.println("Message is displayed with correct amout and from/to account details"); 
    	 }
     } 
}
