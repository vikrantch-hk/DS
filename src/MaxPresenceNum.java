public class MaxPresenceNum {

	public void findMaxPresenceNum() {
		int arr[] = { 1, 2, 3, 1, 1, 1, 2, 4, 4, 4, 4, 2, 2, 2, 3, 3, 3, 3, 44,
				4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3,
				3, 3, 3, 3, 3, 4 };
		// QuickSort.doSorting(arr, 0, arr.length-1);
		Sorting.sort(arr);
		// Arrays.sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}

		int i, count = 1, fav = arr[0], prev = arr[0];
		int maxCount = 1;
		for (i = 1; i < arr.length; i++) {
			if (arr[i] == prev) {
				count++;
			} else {
				if (count > maxCount) {
					fav = arr[i - 1];
					maxCount = count;
				}
				count = 1;
				prev = arr[i];
			}
		}
		if (count > maxCount)
			fav = arr[arr.length - 1];
		System.out.println("fav" + fav + " maxCount" + maxCount);
	}

	public static void main(String[] args) {
		MaxPresenceNum maxPresenceNum = new MaxPresenceNum();
		maxPresenceNum.findMaxPresenceNum();
		// int arr[]
		// ={1,2,3,1,1,1,2,4,4,4,4,2,2,2,3,3,3,3,44,4,4,4,4,4,4,4,4,4,4,4,4,3,3,3,3,3,3,3,3,3,3,3,3,3,3,4};
		// System.out.println(maxPresenceNum.findPopular(arr));
	}
}
