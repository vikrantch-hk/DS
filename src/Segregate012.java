public class Segregate012 {
	
	// time complexity O(n)
	public static void sort(int[] arr) {
		// start mid with low and take it to high
		int low = 0, mid = 0, high = arr.length - 1;
		while (mid <= high) {
			switch (arr[mid]) {
			case 0:
				// 0 shld be in low so swap with low pointer
				swap(arr, mid, low);
				low++;
				mid++;
				// take mid to high by incrementing
				break;
			case 1:
				mid++;
				// no need to swap as we want 1 in mid simply take mid to high by incrementing
				break;
			case 2:
				// 2 shld be in high so swap with high pointer
				swap(arr, mid, high);
				// take mid to high by decremeting high
				high--;
				break;
			}
		}
	}

	private static void swap(int[] a, int low, int mid) {
		// TODO Auto-generated method stub
		int temp = a[low];
		a[low] = a[mid];
		a[mid] = temp;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int j = (Integer.MAX_VALUE + 0) / 2;
		System.out.println(j);
		int arr[] = new int[] { 0, 2, 1, 1, 2, 0, 1, 1, 2, 2, 2, 0, 0, 2 };
		// Segregate012.doSegregation(arr);
		// Segregate012.sort012(arr);
		Segregate012.sort(arr);
		for (int i : arr)
			System.out.print(i + " ");
	}

}
