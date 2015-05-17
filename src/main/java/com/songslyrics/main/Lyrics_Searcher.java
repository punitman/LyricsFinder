package com.songslyrics.main;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

import com.songlyrics.action.IndexerDocument;
import com.songlyrics.action.SearchDocument;
import com.songlyrics.fields.ConstantData;
import com.songlyrics.fields.Documents;
import com.songlyrics.message.SelectOption;
import com.songlyrics.message.UI_musicReview_Input;
import com.songlyrics.message.UI_userinput;

public class Lyrics_Searcher {

	public static void main(String[] args) {
		Node node = nodeBuilder().clusterName(
				ConstantData._CLUSTER_NAME.toString()).node();
		Client client = node.client();
		String select;
		do {
			select = SelectOption.select();
			if (select.trim().compareTo(ConstantData._OPTION_EXIT.toString()) != 0) {
				try {
					if (select.trim().compareTo(ConstantData._OPTION_INSERT.toString()) == 0){
						Documents music=UI_musicReview_Input.insertMusic();
						IndexerDocument.insert(client,music);
					}
					else if (select.trim().compareTo(ConstantData._OPTION_SEARCH.toString()) == 0)
						SearchDocument.search(client,UI_userinput.input("Search").toLowerCase()
										.trim());
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					System.out.println("exception in main");
					ex.getStackTrace();

				}
			}
			else
				break;
		} while (select.trim().compareTo(ConstantData._OPTION_EXIT.toString()) != 0);
		node.close();
	}
}
