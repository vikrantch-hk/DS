package com.practice.ds;

public class StockBuySellMoreThan1Stock {

	public static int maxProfit(int[] a) {
		int max=0,profit=0;
		for(int i=a.length-1;i>=0;i--)
		{
			if(a[i]>max)
				max=a[i];
			profit+=max-a[i];
		}
		return profit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(" max profit "+maxProfit(new int[] { 1, 4, 5, 7, 6, 3, 2, 9 ,8}));
	}

}
