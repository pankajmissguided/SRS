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
	
	public String getFamilyName() {
		driver.findElement(FamilyName).clear();
		return driver.findElement(FamilyName).getText();
	}
	//Objects for Given Name
		By GivenName = By.cssSelector("#GivenName");
		
		public String getGivenName() {
			driver.findElement(GivenName).clear();
			return driver.findElement(GivenName).getText();
		}
		//Objects for Date Birth
				By DateOfBirth = By.cssSelector("#BirthDate");
				
				public String getDateOfBirth() {
					driver.findElement(DateOfBirth).clear();
					return driver.findElement(DateOfBirth).getText();
				}
}
