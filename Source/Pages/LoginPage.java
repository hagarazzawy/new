package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;

public class LoginPage extends PageBase  {
	
	static WebDriver driver;
	WebDriverWait wait;
	
	By createButton = By.xpath("//*[@id='SubmitCreate']");
	By Email = By.xpath("//*[@id='email_create']");
	By ErrorMessage = By.xpath("//div[@class='alert alert-danger']/ol/li");

	public LoginPage(WebDriver driver) {
		LoginPage.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	public void clickoncreateButton()  {
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(createButton));
		ClickElement(driver, createButton, "create Button");
	}
	
	public void setEmail(String text ) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
		SetElement(driver, Email, text, "Email");

	}
	
	public String getErrorMessage() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessage));
		return driver.findElement(ErrorMessage).getText();
	}

}
