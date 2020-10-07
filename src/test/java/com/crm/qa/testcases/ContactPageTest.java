package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

public class ContactPageTest extends Base {

	LoginPage login;
	HomePage homePage;
	ContactPage contactPage;
	String sheetName="contacts";

	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException {
		browser_intialization();
		login = new LoginPage();
		homePage = login.CRMLogin(prop.getProperty("Email"), prop.getProperty("Password"));
		contactPage=homePage.clickOnContactsLink();
		
		Thread.sleep(2000);

	}
	
	@DataProvider
	public Object[][] getCRMContactsData(){
		
		Object data[][] = TestUtils.getCRMSheetTestData(sheetName);
		return data;
		
	}
	
	@Test(dataProvider = "getCRMContactsData")
	public void validateCreateNewContact(String firstname, String lastname, String company, String email, String address) throws InterruptedException {
		
		contactPage.addnewcontact(firstname, lastname, company, email, address);
		
	}
	
	@AfterMethod
	public void afterMethod() {

		driver.quit();
	}

}
