package Java_Files;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PROPERTIES {

	static Properties objectProp = new Properties();
	
	
	
	@BeforeClass
	public static void getProperties()
	{
		try {
			InputStream objectinput = new FileInputStream("C:\\Users\\devel\\eclipse-workspace\\YAML2\\Files\\PROPERTIES.properties");
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
		
	}
	
	@Test
	public void testProperties()
	{
		System.out.println("name");
		System.out.println("age");
		System.out.println("location");
	}
}
