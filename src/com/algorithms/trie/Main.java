package com.algorithms.trie;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Dictionary dictionary = new WordsDictionary();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >= 0){
            String input = sc.nextLine();
            String[] params = input.split(" ");
            if("add".equalsIgnoreCase(params[0]))
                dictionary.add(params[1].trim());
            else if("find".equalsIgnoreCase(params[0]))
                System.out.println(dictionary.wordByPrefix(params[1].trim()));
        }
		
	}

}
