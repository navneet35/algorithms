package com.algorithms.dp;

public class PalindromePartitioning {
	static boolean isPalindrome(String str){
		int n = str.length();
		if(n == 0 || n==1)
			return true;
		
		for(int i=0, j=n-1; i<j; i++, j--){
			if(str.charAt(i) != str.charAt(j))
				return false;
		}
	
		return true;
	}
	
	static int minCuts(String str){
		if(isPalindrome(str))
			return 0;
		
		int cuts = Integer.MAX_VALUE;
		
		for(int i=1; i<str.length(); i++)
			cuts = Math.min(1 + minCuts(str.substring(0, i)) + minCuts(str.substring(i)), cuts);
		
		return cuts;
	}
	
	public static void main(String[] args) {
		System.out.println(minCuts("ababm"));
	}
}
