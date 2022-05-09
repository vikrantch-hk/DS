import java.util.Arrays;

public class MaxSumSubSequence {

	public void findMaxSumSubSequence(int[] a) {
		int maxSum = 0;
		int[] sum = new int[a.length];
		int beginIndex = 0, endIndex = 0;
		sum[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			if ((sum[i - 1] + a[i]) > a[i]) {
				sum[i] = sum[i - 1] + a[i];
				endIndex++;
			} else {
				sum[i] = a[i];
				beginIndex = i;
				endIndex = i;
			}
		}
		for (int j = 0; j < sum.length; j++) {
			maxSum = (maxSum > sum[j]) ? maxSum : sum[j];
		}
		System.out.println(maxSum + " " + beginIndex + "  " + endIndex);
	}

	public static void main(String[] args) {
		MaxSumSubSequence maxSumSubSequence = new MaxSumSubSequence();
		int[] input = {1,-3,4,-2,-1,6/*2, -8, 3, -2, 4, -10/* -1, -2, 4, 5, -2, -4, -3, 5, 5, -6, -12 */};
		maxSumSubSequence.findMaxSumSubSequence(input);
	}
}
