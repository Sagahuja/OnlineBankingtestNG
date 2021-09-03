package OnlineBankingPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountInformationPageObjects {

	WebDriver driver;

	public AccountInformationPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='MenuHyperLink1']")
	WebElement ViewAccountSummaryLink;

	public WebElement ViewAccountSummaryLink() {

		return ViewAccountSummaryLink;
	}

	@FindBy(xpath = "//Select[@id='listAccounts']")
	WebElement ViewAccountDetailsDropdown;

	public WebElement ViewAccountDetailsDropdown() {

		return ViewAccountDetailsDropdown;
	}

	@FindBy(id = "btnGetAccount")
	WebElement GoButton;

	public WebElement GoButton() {

		return GoButton;
	}

	@FindBy(xpath = "//div[@id='debits']/table/tbody/tr")
	WebElement DebitsTableTransactionrows;

	public WebElement DebitsTableTransactionrows() {

		return DebitsTableTransactionrows;
	}
	@FindBy(xpath = "//div[@id='debits']/table/tbody/tr/td")
	WebElement DebitsTableTransactioncolumns;

	public WebElement DebitsTableTransactioncolumns() {

		return DebitsTableTransactioncolumns;
	}
	
	
	
	// date = 04/27/2007

	@FindBy(xpath = "//Select[@id='listAccounts']")
	WebElement BalanceDetailTableDropdown;

	public WebElement BalanceDetailTableDropdown() {

		return BalanceDetailTableDropdown;
	}

	@FindBy(id = "btnGetAccount")
	WebElement SelectAccountButton;

	public WebElement SelectAccountButton() {

		return SelectAccountButton;
	}

	
	// Taking Credit table as Recent transactions, because data is only updating in Recent transaction table
	@FindBy(xpath = "//div[@id='recent']/table/tbody/tr[1]/td[1]")
	WebElement CreditsTableTransaction;

	public WebElement CreditsTableTransaction() {

		return CreditsTableTransaction;
	}
	// date = 01/29/2006

	@FindBy(xpath = "//a[@id='LoginLink']")
	WebElement Signoffbutton;

	public WebElement Signoffbutton() {

		return Signoffbutton;
	}
}
