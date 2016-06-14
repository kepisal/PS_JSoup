package Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.CacheLookup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG {
	private WebDriver web = null;

	@BeforeSuite
	public void myBrowser() {
		try {
			System.out.println("-------------------------Open Browser----------------------");
			/*System.setProperty("webdriver.ie.driver",
					"D:\\Documents\\Documents\\Selenium Webdriver with Java Language\\lib\\IEDriverServer.exe");*/
			/*ProfilesIni prof=new ProfilesIni();
			FirefoxProfile profile=prof.getProfile("default");
			web=new FirefoxDriver(profile);*/
			web = new FirefoxDriver();
			web.get("http://www.google.com.kh");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/*@BeforeClass
	public void openTab(){
		try {
			System.out.println("************************ New Tab *************************");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@BeforeMethod
	public void navigateTo(){
		System.out.println("------------------ URL Navigate To --------------------");
	}
	
	@AfterMethod
	public void navigateBack(){
		System.out.println("------------------ URL Navigate Back --------------------");
	}
	@Test
	public void tabOne(){
		try {
			web.get("http://www.google.com.kh");
			System.out.println(web.getTitle());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/
	/*@Test
	public void tabTwo(){
		String title=null;
		String Source=null;
		try {
			web.get("https://www.facebook.com/kampucheaonlineshop/timeline");
			title=web.getTitle();
			System.out.println(title);
			System.err.println(web.getCurrentUrl());
			System.out.println("--------------------");
			File scrFile=((TakesScreenshot)web).getScreenshotAs(OutputType.FILE);
			try {
				//FileUtils.copyFile(scrFile, "d://screenshot.png");
				FileUtils.copyFile(scrFile, new File("d://"+title+".png"));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			Source = web.getPageSource();
			Document doc = Jsoup.parse(Source);
			Elements el=doc.select("div._5pcb");
			System.out.println(el);
			
			
			Writer writer = null;

			try {
			    writer = new BufferedWriter(new OutputStreamWriter(
			          new FileOutputStream("d://"+title+".txt"), "utf-8"));
			    writer.write(Source);
			} catch (IOException ex) {
			  // report
			} finally {
			   try {writer.close();} catch (Exception ex) {ignore}
			}
			
			//System.err.println(web.getPageSource());
			System.out.println("--------------------");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/
	/*@AfterClass
	public void closeTab(){
		try {
			System.out.println("************************ Close Tab *************************");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void closeBrowser(){
		if(web!=null){
			web.quit();
			web =null;
			System.out.println("************************ Quit Browser *************************");
		}
	}*/

}
