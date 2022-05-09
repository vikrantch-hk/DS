public class LevenShteinDistance {

	public static int editDistance(String s, String t) {
		int arr[][] = new int[s.length() + 1][t.length() + 1];

		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j <= t.length(); j++) {
				if (i == 0) {
					arr[i][j] = j;
				} else if (j == 0) {
					arr[i][j] = i;
				}
				if (i > 0 && j > 0) {
					if (s.charAt(i - 1) == t.charAt(j - 1))
						arr[i][j] = arr[i - 1][j - 1];
					else
						arr[i][j] = 1 + Math.min(arr[i - 1][j - 1],
								Math.min(arr[i][j - 1], arr[i - 1][j]));
				}
			}
		}
		return arr[s.length()][t.length()];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(editDistance("x", "xdfh"));
	}

}
