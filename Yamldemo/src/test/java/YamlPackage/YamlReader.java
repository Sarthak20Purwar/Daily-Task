package YamlPackage;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlReader {

	public static void main(String[] args) throws Throwable {
		
	File f = new File("src\\test\\java\\YamlFile\\demo.yml");
	ObjectMapper ob = new ObjectMapper(new YAMLFactory());
	
	Yamldata data= ob.readValue(f, Yamldata.class);
	System.out.println(data.getName());
	System.out.println(data.getAge());
		
	}
	
	
	
	
}
