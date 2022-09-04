package ui;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardEvents {

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

		driver.get("https://extendsclass.com/text-compare.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		WebElement frame = driver.findElement(By.xpath("//*[@id=\"google_esf\"]"));
//		driver.switchTo().frame(frame);

		WebElement sourcetextarea = driver.findElement(By.xpath("//*[@id=\"result\"]/div[4]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/pre[11]/span"));
		WebElement targettextarea = driver.findElement(By.xpath("//*[@id=\"dropZone2\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/div[10]/pre"));
		
		Actions actions = new Actions(driver);
		Thread.sleep(6000);
		actions.keyDown(sourcetextarea, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		Thread.sleep(6000);
		actions.keyDown(targettextarea, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
		Thread.sleep(6000);
		
		driver.close();
		driver.quit();

	}

}
