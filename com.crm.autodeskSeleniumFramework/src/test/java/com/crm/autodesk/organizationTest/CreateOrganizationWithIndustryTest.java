package com.crm.autodesk.organizationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.BaseClass;
import com.crm.autodesk.objectRepository.CreateNewOraginzationPage;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.OrganizationInformationPage;
import com.crm.autodesk.objectRepository.OrganizationPage;

public class CreateOrganizationWithIndustryTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createOrganization() throws Throwable{
		System.out.println("create organization with industry execution");
		//getting the data from excel sheet
		String ExpectedOrgName=eUtil.getStringCellData("Sheet1", 1, 2)+jUtil.getRandomNumber();
		String industry=eUtil.getStringCellData("Sheet1", 1, 3);

		HomePage homePage = new HomePage(driver);
		homePage.clickOnOrganization();

		OrganizationPage organizationPage = new OrganizationPage(driver);
		organizationPage.clickOnAddIcon();

		CreateNewOraginzationPage createOrg = new CreateNewOraginzationPage(driver);
		createOrg.createOrganization(ExpectedOrgName,industry);

		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		String actualOrgName=orgInfoPage.getOrganizationText();

		Assert.assertEquals(actualOrgName.contains(ExpectedOrgName), true);

	}

}
