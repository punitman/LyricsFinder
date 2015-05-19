package com.songlyrics.action;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.Client;

import com.songlyrics.fields.FIELDS;

public class UpdateDocument {

	public static void update(Client client, String id, String field,
			String newValue) {

		UpdateRequest updateRequest = new UpdateRequest();
		updateRequest.index(FIELDS._INDEX.toString());
		updateRequest.type(FIELDS._TYPE.toString());
		updateRequest.id(id);
		try {
			updateRequest.doc(jsonBuilder().startObject()
					.field(field, newValue).endObject());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			client.update(updateRequest).get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
