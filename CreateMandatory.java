package week5.day2.Assingment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateMandatory extends AssingBaseClass{
@Test
	public void Mandatory() throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		// click on ALL
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(10);
		WebElement all = shadow.findElementByXPath("//div[text()='All']");
		all.click();
		Thread.sleep(5000);
		WebElement proposal = shadow.findElementByXPath("//input[@id='filter']");
		proposal.sendKeys("Knowledge");
		Thread.sleep(4000);
		proposal.sendKeys(Keys.ENTER);
		
		//Create an Article
		
		WebElement article = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(article);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Create an Article']")).click();
		driver.switchTo().defaultContent();
		
		//Select knowledge base as IT and category as IT- java and Click Ok
		WebElement know = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(know);
		WebElement knowledge = driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']"));
		knowledge.sendKeys("IT");
		knowledge.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement cate = driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_category']"));
		cate.sendKeys("Java");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//table[@class='ac_table_completer']//tr[2]/td[2]")).click();
		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("new records");
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		
		
	}

}
