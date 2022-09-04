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

public class PrintAllLinks {

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

//		List<WebElement> alltags = driver.findElements(By.tagName("a"));
//		System.out.println("Total tags are: "+ alltags.size());
//		
//		for(int i=0;i<=alltags.size();i++) {
//			System.out.println("Total links on webpage are: "+alltags.get(i).getAttribute("href"));
//			System.out.println("Total text show on webpage are: "+alltags.get(i).getText());
//		}
		
		
		List<WebElement> alloption = driver.findElements(By.tagName("option")); 
		System.out.println(alloption.size());
		
		for(int j=0; j<=alloption.size();j++) {
			System.out.println(alloption.get(j).getAttribute("value"));
		}

		driver.close();
		driver.quit();
		driver = null;
		

	}

}
