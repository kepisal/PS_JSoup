package Model;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mysql.jdbc.log.Log;

import Browser.mybrowser;
import utilities.Logger;

public class shop168 extends mybrowser {
	private final String hostname = "http://shop168.com.kh/";
	private int timeout = 10000;
	private Document shop168doc = null;
	public shop168(){
		try {
			shop168doc = getDocument(hostname, 	timeout);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.writeLogException(e, "Constructor", this.getClass().getName());
		}
	}
	public Document getPageShop168(){
		return shop168doc;
	}
	public Document getPageShop168(String pathURL, int timeout){
		String URL = hostname+pathURL;
		return getDocumentBrowser(URL, (timeout=timeout<1000?5000:timeout), "Mozilla", true, true);
	}
	public static void main(String[] args) {
		/*System.out.println(new shop168().getPageShop168("mobiles-and-tablets-kh/mobile-phones-kh/", 10000)
				.select("div.product-info"));*/
		Elements elements=new shop168().getPageShop168().select("div#products_new");
		elements = elements.select("div.pin_main_container");
		System.out.println(elements.select("div table.center-block td.product-title-wrap").get(0).text());
	}
}
