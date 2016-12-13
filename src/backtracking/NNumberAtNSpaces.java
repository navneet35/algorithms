package backtracking;

import java.util.Arrays;

/*
 * Given a number n, create an array of size 2n such that the array contains 2 instances of every number from 1 to n, 
 * and the number of elements between two instances of a number i is equal to i. If such a configuration is not possible, 
 * then print the same.
 * 
Examples:
Input: n = 3
Output: res[] = {3, 1, 2, 1, 3, 2}

Input: n = 2
Output: Not Possible

Input: n = 4
Output: res[] = {4, 1, 3, 1, 2, 4, 3, 2}
 * */
public class NNumberAtNSpaces {

  static boolean nNumbersAtNSpaces(int n, int cur, int[] res){
    if(cur == 0)
      return true;
    
    for(int i=0; i < 2*n-cur-1; i++){
      if(res[i] == 0 && res[i+cur+1] == 0){
        res[i] = res[i+cur+1] = cur;
        
        if(nNumbersAtNSpaces(n, cur-1, res))
          return true;
        
         res[i] = res[i+cur+1] = 0;
      }
    }
    
    return false;
  }
  
  public static void main(String[] args) {
    int n = 4;
    int[] res = new int[2*n];
    Arrays.fill(res, 0);
    if(nNumbersAtNSpaces(n, n, res)){
      System.out.println("Number exists");
      Arrays.stream(res).forEach(elm -> System.out.print(elm + " "));
    }else{
      System.out.println("Number doesn't exist.");
    }

  }

}
