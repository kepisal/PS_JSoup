package Process;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
 
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.security.cert.X509Certificate;

public class khmer24 {
	public static void main(String[] args) throws Exception {
		try {
//			System.setProperty(key, value)
			Document doc = Jsoup.connect("https://www.khmer24.com").userAgent("Mozilla").get();
			Element myelemet  = doc.body();
			System.out.println(myelemet.select("div.category_block"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
