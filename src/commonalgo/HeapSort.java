package commonalgo;

public class HeapSort {
	
	public void sort(int[] arr){
		int n = arr.length;
		for(int i = n/2 -1;i >=0; i--){
			heapify(arr, n, i);
		}
		
		for(int i = n-1; i>= 0; i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
		
	}
	
	// The heapify procedure calls itself recursively to build heap in top down manner.
	private void heapify(int[] arr, int n, int i){
		int largest = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		if(left < n && arr[left] > arr[largest])
			largest = left;
		if(right < n && arr[right] > arr[largest])
			largest = right;
		
		if(largest != i){
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			heapify(arr, n, largest);//run heapify on affected subtree
		}
		
	}
	
	public void print(int[] arr){
		for(int i : arr)
			System.out.print(i + " ");
	}
	
	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
		HeapSort hs = new HeapSort();
		hs.sort(arr);
		hs.print(arr);
	}

}
