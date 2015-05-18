package com.songlyrics.fields;

public enum ConstantData {
//	elasticsearchTutorial
	_INDEX("songs"),_TYPE("genre"),_CLUSTER_NAME("elasticsearchTutorial"),
	_OPTION_INSERT("insert"),_OPTION_SEARCH("search")
	,_OPTION_UPDATE("update"),_OPTION_SEARCH_ALL("searchall")
	,_OPTION_DELETE("delete"),_OPTION_EXIT("exit");
	private String _data;
	private ConstantData(String data) {
		// TODO Auto-generated constructor stub
		_data=data;
	}
	public String toString(){
		return _data;
	}
}
