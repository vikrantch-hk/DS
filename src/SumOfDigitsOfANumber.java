public class SumOfDigitsOfANumber {

	/*
	 * java program that sums up the digits of a number until it is a single
	 * number Eg: 2748303 = 2+7+4+8+3+0+3 = 27 = 2+7 = 9
	 */
	public static int doSum(int num) {
		while (num > 9) {
			int sum = 0;
			while (num > 0) {
				sum += num % 10;
				num = num / 10;
			}
			num = sum;
		}
		return num;
	}

	public static void main(String[] args) {
		System.out.println(doSum(2748303));
	}

}
