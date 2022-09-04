package ui;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleWindows {

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

		driver.get("https://www.salesforce.com/au/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/div[6]/div[1]/div[2]/div[2]/div/div[1]/div/a/span")).click();
		
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
		
		Iterator<String> iterator = windowhandles.iterator();
		String parentwindow = iterator.next();
		System.out.println(parentwindow);
		
		
		String childwindow = iterator.next();
		System.out.println(childwindow);
		
		driver.switchTo().window(childwindow);
		

		
		driver.findElement(By.name("UserFirstName")).sendKeys("sokoeurn");
		driver.findElement(By.name("UserLastName")).sendKeys("chhay");
		Thread.sleep(1000);
		
		System.out.println( driver.switchTo().window(parentwindow).getTitle());
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/div[6]/div[1]/div[2]/div[2]/div/div[2]/div/a/span")).click();
		
		driver.close();
		driver.quit();

	}

}
