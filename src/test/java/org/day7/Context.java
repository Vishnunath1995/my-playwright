package org.day7;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Context {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = browserType.launch(headless);
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://bookcart.azurewebsites.net/");
		page.click("//span[normalize-space(text())='Login']");
		page.locator("input[placeholder='Username']").type("man");
		page.locator("input[placeholder='Password']").type("Man@@123");
		page.locator("//span[text()='Login']").click();
		String userName = page.locator("//span[normalize-space(text())='man']").textContent();
		System.out.println(userName);
		


BrowserContext context2 = browser.newContext();
Page newpage = context2.newPage();
newpage.navigate("https://bookcart.azurewebsites.net/");
newpage.locator("//span[normalize-space(text())='Register']").click();
newpage.locator("input[placeholder='First name']").type("s");
newpage.locator("input[placeholder='Last Name']").type("k");
newpage.locator("input[placeholder='Password']").type("Sk@@2000");
newpage.locator("input[placeholder='Confirm Password']").type("Sk@@2000");
newpage.locator("input[value='Male']").click();
newpage.locator("xpath=//span[normalize-space(text())='Register']").click();




	}

}
