package org.day5;

import java.util.function.Consumer;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AAlert {
public static void main(String[] args) {
	Playwright playwright=Playwright.create();
	LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
	Page page = playwright.chromium().launch(headless).newPage();
	page.navigate("https://letcode.in/alert");
	
	
	page.onceDialog(dialog -> {
		System.out.println(dialog.defaultValue());
		
	System.out.println(dialog.message());
	dialog.accept("vishnunath");
	System.out.println(page.locator("#myName").textContent());

	});
	
	//page.locator("#accept").click();
	
	//page.locator("#myName").click();
	
	page.locator("#prompt").click();
	
	
	Consumer<Dialog>alert=a -> {System.out.println(a.defaultValue());
	System.out.println(a.message());
	a.accept("vishnunath");

	};
	
}
}
