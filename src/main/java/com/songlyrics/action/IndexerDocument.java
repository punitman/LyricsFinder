package com.songlyrics.action;

import java.io.IOException;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;

import com.songlyrics.fields.FIELDS;
import com.songlyrics.fields.Documents;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

public class IndexerDocument {

	public static IndexResponse insert(Client client, Documents detail) throws ElasticsearchException,
			IOException {
		IndexResponse response = client
				.prepareIndex(FIELDS._INDEX.toString(), FIELDS._TYPE.toString())
				.setSource(jsonBuilder().startObject()
								.field("song_title", detail.getSong_title())
								.field("artist",detail.getArtist())
								.field("album_name",detail.getAlbum_name())
								.field("band",detail.getBand())
								.field("genre_type",detail.getGenre_type())
								.field("rating",detail.getRating())
								.field("lyrics",detail.getLyrics())
								.field("released_date",detail.getReleased_date())
								.endObject()).execute().actionGet();
		return response;
	}

}
