package com.crm.autodesk.GenericUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public WebDriver driver=null;
	public FileUtility fUtil = new FileUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	public JavaUtility jUtil = new JavaUtility();
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void bs() {
		System.out.println("data base connection");
	}
	
	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void bt() {
		System.out.println("execute script in parallel mode");
	}
	@Parameters("browser")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void bc(@Optional("chrome")String browserName) throws Throwable {
		//String browserName = fUtil.getPropertyFileData("browser");
		String url=fUtil.getPropertyFileData("url");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			throw new Exception("browser is not compatible");
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void bm() throws Throwable {
		String userName=fUtil.getPropertyFileData("username");
		String password=fUtil.getPropertyFileData("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userName, password);
		
	}
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void am() {
		HomePage homePage = new HomePage(driver);
		homePage.logout(driver);
	}
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void ac() {
		driver.quit();
		
	}
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void at() {
		System.out.println("close parallel mode execution");
		
	}
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void as() {
		System.out.println("close database connection");
		
	}

}
