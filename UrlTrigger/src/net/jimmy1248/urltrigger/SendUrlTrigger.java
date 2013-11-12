package net.jimmy1248.urltrigger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class SendUrlTrigger {
	public String inputLine;
	public SendUrlTrigger(String url) {
		
		try{
		    URLConnection myURLConnection = new URL(url).openConnection();
		    BufferedReader in = new BufferedReader(
		    		new InputStreamReader(
                    myURLConnection.getInputStream()));
		    
		    
		    while ((inputLine = in.readLine()) != null) 
		    in.close();

	        
		    //myURLConnection.getDate();
		    
		} 
		catch (MalformedURLException e) { 
		    // new URL() failed
		    // ...
		} 
		catch (IOException e) {   
		    // openConnection() failed
		    // ...
		}
	}
	public String getResponse(){
		return inputLine;
	}

}
