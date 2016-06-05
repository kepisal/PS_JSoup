package Browser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import branch.IBrowser;
import utilities.Logger;

public class mybrowser implements IBrowser {

	@Override
	public Document getDocument(String URL, int timeout) {
		// TODO Auto-generated method stub
		try {
			return Jsoup.connect(URL).timeout(timeout).get();
		} catch (Exception e) {
			// TODO: handle exception
			Logger.writeLogException(e, "getDocument", this.toString());
		}
		return null;
	}

	@Override
	public Document getDocumentBrowser(String URL, int timeout, String useragent, boolean ignoreContentype,
			boolean isRedirect) {
		// TODO Auto-generated method stub
		try {
			return Jsoup.connect(URL).userAgent(useragent).ignoreContentType(ignoreContentype)
					.followRedirects(isRedirect).timeout(timeout).get();
		} catch (Exception e) {
			// TODO: handle exception
			Logger.writeLogException(e, "getDocument", this.toString());
		}
		return null;
	}
	
	public void StringGrap(){
		
	}
}
