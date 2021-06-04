package TestCases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CreateAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import TestData.TestData;
import io.qameta.allure.Description;

public class CreateAccount_NegativeTCs extends TestBase {
	
	LoginPage loginpPageOBJ;
	HomePage homePageOBJ;
	CreateAccountPage createAccountPageOBJ;
	MyAccountPage myAccountPageOBJ;
	
	String Email= RandomStringUtils.randomAlphabetic(8)+"@gmail.com";

	
	@BeforeClass
	public void beforeMethod() throws InterruptedException {

		OpenBrowser();
		loginpPageOBJ = new LoginPage(driver);
		homePageOBJ = new HomePage(driver);
		createAccountPageOBJ = new CreateAccountPage(driver);
		myAccountPageOBJ = new MyAccountPage(driver);
		
	}
	
	 @Description("Create account with previously added email")
	 @Test(priority = 1, dataProvider = "createNewAccount_InvalidEmail_dataProvider")
	  public void createNewAccount_InvalidEmail( String Email , String Error) throws InterruptedException, AWTException  {
		  
		  logger.info("============== TestCase 1 -  Start ==============");
		  homePageOBJ.clickonSigninButton();
		  loginpPageOBJ.setEmail(Email);
		  loginpPageOBJ.clickoncreateButton();
		  Assert.assertEquals(loginpPageOBJ.getErrorMessage(), Error);	
		  logger.info("============== TestCase 1 -  End ==============");
	  }
	  
	  @DataProvider
		public Object[][] createNewAccount_InvalidEmail_dataProvider() throws Exception {

			Object[][] testObjArray = TestData.fetchData("CreateNewAccount_InvalidEmail");

			return (testObjArray);
		}
	
	  @Description("Create account with empty Firstname field")
	  @Test(priority = 2, dataProvider = "createNewAccount_EmptyFirstname_dataProvider")
	  public void createNewAccount_EmptyFirstname( String LastName,String Password,String Address,String City,String PostCode,String Mobile,String State ,String Error) throws InterruptedException, AWTException  {
		  
		  logger.info("============== TestCase 2 -  Start ==============");
		//homePageOBJ.clickonSigninButton();
		  loginpPageOBJ.setEmail(Email);
		  loginpPageOBJ.clickoncreateButton();
		  createAccountPageOBJ.setLastName(LastName);
		  createAccountPageOBJ.setPassword(Password);
		  createAccountPageOBJ.setAddress(Address);
		  createAccountPageOBJ.setCity(City);
		  createAccountPageOBJ.selectState();
		  createAccountPageOBJ.setPostCode(PostCode);
		  createAccountPageOBJ.setMobile(Mobile);
		  createAccountPageOBJ.clickonRegisterButton();
		  Assert.assertEquals(createAccountPageOBJ.getErrorMessage(), Error);
		  logger.info("============== TestCase 2 -  End ==============");
		  
	  }
	  
	  @DataProvider
		public Object[][] createNewAccount_EmptyFirstname_dataProvider() throws Exception {

			Object[][] testObjArray = TestData.fetchData("CreateNewAccount_EmptyFirstname");

			return (testObjArray);
		}
	  
	  @Description("Create account with empty Lastname field")
	  @Test(priority = 3, dataProvider = "createNewAccount_EmptyLastname_dataProvider")
	  public void createNewAccount_EmptyLastname( String FirstName,String Password,String Address,String City,String PostCode,String Mobile,String State ,String Error) throws InterruptedException, AWTException  {
		  
		  logger.info("============== TestCase 3 -  Start ==============");
		  homePageOBJ.clickonSigninButton();
		  loginpPageOBJ.setEmail(Email);	
		  loginpPageOBJ.clickoncreateButton();
		  createAccountPageOBJ.setFirstName(FirstName);
		  createAccountPageOBJ.setPassword(Password);
		  createAccountPageOBJ.setAddress(Address);
		  createAccountPageOBJ.setCity(City);
		  createAccountPageOBJ.selectState();
		  createAccountPageOBJ.setPostCode(PostCode);
		  createAccountPageOBJ.setMobile(Mobile);
		  createAccountPageOBJ.clickonRegisterButton();
		  Assert.assertEquals(createAccountPageOBJ.getErrorMessage(), Error);
		  logger.info("============== TestCase 3 -  End ==============");
	  }
	  
	  @DataProvider
		public Object[][] createNewAccount_EmptyLastname_dataProvider() throws Exception {

			Object[][] testObjArray = TestData.fetchData("CreateNewAccount_EmptyLastname");

			return (testObjArray);
		}
	  
	  @Description("Create account with empty password field")
	  @Test(priority = 4, dataProvider = "createNewAccount_EmptyPassword_dataProvider")
	  public void createNewAccount_EmptyPassword( String FirstName,String LastName,String Address,String City,String PostCode,String Mobile,String State ,String Error) throws InterruptedException, AWTException  {
		  
		  logger.info("============== TestCase 4 -  Start ==============");
		  homePageOBJ.clickonSigninButton();
		  loginpPageOBJ.setEmail(Email);
		  loginpPageOBJ.clickoncreateButton();
		  createAccountPageOBJ.setFirstName(FirstName);
		  createAccountPageOBJ.setLastName(LastName);
		  createAccountPageOBJ.setAddress(Address);
		  createAccountPageOBJ.setCity(City);
		  createAccountPageOBJ.selectState();
		  createAccountPageOBJ.setPostCode(PostCode);
		  createAccountPageOBJ.setMobile(Mobile);
		  createAccountPageOBJ.clickonRegisterButton();
		  Assert.assertEquals(createAccountPageOBJ.getErrorMessage(), Error);	
		  logger.info("============== TestCase 4 -  End ==============");
	  }
	  
