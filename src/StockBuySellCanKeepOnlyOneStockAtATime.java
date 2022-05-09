import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockBuySellCanKeepOnlyOneStockAtATime {

	public static void main(String[] args) {
		int[] priceArr = {1, 2, 100, 50, 80};
				//{ 100, 180, 260, 310, 40, 535, 695 ,5,50};
				//{ 50, 100, 90, 500 };
		getMaxProfits(priceArr);
	}

	private static void getMaxProfits(int[] priceArr) {


        // Prices must be given for at least two days
        if (priceArr.length == 1)
            return;
		
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
			interval.buy = i;
			
			while (i < priceArr.length - 1 && priceArr[i + 1] > priceArr[i])
				i++;

			interval.sell = i;
			
			list.add(interval);
			i++;
		}

		for (Interval interval : list)
			System.out.println("buy " + interval.buy + " sell " + interval.sell);
	}

	static class Interval {
		int buy;
		int sell;

	}
}
