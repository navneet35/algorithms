package commonalgo;

public class Knapsack0_1 {

  public int getMaxValueRecursive(int n, int[] val, int[] w, int W){
    if(n<0 || W <=0 )
      return 0;
    
    if(w[n] > W)
      return getMaxValueRecursive(n-1, val, w, W);
    
    else 
      return Math.max(val[n] + getMaxValueRecursive(n-1, val, w, W-w[n]), getMaxValueRecursive(n-1, val, w, W)); 
  }
  
  public int getMaxValueDP(int n, int[] val, int[] w, int W){
    int[][] T = new int[n+1][W+1];
    
    for(int i=0;i<=n;i++){
      for(int j=0; j<=W; j++){
        if(i==0 || j==0)
          T[i][j] = 0;
        else if(w[i] > j){
          T[i][j] = T[i-1][j];
        } else {
          T[i][j] = Math.max(val[i] + T[i-1][j - w[i]], T[i-1][j]);
        }
      }
    }
    
    return T[n][W];
  }
  
  public static void main(String[] args) {
    /*int[] w = {10,20,30,40};
    int[] val = {50,100,120,500};
    int W = 50;*/
    int[] w = {1,2,3};
    int[] val = {10,20,30};
    int W = 4;
    Knapsack0_1 obj = new Knapsack0_1();
    System.out.println("This is recursive solution to 0-1 Knapasack problem.");
    System.out.println(obj.getMaxValueRecursive(w.length-1, val, w, W));
    
    System.out.println("This is DP solution to 0-1 Knapasack problem.");
    System.out.println(obj.getMaxValueDP(w.length-1, val, w, W));
  }

}
