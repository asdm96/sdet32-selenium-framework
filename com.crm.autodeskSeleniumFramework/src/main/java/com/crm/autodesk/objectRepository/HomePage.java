package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtilities.WebDriverUtility;
/**
 * This is Homepage object repository
 * @author Adarsh M
 *
 */
public class HomePage extends WebDriverUtility {
	//initialization of web element
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//decalartion of web element
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;

	@FindBy(linkText = "Leads")
	private WebElement LeadsLink;

	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutIconImage;

	@FindBy(linkText ="Sign Out")
	private WebElement signOutLink;

	public WebElement getSignOutIconImage() {
		return signOutIconImage;
	}

	//getters method
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	//business logic
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrganization() {
		organizationLink.click();
	}
	/**
	 * This method will click on contact link
	 */
	public void clickOnContactLink() {
		ContactsLink.click();
	}
	/**
	 * This method will logout the application
	 * @param driver
	 */
	public void logout(WebDriver driver) {
	 mouseOver(driver, signOutIconImage);
	 signOutLink.click();
	}



}
