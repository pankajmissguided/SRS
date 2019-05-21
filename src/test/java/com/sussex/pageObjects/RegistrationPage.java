package com.sussex.pageObjects;

import org.openqa.selenium.WebDriver;

public class RegistrationPage {

	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
}
