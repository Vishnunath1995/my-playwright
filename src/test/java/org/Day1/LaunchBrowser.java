package org.Day1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Response;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		Page page = browser.newPage();
		  page.navigate("https://www.google.com/");
		  String url = page.url();
		  System.out.println("page url "+url);
		  
		  String title = page.title();
		  System.out.println("page title "+title);
		  
		  page.close();
		  browser.close();
		  playwright.close();
	}
}
