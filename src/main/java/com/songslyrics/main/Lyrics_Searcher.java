package com.songslyrics.main;

import java.util.List;

import com.songlyrics.action.DeleteDocument;
import com.songlyrics.api.SearchEngineFactory;
import com.songlyrics.fields.FIELDS;
import com.songlyrics.fields.Documents;
import com.songlyrics.fields.SEARCHENGINE_TYPE;
import com.songlyrics.services.SearchEngine;
import com.songlyrics.utils.GetDocumentInput;
import com.songlyrics.utils.GetUserInput;
import com.songlyrics.utils.ShowActionOption;
import com.songlyrics.utils.ShowDocument;

public class Lyrics_Searcher {

	public static void deleteDocument(SearchEngine engine){
		String searchData=GetUserInput.getInput("Search").toLowerCase().trim();
		List<Documents> documents=engine.search(searchData);
		String deleteId="";
		if(documents.size()==1){
			deleteId=documents.get(0).getId();
			engine.delete(deleteId);
		}
		else if(documents.size()>1){
			ShowDocument.displayDocumentList(documents);
			int index=GetUserInput.getInputInt("SNO. for Deletion");
			if(index==0)
				index++;
			boolean indexIsValid=(index> 0 &&index<=documents.size());
			if(indexIsValid){
				deleteId=documents.get(index-1).getId();
				engine.delete(deleteId);
			}
		}
		System.out.println(" Id:"+deleteId+" Deleting ");
		
	}
	public static void SearchDocument(SearchEngine engine){
		
	}
	public static void main(String[] args) {
		SearchEngine engine=SearchEngineFactory.createSearchEngine(SEARCHENGINE_TYPE._ELASTICSEARCH.toString());
		String select;
		do {
			select = ShowActionOption.selectOption();
			if (select.trim().compareTo(FIELDS._OPTION_EXIT.toString()) != 0) {
				try {
					if (select.trim().compareTo(FIELDS._OPTION_INSERT.toString()) == 0){
						Documents music=GetDocumentInput.insertMusic();
						engine.insert(music);
					}
					else if (select.trim().compareTo(FIELDS._OPTION_SEARCH.toString()) == 0)
					{
						String searchData=GetUserInput.getInput("Search").toLowerCase().trim();
						ShowDocument.displayDocumentList(engine.search(searchData));
					}else if (select.trim().compareTo(FIELDS._OPTION_SEARCH_ALL.toString()) == 0)
					{
						ShowDocument.displayDocumentList(engine.search(""));
					}
					else if(select.compareTo(FIELDS._OPTION_DELETE.toString())==0){
						deleteDocument(engine);
					}
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					System.out.println("Exception in main");
					ex.getStackTrace();

				}
			}
		} while (select.compareTo(FIELDS._OPTION_EXIT.toString()) != 0);
		engine.exit();
	}
}
