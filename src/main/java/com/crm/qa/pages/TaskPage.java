package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.Base;

public class TaskPage extends Base {

	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement TaskNewBTN;
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement TaskNewTitle;
	
	@FindBy(xpath="//input[@name='title']")
	WebElement Title;
	
	@FindBy(xpath="//div[@name='contact']//input[@class='search']")
	WebElement Contact;
	
	@FindBy(xpath="//div[@name='deal']//input[@class='search']")
	WebElement Deal;
	
	@FindBy(xpath="//div[@name='case']//input[@class='search']")
	WebElement Case;
	
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement Description;
	
	
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement SaveBTN;
	
	
	
	
	public TaskPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyTaskCreateTitle() {
		boolean taask=TaskNewTitle.isDisplayed();
		Assert.assertTrue(taask);
		System.out.println(taask);
	}
	
	public void taskNewclick(String tit, String cont, String del, String cas, String desc) throws InterruptedException {
		
		Thread.sleep(2000);
		TaskNewBTN.click();
		
		Thread.sleep(2000);
		Title.sendKeys(tit);
		
		Thread.sleep(2000);
		Contact.sendKeys(cont, Keys.ENTER);
		
		Thread.sleep(2000);
		Deal.sendKeys(del, Keys.ENTER);
		
		Thread.sleep(2000);
		Case.sendKeys(cas, Keys.ENTER);
		
		Thread.sleep(3000);
		
		Description.sendKeys(desc);

		Thread.sleep(2000);
		
		SaveBTN.click();
		Thread.sleep(2000);
		
	}
	
}
