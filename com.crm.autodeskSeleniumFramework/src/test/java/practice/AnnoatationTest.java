package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnoatationTest {
	@BeforeSuite
	public void bs() {
		System.out.println("This is beforesuite");
	}
	@AfterSuite
	public void as() {
		System.out.println("This is aftersuite");
	}
	@BeforeTest
	public void bt() {
		System.out.println("This is beforeTest");
	}
	@BeforeClass
	public void bc() {
		System.out.println("This is beforeclass");
	}
	@BeforeMethod
	public void bm() {
		System.out.println("This is beforemethod");
	}
	@Test
	public void ts1() {
		System.out.println("This is test script 1");
	}
	@Test
	public void ts2() {
		System.out.println("This is test script 2");
	}
	@AfterMethod
	public void am() {
		System.out.println("This is afterMethod");
	}
	@AfterClass
	public void ac() {
		System.out.println("This is afterclass");
	}
	@AfterTest
	public void at() {
		System.out.println("This is aftertest");
	}
	

}
