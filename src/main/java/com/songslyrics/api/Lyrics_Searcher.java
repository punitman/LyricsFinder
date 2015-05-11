package com.songslyrics.api;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.io.IOException;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

import com.songlyrics.action.IndexerDocument;
import com.songlyrics.action.InputData;
import com.songlyrics.action.LyricsFinderConstants;
import com.songlyrics.action.Music;
import com.songlyrics.action.SearchDocument;

public class Lyrics_Searcher {

	public static void main(String[] args){
		Node node = nodeBuilder().clusterName(LyricsFinderConstants._CLUSTER_NAME.toString()).node();
		Client client = node.client();
		Music detail=new Music();
		detail.setAlbum_name("shyam album");
		detail.setContributer("shyam");
		try {
//			IndexerDocument.insert(client, detail);
			SearchDocument.search(client, "ram");
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.out.println("exception in main");
			ex.getStackTrace();
			
		}finally{
			System.out.println("main successful");
		}
		InputData.input();
		node.close();
	}
}
