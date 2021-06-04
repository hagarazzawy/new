package Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class PageBase {
	public static Logger logger = Logger.getLogger(PageBase.class);

	public Boolean ElementIsDisplayed(WebDriver driver, By element_locator, String element_log) {
		logger = Logger.getLogger("Check Element is displayed");

		try {
			driver.findElement(element_locator).isDisplayed();
			logger.info(element_log + " is Displayed successfully");
			return true;

		} catch (Exception e) {
			logger.error(element_log + " is not Displayed");

			return false;
		}
	}
	
	public void ClickElement_JS(WebDriver driver, By element_locator, String element_log) {
		logger = Logger.getLogger("Click Element");
		Boolean flag = ElementIsDisplayed(driver, element_locator, element_log);
		if (flag == true) {
			WebElement element = driver.findElement(element_locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			logger.info("click on " + element_log);
		} else {
			logger.error("Can't Click on " + element_log);
		}
}
	public void ClickElement(WebDriver driver, By element_locator, String element_log) {
		logger = Logger.getLogger("Click Element ");
		Boolean flag = ElementIsDisplayed(driver, element_locator, element_log);
		if (flag == true) {
			WebElement element = driver.findElement(element_locator);
			element.click();
			logger.info("Click on " + element_log);
		} else {
			logger.error("Cannot Click on " + element_log);
		}
	}
	
	public void SetElement(WebDriver driver, By element_locator, String value, String element_log) {
		logger = Logger.getLogger("Set Element Text");
		
		Boolean Flag_element = ElementIsDisplayed(driver, element_locator, element_log);
		try {
			if (Flag_element == true) {
				WebElement element = driver.findElement(element_locator);
				element.clear();
				element.sendKeys(value);
				logger.info("Set " + element_log + " : " + value);
			} else {
				logger.error("Can't Set Element :" + element_log);
			}
		} catch (Exception e) {
			logger.error("Can't Set Element :" + element_log);
		}

	}
	
	public void SelectItemFromList(WebDriver driver, By element_locator, String value, String element_log) {
		logger = Logger.getLogger("Select Item from List");
		ClickElement_JS(driver, element_locator, element_log);
		try {
			new Select(driver.findElement(element_locator)).selectByVisibleText(value);
			logger.info("Select " + element_log + " :  " + value);
		} catch (Exception e) {
			logger.error(" Cannot find element in list with text  : " + value);

		}
	}
	
	public void HoverOverElement(WebDriver driver, By element_locator, String element_log) {
		logger = Logger.getLogger("Hover Element ");
		WebElement element = driver.findElement(element_locator);
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			logger.info("Hover element " + element_log);
		} catch (Exception ex) {
			logger.error("Can't Hover element " + element_log + " due to exception " + ex.getMessage());
		}
	}
	
	public void ScrollDown() throws AWTException, InterruptedException  {
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_DOWN);
	    Thread.sleep(1000);
	    robot.keyRelease(KeyEvent.VK_DOWN);
	    Thread.sleep(1000);   
		logger.info("Scroll down");
	}
//	
//	public void ScrollDownToHalfPage(WebDriver driver) throws AWTException {
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollTo(0, document.body.scrollHeight / 2)");
//		logger.info("Scroll down to half of the page");
//	}
//	
//	public void Scroll250(WebDriver driver) {
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("scroll(0, 250);");
//		logger.info("Scroll");
//	}
//	
//	public void PressEnter() throws AWTException, InterruptedException {
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
//	    robot.keyRelease(KeyEvent.VK_ENTER);
//
//		logger.info("Press Enter");
//	}
//	
	public void PressTab() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
	    robot.keyRelease(KeyEvent.VK_TAB);

		logger.info("Press Tab");
	}
	
}
