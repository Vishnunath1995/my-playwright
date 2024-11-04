package org.day6;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HttpRequestAuthentication {
	
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().
				setHeadless(false));
	BrowserContext context = browser.newContext(new Browser.NewContextOptions().
			setHttpCredentials("admin","admin"));
	Page page = context.newPage();
	page.navigate("https://the-internet.herokuapp.com/basic_auth");
	String msg = page.locator("h3").textContent();
	System.out.println("Mssage ---> "+msg);

	page.close();
	context.close();
	browser.close();
	playwright.close();
	}

}
