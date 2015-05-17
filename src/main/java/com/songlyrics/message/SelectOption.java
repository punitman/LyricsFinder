package com.songlyrics.message;

import java.security.cert.PKIXRevocationChecker.Option;

import com.songlyrics.fields.ConstantData;

public class SelectOption {
	private static String option(String op){
		String result="";
		op=op.charAt(0)+"";
		op=op.toLowerCase().trim();
		if(op.compareTo("s")==0)
			result=ConstantData._OPTION_SEARCH.toString();
		else if(op.compareTo("i")==0)	
			result=ConstantData._OPTION_INSERT.toString();
		else if(op.compareTo("a")==0)
			result=ConstantData._OPTION_SEARCH_ALL.toString();
		else if(op.compareTo("d")==0)
			result=ConstantData._OPTION_DELETE.toString();
		else if(op.compareTo("e")==0)
			result=ConstantData._OPTION_EXIT.toString();
//		System.out.println(result);
		return result;
	}
	public static String select(){
		System.out.println("===========OPTIONS==============");
		System.out.println("     Insert      press : i");
		System.out.println("     Search      press : s");
		System.out.println("     Display all press : a");
		System.out.println("     Delete      press : d");
		System.out.println("     Exit        press : e");
		System.out.println("================================");
		return option(UI_userinput.input("Choice"));
	}

}
