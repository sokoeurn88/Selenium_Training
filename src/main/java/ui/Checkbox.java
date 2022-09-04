package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.util.List;
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

	public static String browser = "chrome";
	public static WebDriver driver;
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
		
		driver.manage().window().maximize();
		driver.get("https://www.sugarcrm.com/request-demo/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")).click();
		Thread.sleep(2000);
		
		WebElement radiobutton = driver.findElement(By.xpath("//input[@id='doi1']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(radiobutton).perform();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='interest_market_c']")).click();
		driver.findElement(By.xpath("//input[@name='interest_market_c']")).isSelected();
		
		Thread.sleep(2000);
		driver.findElement(By.id("interest_market_c0")).click();
		System.out.println( driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
		driver.close();
		driver.quit();

	}

}
