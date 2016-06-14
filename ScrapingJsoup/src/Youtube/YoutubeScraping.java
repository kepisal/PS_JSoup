package Youtube;
/**
 * 
 */

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jaunt.JauntException;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.SearchException;
import com.jaunt.UserAgent;

/**
 * @author Pisal
 *
 */
public class YoutubeScraping {

	/*public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("http://jsoup.org").get();

			Element link = doc.select("a").first();
			String relHref = link.attr("href"); // == "/"
			String absHref = link.attr("abs:href"); // "http://jsoup.org/"
			System.out.println(relHref);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/
	public static void main(String[] args) throws JauntException {
		UserAgent userAgent = new UserAgent();         //create new userAgent (headless browser)
		userAgent.visit("http://www.cnn.com");          //visit google
		System.out.println(userAgent.response.getMessage());
		/*userAgent.doc.apply("butterflies");            //apply form input (starting at first editable field)
		userAgent.doc.submit("Google Search");         //click submit button labelled "Google Search"
		     
		com.jaunt.Elements links = userAgent.doc.findEvery("<h3 class=r>").findEvery("<a>");  //find search result links
		for(com.jaunt.Element link : links) System.out.println(link.getAt("href")); */          //print results
	}
}
