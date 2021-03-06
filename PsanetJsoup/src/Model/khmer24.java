package Model;

import org.jsoup.nodes.Document;

import com.mysql.jdbc.MySQLConnection;

import Browser.mybrowser;
import branch.IBrowser;
import utilities.Logger;

public class khmer24 extends mybrowser {
	private final String hostname = "https://www.khmer24.com/";
	private int timeout = 10000;
	private Document khmerdoc=null;
	public khmer24(){
		try {
			khmerdoc = getDocumentBrowser(hostname, timeout, "Mozilla", true, true);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.writeLogException(e, "constructor", this.getClass().getName());
		}
	}
	public Document getKhmerDoc(){
		return khmerdoc = khmerdoc!=null ? this.khmerdoc:null;
	}
	//https://www.khmer24.com/all-categories.html
	public Document getAllProductsInCategory(String pathUrl){
		String hostname = this.hostname+pathUrl;
		if(this.khmerdoc!=null){
			khmerdoc = getDocumentBrowser(hostname, timeout, "Mozilla", true, true);
			return khmerdoc;
		}
		return null;
	}
	
	
	
	public static void main(String[] args) {
		/*System.out.println(new khmer24().getKhmerDoc().select("ul.main_cat"));
		System.out.println(new khmer24().getKhmerDoc().select("section.popular_cat"));*/
		System.out.println(new khmer24().getAllProductsInCategory("/all-categories.html").title());
	}
}
