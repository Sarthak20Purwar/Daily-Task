package FirstTest;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Googlesearch {

	public static void main(String[] args) {
		googleSearch();
	}
	
	
	
	public static void googleSearch()
	{
		
   	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://google.com");
	driver.findElement(By.name("q")).sendKeys("Automation Step By Step");
	driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
	
	driver.close();
	System.out.println("Test Completed Successfully");
	
	}
	
	
}
