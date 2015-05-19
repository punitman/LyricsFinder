package com.songlyrics.api;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

import com.songlyrics.action.DeleteDocument;
import com.songlyrics.action.IndexerDocument;
import com.songlyrics.action.SearchDocument;
import com.songlyrics.action.UpdateDocument;
import com.songlyrics.fields.FIELDS;
import com.songlyrics.fields.Documents;
import com.songlyrics.services.SearchEngine;

public class ElasticSearchEngine implements SearchEngine{
	private Node node = nodeBuilder().clusterName(FIELDS._CLUSTER_NAME.toString()).node();	
	private Client client = node.client();

	@Override
	public List<Documents> search(String file) {
		// TODO Auto-generated method stub
		return SearchDocument.search(client,file);
	}

	@Override
	public void insert(Documents document) {
		// TODO Auto-generated method stub
		try {
			IndexerDocument.insert(client,document);
		} catch (ElasticsearchException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR IN INSERTION" );
		}
	}
	@Override
	public void exit(){
		// TODO Auto-generated method stub
		node.close();
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		DeleteDocument.delete(client, id);
	}

	@Override
	public void update(String id, String fieldName, String newValue) {
		// TODO Auto-generated method stub
		UpdateDocument.update(client, id, fieldName, newValue);
	}


}
