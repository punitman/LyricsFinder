package com.songlyrics.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;

import com.songlyrics.fields.FIELDS;
import com.songlyrics.fields.Documents;
import com.songlyrics.utils.RetriveDocFrmStr;

import static org.elasticsearch.index.query.QueryBuilders.*;

public class SearchDocument{
	public static List<Documents> search(Client client,String value){
		SearchResponse response ;
		if(value.length()>0)
		response = client.prepareSearch(FIELDS._INDEX.toString())
				.setTypes(FIELDS._TYPE.toString())
				.setQuery(fieldQuery(value))
				.setExplain(true)
				.execute().actionGet();//.prepareSearch(LyricsFinderConstants._INDEX.toString())
		else{
			response = client.
					prepareSearch(FIELDS._INDEX.toString())
					.setTypes(FIELDS._TYPE.toString())
//					.setQuery(fieldQuery(value))
					.setExplain(true)
					.execute().actionGet();
	    }
		return getDocListFrmResponse(response);
	}
	private static List<Documents> getDocListFrmResponse(SearchResponse response){
		List<Documents> documentList=new ArrayList<Documents>();
		SearchHit[] results = response.getHits().getHits();
		for (SearchHit hit : results) {
			Documents doc=new Documents();
			doc=RetriveDocFrmStr.getDocument(hit.sourceAsMap().toString());
			doc.setId(hit.getId());
			documentList.add(doc);
			}
	    return documentList;
	}
	private static QueryBuilder fieldQuery( String value) {
		// TODO Auto-generated method stub
		QueryBuilder qb=multiMatchQuery(value,
				"song_title","band","artist","genre_type","album_name","lyrics","released_date");
		return qb;
	}
}
