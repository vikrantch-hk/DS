import java.util.Arrays;

// http://www3.cs.stonybrook.edu/~yuylin/blog/combination_sum/
public class MinimumUmbrellas {

	/*
	 * There are n people, and an integer array p with size m. Each p[i] records
	 * the number of people that can be covered by the umbrella of type i. Each
	 * type can be picked multiple times. What is the minimal number of
	 * umbrellas to cover exactly n people?
	 * 
	 * ex. n = 4, m = 2, p[0] = 2, p[1] = 4. The answer is 1.
	 * 
	 * ex. n = 1, m = 1, p[0] = 2. The answer is -1.
	 */

	public static int findMinUmbrellas(int n, int[] p) {
		Arrays.sort(p);
		for (int i = p.length - 1; i >= 0; i--) {
			int j = i, tempN = n, result = 0;
			while (j > 0 && tempN % p[j] != 0) {
				result += tempN / p[j];
				tempN = tempN % p[j];
				j--;
			}
			if (j >= 0 && tempN % p[j] == 0) {
				result += tempN / p[j];
				return result;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findMinUmbrellas(8, new int[] { 4, 2 }));
		System.out.println(findMinUmbrellas(7, new int[] { 1, 2 }));
		System.out.println(findMinUmbrellas(8, new int[] { 5, 2 }));
		System.out.println(findMinUmbrellas(8, new int[] { 3, 5, 7 }));
		System.out.println(findMinUmbrellas(9,new int[] { 5, 2 }));
		System.out.println(findMinUmbrellas(9,new int[] { 4, 2 }));
	}

}
