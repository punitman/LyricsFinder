package com.songlyrics.action;

import static org.elasticsearch.index.query.QueryBuilders.termQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;

import static org.elasticsearch.index.query.QueryBuilders.*;
import static org.elasticsearch.index.query.FilterBuilders.*;



public class SearchDocument {
	public static List<Music> search(Client client,String test){
		List<Music> searchedMusic=new ArrayList<Music>();
		
//		QueryBuilder qb = termQuery("contributer",");
		IndexRequestBuilder rep=client.prepareIndex(LyricsFinderConstants._INDEX.toString(), LyricsFinderConstants._TYPE.toString());
		System.out.println("query built");
		SearchResponse scrollResp ;
		try{
		scrollResp = client.prepareSearch(LyricsFinderConstants._INDEX.toString()).setTypes(LyricsFinderConstants._TYPE.toString()).setQuery(fieldQuery(test)).execute().actionGet();//.prepareSearch(LyricsFinderConstants._INDEX.toString())
//		        .setSearchType(SearchType.SCAN)
//		        .setScroll(new TimeValue(60000))
//				.setTypes(LyricsFinderConstants._TYPE.toString())
//				.setSearchType(SearchType.)
//		        .setQuery(fieldQuery(test))
//				.setFrom(0).setSize(60).setExplain(true)
//		        .setSize(100)
//		        .execute().actionGet(); //100 hits per shard will be returned for each scroll
		SearchHit[] results = scrollResp.getHits().getHits();
		for (SearchHit hit : results) {
			System.out.println("------------------------------");
			Map<String,Object> result = hit.getSource();  
			System.out.println(result);
			}
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
				     "song_title","contributer","genre_type","lyrics","released_date");
		return qb;
	}
	public static void searchDocument(Client client, String index, String type,
			String field, String value){
			SearchResponse response = client.prepareSearch(index)
			.setTypes(type)
			.setSearchType(SearchType.QUERY_AND_FETCH)
			.setQuery(fieldQuery(field, value))
			.setFrom(0).setSize(60).setExplain(true)
			.execute()
			.actionGet();
			SearchHit[] results = response.getHits().getHits();
			System.out.println("Current results: " + results.length);
			for (SearchHit hit : results) {
			System.out.println("------------------------------");
			Map<String,Object> result = hit.getSource();  
			System.out.println(result);
			}
			}
//	public static void searchDocument(Client client,
//			String index, String type, String field, String value) {
//		SearchResponse response = client.prepareSearch()
//				.setTypes("type1", "type2")
//				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
//				.setQuery(QueryBuilders.termQuery("multi", "test"))
//				// Query
//				.setPostFilter(
//						FilterBuilders.rangeFilter("age").from(12).to(18)) // Filter
//				.setFrom(0).setSize(60).setExplain(true).execute().actionGet();
//		// Scroll until no hits are returned
//		while (true) {
//
//			for (SearchHit hit : response.getHits().getHits()) {
//				// Handle the hit...
//			}
//			response = client.prepareSearchScroll(response.getScrollId())
//					.setScroll(new TimeValue(600000)).execute().actionGet();
//			// Break condition: No hits are returned
//			if (response.getHits().getHits().length == 0) {
//				break;
//			}
//		}
//
//	}
	private static QueryBuilder fieldQuery(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}
}
