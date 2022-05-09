

// https://www.geeksforgeeks.org/understanding-the-coin-change-problem-with-dynamic-programming/
public class CoinChangeAllSolutions {
	public int getCount(int totalAmt, int[] coins) {
		int amts[] = new int[totalAmt + 1];// arr which contains all sub problem
											// solutions
		amts[0] = 1;
		for (int j = 0; j < coins.length; j++) {
		for (int amt = 1; amt <= totalAmt; amt++) {// for each sub amt get
													// solution
			//amts[amt] = 1;
				
				if (coins[j] <= amt) {
					// for each i find
			        // c(p)+= [C(P)-Vi];
					amts[amt] += amts[amt-coins[j]];
					}
			}
		}
		return amts[totalAmt];

	}
	
	static long getNumberOfWays(int N, int[] Coins) 
    { 
        // Create the ways array to 1 plus the amount 
        // to stop overflow 
        int[] ways = new int[N + 1];  
  
        // Set the first way to 1 because its 0 and 
        // there is 1 way to make 0 with 0 coins 
        ways[0] = 1;  
  
         // Go through all of the coins 
        for (int i = 0; i < Coins.length; i++) { 
  
            // Make a comparison to each index value  
            // of ways with the coin value. 
            for (int j = 0; j < ways.length; j++) {  
                if (Coins[i] <= j) { 
       
                    // Update the ways array 
                    ways[j] += ways[j - Coins[i]];  
                } 
            } 
        } 
  
        // return the value at the Nth position 
        // of the ways array.     
        return ways[N];  
    } 

	public static void main(String[] args) {
		// C(P) = min for all i{C(P-Vi)}+1

		CoinChangeAllSolutions cc = new CoinChangeAllSolutions();
		int arr[] = { 1,5,10};
		long arr1[] = { 1,5,10};
		//int arr[] = { 2, 4, 5, 10 };
		System.out.println(cc.getCount(12, arr));	
		System.out.println(getNumberOfWays(12, arr));

	}


}
