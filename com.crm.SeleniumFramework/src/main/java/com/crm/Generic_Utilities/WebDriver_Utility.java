package com.crm.Generic_Utilities;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
	/**
	 * This method is used for Implicit Wait
	 * @param driver
	 * @author pavan
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void scriptTimeOut(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}

	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement Element, int poolintTime) {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}

	/**
	 * This method is used to handle Switch to window
	 * @param driver
	 * @param PartialWindowTitle
	 * @author pavan
	 */
	public void switchToWindow(WebDriver driver, String PartialWindowTitle) {
		Set<String> allId = driver.getWindowHandles();
		java.util.Iterator<String> it = allId.iterator();
		while(it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(PartialWindowTitle)) {
				break;
			}
		}
	}

	/**
	 * This method is used for Explicit Wait
	 * @param driver
	 * @author pavan
	 */
	public void waitForElement(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
	}

	/**
	 * This method is used for Right Click(Context Click)
	 * @param driver
	 * @param element
	 * @author pavan
	 */
	public void mouseActionsContextCLick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	/**
	 * This method is used for Drag & Drop
	 * @param driver
	 * @param source
	 * @param target
	 * @author pavan
	 */
	public void mouseActionsDragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	/**
	 * This method is used for Double Click
	 * @param driver
	 * @param element
	 * @author pavan
	 */
	public void mouseActionsDoubleClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	/**
	 * This method is used for Mouse Hover
	 * @param driver
	 * @param element
	 * @author pavan
	 */
	public void mouseActionsMouseHover(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	/**
	 * This method is used to select the List Box with Index
	 * @param element
	 * @param index
	 * @author pavan
	 */
	public void listBoxSelectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * This method is used to select the List Box with Value
	 * @param element
	 * @param text
	 * @author pavan
	 */
	public void listBoxSelectByValue(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByValue(text);
	}

	/**
	 * This method is used to select the List Box with Visible Text
	 * @param element
	 * @param text
	 * @author pavan
	 */
	public void listBoxSelectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * This method is used handle Alert Pop Up Accept
	 * @param driver
	 * @author pavan
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to handle Alert pop up Dismiss
	 * @param driver
	 * @author pavan
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to handle Frames
	 * @param driver
	 * @param index
	 * @author pavan
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to handle Frames
	 * @param driver
	 * @param index
	 * @author pavan
	 */
	public void switchToFrame(WebDriver driver, String id_name_Attribute) {
		driver.switchTo().frame(id_name_Attribute);
	}

	/**
	 * This method is used to Take Screenshot
	 * @param sDriver
	 * @param methodName
	 * @return
	 * @author pavan
	 */
	public String takeScreenshot(WebDriver sDriver, String methodName) {
		return null;
	}
}
