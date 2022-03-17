package practice;


import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.GenericUtilities.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TwoPages {
	public static void main(String[] args) throws Throwable {
		JavaUtility jUtil=new JavaUtility();
		
		String organizationName="vtigerCRM Inc";    //"Tyss"+ jUtil.getRandomNumber();
		System.out.println("expected org==>"+organizationName);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager",Keys.ENTER);
		driver.findElement(By.linkText("Organizations")).click();
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//driver.findElement(By.name("accountname")).sendKeys(organizationName);
		//driver.findElement(By.xpath("//input[@value='  Save  ']")).click();	
		//Thread.sleep(2000);
		//driver.findElement(By.linkText("Organizations")).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		boolean flag=false;
	    for(;;) {
			try {
				List<WebElement> orgList = driver.findElements(By.xpath("//a[@title='Organizations']"));
				wait.until(ExpectedConditions.visibilityOfAllElements(orgList));
				for(WebElement ele:orgList) {
					System.out.println(ele.getText());
					if(ele.getText().equals(organizationName)) {
						flag=true;
						ele.click();
						break;
					}
				}
				if(flag==false) {
					throw new Exception();
				}
			break;
			} catch (Exception e) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@title='Next']")).click();
				//Thread.sleep(2000);
			}
	    }
	}
}
