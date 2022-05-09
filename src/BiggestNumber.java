import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/*Given an array of numbers, arrange them in a way that yields the largest value. 
 * For example, if the given numbers are {9, 92, 5}, the arrangement 9925 gives the largest value*/

public class BiggestNumber {

	public static void formBiggestNumber(int[] arr) {
		int biggestNum = 0;
		for (int i = 0; i < arr.length; i++) {
			StringBuilder sb = new StringBuilder().append(arr[i]);
			for (int j = 0; j < arr.length; j++) {
				if (i != j)
					sb.append(arr[j]);
			}
			if (Integer.parseInt(sb.toString()) > biggestNum)
				biggestNum = Integer.parseInt(sb.toString());
		}
		System.out.println("biggest number is " + biggestNum);
	}

	/*
	 * A simple solution that comes to our mind is to sort all numbers in
	 * descending order, but simply sorting doesn�t work. So how do we go about
	 * it? The idea is to use any comparison based sorting algorithm. In the
	 * used sorting algorithm, instead of using the default comparison, write a
	 * comparison function myCompare() and use it to sort numbers. Given two
	 * numbers X and Y, how should myCompare() decide which number to put first
	 * � we compare two numbers XY (Y appended at the end of X) and YX (X
	 * appended at the end of Y). If XY is larger, then X should come before Y
	 * in output, else Y should come before. For example, let X and Y be 92 and
	 * 9. To compare X and Y, we compare 929 and 992. Since 992 is
	 * greater than 929, we put Y first
	 */
	public static void bySorting(Integer[] arr) {
		Arrays.sort(arr, new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return Integer.parseInt(i2.toString() + i1.toString())
						- (Integer.parseInt(i1.toString() + i2.toString()));
			}
		});
		StringBuffer sb = new StringBuffer();
		for (Integer i : arr)
		{
			System.out.println(i);
			sb.append(i);
		}
		System.out.println("biggestnumber by sorting "+sb);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		formBiggestNumber(new int[] { 9, 92, 5 });
		formBiggestNumber(new int[] { 1, 34, 3, 98, 9, 76 });
		bySorting(new Integer[] { 1, 34, 3, 98, 9, 76 });
		bySorting(new Integer[] { 9,92, 5 });
	}

}
