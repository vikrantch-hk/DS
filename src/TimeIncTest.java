/* you need to print like below
 * i/p         o/p
 * aaabbca     a3b2ca
 * aaab        a3b
 * a           a*/
public class TimeIncTest {

	public static void print(String str) {
		System.out.println();
		char prev = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == prev)
				count++;
			else {
				if (count == 1)
					System.out.print(prev);
				else
					System.out.print(prev + "" + count);
				count = 1;
				prev = str.charAt(i);
			}
		}
		if (count == 1)
			System.out.print(str.charAt(str.length() - 1));
		else
			System.out.print(str.charAt(str.length() - 1) + "" + count);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeIncTest.print("aaabbca");
		TimeIncTest.print("aaab");
	}

}
