package com.songlyrics.utils;


import java.util.List;

import com.songlyrics.fields.Documents;

public class ShowDocument {
	private static boolean detail=true;
	public static void displayDocumentList(List<Documents> documentList){
//		if(list.size()>1)
//			detail=false;
		for (int i = 0; i < documentList.size(); i++) {
			try{
				System.out.println("S.No> "+(i+1));
			    displayDocument(documentList.get(i));
			}catch(Exception ex){
				System.out.println("\nSHOWDOCUMENT:error in list num:"+i);
			}
		}
		System.out.println("TOTAL DOCUMENTS FOUND: "+documentList.size());
		detail=true;

	}
	private static void showString(String data){
		if(data.length()>0)
			System.out.println(data);
		else
			System.out.println("unknown");
	}
	public static void displayDocument(Documents document){
		System.out.println("=========================================");
		System.out.print("ID           : ");
		showString(document.getId());
		System.out.print("Album Name   : ");
		showString(document.getAlbum_name());
		System.out.print("Song Title   : ");
		showString(document.getSong_title());
		System.out.print("Lyrics       : ");
		showString(document.getLyrics());
		System.out.print("Rating       : ");
		showString(document.getRating());
		if (detail) {
			System.out.print("Artist       : ");
			showString(document.getArtist());
			System.out.print("Band         : ");
			showString(document.getBand());
			System.out.print("Genre Type   : ");
			showString(document.getGenre_type());
			System.out.print("Released Date: ");
			showString(document.getReleased_date());
		}
		System.out.println("=========================================");
	}
}
