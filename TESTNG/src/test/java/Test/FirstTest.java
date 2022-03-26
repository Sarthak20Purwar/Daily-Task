package Test;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	@Test
	public void testGoogle() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Arijit Singh" , Keys.ENTER);
		String expectedTitle="Arijit Singh - Google Search";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle );//hard assertions
		
		
		driver.quit();
	}
	
	
	
	@Test
	public void testFacebook() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("HYR $$$$" , Keys.ENTER);
		Thread.sleep(5000);
	
		SoftAssert soft = new SoftAssert();
		
		
		//Title assertion
		String expectedTitle="Log in to Facebook";
		String actualTitle=driver.getTitle();
		 soft.assertEquals(actualTitle, expectedTitle , "Title is Mismatched" );
		
		//URL assertion
		String expectedURL="https://www.facebook.com/";
		String actualURL=driver.getCurrentUrl();
		soft.assertNotEquals(actualURL, expectedURL, "URL is Mismatched" );
		
		//Text Assertion 
		String expectedText="";
		String actualText=driver.findElement(By.name("email")).getAttribute("value");
		soft.assertEquals(actualText, expectedText, "Text is Mismatched" );
	    
        //Border Assertion
		String expectedBorder="1px solid rgb(240, 40, 73)";
		String actualBorder=driver.findElement(By.name("email")).getCssValue("border");
		soft.assertEquals(actualBorder, expectedBorder, "Border is Mismatched" );
	    
		//ErrorMessage
		String expectedErrorMessage="The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		String actualErrorMessage=driver.findElement(By.xpath("(//div[@id='email_container']/div)[last()]")).getText();
		soft.assertEquals(actualErrorMessage, expectedErrorMessage, "ErrorMessage is Mismatched" );
		
		
		driver.quit();
		soft.assertAll();
	}
	
}
