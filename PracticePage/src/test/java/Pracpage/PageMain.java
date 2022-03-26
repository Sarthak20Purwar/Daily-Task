package Pracpage;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageMain extends DynamicYamlReader{
	File file;
	FileInputStream fileInput;
	Properties prop;

	WebDriver driver;

	@BeforeTest
	public void setUp() throws Throwable
	{
		file=new File("C:\\Users\\devel\\eclipse-workspace\\PracticePage\\Files\\Page.properties");
		fileInput=new FileInputStream(file);
		prop=new Properties();
		prop.load(fileInput);

		String browsername = System.getProperty("bn");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();  
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
		}

		else if(browsername.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}

		driver.get(prop.getProperty("websiteUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	}


		@AfterTest
		public void close() throws InterruptedException
		{
			Thread.sleep(5000);
			driver.quit();
		}
	

	public void verifyRadio(String name[]) throws Throwable
	{
		int count=0;
		for(int j=0;j<name.length;j++) {
			driver.findElement(By.cssSelector(getData("radioButton."+name[j]))).click();
			List<WebElement> allRadio=driver.findElements(By.cssSelector("input[name=\"cars\"][type=\"radio\"]"));
			for(int i=0;i<allRadio.size();i++)
			{
				WebElement temp=allRadio.get(i);
				if(temp.isSelected()) {					
					System.out.println(name[j]+": true");
					count++;
				}
				else
					System.out.println(temp.getAttribute("value")+": false");
			}
			System.out.println("********************");
		}
		if(count==name.length)
			System.out.println("Radio Button functionality works fine !!");
		else
			System.out.println("Radio Button functionality doesn't work fine !!");
	}

	public void verifySelectClass(String name[]) throws Throwable
	{
		int count=0;
		for(int j=0;j<name.length;j++) {
			driver.findElement(By.cssSelector(getData("selectClass.carSelect"))).click();
			driver.findElement(By.xpath("//select[@id='carselect']/option[@value='"+name[j]+"']")).click();
			List<WebElement> allCarOptions=driver.findElements(By.xpath("//select[@id='carselect']/option"));
			for(int i=0;i<allCarOptions.size();i++)
			{
				WebElement temp=allCarOptions.get(i);
				if(temp.isSelected()) {					
					System.out.println(temp.getAttribute("value")+": true");
					count++;
				}
				else
					System.out.println(temp.getAttribute("value")+": false");
			}
			System.out.println("********************");
		}
		if(count==name.length)
			System.out.println("Select class functionality works fine !!");
		else
			System.out.println("Select class functionality doesn't work fine !!");
	}

	public void verifyCheckbox(String name[]) throws Throwable
	{
		int count=0;
		for(int j=0;j<name.length;j++) {
			driver.findElement(By.cssSelector(getData("checkboxSelect."+name[j]))).click();
		}
		List<WebElement> allCheckbox=driver.findElements(By.cssSelector("input[name='cars'][type='checkbox']"));
		for(int i=0;i<allCheckbox.size();i++)
		{
			WebElement temp=allCheckbox.get(i);
			if(temp.isSelected()) {					
				System.out.println(temp.getAttribute("value")+": true");
				count++;
			}
			else
				System.out.println(temp.getAttribute("value")+": false");
		}
		System.out.println("********************");

		if(count==name.length)
			System.out.println("Checkbox functionality works fine !!");
		else
			System.out.println("Checkbox functionality doesn't work fine !!");
	}

	@Test
	public void test() throws Throwable  {
		
		String carRadio[]= prop.getProperty("radio").toString().split("#");
		verifyRadio(carRadio);	

		System.out.println("====================================================================================");

		String selectClass[]= prop.getProperty("selectClass").toString().split("#");
		verifySelectClass(selectClass);
		
		System.out.println("====================================================================================");

		String carCheckbox[]= prop.getProperty("checkbox").toString().split("#");
		verifyCheckbox(carCheckbox);

		System.out.println("====================================================================================");
		
		Thread.sleep(2000);
		String parentWindow=driver.getWindowHandle();
		driver.findElement(By.cssSelector(getData("switchWindow.openWindow"))).click();
		Set<String> newWindow=driver.getWindowHandles();
		String[] str1 = newWindow.toArray(new String[newWindow.size()]);
		driver.switchTo().window(str1[1]);
		Thread.sleep(2000);
		WebElement title= driver.findElement(By.cssSelector(getData("switchWindow.title")));
		if(title.isDisplayed())
			System.out.println("Switch window functionality works fine");
		else
			System.out.println("Switch window functionality doesn't work fine");
		Thread.sleep(2000);
		//driver.findElement(By.xpath(getData("switchWindow.selectCourse"))).click();	
		driver.close();

		System.out.println("====================================================================================");

		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);
		driver.findElement(By.cssSelector(getData("switchTab.openTab"))).click();
		Set<String> newTab=driver.getWindowHandles();
		String[] str2 = newTab.toArray(new String[newWindow.size()]);
		driver.switchTo().window(str2[1]);
		WebElement title2= driver.findElement(By.cssSelector(getData("switchWindow.title")));
		if(title2.isDisplayed())
			System.out.println("Switch tab functionality works fine");
		else
			System.out.println("Switch tab functionality doesn't work fine");
		driver.findElement(By.xpath(getData("switchWindow.selectCourse"))).click();
		driver.close();

		System.out.println("====================================================================================");

		driver.switchTo().window(parentWindow);
		driver.findElement(By.cssSelector(getData("switchToAlert.enterName"))).sendKeys("Vicky Bhatia");
		driver.findElement(By.cssSelector(getData("switchToAlert.alert"))).click();
		Thread.sleep(1000);
		Alert obj;
		obj=driver.switchTo().alert();
		System.out.println(obj.getText());
		obj.accept();
		driver.findElement(By.cssSelector(getData("switchToAlert.confirm"))).click();
		obj=driver.switchTo().alert();
		System.out.println(obj.getText());
		obj.accept();
		System.out.println("Alert Functionality works fine !!");
		//Web Table Example//
		System.out.println("====================================================================================");

		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,500)");
		WebElement input=driver.findElement(By.cssSelector(getData("enabled/Disabled.input")));
		input.sendKeys("Check disable ");
		driver.findElement(By.cssSelector(getData("enabled/Disabled.disable"))).click();
		int count=0;
		if(!input.isEnabled())
			count++;
		driver.findElement(By.cssSelector(getData("enabled/Disabled.enable"))).click();
		input.sendKeys("check enable");
		if(input.isEnabled())
			count++;

		if(count==2)
			System.out.println("enabled/Disabled functionality works fine");
		else
			System.out.println("enabled/Disabled functionality doesn't work fine");

		System.out.println("====================================================================================");

		int count2=0;
		WebElement input2=driver.findElement(By.cssSelector(getData("elementDisplayed.input")));
		input2.sendKeys("Good Morning");
		driver.findElement(By.cssSelector(getData("elementDisplayed.hide"))).click();
		if(!input2.isDisplayed())
			count2++;
		driver.findElement(By.cssSelector(getData("elementDisplayed.show"))).click();
		if(input2.isDisplayed())
			count2++;
		if(count2==2)
			System.out.println("Element Displayed functionality works fine");
		else
			System.out.println("Element Displayed functionality doesn't work fine");

		System.out.println("====================================================================================");

		Actions act=new Actions(driver);
		WebElement mouseHoverButton=driver.findElement(By.cssSelector(getData("mouseHover.button")));
		act.moveToElement(mouseHoverButton).build().perform();

		WebElement top=driver.findElement(By.cssSelector(getData("mouseHover.top")));
		WebElement reload=driver.findElement(By.xpath(getData("mouseHover.reload")));
		if(top.isDisplayed() && reload.isDisplayed())
			System.out.println("Mouse Hover functionality works fine !!");
		else
			System.out.println("Mouse Hover functionality doesn't work fine !!");

		System.out.println("====================================================================================");
		
		j.executeScript("window.scrollBy(0,200)");
		driver.switchTo().frame("courses-iframe");
		driver.findElement(By.cssSelector(getData("iframe.input"))).sendKeys(prop.getProperty("courseName"));
		driver.findElement(By.cssSelector(getData("iframe.search"))).click();
		JavascriptExecutor k=(JavascriptExecutor)driver;
		k.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		WebElement course=driver.findElement(By.xpath(getData("iframe.selectCourse")));
		course.click();
		WebElement courseTitle=driver.findElement(By.xpath(getData("iframe.courseTitle")));
		if(courseTitle.isDisplayed())
			System.out.println("iframe functionality works fine !!");
		else
			System.out.println("iframe functionality doesn't work fine !!");
		
		System.out.println("====================================================================================");
	}
}


