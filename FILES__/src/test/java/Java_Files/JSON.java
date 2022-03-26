package Java_Files;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON {

	public static void main(String[] args) throws IOException, ParseException {
		
		JSONParser objectparser = new JSONParser();
		FileReader reader = new FileReader("C:\\Users\\devel\\eclipse-workspace\\YAML2\\Files\\JSON.json");
		Object object = objectparser.parse(reader);
		JSONObject objectObject= (JSONObject)object;
		
		String fname= (String) objectObject.get("firstname");
		String lname= (String) objectObject.get("lastname");
		
		
		System.out.println(fname);
		System.out.println(lname);
		System.out.println("                          ");
	    System.out.println("                          ");
		
	    JSONArray objectarray = (JSONArray)objectObject.get("address");
	    
	    for(int i = 0 ; i<objectarray.size() ; i++)
	    {
	    	JSONObject objectaddress = (JSONObject)objectarray.get(i);
	    	String street =(String)objectaddress.get("street");
            String city =(String)objectaddress.get("city");
			String state =(String)objectaddress.get("state");
			
		    System.out.println("                          ");
		    System.out.println("                          ");
			System.out.println("Street :" +street);
			System.out.println("City :" +city);
			System.out.println("State :" +state);
			
	    }
	}
	
	
}
