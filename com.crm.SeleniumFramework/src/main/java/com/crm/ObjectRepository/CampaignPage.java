package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {


	//Initialization
	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(xpath="//img[@alt=\"Create Campaign...\"]")
	private WebElement createCampaign;

	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignName;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement saveBtn;

	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement verfTitle;

	@FindBy(xpath="//img[@style=\"cursor:hand;cursor:pointer\"]")
	private WebElement addProd;

	@FindBy(id="search_txt")
	private WebElement enterTxt;

	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchBtn;

	@FindBy(xpath="//a[@href=\'javascript:window.close();\']")
	private WebElement selectFirstOption;

	public WebElement getCreateCampaign() {
		return createCampaign;
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getVerfTitle() {
		return verfTitle;
	}
	
	public WebElement getAddProd() {
		return addProd;
	}

	public WebElement getEnterTxt() {
		return enterTxt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSelectFirstOption() {
		return selectFirstOption;
	}

	//Business Logic
	public void campaignCreation() {
		createCampaign.click();
	}

	public void campaignNameTextField(String data) {
		campaignName.sendKeys(data);
	}

	public void clickSaveButton() {
		saveBtn.click();
	}

	public void titleVerification(String data) {
		String title = verfTitle.getText();
		if(title.contains(data)) {
			System.out.println("Campaign Created");
		}
		else {
			System.out.println("Campaign Not Created");
		}
	}
	
	public void clickAddProduct() {
		addProd.click();
	}
	
	public void enterProdName(String data) {
		enterTxt.sendKeys(data);
	}
	
	public void clickProdSearchButton() {
		searchBtn.click();
	}
	
	public void selectProdOption() {
		selectFirstOption.click();
	}
}
