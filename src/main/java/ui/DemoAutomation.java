package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.util.List;
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAutomation {

	public static String browser = "chrome";
	public static WebDriver driver;
	public static void main(String[] args) {
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
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
//		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		//withTageName().above(); with Seleniun-Java 4 up
		WebElement password = driver.findElement(By.id("password"));
		driver.findElement(withTagName("input").above(password)).sendKeys("standard_user");
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
//		driver.findElement(By.id("login-button")).click();
		driver.findElement(withTagName("input").below(password)).click();
		
		List<WebElement> lwe = driver.findElements(By.xpath("//div[@class='inventory_list']/div"));
		System.out.println(lwe);
		
		driver.navigate().to("https://sugarcrm.com/");
		driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 6000)");
		
		String windowhandle = driver.getWindowHandle();
		System.out.println(windowhandle);
				
		driver.findElement(By.xpath("//*[@class='icon icon-youtube-play']")).click();
		
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
		
		System.out.println(driver.findElement(By.xpath("//*[@class='icon icon-youtube-play']")).getAttribute("class"));
		System.out.println(driver.findElement(By.xpath("//*[@class='icon icon-youtube-play']")).getLocation());
		System.out.println(driver.findElement(By.xpath("//*[@class='icon icon-youtube-play']")).getSize());
		System.out.println(driver.findElement(By.xpath("//*[@class='icon icon-youtube-play']")).getCssValue("class"));
		System.out.println(driver.findElement(By.xpath("//*[@class='icon icon-youtube-play']")).getTagName());
		System.out.println(driver.findElement(By.xpath("//*[@class='icon icon-youtube-play']")).isSelected());
		System.out.println( driver.findElement(By.xpath("//*[@class='icon icon-youtube-play']")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//*[@class='icon icon-youtube-play']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"menu-item-16778\"]/a")).getText());
		
		driver.close();
		driver.quit();

	}

}
