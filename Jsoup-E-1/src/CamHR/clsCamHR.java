package CamHR;

import java.util.Map;
import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class clsCamHR {
public static void main(String[] args) {
		
		final String HostName ="http://www.camhr.com"; 
		
		String csrf_test_name;
		String login;
		String password;
		
		String mQuery;
		
		String _Username,_Firstname,_Lastname,_Sex,_Dob,_Email,_Mobile,_Address;
		
		
		Scanner sc=new Scanner(System.in);
		/*
		 * This's step to select specific data on the websites.
		 * 1. URL Target.
		 * 2. Identify Browser Agent.
		 * 3. Connect to URL.
		 * 4. Identify block and Select element.
		 * 5. Crop the data.
		 * 6. OUtput.
		 * */
		
		
		try {
			
			String url = HostName;
            String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.130 Safari/537.36";

            Connection.Response response = Jsoup.connect(url).userAgent(userAgent)
                    .method(Connection.Method.GET)
                    .execute();

            Map<String, String> cooking= response.cookies();
            System.out.println(cooking);
            response = Jsoup.connect(HostName+"/pages/user/UserLogin.json?r=")
                    .cookies(response.cookies())
                    .data("name", "kepisal")
					.data("password", "s0keangpisal")
                    .userAgent(userAgent)
                    .ignoreContentType(true)
                    .method(Connection.Method.POST)
                    .followRedirects(true)
                    .execute();            
            
            Document doc = Jsoup.connect(HostName+"/pages/user/UserEdit.action")
                    .cookies(response.cookies())
                    .userAgent(userAgent)
                    .get();

            Elements element = doc.select("form#usersave div");
			
			_Username = element.get(0).select("label").get(1).html();
			_Firstname = element.get(1).select("input").val();
			_Lastname = element.get(2).select("input").val();
			_Sex = element.get(4).select("select option[selected]").text();
			
			_Dob = element.get(5).select("input[value]").val();
			_Email = element.get(6).select("label").get(1).html();
			_Mobile= element.get(8).select("input[value]").val();
			_Address = element.get(11).select("input[value]").val();
			
			System.out.println("--------------------------- Your Profile ---------------------------");
            System.out.println("User Name     : " + _Username);
            System.out.println("First Name    : " + _Firstname);
            System.out.println("Last Name     : " + _Lastname);
            System.out.println("Sex           : " + _Sex);
			
            System.out.println("Date of Birth : " + _Dob);
            System.out.println("Email         : " + _Email);
            System.out.println("Mobile        : " + _Mobile);
            System.out.println("Address       : " + _Address);
            System.out.println("--------------------------- Your Profile ---------------------------");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
