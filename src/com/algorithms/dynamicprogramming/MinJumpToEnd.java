package com.algorithms.dynamicprogramming;

/**
 * @author navneet
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 ->9)
 */
public class MinJumpToEnd {

	static int dpSol(int[] arr){
		return 0;
	}
	
	static int recursiveSol(int[] arr){
		return 0;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(recursiveSol(arr));
		System.out.println(dpSol(arr));
	}

}
