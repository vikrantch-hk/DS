public class PrintStars {

	public static void Print(int row, int col) {
		char[][] arr = new char[row][col];
		arr[0][col / 2] = '*';
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i - 1][j] == '*') {
					arr[i][j - 1] = arr[i][j] = arr[i][j + 1] = '*';
				}
			}
		}
		for (int i = 0; i < row; i++) {
			System.out.println();
			for (int j = 0; j < col; j++)
				System.out.print(arr[i][j] + " ");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintStars.Print(4, 7);
	}

}
