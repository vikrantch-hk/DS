public class BinarySearch {

	public BinarySearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int doSearch(int[] arr, int data) {
		int low, high, mid;
		low = 0;
		high = arr.length - 1;
		while (low <= high) {
			mid = low + (high - low) / 2;// always use low+(high-low)/2 never
											// (low+high)/2 it will fail if
											// high=integer.max_value and low >0
			if (arr[mid] == data)
				return mid;
			else if (arr[mid] < data)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	// /public String doSearch(int[] arr, int data){} will give compile error
	// Duplicate method doSearch(int[], int) in type BinarySearch
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearch bs = new BinarySearch();
		int[] arr = { 1, 2, 5, 8, 20, 33, 41 };
		System.out.println(bs.doSearch(arr, 5));
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	/*This tells the compiler “I think that I am
	overriding a method from the parent class”. If
	there is no such method in the parent class,
	code won’t compile. If there is such a method
	in the parent class, then @Override has no
	effect on the code. Recommended but optional.
	More on @Override in later sections.*/
}
