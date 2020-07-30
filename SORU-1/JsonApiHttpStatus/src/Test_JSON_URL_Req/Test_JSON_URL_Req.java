package Test_JSON_URL_Req;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test_JSON_URL_Req {
public static void main(String[] args) throws IOException {
	
	
	try {
		
		String url_adress="http://generator.swagger.io/api/swagger.json";
		URL obj=new URL(url_adress);
		HttpURLConnection conn = (HttpURLConnection)obj.openConnection();
		
		conn.setRequestMethod("GET");
		conn.connect();
		
		int response_code=conn.getResponseCode();
		
		if(response_code != 200)
			{
				System.out.println("Test failed.");
				throw new RuntimeException("HttpResponseCode: " + response_code);
			}
			else
			{
				System.out.println("Test successful."); 
			}
		
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
