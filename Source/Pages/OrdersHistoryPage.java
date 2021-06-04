package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;


public class OrdersHistoryPage extends PageBase{

	static WebDriver driver;
	WebDriverWait wait; 
		
	By ErrorMessage = By.xpath("//*[@class='alert alert-warning']");
	
	public OrdersHistoryPage(WebDriver driver) {
		OrdersHistoryPage.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	public boolean CheckErrorMessage()  {

		try {
	        driver.findElement(ErrorMessage);
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }	}
}
