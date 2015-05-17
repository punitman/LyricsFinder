package com.songlyrics.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;

import com.songlyrics.fields.ConstantData;
import com.songlyrics.fields.Documents;

import static org.elasticsearch.index.query.QueryBuilders.*;



public class SearchDocument {
	public static List<Documents> search(Client client,String test){
		List<Documents> searchedMusic=new ArrayList<Documents>();
		SearchResponse scrollResp ;
		scrollResp = client.prepareSearch(ConstantData._INDEX.toString()).setTypes(ConstantData._TYPE.toString()).setQuery(fieldQuery(test)).execute().actionGet();//.prepareSearch(LyricsFinderConstants._INDEX.toString())
		
		try{
		SearchHit[] results = scrollResp.getHits().getHits();
		for (SearchHit hit : results) {
			System.out.println("building");
			Map<String,Object> result = hit.getSource();  
			System.out.println(result);
			}
		System.out.println("done");
		System.out.println("response built"+results.length);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		//Scroll until no hits are returned
		
//		while (true) {
//		    for (SearchHit hit : scrollResp.getHits().getHits()) {
//		        //Handle the hit...
//		    	System.out.println("ok");
//		    }
//		    scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(600000)).execute().actionGet();
//		    //Break condition: No hits are returned
//		    if (scrollResp.getHits().getHits().length == 0) {
//		        break;
//		    }
//		}		
		return searchedMusic;
	}
	private static QueryBuilder fieldQuery( String value) {
		// TODO Auto-generated method stub
		QueryBuilder qb=multiMatchQuery(value,
				"song_title","band","contributer","genre_type","lyrics","released_date");
		return qb;
	}
	private static QueryBuilder fieldQuery(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}
}
