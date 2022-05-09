import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Generics{//<E super String> { cant use super compile exception

	/*
	 * All generic method declarations have a type parameter section delimited
	 * by angle brackets (< and >) that precedes the method's return type ( < E
	 * > in the next example).
	 */

	/*
	 * example l1{2,4,4,8,10} l2{4,8,8,12,14} o/p {4,8}
	 */
	public static <E extends Comparable<E>> List<E> findCommonElementsInSortedLists(
			List<E> l1, List<E> l2) {
		List<E> list = new ArrayList<>();
		int i = 0, j = 0;
		while (i < l1.size() && j < l2.size()) {
			E first = l1.get(i);

			E second = l2.get(j);
			if (first.equals(second)) {
				list.add(l1.get(i));
				i++;
				j++;
			}
			if (first.compareTo(second) > 0)// l1.get(i)>l2.get(j)
				j++;
			else
				i++;

		}
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l1 = Arrays.asList(2, 4, 4, 8, 10);
		List<Integer> l2 = Arrays.asList(4, 8, 8, 12, 14);
		List<Integer> list = findCommonElementsInSortedLists(l1, l2);
		for (int i : list)
			System.out.print(i + " ");
	}

}
