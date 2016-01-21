package Delimeters;

import java.util.Scanner;

public class StringDelimeter {
	public void test(){
		
	}
	public static void main(String[] args) {
		String str="10 fish, 20 cows, ABC[20]";
		Scanner sc=new Scanner(str);
		System.out.println(sc.nextLine());
		sc.useDelimiter(", *");
		System.out.println(sc.delimiter());
	}
}
