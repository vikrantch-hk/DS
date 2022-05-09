import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByFrequency {

	/*
	 * // sample input 2, 3, 4, 2, 8, 1, 1, 2 //sample output 2,2,2,1,1,3,4,8
	 * sort by frequency higher to lower, if frequency is same then smaller
	 * number first
	 */

	public static int[] sort(int[] inputArray) {

		final List<Integer> inputList = new ArrayList<Integer>();
		for (int i : inputArray)
			inputList.add(i);
		Collections.sort(inputList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (((Integer) Collections.frequency(inputList, o1))
						.compareTo(Collections.frequency(inputList, o2)) == 0)
					return o1.compareTo(o2);
				else
					return ((Integer) Collections.frequency(inputList, o2))
							.compareTo(Collections.frequency(inputList, o1));
				// compare o2's frequnecy with o1 coz we wnt to be bigger
				// frequency first then smaller
			}
		}

		);

		int[] outputArray = new int[inputArray.length];
		for (int i = 0; i < inputArray.length; i++)
			outputArray[i] = inputList.get(i);
		return outputArray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = sort(new int[] { 2, 3, 4, 2, 8, 1, 1, 2 });
		for (int i : arr)
			System.out.println(i);

	}

}
