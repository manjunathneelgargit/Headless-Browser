package headlessBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessBrowser 
{
	public static void main(String[] args) 
	{
		//WebDriver driver = new ChromeDriver(); // To launch ChromeBrowser
		
		//To launch headless browser : create Object of HtmlUnitDriver() and upcast it to WebDriver
		WebDriver driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888");
		System.out.println("Login title ====> "+driver.getTitle());
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager",Keys.ENTER);
		System.out.println("Home title ===> "+driver.getTitle());
		
		driver.quit();
	}
}
