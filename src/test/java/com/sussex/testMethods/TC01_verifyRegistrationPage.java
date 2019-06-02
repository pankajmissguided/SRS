package com.sussex.testMethods;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.sussex.pageObjects.HomePage;
import com.sussex.pageObjects.LoginPage;
import com.sussex.pageObjects.RegistrationPage;
import com.sussex.testBase.TestBase;

/**
 * Test Script for Home Page Controls Verification
 * @author Pankaj Kumar
 *
 */
public class TC01_verifyRegistrationPage extends TestBase {
	
	RegistrationPage registrationPage;
	HomePage homePage;
	LoginPage loginPage;
//	SerpPage serpPage;
	public TC01_verifyRegistrationPage() {
		
		super();
	}
	@DataProvider(name = "Register")
	public String[][] Register() {
		String[][] testRecords = getData("Registration.xlsx", "Register");
		return testRecords;
	}
	
	@BeforeSuite
	public void setUp() throws InterruptedException {
		try {
			// Creating an instance for Browser, Navigating to Url & Maximize the browser
			initialize();
			// Start Reporting - Extent Report
			report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReports.html");
			test = report.startTest("Home Page Controls verification");
			registrationPage = new RegistrationPage(driver);
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	@Test(enabled = true,dataProvider = "Register")
	public void TS01_verifyTudentAbleToRegister(String familyName,String givenName
,String dateOFBirth
,String gender
,String emailId
,String nationality
,String password
, String conPassword) {

		 try {
			 loginPage.acceptCookies();
							
								
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
	
	
	@AfterSuite
	public void closeBrowser() {
		try {
			Thread.sleep(1000);
			driver.close();
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
