package Pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;


public class CreateAccountPage extends PageBase{

	static WebDriver driver;
	WebDriverWait wait;
	
	By FirstName = By.xpath("//*[@id='customer_firstname']");
	By LastName = By.xpath("//*[@id='customer_lastname']");
	By Password = By.xpath("//*[@id='passwd']");
	By Address = By.xpath("//*[@id='address1']");
	By City = By.xpath("//*[@id='city']");
	By PostCode = By.xpath("//*[@id='postcode']");
	By Mobile = By.xpath("//*[@id='phone_mobile']");
	By RegisterButton = By.xpath("//*[@id='submitAccount']");
	By StateDropDownList = By.xpath("//*[@id='id_state']");
	By CountryDropDownList = By.xpath("//*[@id='id_country']");
	By ErrorMessage = By.xpath("//div[@class='alert alert-danger']/ol/li");
	
	public CreateAccountPage(WebDriver driver) {
		CreateAccountPage.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	public void clickonRegisterButton() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterButton));
		ClickElement_JS(driver, RegisterButton, "Register Button");
	}
	
	
	public void createNewAccount (String FirstName_text ,String LastName_text , String Password_text , String Address_text , String City_text , String PostCode_text , String Mobile_text ,String State_text ) throws InterruptedException, AWTException 
	{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName));
		SetElement(driver, FirstName, FirstName_text, "FirstName");
		wait.until(ExpectedConditions.visibilityOfElementLocated(LastName));
		SetElement(driver, LastName, LastName_text, "LastName");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
		SetElement(driver, Password, Password_text, "Password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Address));
		SetElement(driver, Address, Address_text, "Address");
		wait.until(ExpectedConditions.visibilityOfElementLocated(City));
		SetElement(driver, City, City_text, "City");
		selectState();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(StateDropDownList));
//		SelectItemFromList(driver, StateDropDownList, State_text, "State DropDown List");
		wait.until(ExpectedConditions.visibilityOfElementLocated(PostCode));
		SetElement(driver, PostCode, PostCode_text, "PostCode");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Mobile));
		SetElement(driver, Mobile, Mobile_text, "Mobile");

	}
	public void setFirstName(String text) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName));
		SetElement(driver, FirstName, text, "FirstName");
	}
	
	
	public void setLastName(String text) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(LastName));
		SetElement(driver, LastName, text, "LastName");
	}
	public void setPassword(String text) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
		SetElement(driver, Password, text, "Password");
	}
	
	public void setAddress(String text) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(Address));
		SetElement(driver, Address, text, "Address");
	}
	
	public void setCity(String text) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(City));
		SetElement(driver, City, text, "City");
	}
	
	public void setPostCode(String text) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(PostCode));
		SetElement(driver, PostCode, text, "PostCode");
	}
	
	public void setMobile(String text) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(Mobile));
		SetElement(driver, Mobile, text, "Mobile");
	}
	
	public String getErrorMessage() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessage));
		return driver.findElement(ErrorMessage).getText();
	}
	
	public void selectState() throws AWTException, InterruptedException {
//	public void selectState(String text) {	
//		wait.until(ExpectedConditions.visibilityOfElementLocated(StateDropDownList));
//		SelectItemFromList(driver, StateDropDownList, text, "State DropDown List");
		
		PressTab();
		ScrollDown();
	}
	

}