	  @DataProvider
		public Object[][] createNewAccount_EmptyPassword_dataProvider() throws Exception {

			Object[][] testObjArray = TestData.fetchData("CreateNewAccount_EmptyPassword");

			return (testObjArray);
		}
	  
	  @Description("Create account with empty address field")
	  @Test(priority = 5, dataProvider = "createNewAccount_EmptyAddress_dataProvider")
	  public void createNewAccount_EmptyAddress( String FirstName,String LastName,String Password,String City,String PostCode,String Mobile,String State,String Error ) throws InterruptedException, AWTException  {
		  
		  logger.info("============== TestCase 5 -  Start ==============");
		  homePageOBJ.clickonSigninButton();
		  loginpPageOBJ.setEmail(Email);
		  loginpPageOBJ.clickoncreateButton();
		  createAccountPageOBJ.setFirstName(FirstName);
		  createAccountPageOBJ.setLastName(LastName);
		  createAccountPageOBJ.setPassword(Password);
		  createAccountPageOBJ.setCity(City);
		  createAccountPageOBJ.selectState();
		  createAccountPageOBJ.setPostCode(PostCode);
		  createAccountPageOBJ.setMobile(Mobile);
		  createAccountPageOBJ.clickonRegisterButton();
		  Assert.assertEquals(createAccountPageOBJ.getErrorMessage(), Error);
		  logger.info("============== TestCase 5 -  End ==============");
	  }
	  
	  @DataProvider
		public Object[][] createNewAccount_EmptyAddress_dataProvider() throws Exception {

			Object[][] testObjArray = TestData.fetchData("CreateNewAccount_EmptyAddress");

			return (testObjArray);
		}
	  
	  @Description("Create account with empty mobile field")
	  @Test(priority = 6, dataProvider = "createNewAccount_EmptyMobile_dataProvider")
	  public void createNewAccount_EmptyMobile( String FirstName,String LastName,String Password,String Address ,String City,String PostCode,String State ,String Error) throws InterruptedException, AWTException  {
		  
		  logger.info("============== TestCase 6 -  Start ==============");
		  homePageOBJ.clickonSigninButton();
		  loginpPageOBJ.setEmail(Email);
		  loginpPageOBJ.clickoncreateButton();
		  createAccountPageOBJ.setFirstName(FirstName);
		  createAccountPageOBJ.setLastName(LastName);
		  createAccountPageOBJ.setPassword(Password);
		  createAccountPageOBJ.setAddress(Address);
		  createAccountPageOBJ.setCity(City);
		  createAccountPageOBJ.selectState();
		  createAccountPageOBJ.setPostCode(PostCode);
		  createAccountPageOBJ.clickonRegisterButton();
		  Assert.assertEquals(createAccountPageOBJ.getErrorMessage(), Error);	
		  logger.info("============== TestCase 6 -  End ==============");
	  }
	  
	  @DataProvider
		public Object[][] createNewAccount_EmptyMobile_dataProvider() throws Exception {

			Object[][] testObjArray = TestData.fetchData("CreateNewAccount_EmptyMobile");

			return (testObjArray);
		}
	  
	  @Description("Create account with empty postcode field")
	  @Test(priority = 7, dataProvider = "createNewAccount_EmptyPostCode_dataProvider")
	  public void createNewAccount_EmptyPostCode( String FirstName,String LastName,String Password,String Address ,String City,String Mobile,String State ,String Error) throws InterruptedException, AWTException  {
		  
		  logger.info("============== TestCase 7 -  Start ==============");
		  homePageOBJ.clickonSigninButton();
		  loginpPageOBJ.setEmail(Email);
		  loginpPageOBJ.clickoncreateButton();
		  createAccountPageOBJ.setFirstName(FirstName);
		  createAccountPageOBJ.setLastName(LastName);
		  createAccountPageOBJ.setPassword(Password);
		  createAccountPageOBJ.setAddress(Address);
		  createAccountPageOBJ.setCity(City);
		  createAccountPageOBJ.selectState();
		  createAccountPageOBJ.setMobile(Mobile);
		  createAccountPageOBJ.clickonRegisterButton();
		  Assert.assertEquals(createAccountPageOBJ.getErrorMessage(), Error);	
		  logger.info("============== TestCase 7 -  End ==============");
	  }
	  
	  @DataProvider
		public Object[][] createNewAccount_EmptyPostCode_dataProvider() throws Exception {

			Object[][] testObjArray = TestData.fetchData("CreateNewAccount_EmptyPostCode");

			return (testObjArray);
		}
	  
	 
		@AfterClass
		public void afterMethod() {
			CloseBrowser();
		}
}
