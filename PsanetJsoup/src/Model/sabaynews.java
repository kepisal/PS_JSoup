package Model;

import java.io.InputStream;

import org.apache.taglibs.standard.tag.common.core.ForEachSupport;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Connection.KeyVal;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.helper.HttpConnection.Response;
import org.jsoup.nodes.Document;

import com.google.gson.JsonArray;

public class sabaynews {
	public static void main(String[] args) {
		//action=do_action_ajax&do_action=moreposts&term_id=3&term_name=cat&paged=3
		//action=do_action_ajax&do_action=add_post_view&post_id=747858
		//action=do_action_ajax&do_action=moreposts&term_id=3&term_name=cat&paged=3
		String url="http://news.sabay.com.kh/wp-content/themes/sabaynews_v9.0.3/ajax.php";
		try {
			int i=500;
			do{
				Connection con = HttpConnection.connect(url)
						.method(Method.POST)
						.data("action","do_action_ajax")
						.data("do_action","moreposts")
						.data("term_id","3")
						.data("term_name","cat")
						.data("paged",Integer.toString(i))
						.timeout(10000)
						.ignoreContentType(true);
				org.jsoup.Connection.Response res = con.execute();
				if(res.equals(null)){
					System.out.println("break");
					break;
				}else{
				System.out.println(res.body());
				}
				i++;
			}while(true);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
