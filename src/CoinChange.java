public class CoinChange {

	public int getMinCount(int totalAmt, int[] coins) {
		int amts[] = new int[totalAmt + 1];// arr which contains all sub problem
											// solutions
		amts[0] = 0;
		for (int amt = 1; amt <= totalAmt; amt++) {// for each sub amt get
													// solution
			amts[amt] = Integer.MAX_VALUE-1;
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= amt) {
					// for each i find
			        // min [C(P)-Vi] +1;
					amts[amt] = Math.min(amts[amt],(amts[amt-coins[j]]+1));
					}
			}
		}if(amts[totalAmt]==Integer.MAX_VALUE-1)
			return -1;
		else
		return amts[totalAmt];

	}

	public static void main(String[] args) {
		// C(P) = min for all i{C(P-Vi)}+1

		CoinChange cc = new CoinChange();
		//int arr[] = { 3, 1, 2, 4 };
		int arr[] = { 2, 4, 5, 10 };
		System.out.println(cc.getMinCount(23, arr));

	}

}
