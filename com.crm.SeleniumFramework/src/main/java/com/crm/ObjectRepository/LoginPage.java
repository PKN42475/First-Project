package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Initialization
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(name="user_name")
	private WebElement userNameTextBox;

	@FindBy(name="user_password")
	private WebElement passwordTextBox;

	@FindBy(id="submitButton")
	private WebElement submitButton;

	public WebElement getUserNameTextBox() {
		return userNameTextBox;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	//Business Logics
	/**
	 * This method is used to login to the page
	 * @param userName
	 * @param Password
	 */
	public void login(String userName, String Password) {
		userNameTextBox.sendKeys(userName);
		passwordTextBox.sendKeys(Password);
		submitButton.click();
	}
}
