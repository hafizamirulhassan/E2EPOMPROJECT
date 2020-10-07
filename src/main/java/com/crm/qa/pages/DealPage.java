package com.crm.qa.pages;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.Base;

public class DealPage extends Base {

	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement newDealBTN;

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement createnewTitle;

	@FindBy(xpath = "//input[@name='title']")
	WebElement TitleField;

	@FindBy(xpath = "//div[@class='ui fluid selection dropdown']")
	WebElement assignedclick;

	@FindBy(xpath = "//div[@class='visible menu transition']//div[@class='selected item']")
	WebElement valueselect;

	@FindBy(xpath = "//div[@name='company']//input[@class='search']")
	WebElement Company;

	@FindBy(xpath = "//input[@name='amount']")
	WebElement Amount;

	@FindBy(xpath = "//div[@name='status']")
	WebElement Status;

	@FindBy(xpath = "//div[@name='stage']")
	WebElement Stage;

	/*
	 * @FindBy(xpath="//div[@class='visible menu transition']") WebElement
	 * Statusvalues;
	 */

	@FindBy(xpath = "//text()[.='Save']/ancestor::button[1]")
	WebElement savebtn;

	public DealPage() {
		PageFactory.initElements(driver, this);
	}

	// For status
	private static int getStatusRandomNumberInBetween(int lowerBound, int upperBound) {
		Random r = new Random();
		return (r.nextInt(upperBound) + lowerBound);
	}

	// For Stage
	private static int getStageRandomNumberInBetween(int lowerBound, int upperBound) {
		Random r = new Random();
		return (r.nextInt(upperBound) + lowerBound);
	}

	public void verifycreatenewbuttontitle() {
		boolean verifytitle = createnewTitle.isDisplayed();
		Assert.assertTrue(verifytitle);
		System.out.println(verifytitle);
	}

	public void clickonnewdealBTN(String titl, String com, String amnt) throws InterruptedException {

		Thread.sleep(2000);
		newDealBTN.click();

		Thread.sleep(2000);

		TitleField.sendKeys(titl);
		Thread.sleep(2000);

		Company.sendKeys(com, Keys.ENTER);

		Thread.sleep(3000);

		assignedclick.click();
		valueselect.click();

		Amount.sendKeys(amnt);

		// Random itmes selection from Status.

		for (int i = 0; i < 5; i++) {

			Status.click();

			List<WebElement> statusItemsDropdown = driver
					.findElements(By.xpath("//div[@class='visible menu transition']//div[@class='item']"));

			statusItemsDropdown.get(getStatusRandomNumberInBetween(1, statusItemsDropdown.size() - 1)).click();

			Thread.sleep(2000);

		}

		// Random itmes selection from Stage.

		for (int i = 0; i < 7; i++) {

			Stage.click();

			List<WebElement> stageItemsDropdown = driver
					.findElements(By.xpath("//div[@class='visible menu transition']//div[@class='item']"));

			stageItemsDropdown.get(getStageRandomNumberInBetween(1, stageItemsDropdown.size() - 1)).click();

			Thread.sleep(2000);

		}

		savebtn.click();
		Thread.sleep(2000);

	}
}
