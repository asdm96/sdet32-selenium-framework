package practice;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsTest {
	@Test
	public void demo() {
		
		String name1="ada";
		String name2="adarsh";
		
		int a=10;
		int b=20;
		
		boolean flag=false;
		boolean flag2=true;
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(flag, flag2);
		soft.assertEquals(name1, name2);
		soft.assertAll();
		
	}

}
