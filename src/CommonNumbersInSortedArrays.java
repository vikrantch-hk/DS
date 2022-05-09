public class CommonNumbersInSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printCommonNumbersIn2SortedArrays(new int[] { 2, 5, 6, 9 }, new int[] {
				5, 7, 9, 10 });

		System.out.println();

		printCommonNumbersIn3SortedArrays(new int[] { 1, 5, 5 }, new int[] { 3,
				4, 5, 5, 10 }, new int[] { 5, 5, 10, 20 });
	}

	private static void printCommonNumbersIn3SortedArrays(int[] a, int[] b,
			int[] c) {
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length && k < c.length) {
			if (a[i] == b[j]) {
				if (a[i] == c[k]) {
					System.out.print(a[i] + " ");
					i++;
					j++;
					k++;
				} else if (a[i] < c[k]) {
					i++;
					j++;
				} else
					k++;
			} else if (a[i] > b[j])
				j++;
			else
				i++;
		}
	}

	private static void printCommonNumbersIn2SortedArrays(int[] a, int[] b) {
		// TODO Auto-generated method stub
		// if a[i] is lesser can get bigger element only by doing i++
		// if a[i] is bigger we can get bigger element in b only by doing j++
		
		
		
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				System.out.print(a[i] + " ");
				i++;
				j++;
			} else if (a[i] > b[j])
				j++;
			else
				i++;
		}
	}

}
