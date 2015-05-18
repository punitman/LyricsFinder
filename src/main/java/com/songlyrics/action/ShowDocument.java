package com.songlyrics.action;


import java.util.List;

import com.songlyrics.fields.Documents;

public class ShowDocument {
	private static boolean detail=true;
	public static void display(List<Documents> list){
//		if(list.size()>1)
//			detail=false;

		System.out.println("list size"+list.size());
		for (int i = 0; i < list.size(); i++) {
			try{
				System.out.println("S.No> "+i);
			    display(list.get(i));
			}catch(Exception ex){
				System.out.println("\nSHOWDOCUMENT:error in list num:"+i);
			}
		}
		System.out.println("TOTAL DOCUMENTS FOUND: "+list.size());
		detail=true;

	}
	private static void show(String data){
		if(data.length()>0)
			System.out.println(data);
		else
			System.out.println("unknown");
	}
	public static void display(Documents doc){
		System.out.println("=========================================");
		System.out.print("ID           : ");
		show(doc.getId());
		System.out.print("Album Name   : ");
		show(doc.getAlbum_name());
		System.out.print("Song Title   : ");
		show(doc.getSong_title());
		System.out.print("Lyrics       : ");
		show(doc.getLyrics());
		System.out.print("Rating       : ");
		show(doc.getRating()+"");
		if (detail) {
			System.out.print("Contributer  : ");
			show(doc.getArtist());
			System.out.print("Band         : ");
			show(doc.getBand());
			System.out.print("Genre Type   : ");
			show(doc.getGenre_type());
			System.out.print("Released Date: ");
			show(doc.getReleased_date());
		}
		System.out.println("=========================================");
	}
}
