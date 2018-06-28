package Utilities;

import java.net.HttpURLConnection;
import java.net.URL;



public class Utils {
	public static void main(String[] args) {
		boolean f=verifyhub("http://localhost:4444/wb/hub");
		System.out.println(f);
	}

	public static boolean verifyhub(String huburl){
		
		URL url;
		try{
			
			url=new URL(huburl);
			HttpURLConnection connectionurl=(HttpURLConnection)url.openConnection();
			
			connectionurl.setRequestMethod("GET");
			
			connectionurl.connect();
			
			
			int code=connectionurl.getResponseCode();
			
			String response=connectionurl.getResponseMessage();
			
			String concat=response+code;
			
			if((response+code).equals("200k"))
			{
				return true;
				
				
				
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	
		
	}
	
	
	
}
