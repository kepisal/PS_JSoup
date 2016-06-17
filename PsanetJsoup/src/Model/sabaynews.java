package Model;

import org.apache.taglibs.standard.tag.common.core.ForEachSupport;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.JsonArray;

public class sabaynews {
	public static void main(String[] args) {
		//action=do_action_ajax&do_action=moreposts&term_id=3&term_name=cat&paged=3
		try {
			int i=1;
			while(true){
			Document doc=Jsoup.connect("http://news.sabay.com.kh/wp-content/themes/sabaynews_v9.0.1/ajax.php")
					.data("action","do_action_ajax")
					.data("do_action","moreposts")
					.data("term_id","3")
					.data("term_name","cat")
					.data("paged",Integer.toString(i))
					.userAgent("Mozilla")
					.timeout(10000)
					.ignoreContentType(true)
					.followRedirects(true)
					.post();
			Thread.sleep(3000);
			String jsondata = doc.body().text();
			
			if(jsondata.contains("msg")){
				break;
			}else{
				//JSONArray jsonarray=new JSONArray(jsondata);
				//System.err.println("page"+i+"+++Content : +++"+jsonarray.length()+"++++++++");
				System.err.println("page : "+i);
				i++;
			}
			/*JSONArray jsonarray=new JSONArray(jsondata);
			if(jsonarray.length()>0){
				System.err.println("++++++++++++++++++++"+i+"+++++++++++++++++++++++");
				jsonarray=null;
					i++;

			}*/
			}
			/*for(int i=0; i<jsonarray.length(); i++){
				JSONObject jsonobj = jsonarray.getJSONObject(i);
				System.out.println(jsonobj +"\n\n");
			}*/
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
