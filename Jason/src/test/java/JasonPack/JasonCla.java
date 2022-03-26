package JasonPack;





import java.io.FileReader;

import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JasonCla {





	public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException{
		FileReader reader = new FileReader("C:\\Users\\devel\\eclipse-workspace\\Jason\\src\\test\\java\\JasonPackla\\filea.json");

		JSONParser jsonparser = new JSONParser();
		Object obj = jsonparser.parse(reader);

		JSONObject empjsonobj = (JSONObject) obj;

//		String fname = (String) empjsonobj.get("username");
//		String lname = (String) empjsonobj.get("password");
//
//		System.out.println("First name:" + fname);
//		System.out.println("Last name:" + lname);
//		
//		
		JSONArray array=(JSONArray)empjsonobj.get("userlogins");
		
		for(int i=0;i<array.size();i++)
		{
			JSONObject address= (JSONObject)array.get(i);
			
			String street = (String)address.get("username");
			String city = (String)address.get("password");
		
			
			System.out.println("Address of "+(i+1)+" employee is : ");
			System.out.println("Street --- "+ street);
			System.out.println("City --- "+ city);
			
			
		}

	}

	
	
}
