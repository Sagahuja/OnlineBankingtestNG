package OnlineBankingTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import OnlineBankingPages.AccountInformationPageObjects;
import OnlineBankingPages.LoginPageObjects;
import OnlineBankingPages.OnlineBankingHomeObjects;
import OnlineBankingPages.TransferFundPageObjects;
import OnlineBankingUtilities.BaseClass;
import OnlineBankingUtilities.ConfigPropertyDataDriven;

public class AccountInformationPageTest extends BaseClass {

	WebDriver driver;
	LoginPageObjects LPT;
	ConfigPropertyDataDriven cptdd;
	OnlineBankingHomeObjects obho;
	TransferFundPageObjects TFPO;
	AccountInformationPageObjects AIPO;

	@AfterClass
	void closeBrowser() {

		driver.close();

	}

	// Click on View Account Summary link in left hand navigation section
	@Test(priority = 0)
	public void ViewAccountSummaryLink() throws IOException {
		System.out.println("Test Method First has been started");
		driver = Initialize_driver();
		cptdd = new ConfigPropertyDataDriven();
		driver.get(cptdd.getProperty("Url"));
		driver.manage().window().maximize();
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
		Select dropdown1 = new Select(TFPO.FromAccountDropdown());
		dropdown1.selectByValue("800003");
		Select dropdown2 = new Select(TFPO.ToAccountDropdown());
		dropdown2.selectByValue("4539082039396288");

		TFPO.AmountToTransferValue().sendKeys(cptdd.getProperty("TransferAmount"));
		TFPO.TransferMoneyButton().click();
		AIPO = new AccountInformationPageObjects(driver);
		AIPO.ViewAccountSummaryLink().click();
		System.out.println("Test Method First has been completed");

	}

	// Select From account (same as used before) in the dropdown and click on GO
	// button
	@Test(priority = 1)
	public void SelectFromAccountDropdowandClickGo() {
		System.out.println("Test Method Second has been started");
		Select dropdown = new Select(AIPO.ViewAccountDetailsDropdown());
		dropdown.selectByValue("800003");
		AIPO.GoButton().click();
		System.out.println("Test Method Second has been completed");

	}

	// Verify that an entry is present in the Debits table for transaction done on
	// Transfer Funds page
	// Verify that the amount is same as entered while transferring funds.
	@Test(priority = 2)
	public void ValidateDebitsTableTransaction() {
		System.out.println("Test Method Third has been started");
		int r = driver.findElements(By.xpath("//div[@id='debits']/table/tbody/tr")).size();
		int c = driver.findElements(By.xpath("//div[@id='debits']/table/tbody/tr[1]/td")).size();
		// Matching Details - 1001160140 01/25/2005 Electric Bill 45.25
		int i, j;
		System.out.println("Rows" + r + "Coulums" + c);

		for (i = 1; i <= r; i++) {
			boolean flag = false;
			for (j = 1; j <= c; j++) {

				if (j == 1) {
					if (driver.findElement(By.xpath("//div[@id='debits']/table/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText().equalsIgnoreCase("1001160140")) {

						flag = true;

					} else {
						flag = false;
						break;

					}
				}

				if (j == 2) {
					if (driver.findElement(By.xpath("//div[@id='debits']/table/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText().equalsIgnoreCase("01/25/2005")) {
						flag = true;
					} else {
						flag = false;
						break;
					}
				}
				if (j == 3) {
					if (driver.findElement(By.xpath("//div[@id='debits']/table/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText().equalsIgnoreCase("Electric Bill")) {
						flag = true;

					} else {
						flag = false;
						break;
					}
				}
				if (j == 4) {
					if (driver.findElement(By.xpath("//div[@id='debits']/table/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText().equalsIgnoreCase("45.25")) {

						flag = true;

						if (flag == true) {
							System.out.println(
									"an entry is present in the Debits table for transaction done on Transfer Funds page");

							System.out.println("the amount is same as entered while transferring funds" + driver
									.findElement(
											By.xpath("//div[@id='debits']/table/tbody/tr[" + i + "]/td[" + j + "]"))
									.getText());
							System.out.println("Test Method Third has been completed");
							break;

						}

						else {
							System.out.println("There is no such record present");
							break;
						}

					} else {
						flag = false;
						break;
					}

				}

			}

		}

	}

	// Select To Account (same as used before) in drop down present inside Balance
	// Detail table and click on Select Account button.

	@Test(priority = 3)
	public void SelectToAccountDropdownandSelectAccountbutton() throws IOException {
		System.out.println("Test Method Fourth has been started");
		Select dropdown = new Select(AIPO.BalanceDetailTableDropdown());
		dropdown.selectByValue(cptdd.getProperty("SelectToAccount"));
		AIPO.SelectAccountButton().click();
		System.out.println("Test Method Fourth has been completed");

	}

	// Verify that an entry is present in the Credits table for transaction done on
	// Transfer Funds page.
	// Verify that the amount is same as entered while transferring funds.

	@Test(priority = 4)
	public void ValidateCreditsTableTransaction() {
		int r = driver.findElements(By.xpath("//div[@id='recent']/table/tbody/tr")).size();
		int c = driver.findElements(By.xpath("//div[@id='recent']/table/tbody/tr[1]/td")).size();
		int i, j;
		System.out.println("Test Method Fifth has been started");
		// Taking Credit table as Recent transactions, because data is only updating in
		// Recent transaction table
		// Matching Details - 2021-08-20 Payment $142857.00

		for (i = 1; i <= r; i++) {
			boolean flag = false;
			for (j = 1; j <= c; j++) {

				if (j == 1) {
					if (driver.findElement(By.xpath("//div[@id='recent']/table/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText().equalsIgnoreCase("2021-09-01")) {
						flag = true;
					} else {
						flag = false;
						break;
					}
				}

				if (j == 2) {
					if (driver.findElement(By.xpath("//div[@id='recent']/table/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText().equalsIgnoreCase("Payment")) {
						flag = true;
					} else {
						flag = false;
						break;
					}
				}

				if (j == 3) {
					if (driver.findElement(By.xpath("//div[@id='recent']/table/tbody/tr[" + i + "]/td[" + j + "]"))
							.getText().equalsIgnoreCase("$142857.00")) {
						flag = true;
						if (flag == true) {
							System.out.println(
									" An entry is present in the Recent Transactions table for transaction done on Transfer Funds page");
							System.out.println("the amount is same as entered while transferring funds as $" + driver
									.findElement(
											By.xpath("//div[@id='debits']/table/tbody/tr[" + i + "]/td[" + j + "]"))
									.getText());
							System.out.println("Test Method Fifth has been completed");
							break;
						}}
					else {
						flag = false;
						System.out.println("Test Method Fifth has been not  completed");
						break;
					}

				}

			}
		}
	}

	// Click on Sign off link at the top and verify that user is signed off.

	@Test(priority = 5)
	public void Signoff() {
		System.out.println("Test Method Sixth has been started");
		System.out.println(AIPO.Signoffbutton().getText());
		AIPO.Signoffbutton().click();
		if (AIPO.Signoffbutton().getText().equalsIgnoreCase("Sign In")) {
			System.out.println("User is signed off");
			System.out.println("Test Method Sixth has been completed");
		}

	}
}
