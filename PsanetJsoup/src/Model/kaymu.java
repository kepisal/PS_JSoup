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
	private Document kaymu_document=null;
	private ArrayList<MainCategories> maincategory_array=null;
	private Elements kaymu_body=null;
	private Element kaymu_element=null;
	
	public kaymu(String URL, int timeout){
		kaymu_document = super.getDocument(URL, timeout);
	}
	public Document resetDocument(String URL, int timeout,String useragent, boolean ignoreContentype, boolean isRedirect){
		if (kaymu_document!=null){
			kaymu_document = super.getDocumentBrowser(URL, timeout, useragent, ignoreContentype, isRedirect);
		}
		return kaymu_document;
	}
	public Elements getAllElement(String Tag){
		Elements result=null;
		if (kaymu_document != null){
			result = kaymu_document.getAllElements();
		}		
		return result; 
	}
	
	
	public Elements getClass(String className){
		Elements result=null;
		if (kaymu_document != null){
			result = kaymu_document.getElementsByClass(className);
		}		
		return result; 
	}
	
	public Elements getTag(String Tag){
		Elements result=null;
		if (kaymu_document != null){
			result = kaymu_document.getElementsByTag(Tag);
		}		
		return result; 
	}
	
	public Elements getScript(){
		Elements result=null;
		if (kaymu_document != null){
			result = kaymu_document.getElementsByTag("script");
		}		
		return result; 
	}
	
	
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("http://www.kaymu.com.kh/").timeout(10000).get();
			Elements ele = doc.select("body");
			System.out.println(ele);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.writeLogException(e, "A", "B");
		}
	}
}
