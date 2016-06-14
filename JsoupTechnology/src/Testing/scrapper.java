package Testing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class scrapper {
	public static void main(String[] args) {
		try {
			Document document=Jsoup.connect("http://www.gsmarena.com/").timeout(10000).get();
			System.out.println(document.body().select("p"));
			//System.out.println(document.head());
			//Elements anchors = document.select("div");
			/*for(Element anchor : anchors){
				System.out.println(anchor);
			}*/
		} catch (Exception e) {
			// TODO: handle exception
			//Logger.writeLogException(e, e.getMessage(), null);
		}
	}
}
