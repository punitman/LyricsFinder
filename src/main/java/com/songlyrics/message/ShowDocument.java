package com.songlyrics.message;


import java.util.List;

import com.songlyrics.fields.Documents;

public class ShowDocument {
	public static void display(List<Documents> list){
		for (int i = 0; i < list.size(); i++) {
			display(list.get(i));
		}
	}
	private static void show(String data){
		if(data.length()>0)
			System.out.println(data);
		else
			System.out.println("null");
	}
	public static void display(Documents doc){
		System.out.println("=========================================");
		System.out.print("album name   : ");
		show(doc.getAlbum_name());
		System.out.print("song title   : ");
		show(doc.getSong_title());
		System.out.print("contributer  : ");
		show(doc.getContributer());
		System.out.print("band         : ");
		show(doc.getBand());
		System.out.print("genre type   : ");
		show(doc.getGenre_type());
		System.out.print("lyrics       : ");
		show(doc.getLyrics());
		System.out.print("released date: ");
		show(doc.getReleased_date());
		System.out.println("=========================================");
	}
}
