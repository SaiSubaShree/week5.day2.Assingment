package week5.day2.Assingment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssingBaseClass {
	public ChromeDriver driver;
	@Parameters({"url" ,"username", "password"})
@BeforeMethod
	public  void Login(String url,String username,String password) {
		// TODO Auto-generated method stub
	WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
	driver.manage().window().maximize();
			
	//Launch ServiceNow application
	driver.get(url);
	
	//Login with valid credentials username as admin and password as Sairam13$
	driver.findElement(By.id("user_name")).sendKeys(username);
	driver.findElement(By.id("user_password")).sendKeys(password);
	driver.findElement(By.xpath("//button[@name='not_important']")).click();
	
		
	}
	@AfterMethod
	public void exit()
	{
		driver.quit();
	}

}
