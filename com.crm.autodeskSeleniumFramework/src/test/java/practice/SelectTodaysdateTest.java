package practice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectTodaysdateTest {
	@Test
	public void presentDate() {
		
		LocalDateTime dateAndTime=LocalDateTime.now().plusDays(1);
		String month=dateAndTime.getMonth().toString();
		int date = dateAndTime.getDayOfMonth();
		int year=dateAndTime.getYear();
		String actualMonth=month.substring(0,1)+month.substring(1).toLowerCase();
		String monthAndYear=actualMonth+" "+year;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		
		Actions action=new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		String path="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		driver.findElement(By.xpath(path)).click();
		
	}

}
