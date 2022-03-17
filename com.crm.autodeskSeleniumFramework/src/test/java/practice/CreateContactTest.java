package practice;

import org.testng.annotations.Test;

public class CreateContactTest {
	@Test(groups = "regressionTest")
	public void createcon() {
		
		System.out.println("contact is created");
	}
	@Test(groups = "smokeTest")
	public void createconWithOrg() {
		System.out.println("contact is created using organization");
	}

}
