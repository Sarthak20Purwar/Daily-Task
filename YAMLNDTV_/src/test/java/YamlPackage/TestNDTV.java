package YamlPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNDTV {

	WebDriver driver;
	YamlDriver yd;
	Properties prop;

	@BeforeTest
	public void setup() throws JsonParseException, JsonMappingException, IOException {

		File yamlfile = new File("C:\\Users\\devel\\eclipse-workspace\\YAMLNDTV_\\Files\\locators.yml");
		ObjectMapper om = new ObjectMapper(new YAMLFactory());
		 yd = om.readValue(yamlfile, YamlDriver.class);

		File propertiesfile = new File("C:\\Users\\devel\\eclipse-workspace\\YAMLNDTV_\\Files\\config.properties");
		FileInputStream fileInput = new FileInputStream(propertiesfile);
		 prop = new Properties();
		prop.load(fileInput);

		if (prop.getProperty("browserName").equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().browserVersion(prop.getProperty("browerVersion")).setup();
			driver = new ChromeDriver(options);

		}

		else if (prop.getProperty("browserName").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		driver.get(prop.getProperty("websiteUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}
	
	
	@Test
	public void test() throws InterruptedException
	{
		WebElement searchBox;
		By selectMore = By.cssSelector(yd.getMore_id());
		By selectWeather=By.xpath(yd.getWeather_xpath());
		By selectSearchBox=By.xpath(yd.getWeatherPage().get("searchBox_xpath"));
        By getDegree = By.xpath(yd.getWeatherPage().get("degree_xpath"));
        By getFahrenheit=By.xpath(yd.getWeatherPage().get("degree_xpath"));
        
        
        driver.findElement(selectMore).click();
        driver.findElement(selectWeather).click();
        
        Thread.sleep(2000);
		//
		String removeAllcity[] = prop.getProperty("remove").toString().split("#");
		//
		for(int i=0 ; i<removeAllcity.length;i++)
		{
			searchBox = driver.findElement(selectSearchBox);
			searchBox.sendKeys(removeAllcity[i]);
			By deSelectCity=By.xpath("//label[@for='"+removeAllcity[i]+"']");
			driver.findElement(deSelectCity).click();
			searchBox.clear();
		}
		
		
		
		List<String> enterCity=yd.getRequiredCities();
		for(int j=0 ; j<enterCity.size();j++)
		{
			By selectCity=By.xpath("//label[@for='"+enterCity.get(j)+"']");
			By cityOnMap=By.xpath("//div[@class='cityText' and text()='"+enterCity.get(j)+"']");

			searchBox=driver.findElement(selectSearchBox);
			searchBox.sendKeys(enterCity.get(j));

			driver.findElement(selectCity).click();
			searchBox.clear(); 

			driver.findElement(cityOnMap).click();
			Thread.sleep(1000);
			String degree=driver.findElement(getDegree).getText();
			String Fahrenheit=driver.findElement(getFahrenheit).getText();
			System.out.println(enterCity.get(j)+"\n"+degree+"\n"+Fahrenheit+"\n");
		}
		System.out.println("Hi jenkins");
	}
	
	@AfterTest
	public void closebrowser()
	{
		driver.quit();
	}
	

}
