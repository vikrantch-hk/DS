package bitiwise.hack;


// https://www.geeksforgeeks.org/find-two-missing-numbers-set-2-xor-based-solution/
public class TwoMissingNumbersInArray {

	public static void findMissingNumbers(int[] arr) {
		int x = 0, y = 0, sum = 0;
		for (int i : arr) {
			sum ^= i;
		}

		for (int i = 1; i <= arr.length + 2; i++) {
			sum ^= i;
		}

		// find rightmost set bit of sum of 2 numbers
		sum = sum & ~(sum - 1);

		for (int i : arr) {
			if ((i & sum) > 0)
				x ^= i;
			else
				y ^= i;
		}
		for (int i = 1; i <= arr.length + 2; i++) {
			if ((i & sum) > 0)
				x ^= i;
			else
				y ^= i;
		}
		System.out.println("missing numbers are " + x + " " + y);
	}

	public static void main(String[] args) {

		System.out.println(1 + (int) ((6 - 1) * Math.random()));
		findMissingNumbers(new int[] { 1, 3, 5, 6 });
		findMissingNumbersByArithmetic(new int[] { 1, 3, 5, 6 });
	}

	private static void findMissingNumbersByArithmetic(int[] arr) {
		int sum1 = 0;
		int sum2 = 0;
		for (int i : arr) {
			sum1 += i;
		}
		for (int i = 1; i <= arr.length + 2; i++) {
			sum2 += i;
		}
		
		int sumOfNumbers = sum2-sum1;// (x+y)
		System.out.println("sumOfNumbers "+sumOfNumbers);
		int mul1 = 1;
		int mul2 = 1;
		for (int i : arr) {
			mul1 *= i;
		}
		for (int i = 1; i <= arr.length + 2; i++) {
			mul2 *= i;
		}
		System.out.println("mul2 "+mul2+"mul1 "+mul1);
		int mulOfNumbers = mul2/mul1;//(x*y)
		System.out.println("mulOfNumbers "+mulOfNumbers);
		
		int x=0,y=0;
		int diffOfNumbers = (int) Math.sqrt((sumOfNumbers*sumOfNumbers)-(4*mulOfNumbers));
		x = (sumOfNumbers+diffOfNumbers)/2;
		y= sumOfNumbers-x;
		
		System.out.println("missing numbers are " + x + " " + y);
		
	}

}
