import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
public static void main(String[] args) {

//	
//	WebDriverManager.chromedriver().setup();
//	WebDriver driver = new ChromeDriver();
//	
//	WebDriverManager.firefoxdriver().setup();
//	WebDriver driver = new FirefoxDriver();
	
//	WebDriverManager.iedriver().setup();
//	WebDriver driver = new InternetExplorerDriver();
//	
	
	WebDriverManager.edgedriver().setup();
	WebDriver driver = new EdgeDriver();
	driver.get("https://google.com");
	driver.close();
	driver.quit();
	
}
}
