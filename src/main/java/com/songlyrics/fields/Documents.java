package com.songlyrics.fields;

public class Documents {
	private double id;
	private String song_title="";
	private String contributer="";
	private String album_name="";
	private String genre_type="";
	private String band="";
	
	public String getGenre_type() {
		return genre_type;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public void setGenre_type(String genre_type) {
		this.genre_type = genre_type;
	}
	private String lyrics;
	private String released_date;
	
	public String getReleased_date() {
		return released_date;
	}
	public void setReleased_date(String released_date) {
		this.released_date = released_date;
	}
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public String getSong_title() {
		return song_title;
	}
	public void setSong_title(String song_title) {
		this.song_title = song_title;
	}
	public String getContributer() {
		return contributer;
	}
	public void setContributer(String contributer) {
		this.contributer = contributer;
	}
	public String getAlbum_name() {
		return album_name;
	}
	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}
	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

}
