public class StringPermutation {

	public static void permutation(String prefix, String str) {
		int len = str.length();
		if (len == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < len; i++) {
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1));
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringPermutation.permutation("", "ABC");
	}

}
