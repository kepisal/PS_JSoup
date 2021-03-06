package branch;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public interface IBrowser {
	Document getDocument(String URL, int timeout);

	Document getDocumentBrowser(String URL, int timeout, String useragent, boolean ignoreContentype,
			boolean isRedirect);
}
