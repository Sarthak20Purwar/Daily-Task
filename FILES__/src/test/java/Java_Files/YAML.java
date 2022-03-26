package Java_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

public class YAML {

	Map<String,String> data = new HashMap<String, String>();
	
	@BeforeTest
	public void getYAML() 
	{
		try {
		File objectfile = new File("C:\\Users\\devel\\eclipse-workspace\\YAML2\\Yaml Files\\YAML.yml");
		InputStream objectinput = new FileInputStream(objectfile);
		Yaml objectyaml = new Yaml();
		data=objectyaml.load(objectinput);
	}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
			
		}
	}
	
	
	@Test
	public void YAMLData()
	{
		System.out.println(data);
	}
	
}
