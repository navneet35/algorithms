package com.algorithms.graph;

import java.util.*;

/**
 * @author - navsinn
 * @date - Nov 23, 2018
 */
public class ShortestWordPath {

    public static void main(String[] args) {
        Set<String> dic = new HashSet<>();
        dic.add("cat");
        dic.add("cot");
        dic.add("cog");
        dic.add("sog");
        dic.add("mot");
        dic.add("mog");
        dic.add("dog");
        String start = "cat";
        String end = "dog";
        List<String> path = transformBFS(start, end, dic);
        path.stream().forEach(System.out::println);
    }

    private static LinkedList<String> transformBFS(String start, String end, Set<String> dict) {
        LinkedList<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        Map<String, String> wordBackTrack = new HashMap<>();
        q.add(start);
        visited.add(start);
        while (!q.isEmpty()) {
            String currentWord = q.poll();
            for (String neighbour : getOneEditAwayWords(currentWord, dict)) {
                if (neighbour.equals(end)) {
                    LinkedList<String> path = new LinkedList<>();
                    path.add(neighbour);
                    while (currentWord != null) {
                        path.add(currentWord);
                        currentWord = wordBackTrack.get(currentWord);
                    }
                    return path;
                }
                if (!visited.contains(neighbour)) {
                    wordBackTrack.put(neighbour, currentWord);
                    q.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
        return null;
    }

    private static ArrayList<String> getOneEditAwayWords(String word, Set<String> dict) {
        ArrayList<String> oneEditAwayWords = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String s = word.substring(0, i) + c + word.substring(i + 1);
                if (dict.contains(s))
                    oneEditAwayWords.add(s);
            }
        }
        return oneEditAwayWords;
    }
}
