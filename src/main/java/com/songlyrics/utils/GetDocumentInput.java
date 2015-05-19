package com.songlyrics.utils;

import com.songlyrics.fields.Documents;

public class GetDocumentInput {
	public static Documents insertMusic(){
		Documents document=new Documents();
		document.setAlbum_name(GetUserInput.getInput("Album Name"));
		document.setSong_title(GetUserInput.getInput("Song Title"));
		document.setArtist(GetUserInput.getInput("Artist"));
		document.setBand(GetUserInput.getInput("Band"));
		document.setGenre_type(GetUserInput.getInput("Genre Type"));
		document.setRating(GetUserInput.getInput("Rating"));
		document.setLyrics(GetUserInput.getInput("Lyrics"));
		document.setReleased_date(GetUserInput.getInput("Released Date"));
		return document;
	}

}
