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

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe {

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

		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_myfirst");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
//		driver.switchTo().frame(0);
//		driver.switchTo().frame("iframeResult");
		
		WebElement frame = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame);

		driver.findElement(By.xpath("/html/body/button")).click();
		Thread.sleep(2000);
		
		//if frame has alert and make it's clean code
		
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//		alert.dismiss();
//		alert.sendKeys("sokoeurn");
//		alert.getText();
		
		System.out.println("Title of parent page is "+ driver.switchTo().parentFrame().getTitle());
		
		
		driver.close();
		driver.quit();

	}

}
