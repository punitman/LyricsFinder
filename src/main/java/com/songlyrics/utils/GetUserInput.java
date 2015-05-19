package com.songlyrics.utils;

import java.util.Scanner;

public class GetUserInput {
	
	public static String getInput(){
		Scanner scan =new Scanner(System.in);
		System.out.print("Enter Data :");
		return scan.nextLine();
		
	}
	public static String getInput(String data){
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
