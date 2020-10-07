package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends Base{
	
	LoginPage login;
	HomePage homepage;

	public LoginPageTest() {

		super(); // To call the properties file. mean base constructor
	}
	
	@BeforeMethod
	public void Setup() {
		
		browser_intialization();
		login=new LoginPage();
		
	}

	@Test(priority=1)
	public void CRMTitleTest() {

		String actual=login.GetPageTitle();
		String exptected="Cogmento CR";
		Assert.assertEquals(actual, exptected);
		System.out.println(login.GetPageTitle());
	}
	
	@Test(priority=2)
	public void VerifySignupLinkTest() {
		
		boolean flag=login.Signup_button_verification();
		Assert.assertTrue(flag);
		System.out.println(login.Signup_button_verification());
	}
	
	@Test(priority=3)
	public void VerifyClassicCRMLinkTest() {
		
		boolean flag=login.ClassicCRM_Verification();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=4)
	public void LoginTest() throws InterruptedException {
		
		Thread.sleep(2000);
		homepage = login.CRMLogin(prop.getProperty("Emai"), prop.getProperty("Password")); // Returning HomePage so that's why we have to call homepage object
	}

	
	@AfterMethod
	public void afterMethod() {

		driver.quit();
	}

}
