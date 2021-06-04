package TestCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.BlousesPage;
import Pages.CartSummaryPage;
import Pages.CreateAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.OrdersHistoryPage;
import TestData.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.awt.AWTException;


public class PlaceOrder_TCs extends TestBase {

	LoginPage loginpPageOBJ;
	HomePage homePageOBJ;
	CreateAccountPage createAccountPageOBJ;
	MyAccountPage myAccountPageOBJ;
	BlousesPage blousesPageOBJ;
	CartSummaryPage cartSummaryPageOBJ;
	OrdersHistoryPage ordersHistoryPageOBJ;
	String Email= RandomStringUtils.randomAlphabetic(8)+"@gmail.com";

	@BeforeClass
	public void beforeMethod() throws InterruptedException {

		OpenBrowser();
		loginpPageOBJ = new LoginPage(driver);
		homePageOBJ = new HomePage(driver);
		createAccountPageOBJ = new CreateAccountPage(driver);
		myAccountPageOBJ = new MyAccountPage(driver);
		blousesPageOBJ = new BlousesPage(driver);
		cartSummaryPageOBJ = new CartSummaryPage(driver);
		ordersHistoryPageOBJ = new OrdersHistoryPage(driver);

	}

	@Severity(SeverityLevel.BLOCKER)
	@Description("Create account with valid data")
	@Test(priority = 1, dataProvider = "createNewAccount_dataProvider")
	public void createNewAccount( String FirstName, String LastName, String Password, String Address,
			String City, String PostCode, String Mobile, String State) throws InterruptedException, AWTException {

		logger.info("============== TestCase 1 -  Start ==============");
		homePageOBJ.clickonSigninButton();
		loginpPageOBJ.setEmail(Email);
		loginpPageOBJ.clickoncreateButton();
		createAccountPageOBJ.createNewAccount(FirstName, LastName, Password, Address, City, PostCode, Mobile, State);
		createAccountPageOBJ.clickonRegisterButton();
		Assert.assertTrue(myAccountPageOBJ.CheckSignoutButton());
		logger.info("============== TestCase 1 -  End ==============");

	}

	@DataProvider
	public Object[][] createNewAccount_dataProvider() throws Exception {

		Object[][] testObjArray = TestData.fetchData("createNewAccount");

		return (testObjArray);
	}

	@Description("Place an order Without Terms Check")
	@Test(priority = 2 , dataProvider = "PlaceorderWithoutTermsCheck_dataProvider")
	public void PlaceorderWithoutTermsCheck(String Error) throws AWTException, InterruptedException {
		
		logger.info("============== TestCase 2 -  Start ==============");
		myAccountPageOBJ.HoverOverWomenSec();
		myAccountPageOBJ.clickonBlouses();
		Assert.assertEquals(myAccountPageOBJ.CheckCategoryName(), "BLOUSES ");

		blousesPageOBJ.HoverOverFirstBlouse();
		blousesPageOBJ.ClickOnAddToCartButton();
		Assert.assertTrue(blousesPageOBJ.CheckProceedToCheckoutButton());

		blousesPageOBJ.ClickOnProceedToCheckoutButton();
		cartSummaryPageOBJ.ClickOnProceedToCheckoutButton();
		cartSummaryPageOBJ.setAddressComment("2nd floor");
		cartSummaryPageOBJ.ClickOnProceedToCheckoutButton2();
		cartSummaryPageOBJ.ClickOnProceedToCheckoutButton3();
		Assert.assertEquals(cartSummaryPageOBJ.getErrorMessage(), Error);
		cartSummaryPageOBJ.ClickOnCloseErrorButton();

		logger.info("============== TestCase 2 -  End ==============");

	}
	
	@DataProvider
	public Object[][] PlaceorderWithoutTermsCheck_dataProvider() throws Exception {

		Object[][] testObjArray = TestData.fetchData("PlaceOrderWithoutTermsCheck");

		return (testObjArray);
	}
	
	@Description("Place an order successfully and payment by bank wire")
	@Test(priority = 3 , dataProvider = "BuyBlouse_dataProvider")
	public void BuyBlouse_BankWire(String SuccessMessage) throws AWTException, InterruptedException {
		
		logger.info("============== TestCase 3 -  Start ==============");
		cartSummaryPageOBJ.ClickOnCartMenu();
		cartSummaryPageOBJ.ClickOnProceedToCheckoutButton();
		cartSummaryPageOBJ.ClickOnProceedToCheckoutButton2();
		cartSummaryPageOBJ.ReadTerms();
		cartSummaryPageOBJ.ClickOnTermsCheckBox();
		cartSummaryPageOBJ.ClickOnProceedToCheckoutButton3();
		cartSummaryPageOBJ.ClickOnBankWire();
		cartSummaryPageOBJ.ClickOnConfirmOrderButton();
		Assert.assertEquals(cartSummaryPageOBJ.getSuccessOrderMessage_Bank(), SuccessMessage);
		
		cartSummaryPageOBJ.ClickOnOrdersHistoryButton();
		Assert.assertFalse(ordersHistoryPageOBJ.CheckErrorMessage());
		logger.info("============== TestCase 3 -  End ==============");

	}
	
	 @DataProvider
		public Object[][] BuyBlouse_dataProvider() throws Exception {

			Object[][] testObjArray = TestData.fetchData("BuyABlouse");

			return (testObjArray);
		}

		@Description("Place an order successfully and payment by Check")
		@Test(priority = 4 , dataProvider = "BuyBlouse_dataProvider")
		public void BuyBlouse_Check(String SuccessMessage) throws AWTException, InterruptedException {
			
			logger.info("============== TestCase 4 -  Start ==============");
			myAccountPageOBJ.HoverOverWomenSec();
			myAccountPageOBJ.clickonBlouses();
			Assert.assertEquals(myAccountPageOBJ.CheckCategoryName(), "BLOUSES ");

			blousesPageOBJ.HoverOverFirstBlouse();
			blousesPageOBJ.ClickOnAddToCartButton();
			Assert.assertTrue(blousesPageOBJ.CheckProceedToCheckoutButton());

			blousesPageOBJ.ClickOnProceedToCheckoutButton();
			cartSummaryPageOBJ.ClickOnProceedToCheckoutButton();
			cartSummaryPageOBJ.setAddressComment("2nd floor");
			cartSummaryPageOBJ.ClickOnProceedToCheckoutButton2();
			cartSummaryPageOBJ.ReadTerms();
			cartSummaryPageOBJ.ClickOnTermsCheckBox();
			cartSummaryPageOBJ.ClickOnProceedToCheckoutButton3();
			cartSummaryPageOBJ.ClickOnCheck();
			cartSummaryPageOBJ.ClickOnConfirmOrderButton();
			Assert.assertEquals(cartSummaryPageOBJ.getSuccessOrderMessage_Check(), SuccessMessage);
			
			cartSummaryPageOBJ.ClickOnOrdersHistoryButton();
			Assert.assertFalse(ordersHistoryPageOBJ.CheckErrorMessage());
			
			logger.info("============== TestCase 4 -  End ==============");

		}
		
	@AfterClass
	public void afterMethod() {
		CloseBrowser();
	}
}
