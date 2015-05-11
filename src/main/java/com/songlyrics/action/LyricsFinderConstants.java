package com.songlyrics.action;

public enum LyricsFinderConstants {
	_INDEX("songs"),_TYPE("genre"),_CLUSTER_NAME("elasticsearchTutorial");
	private String _data;
	private LyricsFinderConstants(String data) {
		// TODO Auto-generated constructor stub
		_data=data;
	}
	public String toString(){
		return _data;
	}
}
