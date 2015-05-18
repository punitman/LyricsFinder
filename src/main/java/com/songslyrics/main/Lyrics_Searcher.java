package com.songslyrics.main;

import java.util.List;

import com.songlyrics.action.DeleteDocument;
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
					else if(select.compareTo(ConstantData._OPTION_DELETE.toString())==0){
						List<Documents> docs=engine.search(UI_userinput.input("Search").toLowerCase().trim());
						if(docs.size()==1){
							engine.delete(docs.get(0).getId());
						}
						else if(docs.size()>1){
							ShowDocument.display(docs);
							int index=UI_userinput.inputInt("SNO. for Deletion");
							if(index==0)
								index++;
							System.out.println(" deleting :"+index+" id:"+docs.get(index-1).getId());
							if(index> 0 &&index<=docs.size())
								engine.delete(docs.get(index-1).getId());
						}
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
