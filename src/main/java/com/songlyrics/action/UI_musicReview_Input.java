package com.songlyrics.action;

import com.songlyrics.fields.Documents;

public class UI_musicReview_Input {
	public static Documents insertMusic(){
		Documents music=new Documents();
		music.setAlbum_name(UI_userinput.input("Album Name"));
		music.setSong_title(UI_userinput.input("Song Title"));
		music.setContributer(UI_userinput.input("Contributer"));
		music.setBand(UI_userinput.input("Band"));
		music.setGenre_type(UI_userinput.input("Genre Type"));
		music.setLyrics(UI_userinput.input("Lyrics"));
		music.setReleased_date(UI_userinput.input("Released Date"));
		return music;
	}

}
