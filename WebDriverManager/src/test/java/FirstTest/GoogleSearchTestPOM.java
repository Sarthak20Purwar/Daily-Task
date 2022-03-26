package FirstTest;

import java.awt.RenderingHints.Key;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjectModel.GoogleSearchPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTestPOM {

	static WebDriver driver=null;
	
	public static void main(String[] args) {
		googleSearch();
	}
	
	
	
	public static void googleSearch()
	{
		
   	WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
	
	driver.get("https://google.com");
	
	GoogleSearchPage.textbox_search(driver).sendKeys("Automation Step By Step");
	GoogleSearchPage.textbox_search(driver).sendKeys(Keys.RETURN);
	
	
	driver.close();
	System.out.println("Test Completed Successfully");
	
	}
	
	
}
