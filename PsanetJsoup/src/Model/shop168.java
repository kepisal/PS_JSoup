package Model;

import java.sql.Connection;
import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.log.Log;

import Browser.mybrowser;
import utilities.DatabaseConnection;
import utilities.Logger;

public class shop168 extends mybrowser {
	private final String hostname = "http://shop168.com.kh/";
	private int timeout = 10000;
	private Document shop168doc = null;

	public shop168() {
		try {
			shop168doc = getDocument(hostname, timeout);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.writeLogException(e, "Constructor", this.getClass().getName());
		}
	}

	public Document getPageShop168() {
		return shop168doc;
	}

	public Document getPageShop168(String pathURL, int timeout) {
		String URL = hostname + pathURL;
		return getDocumentBrowser(URL, (timeout = timeout < 1000 ? 5000 : timeout), "Mozilla", true, true);
	}

	//public boolean 
	public static void main(String[] args) {
		ArrayList<product> productcollection = new ArrayList<product>();
		Connection con;
		PreparedStatement stmt=null;
		try {
			con = DatabaseConnection.getConnection();
			String img, link, price, title;
			Elements elements = new shop168().getPageShop168().select("div#products_new");
			elements = elements.select("div.pin_main_container").select("div table.center-block");
			// .select("td.product-image");

			for (Element element : elements) {
				img = element.select("td.product-image").select("a").attr("href").trim();
				link = element.select("td.product-image").select("img").attr("src").trim();
				title = element.select("a.product-title").text().trim();
				price = element.select("span.price-num").text();
				productcollection.add(new product(img, link, price, title));
			}
			
			//System.out.println("Database process ...");
			int i=1;
			for (product element : productcollection) {
				stmt=con.prepareStatement("insert into tbproduct values(?,?,?,?,?)");
				stmt.setInt(1, i);
				stmt.setString(2, element.getImage_link());
				stmt.setString(3, element.getLink());
				stmt.setString(4, element.getTitle());
				stmt.setString(5, element.getPrice());
				stmt.executeUpdate();
				
				i++;
			}
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		/*
		 * System.out.println(new
		 * shop168().getPageShop168("mobiles-and-tablets-kh/mobile-phones-kh/",
		 * 10000) .select("div.product-info")); Elements elements=new
		 * shop168().getPageShop168().select("div#products_new"); elements =
		 * elements.select("div.pin_main_container");
		 * System.out.println(elements.select(
		 * "div table.center-block td.product-title-wrap").get(0).text());
		 */
	}
}
