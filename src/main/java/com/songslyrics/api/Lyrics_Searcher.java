package com.songslyrics.api;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.io.IOException;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

import com.songlyrics.model.IndexerDocument;
import com.songlyrics.model.Music;
import com.songlyrics.model.SearchDocument;

public class Lyrics_Searcher {

	public static void main(String[] args){
		Node node = nodeBuilder().clusterName("elasticsearchTutorial").node();
		Client client = node.client();
		Music detail=new Music();
		detail.setAlbum_name("reshem");
		detail.setContributer("devil");
		try {
//			SearchDocument.searchDocument(client, index, type, field, value);
			IndexerDocument.insert(client, detail);
		} catch (ElasticsearchException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		node.close();
	}
}
