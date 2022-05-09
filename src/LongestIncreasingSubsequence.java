public class LongestIncreasingSubsequence {

	public static void lengthOfLongestIncreasingSubsequence(int[] arr) {
		int A[] = new int[arr.length + 1];
		A[0] = 1;// longest sequence for i=0 is 1
		// for j<i && A[j]<A[i] A[i]=Max of(A[j])+1

		for (int i = 0; i < arr.length; i++) {
			A[i] = 1;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && A[i] < (A[j] + 1))
					A[i] = A[j] + 1;
			}
		}

		int max = 0;
		for (int i : A)
			max = max > i ? max : i;
		System.out.println("lengthOfLongestIncreasingSubsequence is " + max);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lengthOfLongestIncreasingSubsequence(new int[] { 15, 27, 14, 38, 26,
				55, 46, 65, 85 });
	}

}
