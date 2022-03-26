package JasonPack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class WriteJSONFile {

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	JSONObject obj = new JSONObject();
	Object key,value;
	System.out.print("Enter the required number of keys & value: ");
	int numberOfKeysAndValues=sc.nextInt();
	
	
	for(int i=0 ; i<numberOfKeysAndValues;i++)
	{
		System.out.print("Enter key :");
		key=sc.next();
		System.out.print("Enter value :");
		value=sc.next();
		obj.put(key, value);
	}
	try {
		FileWriter fw = new FileWriter("C:\\Users\\devel\\eclipse-workspace\\Jason\\writerJSON.json");
		fw.write(obj.toString());
		fw.close();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
	
	}

}
