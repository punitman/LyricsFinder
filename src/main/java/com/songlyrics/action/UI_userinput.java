package com.songlyrics.action;

import java.util.Scanner;

public class UI_userinput {
	
	public static String input(){
		Scanner scan =new Scanner(System.in);
		System.out.print("Enter Data :");
		return scan.nextLine();
		
	}
	public static String input(String data){
		Scanner scan =new Scanner(System.in);
		System.out.print("Enter "+data+" :");
		return scan.nextLine();	
	}
	public static int inputInt(String data){
		Scanner scan =new Scanner(System.in);
		System.out.print("Enter "+data+" :");
		return scan.nextInt();	
	}
}
