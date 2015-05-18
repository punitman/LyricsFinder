package com.songslyrics.main;

import com.songlyrics.action.SelectOption;
import com.songlyrics.action.ShowDocument;
import com.songlyrics.action.UI_musicReview_Input;
import com.songlyrics.action.UI_userinput;
import com.songlyrics.api.SearchEngineFactory;
import com.songlyrics.fields.ConstantData;
import com.songlyrics.fields.Documents;
import com.songlyrics.fields.SEARCH_ENGINE_TYPE;
import com.songlyrics.services.SearchEngine;

public class Lyrics_Searcher {

	public static void main(String[] args) {
		SearchEngine engine=SearchEngineFactory.createSearchEngine(SEARCH_ENGINE_TYPE._ELASTICSEARCH.toString());
		String select;
		do {
			select = SelectOption.select();
			if (select.trim().compareTo(ConstantData._OPTION_EXIT.toString()) != 0) {
				try {
					if (select.trim().compareTo(ConstantData._OPTION_INSERT.toString()) == 0){
						Documents music=UI_musicReview_Input.insertMusic();
//						IndexerDocument.insert(client,music);
						engine.insert(music);
					}
					else if (select.trim().compareTo(ConstantData._OPTION_SEARCH.toString()) == 0)
					{
						ShowDocument.display(
//								SearchDocument.search(client,
								engine.search(
										UI_userinput.input("Search").toLowerCase().trim()));
					}else if (select.trim().compareTo(ConstantData._OPTION_SEARCH_ALL.toString()) == 0)
					{
						ShowDocument.display(
//								SearchDocument.search(client,
										engine.search(
										""));
					}
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					System.out.println("exception in main");
					ex.getStackTrace();

				}
			}
			else
				break;
		} while (select.trim().compareTo(ConstantData._OPTION_EXIT.toString()) != 0);
//		node.close();
		engine.exit();
	}
}
