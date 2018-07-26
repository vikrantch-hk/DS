package com.practice.ds;

public class StockBuySellOnly1Stock {

	private static class Interval {
		int buy;
		int sell;
	}

	public static void maxProfit(int[] a) {
		int i = 0;
		int profit = 0;
		while (i < a.length - 1) {
			while (i < a.length - 1 && a[i + 1] < a[i])
				i++;
			if (i == a.length - 1)
				break;
			Interval intrvl = new Interval();
			intrvl.buy = i;
			i++;
			while (i < a.length - 1 && a[i + 1] > a[i])
				i++;
			intrvl.sell = i;
			profit += a[intrvl.sell] - a[intrvl.buy];
			System.out.println("buy at " + intrvl.buy + " sell at " + intrvl.sell);
		}
		System.out.println("max profit " + profit);
	}

	public static void main(String[] args) {
		maxProfit(new int[] { 1, 4, 5, 7, 6, 3, 2, 9 });
	}

}
