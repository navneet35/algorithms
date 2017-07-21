package com.algorithms.binarysearch;

/*
 * Search an element in a sorted and rotated array
 * Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 * 			key = 3
 * Output : Found at index 8
 * 
 * Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 *          key = 30
 * Output : Not found
 * 
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * */
public class RotatedArraySearch {
	
	static int findPivot(int[] arr, int l, int h){
		while(l <= h){
			int mid = (l + h)/2;
			if(mid < h && arr[mid + 1] < arr[mid])
				return mid;
			else if(mid > l && arr[mid - 1]  > arr[mid])
				return mid -1;
			else if(arr[l] <= arr[mid])
				l = mid + 1;
			else
				h = mid - 1;
		}
		
		return -1;
	}
	
	static int findInIncreasingPart(int[] arr, int element, int l, int h){
		while(l <= h){
			int mid = (l + h)/2;
			if(arr[mid] == element)
				return mid;
			else if(arr[mid] > element)
				h = mid - 1;
			else if(arr[mid] < element)
				l = mid + 1;
		}
		
		return -1;
	}
	
	static int findElement(int[] arr, int element){
		int pivot = findPivot(arr, 0, arr.length - 1);
		int index = -1;
		if(pivot == -1){
			System.out.println("Pivot not found.");
			index = findInIncreasingPart(arr, element, 0, arr.length - 1);
			/*if(arr[0] > arr[arr.length - 1]){
				System.out.println("Array is descending.");
				index = findInDecreasingPart(arr, element, 0, arr.length - 1);
			}else {
				System.out.println("Array is increasing.");
				index = findInIncreasingPart(arr, element, 0, arr.length - 1);
			}*/
				
		}else{
			if(arr[pivot] == element)
				return pivot;
			index = findInIncreasingPart(arr, element, 0, pivot-1);
			if(index == -1)
				index = findInIncreasingPart(arr, element, pivot + 1, arr.length - 1);
		}
		
		return index;
	}
	
	static int onePassSearch(int[] arr, int element){
		int l = 0, h = arr.length;
		while(l <= h){
			int mid = (l + h) /2;
			if(arr[mid] == element)
				return mid;
			if(arr[l] <= arr[mid]){ 
				if(element >= arr[l] && element <= arr[mid])
					h = mid - 1;
				else 	
					l = mid + 1;
			}
			else {
				if(element >= arr[mid] && element <= arr[l])
					l = mid + 1;
				else
					h = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		/* c -1 : */
		int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		int element = 3;
		
		/* c - 2 */
//		int[] arr = {5, 6, 7, 8, 9, 10};
//		int element = 8;

		/* c - 3 */
//		int[] arr = {5, 6};
//		int element = 6;
		
//		int index = findElement(arr, element);
		int index = onePassSearch(arr, element);
		if(index != -1){
			System.out.println("Key found at index :" + index);
		}else{
			System.out.println("Element not found.");
		}
		
	}

}
