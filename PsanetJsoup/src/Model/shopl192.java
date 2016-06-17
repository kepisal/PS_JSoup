package Model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class shopl192 {
	public static void main(String[] args) {
		try {
			String url ="http://www.khbuy.com/index.php?act=search&op=index&cate_id=162&b_id=0&a_id=0&key=0&order=0&type=0&area_id=0&curpage=3&get_more=1";
			Document doc = Jsoup.connect(url).timeout(5000).get();
			Elements elements = doc.select("ul.list_pic");
			for (Element element : elements) {
				System.out.println("\n"+ element.select("span.cutOff_tag").text());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
