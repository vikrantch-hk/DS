class ReverseWordByWord {
	/*
	 * input- This is good
	 * output- sihT si doog
	 */

	public static String reverseWordByWord(String inputString) {
		String[] input = inputString.split(" ");
		StringBuilder ouput = new StringBuilder();
		for (String s : input) {
			ouput.append(new StringBuilder(s).reverse() + " ");
		}
		return ouput.toString().trim();
	}

	public static void main(String[] args) {
		System.out.println(reverseWordByWord("This is good"));
	}

}
