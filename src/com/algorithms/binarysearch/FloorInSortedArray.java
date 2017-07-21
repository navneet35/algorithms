package com.algorithms.binarysearch;

/*Given a sorted array and a value x, the floor of x is the largest element in array smaller than or equal to x. 
 * Write efficient functions to find floor of x.

 * Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 5
 * Output : 2
 * 2 is the largest element in arr[] smaller than 5.

 * Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 20
 * Output : 19
 * 19 is the largest element in arr[] smaller than 20.

 * Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 0
 * Output : -1
 * Since floor doesn't exist, output is -1.
*/

public class FloorInSortedArray {

	static int floorValueForElement(int[] arr, int element){
		int l = 0, h = arr.length - 1;
		int mid = -1;
		while(l <= h){
			 mid = (l + h)/2;
			 if(arr[mid] == element)
				 return element;
			 else if(element < arr[0])
				 return -1;
			 else if(element > arr[arr.length-1])
				 return arr[arr.length-1];
			 else if((arr[mid] < element && arr[mid + 1] > element))
				 return arr[mid];
			 else if(arr[mid] < element)
				 l = mid + 1;
			 else 
				 h = mid - 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2};
		int element = 2;
		System.out.println(floorValueForElement(arr, element));
	}

}
