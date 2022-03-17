package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object repository for OrganizationInformation Page
 * @author Adarsh M
 *
 */
public class OrganizationInformationPage {
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationHeaderText;
	
	public WebElement getOrganizationHeaderText() {
		return organizationHeaderText;
	}
	
	//business logic
	/**
	 * This method will return the organization header text
	 * @return
	 */
	public String getOrganizationText() {
		return organizationHeaderText.getText();
	}
}
