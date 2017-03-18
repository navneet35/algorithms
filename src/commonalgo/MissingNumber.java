package commonalgo;
/*Find the Missing Number
 *You are given a sorted list of n-1 integers and these integers are in the range of 1 to n. 
 *There are no duplicates in list. One of the integers is missing in the list.
 *
 *Example:
 *I/P    [1, 2, 3, 4, 6, 7, 8]
 *O/P    5
*/

public class MissingNumber {

	static int findMissingNumber(int[] a, int l, int h){
		int mid = -1;
		if(a[0] != 1)
			return 1;

		while(l <= h){
			mid = (l + h)/2;
			
			if(mid > 0 && a[mid-1] + 2 == a[mid]){
				return a[mid-1] + 1;
			}else if(mid == a[mid] - 1){
				//missing element is in right
				l = mid + 1;
			}else{
				//missing element is in right
				h = mid - 1;
			}
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 5};
		System.out.println(findMissingNumber(a, 0, a.length-1));
	}

}
