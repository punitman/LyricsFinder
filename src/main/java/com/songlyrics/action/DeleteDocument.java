package com.songlyrics.action;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.Client;

public class DeleteDocument {

	public static void delete(Client client,String id){
		DeleteResponse response = client.prepareDelete(LyricsFinderConstants._INDEX.toString(), LyricsFinderConstants._TYPE.toString(), id)
		        .execute()
		        .actionGet();
	}
}
