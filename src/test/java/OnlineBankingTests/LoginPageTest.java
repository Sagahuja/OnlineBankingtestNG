package OnlineBankingTests;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import OnlineBankingPages.LoginPageObjects;
import OnlineBankingUtilities.BaseClass;
import OnlineBankingUtilities.ConfigPropertyDataDriven;

// ctrl+ shift +o will import required things automatically

public class LoginPageTest extends BaseClass {

	WebDriver driver;
	LoginPageObjects LPT;
	ConfigPropertyDataDriven cptdd;
	
	@AfterClass
	void closeBrowser() {

		driver.close();

	}

	// On the login page, verify that AltoroMutual logo image is displayed in top
	// left
	
	@Test(priority = 0)
	public void LoginPageImageValidation() {
		driver = Initialize_driver();
		driver.get("http://demo.testfire.net/login.jsp");

		// user should validate the AltoroMutual logo image is displayed in top left
		LPT = new LoginPageObjects(driver);
		// class A obj = new class B ()
		LPT.AltoroMutual_logo_image();

		if (LPT.AltoroMutual_logo_image().isDisplayed()) {

			System.out.println("The  AltoroMutual logo image is getting displayed on top left ");

			// we need to know how to validate that image is exactly on top left
			// we also need to know how to validate that available image is similar to the
			// local image

		} else {
			System.out.println("The  AltoroMutual logo image is not getting displayed on top left");
		}

	}

	// Verify that following four tabs are displayed at the top: ONLINE BANKING
	// LOGIN, PERSONAL, SMALL BUSINESS and INSIDE ALTORO MUTUAL
	@Test(priority = 1)

	public void Fourtabs_displayedValidation() {

		// ONLINE BANKING LOGIN
		System.out.println(LPT.Tab_Online_BANKING_lOGIN().getText());

		if (LPT.Tab_Online_BANKING_lOGIN().getText().equalsIgnoreCase("ONLINE BANKING LOGIN")) {
			System.out.println(" The Online Banking Login tab is available ");

		}

		else {
			System.out.println("The Online Banking Login tab is not available");
		}

		// PERSONAL
		System.out.println(LPT.Tab_PERSONAL().getText());

		if (LPT.Tab_PERSONAL().getText().equalsIgnoreCase("PERSONAL")) {
			System.out.println("The PERSONAL tab is available");

		} else {
			System.out.println("The PERSONAL tab is not available");
		}

		// SMALL BUSINESS

		System.out.println(LPT.Tab_SMALL_BUSINESS().getText());
		if (LPT.Tab_SMALL_BUSINESS().getText().equalsIgnoreCase("SMALL BUSINESS")) {
			System.out.println(" The SMALL BUSINESS tab is available");
		}

		else {
			System.out.println("The SMALL BUSINESS tab is not available");
		}

		// INSIDE ALTORO MUTUAL
		System.out.println(LPT.Tab_INSIDE_ALTORO_MUTUAL().getText());
		if (LPT.Tab_INSIDE_ALTORO_MUTUAL().getText().equalsIgnoreCase("INSIDE ALTORO MUTUAL")) {
			System.out.println("The INSIDE ALTORO MUTUAL tab is available");
		} else {
			System.out.println("The INSIDE ALTORO MUTUAL tab is not available");
		}

	}

	// Verify that when user enters incorrect username and password then following
	// Login Failed message should be displayed.
	@Test(priority = 2)

	public void Login_Failed_with_Incorrect_Credentials() throws IOException {
		cptdd = new ConfigPropertyDataDriven();

		LPT.Username().sendKeys(cptdd.getProperty("InvalidUserName"));
		LPT.Password().sendKeys(cptdd.getProperty("InvalidPassword"));
		LPT.LoginButton().click();

		if (LPT.LoginButton().isDisplayed()) {
			System.out.println(LPT.InvalidLoginMessage().getText());

			if (LPT.InvalidLoginMessage().getText().equalsIgnoreCase(
					"Login Failed: We're sorry, but this username or password was not found in our system. Please try again.")) {
				System.out.println("User is getting correct message in case of logging with incorrect credentials");
			}

			else {
				System.out.println("Incorrect Message is coming ");
			}
		} else {
			System.out.println("Unable to Find any error message");
		}

	}

	// Verify that when user enters valid username and password then Online Banking
	// Home page should be displayed.
	@Test(priority = 3)

	public void Login_Successfully_with_Correct_Credentials() throws IOException {
		LPT.Username().sendKeys(cptdd.getProperty("UserName"));
		LPT.Password().sendKeys(cptdd.getProperty("Password"));
		LPT.LoginButton().click();
		try {
			
			if (LPT.LoginButton().isDisplayed()) {
				System.out.println("Online Banking Page is not displayed");
			}
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.print("Online Banking Page is getting displayed");
		} 

	}

}
