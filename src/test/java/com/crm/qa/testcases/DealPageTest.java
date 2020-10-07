package com.crm.qa.testcases;

import org.testng.annotations.Test;
import com.crm.qa.base.Base;
import com.crm.qa.pages.DealPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

public class DealPageTest extends Base {
	
	LoginPage loginPage;
	HomePage homePage;
	DealPage dealPage;
	
	String SheetName="Deals";

	public DealPageTest() {
		super();
	}

	@BeforeMethod
	public void beforeMethod() {

		browser_intialization();
		loginPage=new LoginPage();
		homePage=loginPage.CRMLogin(prop.getProperty("Email"), prop.getProperty("Password"));
		dealPage =homePage.clickOnDealsLink();

	}

	@DataProvider
	public Object[][] getCRMDealsData(){
		
		Object data[][] = TestUtils.getCRMSheetTestData(SheetName);
		return data;
		
	}

	@Test(priority=1)
	public void validatetitle() {
		
		dealPage.verifycreatenewbuttontitle();
	}
	@Test(priority=2,dataProvider = "getCRMDealsData")
	public void validateNewDeal(String title, String company, String amount) throws InterruptedException {
		
		dealPage.clickonnewdealBTN(title, company, amount);
	}


	@AfterMethod
	public void afterMethod() {
		
		driver.quit();
		
	}

}
