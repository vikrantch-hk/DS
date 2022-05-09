public class NumbersHavingAtLeast15Digit {

	public static void totalNumbersHavingAtLeast15Digit(Integer n) {
		int count = 0;
		for (Integer i = 0; i <= n; i++) {
			String s = i.toString();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '5') {
					count++;
					break;
				}

			}
		}
		System.out.println("count" + count);
	}

	public static int optimalTotalNumbersHavingAtLeast15Digit(Integer n) {

		int d = (int)Math.log10(n); // d = length -1 ex 99=1 999=2 9999=3
		int pow = (int)Math.pow(10, d);
		
		System.out.println("d"+d+" pow +"+pow);
		
		if (n == 9)
			return 1;
		else
			return  (optimalTotalNumbersHavingAtLeast15Digit(pow-1) * 9) + pow;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		totalNumbersHavingAtLeast15Digit(9999);
		System.out.println(optimalTotalNumbersHavingAtLeast15Digit(999));
	}

}
