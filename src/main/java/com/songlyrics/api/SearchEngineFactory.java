package com.songlyrics.api;

import com.songlyrics.fields.SEARCHENGINE_TYPE;
import com.songlyrics.services.SearchEngine;

public class SearchEngineFactory {
	public static SearchEngine createSearchEngine(String type){
		SearchEngine engine=null;
		if(type.compareTo(SEARCHENGINE_TYPE._ELASTICSEARCH.toString())==0)
			engine=new ElasticSearchEngine();
		else
			System.out.println("NO SEARCHENGINE OF FOUND");
		return engine;
	}	
}
