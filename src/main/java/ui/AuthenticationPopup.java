package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopup {

	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static String username = "admin";	//real work reading from external xls or csv
	public static String password = "admin";	//real work reading from external xls or csv
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("Chrome")) {		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.get("https://the-internet.herokuapp.com/basic_auth");
		driver.get("https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		
		// real url: https://the-internet.herokuapp.com/basic_auth
		// add username and password in url: https://username:password@the-internet.herokuapp.com/basic_auth
		// use this one as sample: https://admin:admin@the-internet.herokuapp.com/basic_auth

		driver.close();
		driver.quit();

	}

}
