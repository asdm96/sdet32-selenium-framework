package com.crm.autodesk.contactTest;

import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.BaseClass;
import com.crm.autodesk.GenericUtilities.IPathConstants;
import com.crm.autodesk.objectRepository.ContactInformationPage;
import com.crm.autodesk.objectRepository.ContactPage;
import com.crm.autodesk.objectRepository.CreateContactPage;
import com.crm.autodesk.objectRepository.HomePage;


/**
 * 
 * @author Adarsh M
 *
 */

public class CreateContactTest extends BaseClass{
	@Test(groups = {"smokeTest","regressionTest"})
	public void createConctact() throws Throwable{

		//excel sheet data
		String lastName = eUtil.getStringCellData(IPathConstants.SHEET_NAME, 5, 2)+jUtil.getRandomNumber();
       
		//create contact
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContactLink();
		ContactPage contact = new ContactPage(driver);
		contact.clickOnCreateContactIMG();

		CreateContactPage createContact = new CreateContactPage(driver);
		createContact.createContact(lastName);

		ContactInformationPage contactInfo = new ContactInformationPage(driver);
		String contactText = contactInfo.getContactText();

		
		//verification using hard assertions
		//Assert.assertEquals(contactText.contains(lastName), true);
	}

	@Test(groups = {"regressionTest"})
	public void createContactWithLeadSource() throws Throwable {

		//excel sheet data
		String lastName = eUtil.getStringCellData(IPathConstants.SHEET_NAME, 7, 2)+jUtil.getRandomNumber();
		String leadSource=eUtil.getStringCellData(IPathConstants.SHEET_NAME, 7, 3);
		//create contact
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContactLink();
		ContactPage contact = new ContactPage(driver);
		contact.clickOnCreateContactIMG();

		CreateContactPage createContact = new CreateContactPage(driver);
		createContact.createContactWithLeadSource(lastName,leadSource );
		
		ContactInformationPage contactInfo = new ContactInformationPage(driver);
		String contactText = contactInfo.getContactText();

		//verification
		//Assert.assertEquals(contactText.contains(lastName), true);
		
	}
}




