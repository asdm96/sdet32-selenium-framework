package com.crm.autodesk.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtilities.WebDriverUtility;


/**
 * 
 * @author Adarsh M
 *
 */
public class CreateContactPage extends WebDriverUtility{
	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "lastname")
	private WebElement lastNameTF;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement organizationSaluation;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getOrganizationSaluation() {
		return organizationSaluation;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/**
	 * create contact with mandatory fields
	 * @param lastName
	 */
	public void createContact(String lastName) {
		lastNameTF.sendKeys(lastName);
		saveBtn.click();
	}
	public void createContactWithLeadSource(String lastName,String leadSOurce) {
		lastNameTF.sendKeys(lastName);
		selectOption(leadSOurce, leadSourceDropDown);
		saveBtn.click();
	}
}
