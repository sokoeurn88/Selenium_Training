package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestAllDropdowns {

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

		driver.get("https://makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[text()='From']")).click();
		WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
		from.sendKeys("sydney");
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//span[text()='To']")).click();
		Thread.sleep(1000);
		WebElement to = driver.findElement(By.xpath("//input[@placeholder='To']"));
		to.sendKeys("Phnom Penh");
		Thread.sleep(1000);
		to.sendKeys(Keys.ARROW_DOWN);
		to.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		driver.close();
		driver.quit();

	}

}
