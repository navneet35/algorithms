package com.algorithms.trie;

public class Trie {
	Trie[] words;
	boolean isEnd;
	Integer wordsByPrefix;
	
	Trie(){
		this.words = new Trie[26];
		this.wordsByPrefix = 0;
	}
}
