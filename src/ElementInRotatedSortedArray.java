// https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/ o(logn)
public class ElementInRotatedSortedArray {
	public static void main(String[] args) {
		System.out.println(find(new int[] {4, 5, 6, 7, 8, 9, 1, 2, 3},7));
	}

	private static int find(int[] arr, int num) {
		return find(arr,num,0,arr.length-1);
	}

	private static int find(int[] arr, int num, int l, int r) {
		if (l > r)
			return -1;
		int mid = (l + r) / 2;

		if (arr[mid] == num)
			return mid;
		// left arr is sorted
		if (arr[mid] >= arr[l]) {
			if (arr[l] <= num && arr[mid] >= num) {
				return find(arr, num, l, mid - 1);
			} else {
				return find(arr, num, mid + 1, r);
			}
		} else {
			if (arr[r] >= num && arr[mid] <= num) {
				return find(arr, num, mid + 1, r);
			}
		}
		return find(arr, num, mid + 1, r);
	}

}
