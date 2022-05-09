
public class StockBuySellCanSellOnceOnly {

	// time complexity O(n)
	public static void findMaxDifference(int[] arr) {
		int maxDiff = 0;
		int minElement = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < minElement)
				minElement = arr[i];
			if (arr[i] - minElement > maxDiff)
				maxDiff = arr[i] - minElement;
		}

		System.out.println("max profit is " + maxDiff);
	}

	public static void findMaxDifference2(int[] arr) {
		int maxDiff = 0;
		int maxElement = arr[arr.length - 1];
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] > maxElement)
				maxElement = arr[i];
			if (maxElement - arr[i] > maxDiff)
				maxDiff = maxElement - arr[i];
		}

		System.out.println("max profit is " + maxDiff);
	}

	public static void main(String[] args) {
		int arr[] = { 3, 2, 90, 10, 110, 1, 200, 490 ,0};
		findMaxDifference(arr);
		findMaxDifference2(arr);
	}

}
