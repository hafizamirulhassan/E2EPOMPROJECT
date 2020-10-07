package com.crm.qa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import com.crm.qa.base.Base;

// to generate selenium logs
public class WebEventListener extends Base implements WebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {

		System.out.println("Before navigating to: " + url + "");

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("navigated to: " + url + "");

	}

	public void beforeNavigateBack(WebDriver driver) {
		
		System.out.println("Navigating back to previous page");

	}

	public void afterNavigateBack(WebDriver driver) {
		
		System.out.println("Navigating back to previous page");

	}

	public void beforeNavigateForward(WebDriver driver) {
		
		System.out.println("Navigated forward to page");

	}

	public void afterNavigateForward(WebDriver driver) {

		System.out.println("Navigated forward to page");

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {

		System.out.println("Trying to find Element By : " +by.toString());

	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
		System.out.println("Found Element By : " +by.toString());

	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		
		System.out.println("Trying to click on:" +element.toString());

	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		
		System.out.println("Clicked on: " +element.toString());

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {

		System.out.println("Value of the:" + element.toString() + "before any changes mode");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		
		System.out.println("Element value changed to:" +element.toString());

	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void onException(Throwable error, WebDriver driver) {
		
		System.out.println("Exception occured: " +error);
		try {
			
			TestUtils.failed(); // this is take screenshot method
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
