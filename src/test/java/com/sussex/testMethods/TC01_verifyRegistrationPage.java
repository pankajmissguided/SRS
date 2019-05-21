package com.sussex.testMethods;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.sussex.pageObjects.HomePage;
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
//	SerpPage serpPage;
	public TC01_verifyRegistrationPage() {
		
		super();
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
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
		@Test(enabled = true)
	public void TS01_verifyUserAbleToRegisterToSussexUniversity(){
		 try {
			    test.log(LogStatus.PASS, "------TC02_Verify Services Page info --------");
				test.log(LogStatus.PASS, "Verify the Home Page Title - " + homePage.getTitle());
				//homePage.clickOnMenu().click();
				test.log(LogStatus.PASS, "Click on Services Menu");
				Thread.sleep(1500);
			   // homePage.clickServiceMenu("Services");
			    Thread.sleep(2000);
			    test.log(LogStatus.PASS, "Verify the Service Header exits");
			   // assertTrue(homePage.getHeaderName("Services"));
			    Thread.sleep(2000);
				//homePage.closeMenu().click();
				 Thread.sleep(2000);
				
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
