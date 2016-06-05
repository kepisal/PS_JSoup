package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Browser.mybrowser;
import bsh.Parser;
import utilities.Convertor;
import utilities.Logger;

public class kaymu extends mybrowser {		
	
	public Elements getScript(){
		Elements result=null;
		if (document != null){
			result = document.getElementsByTag("script");
		}		
		return result; 
	}
	
	
	public static void main(String[] args) {
		try {
			/*String source = null;
			kaymu k = new kaymu();
			document = k.getDocument("http://www.kaymu.com.kh", 10000);
			for (Element string : k.getScript()) {
				source+= string.data();
			}
			//System.out.println(source);
			 source= StringGrap(source, "categoryData =", "}]]}];");
			 source= source.substring(source.indexOf("=")+2, source.indexOf(";"));
			 System.out.println(source);
			 
			 Object obj = new JsonParser().parse(source);
			 JSONObject jsonobject = (JSONObject)obj;
			 System.out.println(jsonobject.length());*/
			 //JSONArray array = (JSONArray)jsonobject.get;
			 /*for(int i=0; i<array.length(); i++){
				 System.out.println(array.get(i));
			 }*/
			 
			/* JsonParser jp=new JsonParser();
			 //JsonObject json=(JsonObject)jp.parse(source);
			 Object obj = jp.parse(source);
			 JSONObject json=(JSONObject)obj;
			 String link =(String)json.get("link");
			 String id= (String)json.get("id");
			 String name = (String)json.get("name");
			 System.out.println(name);*/
			
			
			String jsonData = "";
			BufferedReader br = null;
			try {
				String line;
				br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"//jsob.txt"));
				while ((line = br.readLine()) != null) {
					jsonData += line + "\n";
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			// System.out.println("File Content: \n" + jsonData);
			JSONObject obj = new JSONObject(jsonData);
			//System.out.println("blogURL: " + obj.getString("name"));
			System.out.println("twitter: " + obj.getString("twitter"));
			System.out.println("social: " + obj.getJSONObject("social"));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.writeLogException(e, "A", "B");
		}
	}
}
