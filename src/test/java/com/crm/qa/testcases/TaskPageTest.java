package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.utility.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;

public class TaskPageTest extends Base {
	LoginPage loginPage;
	HomePage homePage;
	TaskPage taskPage;
	String SheetName = "Tasks";

	public TaskPageTest() {
		super();
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {

		browser_intialization();
		loginPage = new LoginPage();
		homePage = loginPage.CRMLogin(prop.getProperty("Email"), prop.getProperty("Password"));
		taskPage = homePage.clickOnTaskLink();
		Thread.sleep(2000);

	}

	@DataProvider
	public Object[][] getCRMTaskData() {

		Object data[][] = TestUtils.getCRMSheetTestData(SheetName);
		return data;

	}

	@Test(priority = 1)
	public void verifyTitle() {
		taskPage.verifyTaskCreateTitle();

	}

	@Test(priority = 2, dataProvider = "getCRMTaskData")

	public void verifyNewTask(String title, String contact, String deal, String cases, String description)
			throws InterruptedException {

		taskPage.taskNewclick(title, contact, deal, cases, description);

	}

	@AfterMethod
	public void afterMethod() {

		driver.quit();
	}

}
