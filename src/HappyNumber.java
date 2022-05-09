import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*A number is called happy if it leads to 1 after a sequence of steps where in each step number is replaced by sum of squares of its digit that is if 
 * we start with Happy Number and keep replacing it with digits square sum, we reach 1.
Examples:

Input: n = 19
Output: True
19 is Happy Number,
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
As we reached to 1, 19 is a Happy Number.

Input: n = 20
Output: False*/
public class HappyNumber {
	
	
	public static boolean isHappyNumberSmallSolution(int n)
	{
		Set<Integer> set = new HashSet<Integer>();
		
		// for non happy numbers we'll be getting same number again after repeating the sequence
		while(!set.contains(n))
		{
			set.add(n);
			n=getSum(n);
			System.out.println("n "+n);
			if(n==1)
				return true;
		}
		
		return false;
	}

	private static int getSum(int n) {
		int sum=0;
		while(n>0)
		{
			sum+=(n%10)*(n%10);
			n=n/10;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		System.out.println(isHappyNumber(n));
		System.out.println(isHappyNumberSmallSolution(20));

	}

	private static boolean isHappyNumber(int n) {
		Set<Integer> setOfAllValuesOfSumSoFar = new HashSet<Integer>();
		List<Integer> digitsList = getDigits(n);
		int sumOfSquareOfDigits = getSumOfSquareOfDigits(digitsList);
		setOfAllValuesOfSumSoFar.add(sumOfSquareOfDigits);
		while (sumOfSquareOfDigits > 0) {
			digitsList = getDigits(sumOfSquareOfDigits);

			// if we are getting repeated sum of digits break its not a happy
			// number
			if (setOfAllValuesOfSumSoFar.contains(getSumOfSquareOfDigits(digitsList)))
				return false;

			sumOfSquareOfDigits = getSumOfSquareOfDigits(digitsList);
			System.out.println(sumOfSquareOfDigits);
			if (sumOfSquareOfDigits == 1)
				return true;
		}
		if (sumOfSquareOfDigits == 1)
			return true;
		else
			return false;
	}

	private static int getSumOfSquareOfDigits(List<Integer> digitsList) {
		int sum = 0;
		sum = digitsList.parallelStream().mapToInt(i -> i * i).sum();
		/*
		 * equivalent to for(int i:digitsList) { sum += i*i; }
		 */
		return sum;
	}

	private static List<Integer> getDigits(int n) {
		List<Integer> digitsList = new ArrayList<Integer>();
		while (n > 0) {
			digitsList.add(n % 10);
			n = n / 10;
		}
		return digitsList;
	}

}
