package bitiwise.hack;


// to find 2 missing numbers in array 
// http://www.lifeincode.net/programming/find-two-missing-numbers-from-1-to-n/
public class MissingNumberInArray {

	public static int getMissingNumber(int[] a)
	{
		int sum = 0;
		for(int i:a)
		{
			sum ^= i;
		}
		// doing length+1 because arr is starting from 1 if it starts from 0 then length should work
		for(int i=1;i<=a.length+1;i++)
		{
			sum ^= i;
		}
		/*
		(a1^a2^a3)^(a1^a3)
		(a1^a1)^(a2)^(a3^a3)
		a2*/
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(getMissingNumber(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,15}));
	}
}
