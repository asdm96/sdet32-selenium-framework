package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopupTest {
	@Test
	public void calender(){
		
		String monthAndYear="May 2022";
		String date="14";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com");
		Actions action = new Actions(driver);
		action.moveByOffset(20, 20).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		String Calenderxpath="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		
		for(;;) {
		try {
			driver.findElement(By.xpath(Calenderxpath)).click();
			break;
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		
		}
	}

}
