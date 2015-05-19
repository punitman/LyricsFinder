package com.songlyrics.utils;

import java.util.ArrayList;

import com.songlyrics.fields.Documents;

public class RetriveDocFrmStr {
	private static Documents document;
	public static Documents getDocument(String data){
		document=new Documents();
		document.reset();
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
		return document;
	}
	private static ArrayList<String> splits(String stringLine){
		stringLine=stringLine.replace("}","");
		stringLine=stringLine.replace("=,","=unknown,");
		stringLine=stringLine.replace(", "," ,");
		stringLine=stringLine.replace("{",",");
		stringLine=stringLine.replace("=","= ").trim();
//		System.out.println(data);
		String[] lineParts=stringLine.split(" ");
		ArrayList<String> updatedParts=new ArrayList<String>();
		
		String parts="";
		for (int i = 0; i < lineParts.length; i++) {
			boolean isField=(lineParts[i].charAt(0)==',' && lineParts[i].charAt(lineParts[i].length()-1)=='=');
			if(isField){
				if(parts.length()>0)
					updatedParts.add(parts);
				lineParts[i]=lineParts[i].replace(",","");
				lineParts[i]=lineParts[i].replace("=","");
				parts="";
				updatedParts.add(lineParts[i]);
			}else
			{
				parts+=lineParts[i]+" ";
			}
		}
		updatedParts.add(parts);
		return updatedParts;
	}
//	song_title rating=5
	private static boolean fill(String field,String value){
		field=field.replace(",", "");
		field=field.replace("=", "");
		field=field.trim();
		value=value.replace(",",", ").trim();
//		System.out.println(field+">>"+value);
		if(field.equals("song_title"))
		document.setSong_title(value);
		else if(field.equals("album_name"))
		document.setAlbum_name(value);
		else if(field.equals("rating"))
		document.setRating(value);
		else if(field.equals("artist"))
		document.setArtist(value);
		else if(field.equals("band"))
		document.setBand(value);
		else if(field.equals("genre_type"))
		document.setGenre_type(value);
		else if(field.equals("lyrics"))
		document.setLyrics(value);
		else if(field.equals("released_date"))
		document.setReleased_date(value);
		else
			return false;
		return true;
	}
}
