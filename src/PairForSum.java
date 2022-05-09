import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairForSum {

	public static void findPairForSumUsingMap(int[] a, int sum)// complexity
																// o(n)
	{
		/// map.entrySet().iterator()
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(sum - a[i])) {
				System.out.println("indexes" + map.get(sum - a[i]) + " " + i
						+ " nos" + (sum - a[i]) + " " + a[i]);
			} else {
				map.put(a[i], i);
				
			}
		}
	}

	public static void findPairForSumUsingSort(int[] a, int sum) {// complexity
																	// nlogn
		Arrays.sort(a);// sorting is in place
		for (int i : a)
			System.out.print(i + " ");
		int left = 0;
		int right = a.length - 1;
		while (left < right) {
			if (a[left] + a[right] == sum) {
				System.out.println();
				System.out.println(" nos" + a[left] + " " + a[right]);
				left++;
				right--;
			} else if (a[left] + a[right] < sum)
				left++;
			else
				right--;
		}

	}

	public static void findTripletForSumUsingSort(int[] a, int sum) {// complexity
																		// nlogn+n^2
		Arrays.sort(a);// sorting is in place

		for (int i = 0; i < a.length; i++) {
			int left = i + 1;
			int right = a.length - 1;
			while (left < right) {
				if (a[i] + a[left] + a[right] == sum) {
					System.out.println();
					System.out.println(" nos" + a[i] + " " + a[left] + " "
							+ a[right]);
					left++;
					right--;
				} else if (a[i] + a[left] + a[right] < sum)
					left++;
				else
					right--;
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = new int[] { 3, 1, 5, 6, 2, 4 };
		int sum = 8;
		PairForSum.findPairForSumUsingMap(a, sum);
		PairForSum.findPairForSumUsingSort(a, sum);
		PairForSum.findTripletForSumUsingSort(a, sum);
	}

}
