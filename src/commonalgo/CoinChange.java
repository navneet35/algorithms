package commonalgo;

public class CoinChange {

  static int coinChangeWays(int[] S, int m, int N){
    if(N < 0 || m < 0)
      return 0;
    if(N == 0)
      return 1;
    
    return coinChangeWays(S, m-1, N) + coinChangeWays(S, m, N-S[m]);
    
  }
  
  public static void main(String[] args) {
    int N = 5;
    int[] S = {1, 2, 3};
    System.out.println(coinChangeWays(S, S.length-1, N));
        
  }

}
