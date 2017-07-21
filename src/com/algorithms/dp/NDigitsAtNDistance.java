/*
 * Fill two instances of all numbers from 1 to n in a specific way
 * Given a number n, create an array of size 2n such that the array contains 2 instances of every number from 1 to n, 
 * and the number of elements between two instances of a number i is equal to i. 
 * If such a configuration is not possible, then print the same.
 * Examples:
 *
 * Input: n = 3
 * Output: res[] = {3, 1, 2, 1, 3, 2}
 *
 * Input: n = 2
 * Output: Not Possible
 *
 * Input: n = 4
 * Output: res[] = {4, 1, 3, 1, 2, 4, 3, 2}
*/
package com.algorithms.dp;

import java.util.Scanner;

public class NDigitsAtNDistance {
	
	static boolean convert(int[] result, int n, int cur){
		if(cur == 0)
			return true;
		
		for(int i = 0; i < 2*n-cur-1; i++){
			if(result[i] == 0 && result[i+cur+1]==0){
				result[i] = cur;
				result[i+cur+1] = cur;
				if(convert(result, n, cur-1)){
					return true;
				}
				
				result[i] = 0;
				result[i+cur+1] = 0;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter num:");
		int n = sc.nextInt();
		int[] arr = new int[2*n];
		if(convert(arr, n, n)){
			for(int i=0;i<2*n;i++)
				System.out.print(arr[i] + ", ");
		}else{
			System.out.println("Not Possible");
		}
		
	}

}
