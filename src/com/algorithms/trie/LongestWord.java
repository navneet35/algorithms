package com.algorithms.trie;

/**
 * @author - navsinn
 * @date - Oct 30, 2018
 * https://leetcode.com/problems/longest-word-in-dictionary/
 */

public class LongestWord {
    private static String result = "";
    public static void main(String[] args) {
        String[] wordList = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(new LongestWord().longestWord(wordList));
    }

    private String longestWord(String[] list) {
        Trie root = new Trie();
        for(String word : list) {
            insert(root, word);
        }
        longestWordUtil(root, new StringBuilder(), 0);
        return result;
    }

    private String longestWordUtil(Trie root, StringBuilder str, int index) {
        if(root.isEndOfWord) {
            if(result.length() < index)
                result = str.substring(0, index);
        }

        for(int i=0; i<26; i++) {
            if(root.words[i] != null) {
                str.insert(index, (char) (i + 'a'));
                longestWordUtil(root.words[i], str, index + 1);
            }
        }

        return null;
    }

    private void insert(Trie root, String word) {
        Trie p = root;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(p.words[index] == null){
                p.words[index] = new Trie();
            }
            p = p.words[index];
        }

        p.isEndOfWord = true;
    }

    class Trie {
        Trie[] words;
        boolean isEndOfWord;
        public Trie() {
            words = new Trie[26];
            isEndOfWord = false;
        }
    }
}
