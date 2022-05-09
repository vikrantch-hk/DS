public class NumberIsPowerOfaNumber {

	/*
	 * Given 2 integers x and y, check if x is an integer power of
	 * y" (e.g. for x = 8 and y = 2 the answer is "
	 * true", and for x = 10 and y = 2 "false").
	 */

	public static boolean isPowerOfaNumber(int x, int y) {
		while (x % y == 0)
			x = x / y;
		// return true if base is equal 1
		return x == 1;
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfaNumber(9,3));
		System.out.println(isPowerOfaNumber(10,2));
		System.out.println(isPowerOfaNumber(8,2));
	}

}
