package cracking.code.interview;

import java.util.Arrays;

public class MergeSortedArrays {
	public static void merge(int[] a,int[] b ) {
		int m = a.length, n = b.length;
		int[] c = Arrays.copyOf(a,a.length+b.length);
		while(n>0)
		{
			if(m<=0||b[n-1]>a[m-1])
				c[m+n-1]=b[--n];
			else
				c[m+n-1]=a[--m];
		}
		
		for(int i:c)
			System.out.print(i+" ");
	}
	
	public static void main(String[] args) {
		merge(new int[]{1,8,15,20}, new int[]{3,16,28});
	}
}
