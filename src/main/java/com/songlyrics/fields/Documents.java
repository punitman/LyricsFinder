package com.songlyrics.fields;

public class Documents{
	private String song_title="";
	private String artist="";
	private String album_name="";
	private String genre_type="";
	private String band="";
	private String lyrics="";
	private String released_date="";	
	private float rating=0;
	
	public String getGenre_type() {
		return genre_type;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
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
	public String getReleased_date() {
		return released_date;
	}
	public void setReleased_date(String released_date) {
		this.released_date = released_date;
	}
	public String getSong_title() {
		return song_title;
	}
	public void setSong_title(String song_title) {
		this.song_title = song_title;
	}
	public String getContributer() {
		return artist;
	}
	public void setContributer(String contributer) {
		this.artist = contributer;
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
