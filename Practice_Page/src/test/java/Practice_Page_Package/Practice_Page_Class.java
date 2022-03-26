package Practice_Page_Package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice_Page_Class {

	WebDriver driver;
    YamlDriver yd;
	Properties prop;

	@BeforeTest
	public void OpenBrowser() throws JsonParseException, JsonMappingException, IOException {
		File propertiesfile = new File("C:\\Users\\devel\\eclipse-workspace\\Practice_Page\\Files\\config.properties");
		FileInputStream fileInput = new FileInputStream(propertiesfile);
		prop = new Properties();
		prop.load(fileInput);

		File ym = new File("C:\\Users\\devel\\eclipse-workspace\\Practice_Page\\Files\\YamlFile.yml");
		ObjectMapper om = new ObjectMapper(new YAMLFactory());
		yd = om.readValue(ym, YamlDriver.class);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("application_link"));

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@Test
	public void LaunchApplication() {
		
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
