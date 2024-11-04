package org.day3;

import java.util.List;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.SelectOptionOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Dropdownsample {
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
	 Page page = playwright.chromium().launch(headless
				.setChannel("chrome")).newPage();
		
		page.navigate("https://letcode.in/dropdowns");
	//page using handle	
	//	page.selectOption("#fruits", "1");
		
		//element using handle
		Locator locator = page.locator("#fruits");
//		locator.selectOption("1");
		
		
//		select by value
//	locator.selectOption("1");
//	
	//select by string/label
//locator.selectOption(new SelectOption().setLabel("Banana"));
//select by index
//
//locator.selectOption(new SelectOption().setIndex(3));

//locator.selectOption(new SelectOption().setValue("4"));
//
//locator.selectOption(new SelectOption().setIndex(1));


//select multiple options

Locator heros = page.locator("#superheros");
 heros.selectOption(new String[] {"aq","bt","cm"});
 
 
 //select last selected option
 Locator languages = page.locator("#lang");
 Locator options = languages.locator("option");
 int count = options.count();
 System.out.println("Len "+count);
// languages.selectOption(new SelectOption().setIndex(count-1)
//		 ,new SelectOptionOptions().setTimeout(1000));
 
 languages.selectOption(new SelectOption().setIndex(count-1),new SelectOptionOptions().setTimeout(1000));
 
 //print all value
 List<String> allInnerTexts = options.allInnerTexts();
 int size = allInnerTexts.size();
 System.out.println("size "+ size);
 
 for(String l:allInnerTexts)
 {
	 System.out.println(l);
 }
		
		String textContent = page.locator("//div[@class='notification is-success']//p[1]").textContent();
		System.out.println("Text Content " +textContent);
		
		
		
		

		page.close();
		playwright.close();
		
		
	}

}
