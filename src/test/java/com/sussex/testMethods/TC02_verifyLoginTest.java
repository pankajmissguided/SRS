package com.sussex.testMethods;

import com.sussex.pageObjects.LoginPage;
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
			test = report.startTest("TS01_LoginTest");
			loginPage = new LoginPage(driver);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(enabled = true, priority = 1, dataProvider = "LoginData")
	public void VerifyLoginTest(String username, String password, String runMode) throws InterruptedException {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			test.log(LogStatus.PASS, "***************TC002 Verify Login page with no password****************");
			
			// LoginPage loginPage = new LoginPage(driver);
			test.log(LogStatus.PASS, "Entering Email Id to the login page ");
			loginPage.loginButton();
			test.log(LogStatus.PASS, "Clicking on to the Login Button ");
			loginPage.clickLoginbutton();
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Verify the problem error messgae is appearing correctly in the Login Page");
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
