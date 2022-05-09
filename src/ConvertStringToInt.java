
public class ConvertStringToInt {

	public static void printInt(String str) {
		int n = 0, i = 0;
		boolean isNegative = false;
		if (str.charAt(0) == '-') {
			isNegative = true;
			i = 1;
		}
		while (i < str.length()) {
			n *= 10;
			n = n + (str.charAt(i) - '0');
			i++;
		}
		if (isNegative)
			System.out.println("-" + n);
		else
			System.out.println(n);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printInt("-12345");
	}

}
