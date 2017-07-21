package com.algorithms.trie;

import java.util.List;

public interface Dictionary {
	public boolean add(String word);
	public String search(String word);
	public Integer size();
	public List<String> getAllWordsByPrefix(String prefix);
	public Integer wordByPrefix(String prefix);
}
