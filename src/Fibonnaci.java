
public class Fibonnaci {
	
	static int fibbonaci(int n)
	{
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		else
			return fibbonaci(n-1)+fibbonaci(n-2);
	}
	
	static long sum(int max)
	{
		long c = 0;
		for(int i=0;fibbonaci(i)<=max;i++)
		{
			c+=fibbonaci(i);

		}
		return c;
	}
	
	public static void main(String[] args) {
		System.out.println(sum(8));
	}

}
