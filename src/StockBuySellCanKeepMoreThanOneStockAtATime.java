import java.util.ArrayList;
import java.util.List;

// use full algo of StockBuySellCanKeepMoreThanOneStockAtATime
// add all the stcoks starting from localMinima 
// deduct some from localMaxima*interval size -1
public class StockBuySellCanKeepMoreThanOneStockAtATime {

	public static void getMaxProfit(int[] priceArr)
	{
		int profit = 0,max = 0;
		for(int i =priceArr.length-1;i>=0;i--)
		{
			if(priceArr[i]>=max)
			{
				max = priceArr[i];
			}
			profit += max-priceArr[i];
		}
		System.out.println("profit small soultion "+profit);
	}

	public static void main(String[] args) {
		int[] priceArr = //{1, 2, 100, 50, 80};
				{ 100, 180, 260, 310, 40, 535,695 ,70};
				//{ 50, 100, 90, 500 };
		getMaxProfit(priceArr);
		
		List<Interval> list = getMaxProfits(priceArr);
		int profit = 0;
		for(Interval interval :list){
			int totalStocksTobuy = interval.sell-interval.buy;
			int sum = 0;
			for(int i=interval.buy;i<(interval.buy+totalStocksTobuy);i++)
				sum+=priceArr[i];
			
			profit+=(priceArr[interval.sell]*totalStocksTobuy)-sum;
		}
		System.out.println("profit "+profit);
	}

	private static List<Interval> getMaxProfits(int[] priceArr) {


        // Prices must be given for at least two days
        if (priceArr.length == 1)
            return null;
		
		List<Interval> list = new ArrayList<Interval>();
		int i = 0;
		// Find Local Minima. Note that the limit is (n-2) as we are
        // comparing present element to the next element. 
		while (i < priceArr.length - 1) {
			while (i < priceArr.length - 1 && priceArr[i + 1] < priceArr[i])
				i++;

			if (i == priceArr.length - 1)
				break;
			
			Interval interval = new Interval();
			interval.buy = i++;
			
			while (i < priceArr.length - 1 && priceArr[i + 1] > priceArr[i])
				i++;

			interval.sell = i;
			list.add(interval);
		}

		return list;
	}

	static class Interval {
		int buy;
		int sell;

	}

}
