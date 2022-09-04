package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.util.List;
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Radiobutton {

	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");

			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get("https://www.singaporeair.com/en_UK/us/home#/book/bookflight");
		driver.findElement(By.xpath("//div[@class='btn-1 cookie-continue']")).click();

		driver.findElement(By.id("bookFlights")).click();
		System.out.println(driver.findElement(By.id("bookFlights")).isSelected());
		
		List<WebElement> allradiobutton = driver.findElements(By.xpath("//input[@class='input__radio']"));
		for (int i = 0; i <= allradiobutton.size(); i++) {
			System.out.println(allradiobutton.get(i).getAttribute("id"));

		}

		Thread.sleep(3000);

		driver.findElement(By.id("redeemFlights")).click();
		driver.findElement(By.id("redeemFlights")).isSelected();

		List<WebElement> allradiobutton1 = driver.findElements(By.xpath("//input[@class='input__radio']"));

		for (int i = 0; i <= allradiobutton1.size(); i++) {
			System.out.println(allradiobutton1.get(i).getAttribute("id"));

		}

		driver.close();
		driver.quit();

	}

}
