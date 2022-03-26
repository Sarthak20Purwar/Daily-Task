package YAMLPROJECTPACK;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YAMLDATA {

	
WebDriver driver;
Map<String , String> data =new HashMap<>();

@BeforeTest
public void getYAML()
{

	try {
		File object1 = new File("src\\test\\java\\YAMLPROJECTFILE\\YAML.yml");
		InputStream object2 = new FileInputStream(object1); 
	    Yaml object3 = new Yaml();
	    data=object3.load(object2);
	
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		System.out.println(e.getCause());
		System.out.println(e.getStackTrace());
		
	}
	
}


@Test(priority=1)
public void NDTVPage()
{
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notification");
	driver.get(data.get("link"));
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	String str = driver.findElement(By.xpath(data.get("text"))).getText();
    System.out.println(str);
    Assert.assertEquals(str,"This is the TestProject playground website. Feel free to play around it :)");
    
}

}
