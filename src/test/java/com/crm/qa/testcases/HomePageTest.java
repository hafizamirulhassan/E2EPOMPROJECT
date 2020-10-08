package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends Base {

	LoginPage login;
	HomePage homePage;
	ContactPage contactPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() throws InterruptedException {

		browser_intialization();
		login = new LoginPage();
		Thread.sleep(2000);
		homePage = login.CRMLogin(prop.getProperty("Email"), prop.getProperty("Password"));

	}

	@Test(priority = 1)
	public void EmptyEmailandPassword(){

		
		login = new LoginPage();
		homePage = login.CRMLogin(prop.getProperty("Email"), prop.getProperty("Password"));
		String actualerror=driver.findElement(By.xpath("//p[contains(text(),'Invalid request')]")).getText();
		String expectederror="Invalid request";
		
		Assert.assertEquals(actualerror, expectederror, "Please check your Email Filed");

	}
	
	@Test(priority = 2)
	public void GetHomePageTitleTest() {

		String actual = homePage.VerifyHomeTitle();
		String expected = "Cogmento CR";
		Assert.assertEquals(actual, expected, "Home page title not matched!!"); // message will be call only for
																					// failed cases.
		System.out.println(homePage.VerifyHomeTitle());
	}

	@Test(priority = 3)
	public void VerifyCongmentoLogoTest() {

		boolean flag = homePage.VerifyCongmentoLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 4)
	public void VerifyTestCRMTest() {

		boolean flag = homePage.VerifyTestCRM();
		Assert.assertTrue(flag);
	}

	@Test(priority = 5)
	public void VerifyclickOnContactsLinkTest() {
		contactPage = homePage.clickOnContactsLink();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
