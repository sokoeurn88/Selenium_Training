package ui;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShot {

	public static String browser = "chrome";
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
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
		driver.get("https://www.ebay.com.au/");
		driver.manage().window().maximize();
		
		Date currentdate = new Date();
		System.out.println(currentdate);
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotfilename);
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);		// only take screenshot, but not save
		FileUtils.copyFile(screenshotFile, new File(".//ebayscreenshot//"+ screenshotfilename+".png"));
	
		driver.close();
		driver.quit();

	}

}
