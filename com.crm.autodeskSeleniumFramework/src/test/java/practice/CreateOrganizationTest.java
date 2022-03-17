package practice;

import org.testng.annotations.Test;

public class CreateOrganizationTest {
	@Test(groups = {"smokeTest","regressionTest"})
	public void createorg() {
		System.out.println("organization is created");
		
	}
	@Test(groups = "regressionTest")
	public void createorgwithindustry() {
		System.out.println("orgainzation is created using industry");
	}

}
