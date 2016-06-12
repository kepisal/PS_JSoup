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
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.reporters.jq.Main;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Browser.mybrowser;
import bsh.Parser;
import utilities.Convertor;
import utilities.Logger;

public class kaymu extends mybrowser {
	private Document kaymu_document = null;
	private JSONArray category_Jsonarray = null;
	private Elements kaymu_body = null;
	private Element kaymu_element = null;
	private String URL = "http://www.kaymu.com.kh/";
	private int timeout = 1000;
	private JSONArray array = null;

	public JSONArray getJsonArray(String jsondata) {
		try {
			array = new JSONArray(jsondata);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		this.URL = uRL;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public kaymu() {
		kaymu_document = super.getDocument(URL, timeout);
	}

	public Document resetDocument(String URL, int timeout, String useragent, boolean ignoreContentype,
			boolean isRedirect) {
		if (kaymu_document != null) {
			kaymu_document = super.getDocumentBrowser(URL, timeout, useragent, ignoreContentype, isRedirect);
		}
		return kaymu_document;
	}

	public Elements getAllElement(String Tag) {
		Elements result = null;
		if (kaymu_document != null) {
			result = kaymu_document.getAllElements();
		}
		return result;
	}

	public Elements getClass(String className) {
		Elements result = null;
		if (kaymu_document != null) {
			result = kaymu_document.getElementsByClass(className);
		}
		return result;
	}

	public Elements getTag(String Tag) {
		Elements result = null;
		if (kaymu_document != null) {
			result = kaymu_document.getElementsByTag(Tag);
		}
		return result;
	}

	public Elements getScript() {
		Elements result = null;
		if (kaymu_document != null) {
			result = kaymu_document.getElementsByTag("script");
		}
		return result;
	}

	public String categoriesData() {
		String data = null;
		for (Element element : this.getScript()) {
			data += element;
		}
		data = subString(StringGrap(data, "categoryData = ", ";"), "[{", "];");
		return data;
	}

	public ArrayList<Categories> getListCategories() {
		ArrayList<Categories> arraylist_category = new ArrayList<Categories>();
		JSONObject jsonObj1, jsonObj2 = null, jsonObj3, jsonObj4 = null;
		JSONArray listcategory_jsonarray = null;
		JSONArray listLastsubcategory = null;
		JSONArray listsubcategory= null;
		JSONArray LastSubCategory=null;
		JSONArray listcategory = null;
		try {
			category_Jsonarray = this.getJsonArray(this.categoriesData()); // MainCategory Array
			
			for(int i=0; i<category_Jsonarray.length(); i++){
				JSONObject obj1 = category_Jsonarray.getJSONObject(i); // Get each object in JSONArray
				System.out.println(obj1.getString("name")); // Output properties value
				if (obj1.has("children")){
					listcategory = obj1.getJSONArray("children"); // Category Array
					//System.out.println("MainCategory "+listcategory);
					outerloop:
					for(int j=0; j<listcategory.length()-1; j++){
						JSONObject obj2 = listcategory.getJSONObject(j); // Get each object in JSONArray
						System.out.println("Category "+obj2.getString("name")); // Output properties value
						if(obj2.has("children")){
							listsubcategory = obj2.getJSONArray("children"); 
							//System.out.println("Category "+listcategory);// SubCategory Array
							
							for(int k=0; k<listsubcategory.length()-1; k++){								
								JSONObject obj3 = listcategory.getJSONObject(k); // Get each object in JSONArray
								//System.out.println("SubCategory "+obj3.getString("name")); //
								if(obj3.has("children")){
									listLastsubcategory = obj3.getJSONArray("children");
									//System.out.println("Last SubCategory "+listLastsubcategory);
									for(int z=0; z<listLastsubcategory.length()-1;z++){
										JSONObject obj4=listLastsubcategory.getJSONObject(z);
										if(obj4.has("children")){
											LastSubCategory = obj4.getJSONArray("children");
											System.out.println("End SubCategory : "+LastSubCategory);
											for(int x=0; x<LastSubCategory.length(); x++){
												JSONObject obj5=LastSubCategory.getJSONObject(x);
												System.out.println("End Object : "+obj5.getString("name"));
											}
											break outerloop;
										}
									}
								}else{
									break outerloop;
								}
								
							}
						
						}
						
					}
					
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//Logger.writeLogException(e, "getlistCategory", kaymu.class.getName());
		}
		return arraylist_category;
	}

	public static void main(String[] args) {
		String data = null;
		try {
			kaymu kaymuobj = new kaymu();
			kaymuobj.getListCategories();
			/*
			 * for (Categories el : kaymuobj.getListCategories()) {
			 * System.out.println(el); }
			 */
		} catch (Exception e) {
			// TODO: handle exception
			Logger.writeLogException(e, "A", "B");
		}
	}
}
