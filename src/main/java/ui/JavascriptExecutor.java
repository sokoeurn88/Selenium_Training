package ui;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutor {

	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		//Please note: This script does not work, please keep fixing 

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		

		SearchContext js = (SearchContext) (JavascriptExecutor) driver;
		
		// print title of page
		String script = "return document.title;";
		String title = (String) ((JavascriptExecutor) js).executeScript(script);
		System.out.println(title);
		
		// click button
		
		driver.switchTo().frame("iframeResult");
		((JavascriptExecutor) js).executeScript("myFunction()");
		driver.switchTo().alert().accept();
		
		// highlight
		WebElement button = driver.findElement(By.xpath("/html/body/button"));
		((RemoteWebDriver) js).executeScript("arguments[0].style.border='5px solid green'", button);
		
		//scroll
		driver.navigate().to("https://www.w3schools.com/");
		WebElement certifiedbutton = driver.findElement(By.xpath("//*[@id=\"getdiploma\"]/a"));
		((RemoteWebDriver) js).executeScript("arguments[0].scrollIntoView(true);", certifiedbutton);


		driver.close();
		driver.quit();

	}

	private String executeScript(String script) {
		// TODO Auto-generated method stub
		return null;
	}





}
