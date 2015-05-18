package com.songlyrics.services;

import java.util.List;

import com.songlyrics.fields.Documents;

public interface SearchEngine {
	public List<Documents> search(String file);
	public void insert(Documents document);
	public void delete(String id);
	public void update(String id,Documents document);
	public void exit(); 
}
