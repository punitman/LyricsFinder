package com.songlyrics.model;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

public class IndexerDocument {

	public static void insertData(){
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("user","kimchy");
		json.put("postDate",new Date());
		json.put("message","trying out Elasticsearch");
	}

	public static IndexResponse insert(Client client, Music detail) throws ElasticsearchException,
			IOException {

		IndexResponse response = client
				.prepareIndex("songs", "genre")
				.setSource(
						jsonBuilder().startObject().field("user", "kimchy")
								.field("song_title", detail.getSong_title())
								.field("contributer",detail.getContributer())
								.field("album_name",detail.getAlbum_name())
								.field("genre_type",detail.getGenre_type())
								.field("lyrics",detail.getLyrics())
								.field("released_date",detail.getReleased_date())
								.endObject()).execute().actionGet();
		return response;
	}

}
