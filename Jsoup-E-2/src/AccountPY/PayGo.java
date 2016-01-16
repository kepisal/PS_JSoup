package AccountPY;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

public class PayGo {
	public static void main(String arg[]){
		String HostName = "https://www.paygo24.com";
		
		try {
			String useragent="Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36";
			Connection.Response response=Jsoup.connect(HostName).userAgent(useragent).method(Connection.Method.GET).timeout(5000).execute();
			response = Jsoup.connect(HostName+"/account/logon")
					.cookies(response.cookies()).data("login","85569272102").data("password","160689").data("show_password","on").userAgent(useragent)
					.ignoreContentType(true).followRedirects(true).method(Connection.Method.POST).execute();
			Document doc=Jsoup.connect(HostName).cookies(response.cookies()).userAgent(useragent).timeout(5000).get();
			Elements element = doc.select("div.menu");
			String accountnumber = element.select("a#account").html();
			String balance = element.select("a#balance").html();
			
			System.out.println("Account Number : "+accountnumber);
			System.out.println("Balance Number : "+balance);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
