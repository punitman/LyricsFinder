package com.songlyrics.action;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.deletebyquery.DeleteByQueryResponse;
import org.elasticsearch.client.Client;

import com.songlyrics.fields.FIELDS;

public class DeleteDocument {

	public static void delete(Client client,String id){
		DeleteResponse response = client.prepareDelete(FIELDS._INDEX.toString(), FIELDS._TYPE.toString(), id)
		        .execute()
		        .actionGet();
//		DeleteByQueryResponse response = client.prepareDelete(ConstantData._INDEX.toString(), ConstantData._TYPE.toString(), id)
//			    .setQuery(termQuery("_type", "type1"))
//		        .execute()
//		        .actionGet();
	}

}
