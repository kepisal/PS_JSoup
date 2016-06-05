package Model;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
			String source = null;
			kaymu k = new kaymu();
			document = k.getDocument("http://www.kaymu.com.kh", 10000);
			for (Element string : k.getScript()) {
				source+= string.data();
			}
			//System.out.println(source);
			 source= StringGrap(source, "categoryData =", "}]]}];");
			 source= source.substring(source.indexOf("=")+2, source.indexOf(";"));
			 System.out.println(source);
			 JsonParser jp=new JsonParser();
			 JsonObject json=(JsonObject)jp.parse(source);
			 System.out.println(json.get("Name"));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.writeLogException(e, "A", "B");
		}
	}
}
