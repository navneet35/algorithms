package com.algorithms.graph;

import java.util.*;

/**
 * @author - navsinn
 * @date - Nov 23, 2018
 */
public class ShortestWordLength {

    public static void main(String[] args) {
        ArrayList<String> dic = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        String start = "hit";
        String end = "cog";
        ShortestWordLength swl = new ShortestWordLength();
        int len = swl.ladderLength(start, end, dic);
        System.out.println(len);
    }

    public int ladderLength(String start, String end, ArrayList<String> dict) {
        dict.add(end);
        Queue<Item> q = new LinkedList<>();
        Item it = new Item(start, 1);
        Set<String> visited = new HashSet<>();
        q.offer(it);
        while(!q.isEmpty()) {
            Item cur = q.poll();
            if(visited.contains(cur.word))
                continue;
            for(String dicWord : dict) {
                if(!visited.contains(dicWord) && isAdjacent(cur.word, dicWord)){
                    Item temp = new Item(dicWord, cur.len + 1);
                    q.offer(temp);
                    if(dicWord.equals(end))
                        return cur.len + 1;
                }
            }

            visited.add(cur.word);
        }
        return 0;
    }

    private boolean isAdjacent(String wordA, String wordB) {
        if(wordA.length() != wordB.length())
            return false;
        boolean flag = false;
        for(int i = 0; i < wordA.length(); i++) {
            if(wordA.charAt(i) != wordB.charAt(i)){
                if(flag)
                    return false;
                else
                    flag = true;

            }
        }

        return flag;
    }

    class Item {
        String word;
        int len;
        Item(String word, int len){
            this.word = word;
            this.len = len;
        }
    }
}
