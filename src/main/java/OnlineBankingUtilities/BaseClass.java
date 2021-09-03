package OnlineBankingUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver;
	
	
	public WebDriver Initialize_driver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	
	}
	
	
	
	
	
	
	

}
