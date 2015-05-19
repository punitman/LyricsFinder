package com.songlyrics.utils;

import com.songlyrics.fields.FIELDS;

public class ShowActionOption {
	private static String getFullfrom(String option){
		option=option.charAt(0)+"";
		option=option.toLowerCase().trim();
		String expendedform="";
		if(option.equals("s"))
			expendedform= FIELDS._OPTION_SEARCH.toString();
		else if(option.equals("i"))	
			expendedform= FIELDS._OPTION_INSERT.toString();
		else if(option.equals("a"))
			expendedform= FIELDS._OPTION_SEARCH_ALL.toString();
		else if(option.equals("d"))
			expendedform= FIELDS._OPTION_DELETE.toString();
		else if(option.equals("e"))
			expendedform= FIELDS._OPTION_EXIT.toString();
		return expendedform;
	}
	public static String selectOption(){
		System.out.println("===========OPTIONS==============");
		System.out.println("     Insert      press : i");
		System.out.println("     Search      press : s");
		System.out.println("     Display all press : a");
		System.out.println("     Delete      press : d");
		System.out.println("     Exit        press : e");
		System.out.println("================================");
		return getFullfrom(GetUserInput.getInput("Choice"));
	}

}
