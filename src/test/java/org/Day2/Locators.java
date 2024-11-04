package org.Day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Locators {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		Page page = browser.newPage();
		page.navigate("https://letcode.in/edit");
		//page.locator("id=fullName").type("vishnunath");
		
		page.fill("id=fullName", "vishnunath");
		
		Locator locator = page.locator("id=join");
		locator.press("End");
		locator.type(" man");
		locator.press("Tab");
		
		String attribute = page.locator("id=getMe").getAttribute("Value");
		System.out.println(attribute);
		
		page.locator("id=clearMe").clear();
		
		boolean disabled = page.locator("input#noEdit").isDisabled();
		System.out.println(disabled);
		
//		page.close();
//		browser.close();
//		playwright.close();
		

	}

}
