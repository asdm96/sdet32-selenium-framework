package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtilities.WebDriverUtility;
/**
 * Object repository for CreateNewOraginzation Page
 * @author Adarsh M
 *
 */
public class CreateNewOraginzationPage extends WebDriverUtility {
	public CreateNewOraginzationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//business logic
	/**
	 * This method is used to create organization with industry
	 * @param organizationName
	 * @param dropDownValue
	 */
	public void createOrganization(String organizationName,String dropDownValue) {
		organizationNameTextField.sendKeys(organizationName);
		selectOption(dropDownValue, industryDropDown);
		saveButton.click();
		
	}
	/**
	 * Method will craete organization with one parameter
	 * @param organizationName
	 */
	public void createOrganization(String organizationName) {
		organizationNameTextField.sendKeys(organizationName);
		saveButton.click();
		
	}

	

}
