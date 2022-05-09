

// https://www.ideserve.co.in/learn/rotate-an-array
public class RotateArrLeft {

	public static void rotateLeftExtraSpace(int[] arr, int k) {
		//Time Complexity: O(n)
		//Space Complexity: O(k)
		int[] temp = new int[arr.length];
		int l = arr.length;
		for (int i = 0; i < k; i++) {
			temp[i + (l - k)] = arr[i];
		}
		for (int i = k; i < l; i++) {
			temp[i - k] = arr[i];
		}
		System.out.println("in arr");
		for (int i = 0; i < l; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("out arr");
		for (int i = 0; i < l; i++) {
			System.out.print(temp[i] + " ");
		}
	}
	
	/*Efficient Solution: Using Array Reversal
	1. Reverse the array elements from 0 to k-1.
	2. Reverse the array elements from k to array.length-1.
	3. Reverse the whole array.*/
	public static void rotateLeftReversalAlgo(int[] arr, int k) {
		//Time Complexity: O(n)
		//Space Complexity: O(1)
		
		int l = arr.length;
		if(k>l)
			k=k%l;
		
		
		System.out.println("in arr");
		for (int i = 0; i < l; i++) {
			System.out.print(arr[i] + " ");
		}
		
		reverseArr(arr, 0, k-1);
		reverseArr(arr, k, l-1);
		reverseArr(arr, 0, l-1);
		
		System.out.println("out arr");
		for (int i = 0; i < l; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void reverseArr(int[] arr,int l, int r) {
		while(l<=r)
		{
			int temp = arr[l];
			arr[l]=arr[r];
			arr[r]=temp;
			l++;
			r--;
		}
		
	}
	
	
	public static void main(String[] args) {
		// rotate left by k
		// i/p 1,2,3,4,5,6
		// o/p 3,4,5,6,1,2
		rotateLeftExtraSpace(new int[] { 1, 2, 3, 4, 5, 6 }, 2);
		
		rotateLeftReversalAlgo(new int[] { 1, 2, 3, 4, 5, 6 }, 2);
	}

}
