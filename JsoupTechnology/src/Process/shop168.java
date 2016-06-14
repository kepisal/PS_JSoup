package Process;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class shop168 {
public static void main(String[] args) {
	try {
		Document doc = Jsoup.connect("http://shop168.com.kh/?sl=EN").timeout(10000).get();
		//Elements element = doc.select("div.wrap-dropdown-multicolumns li");
		Elements element = doc.select("ul.dropdown-multicolumns li");
		for (Element element2 : element) {
			System.out.println(element2.html());
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
