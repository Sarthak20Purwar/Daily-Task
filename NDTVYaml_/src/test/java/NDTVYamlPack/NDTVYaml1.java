package NDTVYamlPack;

import java.io.File;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class NDTVYaml1 {

	 WebDriver driver;
	
	 Map<String, String> data=new HashMap<>();

	static String projectPath = System.getProperty("user.dir");
	
	@BeforeTest
	public  void getYaml()
	{
		try {
			File f1 = new File("src/test/java/NDTYFiles/NDTVF.yml");
		InputStream inputstream = new FileInputStream(f1);
		
			Yaml yaml = new Yaml();
		data=yaml.load(inputstream);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
			
		}
		


	}

	

	@Test(priority = 1 )
	public void testNdtvPage()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		System.out.println(data);
		driver.get(data.get("website_link"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actual = driver.findElement(By.linkText(data.get("liveTv_linktext"))).getText();
	    System.out.println(actual);
		Assert.assertEquals(actual, "LIVE TV");

		
	}
	
	@Test(priority = 2 )
	public void testWeatherPage() {
		driver.findElement(By.xpath(data.get("way_to_weather_tab"))).click();
		driver.findElement(By.xpath(data.get("weather_tab"))).click();
		Assert.assertTrue(driver.findElement(By.cssSelector(data.get("weather_page"))).isDisplayed());

	}
	
	
	@Test(priority = 3)
	public void testWeather() {

		WebElement checkbox = driver.findElement(By.id(data.get("city")));
		if (!checkbox.isSelected()) {
			checkbox.click();

		}
		
		System.out.println("Celcius Temperature in " + data.get("city")+" "+driver.findElement(By.xpath(data.get("celcius_temp"))).getText());
		System.out.println("Fahrenheit Temperature in " + data.get("city")+" "+ driver.findElement(By.xpath(data.get("fahrenheit_temp"))).getText());


}
	
	
	
}
