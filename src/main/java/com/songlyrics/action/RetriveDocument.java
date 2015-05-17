package com.songlyrics.action;

import com.songlyrics.fields.Documents;
import com.songlyrics.message.UI_userinput;

public class RetriveDocument {
	private static Documents doc=new Documents();
	
	public static Documents getDocument(String data){
		data=data.replace("{","");
		data=data.replace("}","");
		data=data.replace("="," =");
		data=data.replace(","," ");
		System.out.println(data);
		String[] parts=data.split(" ");
		for (int i = 0; i < parts.length-1; i++) {
			System.out.println(parts[i]);
			fill(parts[i], parts[i+1]);
		}
		return doc;
	}
	private static void fill(String field,String value){
		value=value.replace("=","");
		if(field.compareTo("album_name")==0)
		doc.setAlbum_name(value);
		else if(field.compareTo("song_title")==0)
		doc.setSong_title(value);
		else if(field.compareTo("contributer")==0)
		doc.setContributer(value);
		else if(field.compareTo("band")==0)
		doc.setBand(value);
		else if(field.compareTo("genre_type")==0)
		doc.setGenre_type(value);
		else if(field.compareTo("lyrics")==0)
		doc.setLyrics(value);
		else if(field.compareTo("released_date")==0)
		doc.setReleased_date(value);	
	}
}
