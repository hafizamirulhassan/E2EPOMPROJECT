package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class ContactPage extends Base {

	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement Newbtn;

	@FindBy(xpath = "//input[@type='text'][@name='first_name']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@type='text'][@name='last_name']")
	WebElement LastName;


	@FindBy(xpath = "//input[@type = 'text' and @class= 'search']")
	WebElement Company;

	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement Email;

	@FindBy(xpath = "//input[@placeholder='Street Address']")
	WebElement Address;

	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement savebtn;

	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	public void addnewcontact(String fn, String ln, String com, String em, String adr) throws InterruptedException{

		Newbtn.click();
		
		Thread.sleep(2000);
		FirstName.sendKeys(fn);
		Thread.sleep(2000);

		LastName.sendKeys(ln);
		Thread.sleep(2000);

		Company.sendKeys(com, Keys.ENTER);
		Thread.sleep(2000);

		Email.sendKeys(em);
		Thread.sleep(2000);

		Address.sendKeys(adr);
		Thread.sleep(2000);

		savebtn.click();
		Thread.sleep(2000);


	}
}
