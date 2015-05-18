package com.songlyrics.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;

import com.songlyrics.fields.ConstantData;
import com.songlyrics.fields.Documents;

import static org.elasticsearch.index.query.QueryBuilders.*;

public class SearchDocument{
	public static List<Documents> search(Client client,String value){
		List<Documents> searchedMusic=new ArrayList<Documents>();
		SearchResponse response ;
		if(value.length()>0)
		response = client.
				prepareSearch(ConstantData._INDEX.toString())
				.setTypes(ConstantData._TYPE.toString())
				.setQuery(fieldQuery(value))
				.setExplain(true)
				.execute().actionGet();//.prepareSearch(LyricsFinderConstants._INDEX.toString())
		else{
			response = client.
					prepareSearch(ConstantData._INDEX.toString())
					.setTypes(ConstantData._TYPE.toString())
//					.setQuery(fieldQuery(value))
					.setExplain(true)
					.execute().actionGet();
	    }
	try{
		SearchHit[] results = response.getHits().getHits();
		for (SearchHit hit : results) {
			String res=hit.sourceAsMap().toString();
			String id=hit.getId();
			Documents doc=new Documents();
			doc=RetriveDocument.getDocument(res);
			System.out.println(id);
			doc.setId(id);
			searchedMusic.add(doc);
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		//Scroll until no hits are returned
		
//		while (true) {
//		    for (SearchHit hit : response.getHits().getHits()) {
//		        //Handle the hit...
//		    	System.out.println("ok");
//		    }
//		    response = client.prepareSearchScroll(response.getScrollId()).setScroll(new TimeValue(600000)).execute().actionGet();
//		    //Break condition: No hits are returned
//		    if (response.getHits().getHits().length == 0) {
//		        break;
//		    }
//		}		
		return searchedMusic;
	}
	private static QueryBuilder fieldQuery( String value) {
		// TODO Auto-generated method stub
		QueryBuilder qb=multiMatchQuery(value,
				"song_title","band","artist","genre_type","album_name","lyrics","released_date");
		return qb;
	}
}
