package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object repository for organization Page
 * @author Adarsh M
 *
 */
public class OrganizationPage {
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
    private WebElement addIconImage;

	public WebElement getAddIconImage() {
		return addIconImage;
	}
	
	//business logic
	/**
	 * This method will click on add icon image
	 */
	public void clickOnAddIcon() {
		addIconImage.click();
	}
	
}
