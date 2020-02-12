package com;

/**
 * @author - navsinn
 *
 * [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16] - 17 -32
 */
public class ElementSearch {
    private static int getSize(int[] arr) {
        int i = 1;
        int lower = 0;

        //Empty array check
        try{
            int elm = arr[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array is empty");
            return 0;
        }

        while(true) {
            try{
                int elm = arr[i];
                lower = i;
                i *= 2;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Check for upper bound");
                break;
            }
        }

        int upper = i, mid;
        while(lower <= upper) {
            mid = (lower + upper)/2;
            if(lower + 1 == upper) {
                System.out.println("Infinite loop condition. break");
                break;
            }
            try{
                int elm = arr[mid];
                lower = mid;
            }catch (ArrayIndexOutOfBoundsException e) {
                upper = mid;
            }
        }

        try{
            int elm = arr[upper];
            lower = upper;
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Length is " + lower);
        }

        return lower + 1;
    }

    private static int getElementIndex(int[] arr, int target) {
        int size = getSize(arr);
        if(size == 0) {
            System.out.println("Empty Array");
            return -1;
        }

        int lower = 0, upper = size-1;
        while(lower <= upper) {
            int mid = (lower + upper)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] < target) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
