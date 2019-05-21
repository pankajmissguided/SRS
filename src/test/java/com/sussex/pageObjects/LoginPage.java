package com.sussex.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver =driver;
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
	
	//Object for Login Button On RegistrationPage
	By LoginButton = By.xpath("//a[@class='primary dataEntryPanelActionButton link dataLink alignInherit buttonStyle']");

	public void loginButton(){
	driver.findElement(LoginButton).isDisplayed();
	driver.findElement(LoginButton).isEnabled();
	driver.findElement(LoginButton).click();
	}

	//Object for Login in LoginPage :- Username,Password,LoginButton
	// Object for Login  user

			By username = By.name("LogonName");
			public void enterUserName(String uname) {
				driver.findElement(username).clear();
				driver.findElement(username).sendKeys(uname);
			}
			
	// Object for password
			By password = By.name("Password");
			public void enterPassword(String pass) {
				driver.findElement(password).clear();
				driver.findElement(password).sendKeys(pass);
			}
			
	// Object for Login button
			By loginbtn = By.name("BtnLogOn");
		    public void clickLoginbutton() {
		         driver.findElement(loginbtn).isDisplayed();
				 driver.findElement(loginbtn).isEnabled();
				driver.findElement(loginbtn).click();
							}
	// Objects for Login	    
		    public LoginPage login(String uname, String pass) {
				// TODO Auto-generated method stub
				enterUserName(uname);
				enterPassword(pass);
				 clickLoginbutton();
				 return new LoginPage(driver);
				
			}
		    
	// Object for UOS Logo	
		    By UOSLogo = By.xpath("//a[@class='themedLargeLogo']");
		    
		    public void uosLogo() {
		    	driver.findElement(UOSLogo).isDisplayed();
		    	driver.findElement(UOSLogo).isEnabled();
		    	driver.findElement(UOSLogo).click();
		    }
   //Objects for Log On Details Text
		    By YourDetails = By.xpath("//*[@id=\"LogonPanel\"]/div[1]/h2");
		    
		    public String  verifyYourDetailsText() {
				return driver.findElement(YourDetails).getText();
			}
	
    //Objects for Terms and Condition on Login Page
		    By TermsCondition = By.xpath("//button[@id='lnkTnc']");
		    By LogOnPopUp = By.xpath("//div[@id='LogonPopupTitle']");
		    
		    
		    public String verifyTermsConditionLink() {
		    	driver.findElement(TermsCondition).isDisplayed();
		    	driver.findElement(TermsCondition).isEnabled();
		    	driver.findElement(TermsCondition).click();
		    	return driver.findElement(LogOnPopUp).getText();
		    	
		    		    }
		    
    //Objects for Close popup window
		    By ClosePopUp = By.xpath("//span[@class='icon24 glyph']");
		    public void closePopupWindow() {
		    driver.findElement(ClosePopUp).click();
		    }
		    
	//Objects for CheckBox Keep Me Logged In
		    By KeepMeLogOnCheckbox = By.xpath("//*[@id=\"RememberMe\"]/div[1]");
		    
		    public void verifyKeepMeLogOnCheckbox() {
		    	 driver.findElement(KeepMeLogOnCheckbox).isDisplayed();
		    	 driver.findElement(KeepMeLogOnCheckbox).isEnabled();
		    	 driver.findElement(KeepMeLogOnCheckbox).isSelected();
		    	   }
		    
	//Objects for Accessibility Mode Checkbox
		    By AccessibilityModeCheckbox = By.xpath("//*[@id=\"ChkAccessibility\"]/div[1]");
		    
		    public void  AccessibilityModeCheckbox() {
		    	driver.findElement(AccessibilityModeCheckbox).isDisplayed();
                driver.findElement(AccessibilityModeCheckbox).isEnabled();
                driver.findElement(AccessibilityModeCheckbox).isSelected();
		    }
		    	
		    		
	//Object for Forgot Password link on Registration Page
	By ForgotPasswordLink = By.linkText("Forgot password?");

	public void forgotPasswordLinkOnRegPage(){
	driver.findElement(ForgotPasswordLink).isDisplayed();
	driver.findElement(ForgotPasswordLink).isEnabled();
	driver.findElement(ForgotPasswordLink).click();
	}
	//Object for Forgot password Validation text

	By ForgotPassValidationText = By.xpath("(//*[@id=ValidationSummary]/div/ul/li)");

	public String forgotPassValidationText(){
		driver.findElement(ForgotPassValidationText).isDisplayed();
	     return driver.findElement(ForgotPassValidationText).getText();
		}
		
	
		}





