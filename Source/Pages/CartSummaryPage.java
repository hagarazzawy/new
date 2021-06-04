package Pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;

public class CartSummaryPage extends PageBase{

	static WebDriver driver;
	WebDriverWait wait; 
	
	By ProceedToCheckoutButton = By.xpath("//*[text()='Proceed to checkout']");
	By CheckoutButton = By.linkText("Check out");
	By ProceedToCheckoutButton2 = By.xpath("//*[@name='processAddress']");
	By ProceedToCheckoutButton3 = By.xpath("//*[@name='processCarrier']");
	By TermsCheckBox = By.xpath("//input[@id='cgv']");
	By BankWire = By.xpath("//*[@class='bankwire']");
	By Check = By.xpath("//*[@class='cheque']");
	By ConfirmOrderButton = By.xpath("//*[text()='I confirm my order']");
	By SuccessOrderMessage_Bank = By.xpath("//*[@class='cheque-indent']//strong");
	By SuccessOrderMessage_Check = By.xpath("//*[@class='alert alert-success']");
	By AddressComment = By.xpath("//textarea");
	By OrdersHistoryButton = By.linkText("Back to orders");
	By Terms = By.linkText("(Read the Terms of Service)");
	By CloseTerms = By.xpath("//a[@class='fancybox-item fancybox-close']");
	By ErrorMessage = By.xpath("//*[@class='fancybox-error']");
	By CloseErrorButton = By.xpath("//*[@class='fancybox-item fancybox-close']");
	By CartMenu = By.partialLinkText("Cart");
	
		
	public CartSummaryPage(WebDriver driver) {
		CartSummaryPage.driver = driver;
		wait = new WebDriverWait(driver, 30);
	} 
	
	public void ClickOnCartMenu() throws AWTException, InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(CartMenu));
		ClickElement_JS(driver, CartMenu, "Cart Menu");
	}

	public void ClickOnProceedToCheckoutButton() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(ProceedToCheckoutButton));
		ClickElement_JS(driver, ProceedToCheckoutButton, "Proceed To Checkout Button");
	}
	
	public void ClickOnCheckoutButton() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutButton));
		ClickElement_JS(driver, CheckoutButton, "Checkout Button");
	}
	
	public void ClickOnProceedToCheckoutButton2() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(ProceedToCheckoutButton2));
		ClickElement_JS(driver, ProceedToCheckoutButton2, "Proceed To Checkout Button 2");
	}
	
	public void ClickOnProceedToCheckoutButton3() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(ProceedToCheckoutButton3));
		ClickElement_JS(driver, ProceedToCheckoutButton3, "Proceed To Checkout Button 3");
	}
	
	public void ClickOnCloseErrorButton() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(CloseErrorButton));
		ClickElement_JS(driver, CloseErrorButton, "Close Error Message");
	}
	public void ClickOnTermsCheckBox() {

		ClickElement(driver, TermsCheckBox, "Terms Check Box");
	}
	
	public void ReadTerms() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(Terms));
		ClickElement(driver, Terms, "Terms ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(CloseTerms));
		ClickElement(driver, CloseTerms, "Close Terms ");
	}
	
	public void setAddressComment(String text) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(AddressComment));
		SetElement(driver, AddressComment, text, "Address Comment");
	}

	public void ClickOnBankWire() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(BankWire));
		ClickElement_JS(driver, BankWire, "BankWire");
	}
	
	public void ClickOnCheck() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(Check));
		ClickElement_JS(driver, Check, "Check");
	}
	
	public void ClickOnConfirmOrderButton() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmOrderButton));
		ClickElement_JS(driver, ConfirmOrderButton, "Confirm Order Button");
	}
	
	public String getSuccessOrderMessage_Bank (){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessOrderMessage_Bank));
		return driver.findElement(SuccessOrderMessage_Bank).getText();
	}
	
	public String getSuccessOrderMessage_Check (){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessOrderMessage_Check));
		return driver.findElement(SuccessOrderMessage_Check).getText();
	}
	
	public String getErrorMessage (){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessage));
		return driver.findElement(ErrorMessage).getText();
	}
	
	public void ClickOnOrdersHistoryButton() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(OrdersHistoryButton));
		ClickElement_JS(driver, OrdersHistoryButton, "Orders History Button");
	}
	
}
