package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class HomePage extends Base{

	@FindBy(xpath="//div[@class='header item']")
	@CacheLookup
	WebElement CogmentoLogo;
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement TestCRM;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement Contactbtn;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement Dealsbtn;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement Taskbtn;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyHomeTitle() {
		return driver.getTitle();
	}
	
	public boolean VerifyCongmentoLogo() {
		return CogmentoLogo.isDisplayed();
	}
	
	public boolean VerifyTestCRM() {
		return TestCRM.isDisplayed();
	}
	
	public ContactPage clickOnContactsLink() {
		Contactbtn.click();
		return new ContactPage();
	}
	
	public DealPage clickOnDealsLink() {
		Dealsbtn.click();
		return new DealPage();
	}
	
	public TaskPage clickOnTaskLink() {
		Taskbtn.click();
		return new TaskPage();
	}
	
	
	
}
