package junit;
public class FindMinInRotatedArray {

	public static int FindMin(int arr[], int low, int high) {
		if (high < low)
			return arr[0];
		/*
		 * Check with input - {1,2,3,4,5,6}. If you don't put above condition,
		 * and try this input, it results in ArrayIndexOutOfBoundsException in
		 * Java. This is because start becomes 0 and end becomes -1. So arr[end]
		 * throws exception.
		 */
		if (high == low)
			return arr[low];
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr=new int[]{9,8,7,6,2,3,4,5};
		int[] arr=new int[]{1,2,3,4,5};
		//int[] arr = new int[] { 4, 5, 1, 2, 3 };
		System.out.println(FindMinInRotatedArray
				.FindMin(arr, 0, arr.length - 1));

	}

}
