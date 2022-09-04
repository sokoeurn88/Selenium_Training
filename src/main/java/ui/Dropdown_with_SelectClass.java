package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Dropdown_with_SelectClass {

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

		driver.get("https://techfios.com/billing/?ng=contacts/add/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("demo@techfios.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebElement webelement = driver.findElement(By.id("cid"));
		Select select = new Select(webelement);

		select.selectByIndex(13);
		Thread.sleep(800);

		select.selectByVisibleText("Mastec");
		Thread.sleep(800);

		select.selectByValue("3");
		
		/*in case selecting multi dropdown
		WebElement webelement = driver.findElement(By.id("cid"));
		Select select = new Select(webelement);
		select.selectByValue("provide value from website");
		select.selectByIndex(5);
		List<WebElement> allselectedoptions = select.getAllSelectedOptions();		//return List<WebElement>
		System.out.println(allselectedoptions.getSize());
		
		select.deselectAll();
		select.selectByValue("provide value");
		select.selectByIndex(5);
		
		select.deselectByIndex(5);
		List<WebElement> allselectedoptions1 = select.getAllSelectedOptions();
		System.out.println(allselectedoptions1.getSize());
		
		*/

		driver.close();
		driver.quit();

	}

}
