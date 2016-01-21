package hostpot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class wifihostpot {
	private String getInformation() {

		StringBuffer output = new StringBuffer();
		String command = "netsh wlan show drivers";
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}

	private String creatingHostpot(String hostname, String password) {

		StringBuffer output = new StringBuffer();
		String command = "netsh wlan set hostednetwork mode=allow ssid=" + hostname + " key=" + password + "";
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}

	private String startingHostpot() {

		StringBuffer output = new StringBuffer();
		String command = "netsh wlan start hostednetwork";
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}

	private String stoppingHostpot() {

		StringBuffer output = new StringBuffer();
		String command = "netsh wlan stop hostednetwork";
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}

	private String getClientConnected() {

		StringBuffer output = new StringBuffer();
		String command = "netsh wlan show hostednetwork";
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}

	private boolean confrimkey(int i) {
		boolean exitSystem=false;
		String hostname = null,password=null;
		try {
			switch (i) {
			case 1:
				System.out.println(new wifihostpot().getInformation());
				break;
			case 2:
				System.out.print("\nWiFi-Name : ");
				hostname=new Scanner(System.in).nextLine();
				System.out.print("\nWiFi-Password : ");
				password =new Scanner(System.in).nextLine();
				System.out.println(new wifihostpot().creatingHostpot(hostname, password));
				break;
			case 3:
				System.out.println(new wifihostpot().startingHostpot());
				break;
			case 4:
				System.out.println(new wifihostpot().stoppingHostpot());
				break;
			case 5:
				System.out.println(new wifihostpot().getClientConnected());
				break;
			case 0:
				exitSystem=true;
				break;
			default:
				System.err.println("invalid input");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exitSystem;
	}

	public void createWIFIHOSTPOT() {
		Integer s = 0;
		do{
			System.out.print("--------------- WIFI-HOTSPOT TOOL ---------------" + "\n");
			System.out.print("1. Getting Information \n" + "2. Creating Hotspot \n" + "3. Starting Hotspot \n"
					+ "4. Stopping Hotspot \n" + "5. Getting Clients access \n" + "0. Exit \n");
			System.out.print("Choose Option : ");
			s = new Scanner(System.in).nextInt();
			if(confrimkey(s)){
				System.exit(0);
			}
		}while(true);
		
		
	}

	public static void main(String[] args) {
		wifihostpot obj = new wifihostpot();
		obj.createWIFIHOSTPOT();
	}

}
