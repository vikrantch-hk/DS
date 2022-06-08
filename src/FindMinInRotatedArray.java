public class FindMinInRotatedArray {

	// Time complexity: O(􏰄􏰅􏰆􏰂). Space complexity: O(􏰄􏰅􏰆􏰂) for recursive stack.
	public static int FindMin(int arr[], int low, int high) {
		if (high < low)
		{
			System.out.println("case high < low");
			return arr[0];
			
		}
		/*
		 * Check with input - {1,2,3,4,5,6} array is sorted and arr.length= even . If you don't put above condition,
		 * and try this input, it results in ArrayIndexOutOfBoundsException in
		 * Java. This is because start becomes 0 and end becomes -1. So arr[end]
		 * throws exception.
		 */
		if (high == low)
		{ System.out.println("case high == low");
			return arr[low];
		}
		/* Check with input - {1,2,3,4,5,6,7} array is sorted and arr.length= odd */
		int mid = (high - low) / 2 + low;
		if (mid < high && arr[mid + 1] < arr[mid])
			return arr[mid + 1];
		if (low < mid && arr[mid - 1] > arr[mid])
			return arr[mid];
		if (arr[high] > arr[mid])
			return FindMin(arr, low, mid - 1);
		else
			return FindMin(arr, mid + 1, high);

	}
	
	public static int Find(int arr[], int n, int low, int high) {
		if(low>high) {
			return -1;
		}
		int mid = (high - low) / 2 + low;
		if(n==arr[mid]) {
			return mid;
		}
		// array[low...mid] is sorted
		if (arr[low] <= arr[mid]) {
			// check if key is in 1st half or 2nd
			if(n>=arr[low] && arr[mid]>=n) {
				return Find(arr,n,low, mid-1);
			}else {
				return Find(arr,n,mid+1,high);
			}
		}
		// array[mid...high] is sorted
		else {
			// check if key is in 1st half or 2nd
			if(n<=arr[high] && arr[mid]<=n) {
				return Find(arr,n,mid+1, high);
			}else {
				return Find(arr,n,low,mid-1);
			}
		}

	}

	public static void main(String[] args) {
		int[] arr=new int[]{6,7,8,9,10,1,2,3,4,5};
		 //int[] arr=new int[]{1,2,3,4,5,6,7};
		//int[] arr = new int[] { 4, 5, 1, 2, 3 };
		System.out.println(FindMinInRotatedArray
				.FindMin(arr, 0, arr.length - 1));
		System.out.println(Find(arr,2,0,arr.length-1));

	}

}
