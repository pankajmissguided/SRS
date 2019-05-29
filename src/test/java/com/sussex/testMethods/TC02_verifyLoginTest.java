package com.sussex.testMethods;

import com.sussex.pageObjects.LoginPage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.sussex.pageObjects.HomePage;
import com.sussex.pageObjects.RegistrationPage;
import com.sussex.testBase.TestBase;

public class TC02_verifyLoginTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	RegistrationPage registrationPage;

//	SerpPage serpPage;
	public TC02_verifyLoginTest() {

		super();
	}

	@DataProvider(name = "LoginData")
	public String[][] getuserData() {
		String[][] testRecords = getData("TestData.xlsx", "ValidUserLogin");
		return testRecords;
	}

	@BeforeSuite
	public void setUp() throws InterruptedException {
		try {
			initialize();
			report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReports.html");
			test = report.startTest("TC01_verifyLoginTest");
			loginPage = new LoginPage(driver);
			registrationPage = new RegistrationPage(driver);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(enabled = true, priority = 1, dataProvider = "LoginData")
	public void VerifyLoginTest(String loginPageTitle, String username, String password,String homePageTitle, String runMode) throws InterruptedException {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			test.log(LogStatus.PASS, "***************TC001 Verify Login with valid Login Details****************");
			
			// LoginPage loginPage = new LoginPage(driver);
			loginPage.acceptCookies();
			test.log(LogStatus.PASS, "On Registeration page clicking on Login Button");
			registrationPage.loginButton();
			test.log(LogStatus.PASS,  "*****Entering username in Loging Page*****");
			loginPage.uosLogo();
			Assert.assertEquals(loginPage.getTitle(), loginPageTitle);
			
			loginPage.enterUserName(username);
			Thread.sleep(2000);
			System.out.println("Password");
			test.log(LogStatus.PASS, "On Registeration page clicking on Login Button");
			loginPage.enterPassword(password);
			Thread.sleep(2000);
			
			test.log(LogStatus.PASS, "Clicking on to the Login Button ");
			loginPage.clickLoginbutton();
			Thread.sleep(2000);
			
			loginPage.acceptCookies();
			Assert.assertEquals(loginPage.getTitle(), homePageTitle);
			
			
			loginPage.refreshPage();// Assertions
			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.FAIL, "fail to validate login page without password Credentials");
		}
	}

	@AfterSuite
	public void closeBrowser() {
	    driver.close();
		report.endTest(test);
		report.flush();
	}

}
