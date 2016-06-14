package Process;

import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class kaymu {
	public static void main(String[] args) {
		String sb=null;
		try {
			Document doc=Jsoup.connect("http://www.kaymu.com.kh/").timeout(5000).get();
			//System.out.println(doc.body().data());
			Elements el=doc.getElementsByTag("script");
			/*for(Element ele:el){
				System.out.println(ele);
			}*/
			for (Element element :el ){                
		        for (DataNode node : element.dataNodes()) {
		            sb = node.getWholeData();
		        }
		  }
			System.out.println(sb.substring(sb.indexOf("[{\"link\":"), sb.indexOf("}]]}]") + 5));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
