
public class MissingNumber {

	public static void findMissingNumber(int[] arr) {
		int size = arr.length;
		int sum = ((size + 1) * (size + 2)) / 2;
		for (int i = 0; i < size; i++) {
			sum = sum - arr[i];
		}
		System.out.println("missing number is " + sum);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 2, 4, 1, 5, 8, 7, 9, 6, 10 };
		findMissingNumber(arr);
	}

}
