package week5.day2.Assingment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Orderingmobile extends AssingBaseClass{
@Test
	public  void order() throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(5);
		WebElement all = shadow.findElementByXPath("//div[text()='All']");
		all.click();
		
		//Click on service catalog
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();
		
		//click on mobiles
		Thread.sleep(1000);
		WebElement mobile = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(mobile);
		driver.findElement(By.xpath("(//td[@class='homepage_category_only_description_cell'])[8]/a")).click();		
	driver.switchTo().defaultContent();
	
	// click on iphone 13pro
	WebElement iphone = shadow.findElementByXPath("//iframe[@title='Main Content']");
	driver.switchTo().frame(iphone);
	driver.findElement(By.xpath("//span[contains(text(),'Six new colours')]")).click();
	driver.switchTo().defaultContent();
	
	//Update color field to rose gold and storage field to 128GB
	WebElement radio = shadow.findElementByXPath("//iframe[@title='Main Content']");
	driver.switchTo().frame(radio);
	driver.findElement(By.xpath("//label[text()='Blue']")).click();
	//shadow.findElementByXPath("//label[@text()='256 GB [add $100.00]']").click();
	driver.findElement(By.xpath("//label[text()='256 GB [add $100.00]']")).click();
	
	WebElement select = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
	Select dd=new Select(select);
	dd.selectByValue("500MB");
	
	driver.findElement(By.xpath("//label[text()='Yes']")).click();
	
	driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']")).sendKeys("Screen issue");
	//Select  Order now option
	
	driver.findElement(By.xpath("//button[@data-original-title='Order Now']")).click();
	driver.switchTo().defaultContent();
	//.Verify order is placed and copy the request number"
	
	WebElement msg = shadow.findElementByXPath("//iframe[@title='Main Content']");
	driver.switchTo().frame(msg);
	String Verify = driver.findElement(By.xpath("//div[@class='notification notification-success']/span")).getText();

	System.out.println("The verify msg is " +Verify);
	
	String request = driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText();
	System.out.println("The Request number is "+request);
	
	
	
	
	}

}
