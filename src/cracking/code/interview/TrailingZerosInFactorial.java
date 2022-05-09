package cracking.code.interview;

import java.util.ArrayList;
import java.util.Comparator;

/*A trailing zero is always produced by prime factors 2 and 5. If we can count the number of 5s and 2s, our task
 *  is done. Consider the following examples.

n = 5: There is one 5 and 3 2s in prime factors of 5! (2 * 2 * 2 * 3 * 5). So count of trailing 0s is 1.

n = 11: There are two 5s and three 2s in prime factors of 11! (2 8 * 34 * 52 * 7). So count of trailing 0s is 2.
So if we count 5s in prime factors, we are done.
Trailing 0s in n! = Count of 5s in prime factors of n!
= floor(n/5) + floor(n/25) + floor(n/125) + ....*/
public class TrailingZerosInFactorial {

	public static int findTrailingZeros(int n)
	{
		int count =0;
		if(n<0)
		{
			return -1;
		}
		for(int i=5;n/i>0;i*=5)
		{
			count+=n/i;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(findTrailingZeros(10));
	}
}
