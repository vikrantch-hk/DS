
public class MergeTwoSortedArrays {
	
	
	public static void merge(int[] a,int[] b)
	{
		int m=a.length;
		int n=b.length;
		int[] c= new int[m+n];
		for(int i=0;i<a.length;i++)
			c[i]=a[i];
		while(n>0)
		{
			if(m<=0 || a[m-1]<b[n-1])/// put bigger element in bigger pos
				c[m+n-1]=b[--n];
			else
				c[m+n-1]=a[--m];
		}
		for(int i:c)
			System.out.print(i+" ");
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]=new int[]{1,4,8,9,10};
		int b[]=new int[]{2,3,5,70,80,90,95};
		MergeTwoSortedArrays.merge(a,b);
	}

}
