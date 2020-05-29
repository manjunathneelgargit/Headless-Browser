package html_unit_drievr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import com.gargoylesoftware.htmlunit.BrowserVersion;

public abstract class HTMLUnitDriver_With_Browser_Versions 
{
	public static void main(String[] args) 
	{
		//HTML with Browser Version
		HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		
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
