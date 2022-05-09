/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Stockroom
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i=1;i<=t;i++)
		{
			printResult(Integer.parseInt(sc.nextLine()));
		}
	}

	private static void printResult(int n) {
		// TODO Auto-generated method stub
		boolean b = false;
		int i;
		for(i=2;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
			{
				b=true;
				break;
			}
		}
		if(b)
		{
			System.out.println(n-i+" "+i);
		}
		else
			System.out.println(0+" "+n);
	}
}
