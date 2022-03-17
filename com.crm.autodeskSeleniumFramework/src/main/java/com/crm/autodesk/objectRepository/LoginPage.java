package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//initialization of web elements
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Declaration of web element
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextFiled;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
    
	//getters method to use it in the test script
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextFiled() {
		return passwordTextFiled;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//business logic
	/**
	 * This method will do the login action for application
	 * @param username
	 * @param password
	 */
	public void login(String username,String password) {
		userNameTextField.sendKeys(username);
		passwordTextFiled.sendKeys(password);
		loginButton.click();	
	}
}
