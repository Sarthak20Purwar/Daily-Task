package JASONEP;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JASONCA {

	public static void main(String[] args) throws IOException, ParseException {
	
   //need to parse the json parser
		
		JSONParser jsonparser = new JSONParser();
		
		//load/read the jason file 
		FileReader reader = new FileReader("src\\test\\java\\JasonEF\\file.json");
		
		Object obj =jsonparser.parse(reader);
		
		JSONObject empjsonobj=(JSONObject)obj; //casting to JSON object 
		
		String fname=(String) empjsonobj.get("firstName");  //caste to string
		String lname=(String) empjsonobj.get("lastName");
	    
		
		
		System.out.println(fname);
		System.out.println(lname);
		System.out.println("                          ");
	    System.out.println("                          ");
		
		JSONArray array = (JSONArray)empjsonobj.get("address"); //cast to JSONArray
		
		for(int i =0 ; i<array.size() ; i++)
		{
			JSONObject address =(JSONObject)array.get(i); //again JSON Object
			
			//cast to String
			String street =(String)address.get("street");
            String city =(String)address.get("city");
			String state =(String)address.get("state");
			
			
		
		    System.out.println("                          ");
		    System.out.println("                          ");
			System.out.println("Street :" +street);
			System.out.println("City :" +city);
			System.out.println("State :" +state);
		}

	}

}
