package ui;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

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

		driver.get("https://www.asx.com.au/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"pnProductNavContents\"]/li[2]")).click();
		
		//if frame, switchTo.frame
		//get all numbers of rows
		//get all numbers of columns
		//iterate through and get text
		
		List<WebElement> trlistwebelement = driver.findElements(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr"));
		System.out.println( trlistwebelement.size());
		
		List<WebElement> tdlistwebelement = driver.findElements(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr[2]/td")); 
		System.out.println(tdlistwebelement.size());
		
		for(int i=2; i<=trlistwebelement.size();i++) {
			for(int j=1;j<=tdlistwebelement.size();j++){
				
				System.out.print(
				driver.findElement(By.xpath("//*[@id=\"home_top_five\"]/div/div[1]/div/div[1]/table/tr["+i+"]/td["+j+"]")).getText()+"  ");
			}
			System.out.println();
		}

		driver.close();
		driver.quit();

	}

}
