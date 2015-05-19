package com.songslyrics.main;

import java.util.List;

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

	public static Documents selectIDfromDocList(List<Documents> documentList){
		Documents document=new Documents();
		ShowDocument.displayDocumentList(documentList);	
		int index=GetUserInput.getInputInt("SNo.");
		boolean indexIsValid=(index> 0 &&index<=documentList.size());
		if(indexIsValid)
			document=documentList.get(index-1);
		return document;
	}
	public static void updateDocument(SearchEngine engine){
		String documentId="";
		String searchData=GetUserInput.getInput("Key Word For Update");
		String exitKeyWord="e";
		String userInputField="";
		String userNewValue="";
		Documents selectedDocument;
		List<Documents> documentList=engine.search(searchData);
		if(documentList.size()==1)
			selectedDocument=documentList.get(0);
		else
			selectedDocument=selectIDfromDocList(documentList);
		documentId=selectedDocument.getId();
		ShowDocument.displayDocument(selectedDocument);
		do{
			userInputField=GetUserInput.getInput("Field    (to exit "+exitKeyWord+")").trim();
			userInputField=userInputField.toLowerCase().replace(" ","_");
			userNewValue=GetUserInput.getInput("New Value(to exit "+exitKeyWord+")").trim();
			boolean exit=(userInputField.toLowerCase().equals(exitKeyWord)||userNewValue.toLowerCase().equals(exitKeyWord));
			if(exit)
				break;
			else{
				engine.update(documentId, userInputField, userNewValue);
			}
		}while(userNewValue.compareTo(exitKeyWord)!=0 &&userInputField.compareTo(exitKeyWord)!=0);
		
	}
	public static void deleteDocument(SearchEngine engine){
		String searchData=GetUserInput.getInput("Search").toLowerCase().trim();
		List<Documents> documents=engine.search(searchData);
		String deleteId="";
		if(documents.size()==1){
			deleteId=documents.get(0).getId();
		}
		else if(documents.size()>1){
			deleteId=selectIDfromDocList(documents).getId();
		}
		System.out.println(" Id:"+deleteId+" Deleting ");
		engine.delete(deleteId);
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
					else if(select.compareTo(FIELDS._OPTION_UPDATE.toString())==0){
						updateDocument(engine);
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
