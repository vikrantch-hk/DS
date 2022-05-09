import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}
	private static long lcm(long a, long b)
	{
	    return a * (b / gcd(a, b));
	}

	private static long lcm(long[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
	    return result;
	}
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
 
   Scanner sc = new Scanner(System.in);
   int n = Integer.parseInt(sc.nextLine());
   for(int i=0;i<n;i++)
   {
	   String[] arr = sc.nextLine().split(" " );
	  int s = Integer.parseInt(arr[0]);
	  int k = Integer.parseInt(arr[1]);
	 String[] arr2= sc.nextLine().split(" " );
	 long [] arr3 = new long[s];
	 for(int l=0;l<s;l++)
	 {
		 arr3[l]=Long.parseLong(arr2[l]);
	 }
	 boolean f = false;
	 for(int m=0;m<arr3.length;m++)
	 {
	 if(arr3[m]%k==0)
	 {
	 System.out.println("YES");
	 f=true;
	 break;
	 }
	 }
	 if(!f)
		 System.out.println("NO");
   }
    }
    
    public static int Bib(int a)
    {
        if (a == 1 || a== 0)
            return 1;
        else
            return (Bib(a-1) + Bib(a-2) + 1);
       
    }
}