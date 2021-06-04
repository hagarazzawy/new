package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;

public class BlousesPage extends PageBase{

	static WebDriver driver;
	WebDriverWait wait; 
	
	By FirstBlouse = By.xpath("//*[@class='product-image-container']/a[1]");
	By ProceedToCheckoutButton = By.xpath("//*[@title='Proceed to checkout']");
	By AddToCartButton = By.linkText("Add to cart");
	
	public BlousesPage(WebDriver driver) {
		BlousesPage.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	public void HoverOverFirstBlouse() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstBlouse));
		HoverOverElement(driver, FirstBlouse, "First Blouse");
	}
	
	public void ClickOnAddToCartButton() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCartButton));
		ClickElement_JS(driver, AddToCartButton, "Add To Cart Button");
	}
	
	public void ClickOnProceedToCheckoutButton() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(ProceedToCheckoutButton));
		ClickElement_JS(driver, ProceedToCheckoutButton, "Proceed To Checkout Button");
	}
	
	public boolean CheckProceedToCheckoutButton() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(ProceedToCheckoutButton));
		return driver.findElement(ProceedToCheckoutButton).isDisplayed();
	}
}
