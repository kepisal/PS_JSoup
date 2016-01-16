package BongThom;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator.IsEmpty;

import Model.mBongthom;

public class clsBongThom {
	
	
	public static void main(String[] args) {
		ArrayList<mBongthom> bongthomList = new ArrayList<mBongthom>();
		mBongthom bt;
		Document doc;
		int i=0, j=1;;
		
		try {
		while(true){
			doc = Jsoup.connect("http://www.bongthom.com/Jobs/ipgeJobsList.asp?SID={1B614977-A131-4934-8E38-F7133D17069B}&CurrentPage="+j+"&fQV=1")
					.timeout(30000)
					.get();
			Elements element = doc.select("table#tblList");
			if(element.html().length()<=0){
				break;
			}else{
			while(true){
			if(element.select("tr#LinkCell"+i).text().length() <=0){
				System.out.println("Page "+j+". Element "+i);
				i=0;
				break;
			}else{
				bt=new mBongthom();				
				bt.setJobID(element.select("tr#LinkCell"+i+" td").get(0).text());
				bt.setJobTitle(element.select("tr#LinkCell"+i+" td").get(1).text());
				bt.setCompanyName(element.select("tr#LinkCell"+i+" td").get(2).text());
				bt.setCloseDate(element.select("tr#LinkCell"+i+" td").get(3).text());
				bt.setCategory(element.select("tr#LinkCell"+i+" td").get(4).text());
				bongthomList.add(bt);
				
			}
			i++;
			
			}j++;}
		}
		System.out.println("Number job records : "+bongthomList.size());
		for (mBongthom mBongthom : bongthomList) {
			System.out.println(mBongthom.toString());
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
