package cracking.code.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// method to sort an array of strings so that all the anagrams are next to each other.
public class SortAnagrams {

	public static void main(String[] args) {
		String[] arr = new String[5];
		arr[0] = "cat";
		arr[1] = "dog";
		arr[2] = "tac";
		arr[3] = "god";
		arr[4] = "act";

		Arrays.parallelSort(arr, (o1, o2) -> {
			char[] a1 = o1.toCharArray();
			char[] a2 = o2.toCharArray();
			Arrays.parallelSort(a1);// O(nlogn)
			Arrays.parallelSort(a2);
			return new String(a1).compareTo(new String(a2));
		});

		Arrays.asList(arr).forEach(s -> System.out.println(s));
	}

}
