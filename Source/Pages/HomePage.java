package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;

public class HomePage extends PageBase {
	
	static WebDriver driver;
	WebDriverWait wait;
	
	By SigninButton = By.xpath("//*[contains(text(),'Sign in')]");
	
	public HomePage(WebDriver driver) {
		HomePage.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	public void clickonSigninButton() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(SigninButton));
		ClickElement_JS(driver, SigninButton, "Signin Button");
	}

}
