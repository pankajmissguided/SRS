package com.sussex.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void refreshPage() {
		// TODO Auto-generated method stub
		driver.navigate().refresh();
	}
	By logonButton = By
			.xpath("//*[@id=\"AlreadyLoggedInInformationPanelWrapper\"]/div/div/div[1]/a");

	public void loginButton() {
		driver.findElement(logonButton).isDisplayed();
		driver.findElement(logonButton).isEnabled();
		driver.findElement(logonButton).click();
	}
	//Objects for Family Name
	By FamilyName = By.cssSelector("#FamilyName");
	
	public void getFamilyName(String FName) {
		driver.findElement(FamilyName).clear();
	    driver.findElement(FamilyName).sendKeys(FName);
	}
	//Objects for Given Name
		By GivenName = By.cssSelector("#GivenName");
		
		public void getGivenName(String GName) {
			driver.findElement(GivenName).clear();
			driver.findElement(GivenName).sendKeys(GName);
		}
		//Objects for Date Birth
				By DateOfBirth = By.cssSelector("#BirthDate");
				
				public void getDateOfBirth(String DOB) {
					driver.findElement(DateOfBirth).clear();
					driver.findElement(DateOfBirth).sendKeys(DOB);
				}
				
		//Objects for Gender
		By GenderText = By.cssSelector("#Gender");
		public void enterGender(String Gender) {
		
		driver.findElement(GenderText).clear();
		driver.findElement(GenderText).sendKeys(Gender);
		}
		
		//Objects for Email Id
		
		By EmailIdText = By.cssSelector("#EmailAddress");
		
		public void enterEmailId(String emailId) {
			driver.findElement(EmailIdText).clear();
			driver.findElement(EmailIdText).sendKeys(emailId);
				}
		
		//Objects for Nationality
		
		By NationalityText = By.cssSelector("#Nationality");
		
		public void nationality(String Nationality) {
			driver.findElement(NationalityText).clear();
			driver.findElement(NationalityText).sendKeys(Nationality);
		}
		
		//Objects for Password
		By PasswordText = By.cssSelector("#Password");
		
		public void password(String Password) {
			driver.findElement(PasswordText).clear();
			driver.findElement(PasswordText).sendKeys(Password);
		}
		//Objects for Confirm Password
				By ConPasswordText = By.cssSelector("#ConfirmPassword");
				
				public void conPassword(String ConfirmPassword) {
					driver.findElement(ConPasswordText).clear();
					driver.findElement(ConPasswordText).sendKeys(ConfirmPassword);
				}
				//Objects for CheckBox
				By CheckBoxSelected = By.xpath("//div[@class='styleContainer stackedStyle']//div[@class='cbcEditorField']");
				
				public void previouslyAppliedcheckBox() {
					driver.findElement(CheckBoxSelected).isDisplayed();
					driver.findElement(CheckBoxSelected).sendKeys();
				}
				
				//Objects for Terms ANd Condition
				
				By termsAndConditionCheckBox = By.xpath("//div[@class='firstControl sideBySide styleContainer stackedStyle']//div[@class='cbcEditorField']");
				
				public void termsAndConditionCheckBox() {
					driver.findElement(termsAndConditionCheckBox).isDisplayed();
					driver.findElement(termsAndConditionCheckBox).sendKeys();
				}
				
				By RegisterButton = By.xpath("//*[@id='StudentApplicationRegistrationSection']/div[2]/div[2]/ul/li/button/span");
				
				public void verifyRegisterButton() {
					driver.findElement(RegisterButton).isDisplayed();
                    driver.findElement(RegisterButton).isEnabled();	
                    driver.findElement(RegisterButton).click();
				}
				
}
