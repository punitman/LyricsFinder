package com.songlyrics.action;

import java.util.ArrayList;

import com.songlyrics.fields.Documents;

public class RetriveDocument {
	private static Documents doc;
	private static String temp="";
	public static Documents getDocument(String data){
		doc=new Documents();
		try {
//			System.out.println(data);
			ArrayList<String> parts=splits(data);
			for (int i = 0; i < parts.size() - 1; i++) {
//				System.out.println(parts.get(i));
				fill(parts.get(i), parts.get(i + 1));
					i++;
			}
		} catch (Exception ex) {
			System.out.println("ERROR ON RETRIVE CLASS");
		}
		return doc;
	}
	private static ArrayList<String> splits(String data){
		data=data.replace("{",",");
		data=data.replace("}","");
		data=data.replace("=,","=unknown,");
		data=data.replace(", "," ,");
		data=data.replace("=","= ").trim();
		String[] words=data.split(" ");
		ArrayList<String> res=new ArrayList<String>();
		String word="";
		for (int i = 0; i < words.length; i++) {
			if(words[i].charAt(0)==',' && words[i].charAt(words[i].length()-1)=='='){
				if(word.length()>0)
					res.add(word);
				words[i]=words[i].replace(",","");
				words[i]=words[i].replace("=","");
				word="";
				res.add(words[i]);
			}else
			{
				word+=words[i]+" ";
			}
		}
		return res;
	}
	private static boolean isField(String field){
		if (field.compareTo("album_name") == 0)
			return true;
		else if (field.compareTo("song_title") == 0)
			return true;
		else if (field.compareTo("rating") == 0)
			return true;
		else if (field.compareTo("contributer") == 0)
			return true;
		else if (field.compareTo("band") == 0)
			return true;
		else if (field.compareTo("genre_type") == 0)
			return true;
		else if (field.compareTo("lyrics") == 0)
			return true;
		else if (field.compareTo("released_date") == 0)
			return true;
		return false;
	}
	private static boolean fill(String field,String value){
		field=field.replace(",", "");
		field=field.replace("=", "").trim();
		value=value.replace("¬"," ");
		value=value.replace(",",", ");
		if(field.compareTo("album_name")==0)
		doc.setAlbum_name(doc.getAlbum_name()+value);
		else if(field.compareTo("song_title")==0)
		doc.setSong_title(doc.getSong_title()+value);
		else if(field.compareTo("rating")==0)
		doc.setSong_title(doc.getRating()+value);
		else if(field.compareTo("contributer")==0)
		doc.setContributer(doc.getContributer()+value);
		else if(field.compareTo("band")==0)
		doc.setBand(doc.getBand()+value);
		else if(field.compareTo("genre_type")==0)
		doc.setGenre_type(doc.getGenre_type()+value);
		else if(field.compareTo("lyrics")==0)
		doc.setLyrics(doc.getLyrics()+value);
		else if(field.compareTo("released_date")==0)
		doc.setReleased_date(doc.getReleased_date()+value);
		else
			return false;
		return true;
	}
}
