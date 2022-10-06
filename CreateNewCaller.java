package week5.day2.Assingment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewCaller extends AssingBaseClass {
	//public ChromeDriver driver;
@Test
	public void newCaller() throws InterruptedException {
		// TODO Auto-generated method stub
		// click on ALL
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(10);
		WebElement all = shadow.findElementByXPath("//div[text()='All']");
		all.click();
		Thread.sleep(5000);
		WebElement proposal = shadow.findElementByXPath("//input[@id='filter']");
		proposal.sendKeys("Callers");
		Thread.sleep(2000);
		proposal.sendKeys(Keys.ENTER);
		
		//Create new Caller by filling all the fields and click 'Submit'.
		WebElement add = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(add);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.switchTo().defaultContent();
		
		// enter the details
		WebElement pw = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(pw);
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("Sindhu");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("Vidhu");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();
		
		// verify 
		
		WebElement verify = shadow.findElementByXPath("//iframe[@title='Main Content']");
		
		driver.switchTo().frame(verify);
		String ver = driver.findElement(By.xpath("//div[@class='outputmsg_text']")).getText();
		System.out.println("Primary email device created ");
		
	
	}

}
