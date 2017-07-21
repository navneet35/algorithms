package com.algorithms.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordsDictionary implements Dictionary{

	private Set<String> words;
	private Trie root;
	
	public WordsDictionary() {
		words = new HashSet<String>();
		root = new Trie();
	}
	
	@Override
	public boolean add(String word) {
		if(words.contains(word))
			return true;
		
		Trie p = root;
		for(int i=0; i<word.length();i++){
			char c = word.charAt(i);
			int index = c - 'a';
			if(p.words[index] == null){
				Trie temp = new Trie();
				p.words[index] = temp;
				p = p.words[index];
			}else{
				p = p.words[index];
			}
			
			p.wordsByPrefix++;
		}
		
		p.isEnd = true;
		words.add(word);
		
		return true;
	}

	@Override
	public String search(String word) {
		return (words.contains(word)) ? word : null;
	}

	@Override
	public Integer size() {
		return words.size();
	}

	@Override
	public List<String> getAllWordsByPrefix(String prefix) {
		List<String> wordsByPrefix = new ArrayList<String>();

		Trie t = root;
		for(int i = 0;i < prefix.length(); i++){
			char c = prefix.charAt(i);
			int index = c - 'a';
			
			if(t.words[index] == null)
				return null;
			
			t = t.words[index];
		}
		
		if(t.isEnd)
			wordsByPrefix.add(prefix);
		
		for(int i = 0; i<26; i++){
			if(t.words[i] != null)
				wordsByPrefix.addAll(getWordsByNode(t.words[i], new ArrayList<String>(), new StringBuilder(prefix).append((char)(i + 'a'))));
		}
		
		return wordsByPrefix;
	}

	private List<String> getWordsByNode(Trie t, List<String> words, StringBuilder word){
		if(t == null)
			return null;

		if(t.isEnd){
			words.add(word.toString());
		}
		
		for(int i=0; i<26; i++){
			if(t.words[i] != null){
				getWordsByNode(t.words[i], words, word.append((char)(i + 'a')));
				word.deleteCharAt(word.length() - 1);
			}
		}
		
		return words;
	}
	
	@Override
	public Integer wordByPrefix(String prefix) {
		Trie t = root;
		for(int i = 0;i<prefix.length(); i++){
			char c = prefix.charAt(i);
			int index = c - 'a';
			
			if(t.words[index] == null)
				return null;
			
			t = t.words[index];
		}
		
		return t.wordsByPrefix;
	}

}
