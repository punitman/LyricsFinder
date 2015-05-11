package com.songlyrics.model;

import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import static org.elasticsearch.index.query.FilterBuilders.*;

public class SearchDocument {

public static void searchDocument(org.elasticsearch.client.Client client, String index, String type,
                                      String field, String value){
	SearchResponse response = client.prepareSearch("index1", "index2")
	        .setTypes("type1", "type2")
	        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
	        .setQuery(QueryBuilders.termQuery("multi", "test"))             // Query
	        .setPostFilter(FilterBuilders.rangeFilter("age").from(12).to(18))   // Filter
	        .setFrom(0).setSize(60).setExplain(true)
	        .execute()
	        .actionGet();
	//Scroll until no hits are returned
	while (true) {

	    for (SearchHit hit : response.getHits().getHits()) {
	        //Handle the hit...
	    }
	    response = client.prepareSearchScroll(response.getScrollId()).setScroll(new TimeValue(600000)).execute().actionGet();
	    //Break condition: No hits are returned
	    if (response.getHits().getHits().length == 0) {
	        break;
	    }
	}
    }


}
