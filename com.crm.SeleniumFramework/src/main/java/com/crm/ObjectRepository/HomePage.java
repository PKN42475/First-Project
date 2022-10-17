package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(linkText="Organizations")
	private WebElement clickOrg;
	
	@FindBy(linkText="Products")
	private WebElement clickProduct;
	
	@FindBy(xpath="//a[text()=\"More\"]")
	private WebElement clickMore;
	
	@FindBy(xpath="//a[@name=\"Campaigns\"]")
	private WebElement clickCampaign;

	@FindBy(xpath="//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")
	private WebElement userButton;

	@FindBy(xpath="//a[text()=\"Sign Out\"]")
	private WebElement signOutButton;

	public WebElement getClickOrg() {
		return clickOrg;
	}

	public WebElement getUserButton() {
		return userButton;
	}

	public WebElement getSignOutButton() {
		return signOutButton;
	}

	public WebElement getClickProduct() {
		return clickProduct;
	}

	public WebElement getClickMore() {
		return clickMore;
	}

	public WebElement getClickCampaign() {
		return clickCampaign;
	}

	//Business Logics
	/**
	 * This method is used to handle Home Page
	 * @param data
	 */
	public void clickOnOrganization() {
		clickOrg.click();
	}
	
	public void clickOnProduct() {
		clickProduct.click();
	}
	
	public void clickOnMore() {
		clickMore.click();
	}
	
	public void clickOnCampaign() {
		clickCampaign.click();
	}
	
	public void signOut() {
		userButton.click();
		signOutButton.click();
	}
}