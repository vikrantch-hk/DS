package two.d.arrays;

// http://www.geeksforgeeks.org/maximum-sum-hour-glass-matrix/
// https://github.com/scottnakada/HackerRank-Java/blob/master/11-2D-Arrays/src/twoDArray.java

/*If we count total number of hour glasses in a matrix, we can say that the count is equal to count of possible 
 * top left cells in hour glass. Number of top-left cells in a hour glass is equal to (R-2)*(C-2). Therefore, in a matrix total
 *  number of hour glass is (R-2)*(C-2)*/
public class MaximumSumHourGlass {
	public static int getMaximumSumHourGlass(int[][] arr) {
		int maxSum = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = 0; j < arr[0].length - 2; j++) {
				System.out.println("hourgalss is");
				System.out.println(arr[i][j] + " " + arr[i][j + 1] + " " + arr[i][j + 2]);
				System.out.println(arr[i + 1][j + 1]);
				System.out.println(arr[i + 2][j] + " " + arr[i + 2][j + 1] + " " + arr[i + 2][j + 2]);

				int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j]
						+ arr[i + 2][j + 1] + arr[i + 2][j + 2];
				if (sum > maxSum)
					maxSum = sum;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		arr[0] = new int[] { 1, 2, 3, 0, 0 };
		arr[1] = new int[] { 0, 0, 0, 0, 0 };
		arr[2] = new int[] { 2, 1, 4, 0, 0 };
		arr[3] = new int[] { 0, 0, 0, 0, 0 };
		arr[4] = new int[] { 1, 1, 0, 1, 0 };
		System.out.println(getMaximumSumHourGlass(arr));
	}

}
