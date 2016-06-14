package Testing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ptd {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String html=null;
		try(BufferedReader br = new BufferedReader(new FileReader("D:\\(1) Kampuchea Online Shop.txt"))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		   html= sb.toString();
		}
		Document doc = Jsoup.parse(html);
		Elements el=doc.select("div.uiScaledImageContainer img");
		System.out.println(el.attr("src"));
	}
}
