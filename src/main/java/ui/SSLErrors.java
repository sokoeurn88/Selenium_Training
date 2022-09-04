package ui;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSLErrors {

	public static String browser = "chrome";
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			FirefoxOptions firefoxoptions = new FirefoxOptions();
			firefoxoptions.merge(dc);
			driver = new FirefoxDriver(firefoxoptions);
		}else if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			dc.setAcceptInsecureCerts(true);
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.merge(dc);
			driver = new ChromeDriver(chromeoptions);
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);			
			EdgeOptions edgeoptions = new EdgeOptions();
			edgeoptions.merge(dc);			
			driver = new EdgeDriver(edgeoptions);
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();

		driver.close();
		driver.quit();

	}

}
