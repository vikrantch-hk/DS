/** Class QuickSort **/
public class Sorting {
	/** Quick Sort function **/
	public static void sort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	/** Quick sort function **/
	public static void quickSort(int arr[], int low, int high) {
		int left = low, right = high;
		int temp;
		int pivot = arr[(low + high) / 2];

		/** partition **/
		while (left <= right) {
			while (arr[left] < pivot)
				left++;
			while (arr[right] > pivot)
				right--;
			if (left <= right) {
				/** swap **/
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;
			}
		}

		/** recursively sort lower half **/
		if (low < right)
			quickSort(arr, low, right);
		/** recursively sort upper half **/
		if (left < high)
			quickSort(arr, left, high);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 11,0, 0,1, 3, 1, 0, 0, 0, 4, 9, 8,0 };
		//int[] arr = new int[] { 0, 0, 1, 1, 1, 0, 0 };
		Sorting.sort(arr);
		for (int i : arr)
			System.out.print(i + " ");
	}
}