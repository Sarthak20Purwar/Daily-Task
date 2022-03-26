package YAML__;
import static Yaml_.YamlReaderFile.getData;
import java.io.FileNotFoundException;
import org.testng.annotations.Test;

public class TestYaml {              

	


	
	    @Test
	    public void fileReader() throws FileNotFoundException
	    {
	        String url=getData("credentials.child1.child2.child3");
	        System.out.println(url);
	    }
	}
	
	
	
}
