package Browser;

import java.awt.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import branch.IBrowser;
import utilities.Logger;

public class mybrowser{
	public static Document document=null; 
	private String URL;
	private String useragent;
	private boolean isRedirect, ignoreContentType;
		
	public Document getDocument(String URL, int timeout) {
		// TODO Auto-generated method stub
		try {
			return Jsoup.connect(URL).timeout(timeout).get();
		} catch (Exception e) {
			// TODO: handle exception
			Logger.writeLogException(e, "getDocument", this.toString());
		}
		return null;
	}

	public Document getDocumentBrowser(String URL, int timeout, String useragent, boolean ignoreContentype,
			boolean isRedirect) {
		// TODO Auto-generated method stub
		try {
			return Jsoup.connect(URL).userAgent(useragent).ignoreContentType(ignoreContentype)
					.followRedirects(isRedirect).timeout(timeout).get();
		} catch (Exception e) {
			// TODO: handle exception
			Logger.writeLogException(e, "getDocument", this.toString());
		}
		return null;
	}
	
	public static String StringGrap(String sources,String start,String end){
		String result=null;
		String pattern=start+"(.+?)"+end;
		Pattern p=Pattern.compile(pattern);
		Matcher m=p.matcher(sources);
		if(m.find()){
			result=m.group(0);
		}
		return result;
	}
	public static ArrayList<String> StringGrapArray(String sources,String start,String end){
		String pattern=start+"(.+?)"+end;
		Pattern mypattern = Pattern.compile(pattern);
		ArrayList<String> tagValue= new ArrayList<String>();
		Matcher m=mypattern.matcher(sources);
		while(m.find()){
			tagValue.add(m.group(1));
		}
		return tagValue;		
	}
	public static String subString(String data,String begin, String end){		
		return data.substring(data.indexOf(begin), data.indexOf(end)+end.length());
	}
}
