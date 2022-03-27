package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryimpClass {
	@Test(retryAnalyzer =com.crm.autodesk.GenericUtilities.RetryAnalayzerImplemetationClass.class)
	public void create() {
		System.out.println("retry");
		Assert.assertEquals(false, true);
	}

}
