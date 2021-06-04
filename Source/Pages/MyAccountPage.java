package Pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;


public class MyAccountPage extends PageBase{

	static WebDriver driver;
	WebDriverWait wait;
	
	By WomenSec = By.xpath("//*[@id='block_top_menu']/ul/li[1]/a");
	By BlousesSec = By.linkText("Blouses");
	By signout = By.linkText("Sign out");
	By CategoryName = By.xpath("//span[@class='cat-name']");
	
	public MyAccountPage(WebDriver driver) {
		MyAccountPage.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	public void HoverOverWomenSec() throws AWTException, InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(WomenSec));
		HoverOverElement(driver, WomenSec, "Women Sec");
	}
	
	public void clickonBlouses() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(BlousesSec));
		ClickElement_JS(driver, BlousesSec, "BlousesSec");
	}
	public boolean CheckSignoutButton()  {

		wait.until(ExpectedConditions.visibilityOfElementLocated(signout));
		return driver.findElement(signout).isDisplayed();
	}
	
	public String CheckCategoryName()  {

		wait.until(ExpectedConditions.visibilityOfElementLocated(CategoryName));
		return driver.findElement(CategoryName).getText();
	}
}
