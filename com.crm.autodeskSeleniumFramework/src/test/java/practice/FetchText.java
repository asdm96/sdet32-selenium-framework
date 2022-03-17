package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchText {

	@Test
	public void  fetchText() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager",Keys.ENTER);
		driver.findElement(By.linkText("Organizations")).click();
		for(int page=1;page<=2;page++) {
			try {
				List<WebElement> orgList = driver.findElements(By.xpath("//*[@title='Organizations']"));
				int orgCount=1;
				for(int count=0;count<orgList.size();count++) {
					System.out.println("Org Name: "+orgList.get(count).getText());
					orgCount++;
					try {
						if(driver.findElement(By.xpath("//*[@title='Organizations' and text()='Sdet28&29']")).isDisplayed()) {
							String text=driver.findElement(By.xpath("//*[@title='Organizations' and text()='Sdet28&29']")).getText();
							System.out.println("Org Name found: "+text);
							break;
						}
					}catch (Exception e) {
						Actions act=new Actions(driver);
						act.sendKeys(Keys.ARROW_DOWN);
						if(orgCount>orgList.size()) {
							throw new Exception();
						}
					} 
				}

			}catch (Exception e) {
				driver.findElement(By.xpath("//a[@title='Next']")).click();
			}
		}

	}

}
