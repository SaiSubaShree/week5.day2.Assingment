package week5.day2.Assingment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewProposal extends AssingBaseClass {
@Test
	public void proposal()  throws InterruptedException {
		// TODO Auto-generated method stub
		// click on ALL
		Shadow shadow=new Shadow(driver);
		shadow.setImplicitWait(10);
		WebElement all = shadow.findElementByXPath("//div[text()='All']");
		all.click();
		
		
		// click on change
		//driver.findElement(By.xpath("//span[text='Change']")).click();
		Thread.sleep(5000);
		WebElement proposal = shadow.findElementByXPath("//input[@id='filter']");
		proposal.sendKeys("Proposals");
		Thread.sleep(2000);
		/*proposal.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(500);
		proposal.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(500);
		proposal.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(500);*/
		proposal.sendKeys(Keys.ENTER);
	
		//Click- new  and  fill mandatory fields and click 'Submit' Button.
		Thread.sleep(2000);
		// to get the intial row count
		List<WebElement> intiver = driver.findElements(By.xpath("//table[@id='std_change_proposal_table']//tr/td"));
		int intirowcount = intiver.size();	
		System.out.println("The row count is" +intirowcount);
		
		Thread.sleep(2000);
		WebElement add = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(add);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.switchTo().defaultContent();
		
		// filling mandatory feilds
		Thread.sleep(1000);
		WebElement des = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(des);
		driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys("request changes");
     	Thread.sleep(500);
     	
		driver.findElement(By.xpath("//span[text()='Change Request values']")).click();
		
	Thread.sleep(500);
	WebElement title = driver.findElement(By.xpath("//input[@class='filerTableInput form-control']"));
	title.clear();
	Thread.sleep(500);
	title.sendKeys(" Additional data feild is added");
	
	//adding description
	driver.findElement(By.xpath("//textarea[@class='filerTableInput form-control']")).sendKeys(" Age feild is updated");
	//implementation plan
	WebElement plan = driver.findElement(By.xpath("(//textarea[@class='filerTableInput form-control'])[2]"));
	plan.clear();
	plan.sendKeys("Development team will perform by adding data change");
	
	//backout plan
	WebElement backout = driver.findElement(By.xpath("(//textarea[@class='filerTableInput form-control'])[3]"));
backout.clear();
backout.sendKeys("The database backup will be  managed by Triumph team");

// testplan
Thread.sleep(500);
WebElement testplan = driver.findElement(By.xpath("(//textarea[@class='filerTableInput form-control'])[4]"));
testplan.clear();
testplan.sendKeys("The testing team will do the testcase review");	

// click submit button

driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
driver.switchTo().defaultContent();

// verify the template
WebElement verify = shadow.findElementByXPath("//iframe[@title='Main Content']");
driver.switchTo().frame(verify);
/*String ver = driver.findElement(By.xpath("//table[@id='std_change_proposal_table']//tr[3]/td[4]")).getText();
System.out.println(ver);

Thread.sleep(6000);*/
List<WebElement> ver = driver.findElements(By.xpath("//table[@id='std_change_proposal_table']//tr/td"));
int rowcount = ver.size();	
System.out.println("The row count is" +rowcount);
if(intirowcount!=rowcount )
{
	System.out.println("The new propsal is sucessfully created");
}
	
	}

}
