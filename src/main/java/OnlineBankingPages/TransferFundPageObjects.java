package OnlineBankingPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundPageObjects {
	WebDriver driver;

	public TransferFundPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='MenuHyperLink3']")
	WebElement TransferFundsLink;

	public WebElement TransferFundsLink() {
		return TransferFundsLink;
	}

	
	/*
	 * @FindBy(id = "tForm") WebElement TransferFundsPageConfirmation;
	 * 
	 * public WebElement TransferFundsPageConfirmation() { return
	 * TransferFundsPageConfirmation;
	 * 
	 * }
	 */

	@FindBy(xpath = "//Select[@id='fromAccount']")
	WebElement FromAccountDropdown;

	public WebElement FromAccountDropdown() {
		return FromAccountDropdown;
	}

	@FindBy(xpath = "//Select[@id='toAccount']")
	WebElement ToAccountDropdown;

	public WebElement ToAccountDropdown() {
		return ToAccountDropdown;
	}
	
	
	@FindBy(id = "transferAmount")
	WebElement AmountToTransferValue;
	public WebElement AmountToTransferValue() {
		return AmountToTransferValue;
	}
	@FindBy(id = "transfer")
	WebElement TransferMoneyButton;
	public WebElement TransferMoneyButton() {
		return TransferMoneyButton;
	}
	@FindBy(id = "_ctl0__ctl0_Content_Main_postResp")
	WebElement ValidateMessageTransferAccountDetails;
	public WebElement ValidateMessageTransferAccountDetails() {
		return ValidateMessageTransferAccountDetails;
	}
	

}
