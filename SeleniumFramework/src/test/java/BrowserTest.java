import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BrowserTest {

	public static void main(String[] args) throws InterruptedException {
		
		String path=System.getProperty("user.dir");
		
		
		
		//System.setProperty("webdriver.gecko.driver" , path+"\\Driver\\geckodriver\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver" , path+"\\Driver\\chromedriver\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.ie.driver", path+"\\Driver\\internetexplorer\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.selenium.dev/");
		Thread.sleep(3000);
		driver.close();
		
	}
	
}
