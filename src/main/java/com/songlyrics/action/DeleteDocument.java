package com.songlyrics.action;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.Client;

import com.songlyrics.fields.ConstantData;

public class DeleteDocument {

	public static void delete(Client client,String id){
		DeleteResponse response = client.prepareDelete(ConstantData._INDEX.toString(), ConstantData._TYPE.toString(), id)
		        .execute()
		        .actionGet();
	}
}
