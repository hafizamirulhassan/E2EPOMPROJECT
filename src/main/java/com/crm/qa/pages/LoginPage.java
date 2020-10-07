package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class LoginPage extends Base {

	// PageFactory - OR

	@FindBy(name ="email")
	@CacheLookup
	WebElement user_email;
	
	@FindBy(name="password")
	WebElement user_password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement Login_BTN;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignupBTN;
	
	@FindBy(xpath="//a[contains(text(),'Classic CRM')]")
	WebElement ClassicCRM_BTN;
	
	public LoginPage() {
		PageFactory.initElements(driver, this); // "This" work is using to call the above objects
	}
	
	public String GetPageTitle() {
		return driver.getTitle();
	}
	
	public boolean Signup_button_verification() {
		return SignupBTN.isDisplayed();
	}
	
	public boolean ClassicCRM_Verification() {
		return ClassicCRM_BTN.isDisplayed();
	}
	
	public HomePage CRMLogin(String em, String pw) {
		
		user_email.sendKeys(em);
		user_password.sendKeys(pw);
		Login_BTN.click();
		return new HomePage();
		
	}
	
	

}
