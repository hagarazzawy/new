package Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Logger logger = Logger.getLogger(TestBase.class);
	
	public void OpenBrowser() {		
		logger = Logger.getLogger("Open browser ");
		String URL = "http://automationpractice.com/index.php";
		try {

	
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}
		catch (Exception ex) {
			logger.error("Open browser " + ex.getMessage());
		}
		
		logger.info("Opening Browser ...");
		logger.info("Open URL = " + URL);
		driver.get(URL);
		driver.manage().window().setSize(new Dimension(1024,768));
	}
	
		
	public static void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
		logger.info("Refresh Current Page ");

	}
	
	public static void CloseBrowser() {
			
			logger = Logger.getLogger("Close browser ");
			try {
				driver.quit();
				logger.info("Close Browser ...");
			} catch (Exception ex) {
				logger.error("Close browser " + ex.getMessage());

			}

		}
	
	
	
}
