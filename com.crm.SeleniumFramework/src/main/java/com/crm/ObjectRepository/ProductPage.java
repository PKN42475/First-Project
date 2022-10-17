package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	//Initialization
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//img[@title=\'Create Product...\']")
	private WebElement createPro;
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement proName;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//span[@class=\'lvtHeaderText\']")
	private WebElement verifyTitle;
	
	@FindBy(xpath="//input[@name='Delete']")
	private WebElement proDeletion;
	
	public WebElement getCreatePro() {
		return createPro;
	}

	public WebElement getProName() {
		return proName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getVerifyTitle() {
		return verifyTitle;
	}
	
	public WebElement getproDeletion() {
		return proDeletion;
	}
	
	//Business Logics
	public void productCreation() {
		createPro.click();
	}
	
	public void productName(String data) {
		proName.sendKeys(data);
	}
	
	public void clickSaveButton() {
		saveBtn.click();
	}
	
	public void titleVerification(String data) {
		String text = verifyTitle.getText();
		if(text.contains(data)) {
			System.out.println("Product Created");
		}
		else {
			System.out.println("Producted Not Created");
		}
	}
	
	public void deleteProduct() {
		proDeletion.click();
		System.out.println("Product Deleted");
	}
}
