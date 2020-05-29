package panthomJs;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PanthomJS 
{
	public static void main(String[] args) throws Exception 
	{
		//set the path of Panthom.exe file
		File src = new File("D:\\ALL SELENIUM\\Selenuim softwares\\Headless Browser\\PanthomJS\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");				
        System.setProperty("phantomjs.binary.path", src.getAbsolutePath());	
        
        //create an object of PhantomJSDriver()
        WebDriver driver = new PhantomJSDriver();
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888");
		System.out.println("Login title ====> "+driver.getTitle());
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager",Keys.ENTER);
		System.out.println("Home title ===> "+driver.getTitle());
		
		//take screenshot
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src2 = ts.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./Screenshot/screenshot.png");
		FileUtils.copyFile(src2, dest);
		
		driver.quit();
	}
}
