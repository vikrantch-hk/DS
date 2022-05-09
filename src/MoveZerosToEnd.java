public class MoveZerosToEnd {

	public static void doSegregate01(int[] arr) {
		int left = 0, right = arr.length-1;

		while (left <= right) {
			while (arr[left] != 0)
				left++;
			while (arr[right] == 0)
				right--;
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
			
		}
		for (int i : arr)
			System.out.print(i + " ");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = new int[] { 0, 0,1, 3, 1, 0, 0, 0, 4, 9, 8,0 };
		int[] arr = new int[] { 0, 0,1, 1, 1, 0, 0 };
		MoveZerosToEnd.doSegregate01(arr);
	}

}
