package Browser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class loading {
public static void main(String[] args) {
	try {
		Document doc=Jsoup.connect("http://www.gsmarena.com/").userAgent("Mozillar").get();
		System.out.println(doc.baseUri());
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
