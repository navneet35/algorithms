package com.algorithms.dp;
/*
 * Sample Input
 * 4 3
 * 1 2 3 
 * Sample Output
 * 4
 * */
import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {

  static int coinChangeWays(int[] S, int m, int N){
    if(N < 0 || m < 0)
      return 0;
    if(N == 0)
      return 1;
    
    return coinChangeWays(S, m-1, N) + coinChangeWays(S, m, N-S[m]);
    
  }
  
  static int coinChangeWaysDP(int[] S, int m, int N){
	  int[] ways = new int[N+1];
	  ways[0] = 1;
	  
	  for(int i = 0; i<= m; i++){
		 for(int j = S[i];j <=N ; j++){
			ways[j] += ways[j - S[i]];
		 }
	  }
	  
	  return ways[N];
  }
  
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int c = sc.nextInt();
	int[] S = new int[c];
	for(int i=0;i<c;i++)
		S[i] = sc.nextInt();
	
	Arrays.sort(S);
    System.out.println(coinChangeWays(S, S.length-1, N));
    System.out.println(coinChangeWaysDP(S, S.length-1, N));
        
  }

}
