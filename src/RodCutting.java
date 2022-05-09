import java.util.Arrays;
import java.util.Collections;


public class RodCutting {
	
	public static int getBestPrice(int length,int[] prices)
	{
		int pieceWisePrice[] = new int[length+1];
		pieceWisePrice[0] = 0;
		
		// best price for piece of length k B(k)=max of [Vi+B(k-i-1)] for 0<=i<k
		for(int k=1;k<=length;k++)
		{
			int temp =0;
			for(int i=0;i<k;i++)
			{
				pieceWisePrice[k]=pieceWisePrice[k]>prices[i]+pieceWisePrice[k-1-i]?
						pieceWisePrice[k] : prices[i]+pieceWisePrice[k-1-i];
			}
			
		}
			
		return pieceWisePrice[length];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a[]=new Integer[2];
		System.out.print(a[0]+" "+a[1] );
System.out.println(getBestPrice(8,new int[]{1,5,8,9,10,17,17,20}));
	}

}
