package collection.concepts;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;

import oops.concepts.equals.Employee;

public class CollectionConcepts {

	public static void read(List<Number> list) {

	}

	public static void read2(List<?> list) {

	}

	public static void read3(List<? extends Number> list) {
		// list.add(1);// no write operation possible on extends
	}

	public static void read4(List<? super Integer> list) {
		list.add(1);
		int i = (Integer)list.get(0);
		// super supports both get and add
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Arrays.equals(new int[2], new int[2]);

		Arrays.toString(new char[] {});
		Arrays.asList(new int[] {});
		/*
		 * boolean java.util.Arrays.equals(int[] a, int[] a2)
		 * 
		 * Returns true if the two specified arrays of ints are equal to one
		 * another. Two arrays are considered equal if both arrays contain the
		 * same number of elements, and all corresponding pairs of elements in
		 * the two arrays are equal. In other words, two arrays are equal if
		 * they contain the same elements in the same order. Also, two array
		 * references are considered equal if both are null.
		 */
		String s = "A";
		List<String> list1 = new ArrayList<String>();
		list1.add(null);// boolean java.util.List.add(String e) add returns
						// boolean

		// list1.add(1);
		System.out.println("list1.indexOf(null) " + list1.indexOf(null));
		System.out.println("list1.indexOf(A) " + list1.indexOf("A"));
		/*
		 * int java.util.List.indexOf(Object o)
		 * 
		 * Returns the index of the first occurrence of the specified element in
		 * this list, or -1 if this list does not contain the element. More
		 * formally, returns the lowest index i such that (o==null ?
		 * get(i)==null : o.equals(get(i))), or -1 if there is no such index.
		 */
		list1.remove(0);
		/*
		 * String java.util.List.remove(int index)
		 * 
		 * Removes the element at the specified position in this list (optional
		 * operation). Shifts any subsequent elements to the left (subtracts one
		 * from their indices). Returns the element that was removed from the
		 * list.
		 */
		list1.remove("A");
		/*
		 * boolean java.util.List.remove(Object o)
		 * 
		 * Removes the first occurrence of the specified element from this list,
		 * if it is present (optional operation). If this list does not contain
		 * the element, it is unchanged. More formally, removes the element with
		 * the lowest index i such that (o==null ? get(i)==null :
		 * o.equals(get(i))) (if such an element exists). Returns true if this
		 * list contained the specified element (or equivalently, if this list
		 * changed as a result of the call).
		 */
		list1.add("A");
		List list2 = new ArrayList();
		list2.add(s);
		if (list1.equals(list2))
			System.out.println("list equal");
		System.out.println("list size before remov" + list1.size());

		// iterable is an interface which has just one method iterator()
		Iterator<String> itr = list1.iterator();

		while (itr.hasNext()) {
			itr.next(); // without this illegalstateexception on remove as itr
						// hasn't been initialized
			// can remove only through itr while iterating over collection
			// list1.add("0");// ConcurrentModificationException
			itr.remove();
		}
		System.out.println("list size after remov" + list1.size());
		ListIterator<String> listItr = list1.listIterator();
		while (listItr.hasNext()) {
			listItr.remove();
			listItr.add("A");
			listItr.set("A");
		}
		Map<Object, Object> map1 = new HashMap<Object, Object>();
		map1.put("A", "A");
		map1.remove("A");
		/*
		 * Object java.util.Map.put(Object key, Object value)
		 * 
		 * 
		 * Associates the specified value with the specified key in this map
		 * (optional operation). If the map previously contained a mapping for
		 * the key, the old value is replaced by the specified value. (A map m
		 * is said to contain a mapping for a key k if and only if
		 * m.containsKey(k) would return true.)
		 * 
		 * Parameters: key key with which the specified value is to be
		 * associated value value to be associated with the specified key
		 * Returns: the previous value associated with key, or null if there was
		 * no mapping for key. (A null return can also indicate that the map
		 * previously associated null with key, if the implementation supports
		 * null values.)
		 */
		Map map2 = new HashMap<String, Object>();
		map2.put(s, s);
		if (map1.equals(map2))
			System.out.println("map equal");
		Set<String> set1 = new HashSet();// boolean java.util.Set.add(String e)
		set1.add(null);
		set1.add("A");
		set1.remove("A");/*
							 * //boolean java.util.Set.remove(Object o)
							 * 
							 * 
							 * Removes the specified element from this set if it
							 * is present (optional operation). More formally,
							 * removes an element e such that (o==null ? e==null
							 * : o.equals(e)), if this set contains such an
							 * element. Returns true if this set contained the
							 * element (or equivalently, if this set changed as
							 * a result of the call). (This set will not contain
							 * the element once the call returns.)
							 */
		Set set2 = new HashSet();
		set2.add(s);
		if (set1.equals(set2))
			System.out.println("set equal");

		List<? extends Number> readOnlylist = new ArrayList<Integer>();// error
																		// cannot
																		// convert
		// readOnlylist.add(0); //error List<? extends Number> gives read only
		// list
		// from ArrayList<Integer> to List<Number>

		// CollectionConcepts.read(new ArrayList<Integer>());// The method
		// read(List<Number>)
		// in the type
		// CollectionConcepts
		// is not applicable
		// for the arguments
		// (ArrayList<Integer>)

		// List <?> list4 = new ArrayList<?>();//Cannot instantiate the type
		// ArrayList<?>

		List<?> list5 = new ArrayList<Integer>();// will work fine for any
													// object
		ArrayList list7 = new ArrayList();
		LinkedList list6 = new LinkedList(list7);// converted arraylist to
													// linkedlist
		List<? extends Number> list3 = new ArrayList<Integer>();// will work
		List<? super Integer> list4 = new ArrayList<Number>();
		list4.add(0);
		list4.get(0);
		// List<? super Number> list4 = new ArrayList<Integer>();// err cannot
		// convert from ArrayList<Integer> to List<? super Number>

		// CollectionConcepts.read2(new ArrayList<?>());// Cannot instantiate
		// the type ArrayList<?>
		CollectionConcepts.read2(new ArrayList<Integer>());
		CollectionConcepts.read3(new ArrayList<Integer>());
		CollectionConcepts.read4(new ArrayList<Number>());

		Map<Employee, String> weakMap = new WeakHashMap<Employee, String>();
		Map<Employee, String> strongMap = new HashMap<Employee, String>();
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		weakMap.put(e1, "e1");
		strongMap.put(e2, "e2");
		System.out.println("weakmap size " + weakMap.size());
		System.out.println("strongMap size " + strongMap.size());
		e1 = null;
		e2 = null;
		for (int i = 1; i < 100; i++)
			System.gc();
		// weakmap will remove entry if key becomes null
		System.out.println("weakmap size " + weakMap.size());
		System.out.println("strongMap size " + strongMap.size());
		System.out.println(" get value after setting key null in stringMap " + strongMap.get(e2));// will give null becoz hashcode has been cached

		Map<Employee, String> map = new HashMap<Employee, String>();
		Employee e3 = new Employee();
		e3.setId(1);
		Employee e4 = new Employee();
		e4.setId(1);
		map.put(e3, "e3");
		map.put(e4, "e4");
		map.forEach((k, v) -> {
			System.out.println(v);
		});// map replaces value for duplicate keys

		EnumSet<EnumTest> set = EnumSet.allOf(EnumTest.class);
		set.forEach(k -> System.out.print(k + " "));

		LinkedHashMap lruCache = new LinkedHashMap<>(10, .75f, true);
		List<Integer> list = Arrays.asList(new Integer[] { 1, 2 });// Returns a
																	// fixed-size
																	// list
		// list.add(3);// java.lang.UnsupportedOperationException
		// list.set(0, 3);// java.lang.UnsupportedOperationException
		System.out.println(list.size());

		// NoSuchElementException
		Queue<Integer> q = new LinkedList<Integer>();
		// System.out.println(q.remove());

		Integer a = 1;
		Integer b = 1;
		System.out.println(a == b);

		System.out.println("map before map.keySet().remove()");
		map.forEach((k, v) -> {
			System.out.println(k + " " + v);
		});
		map.keySet().remove(e4);
		System.out.println("map after map.keySet().remove()");
		map.forEach((k, v) -> {
			System.out.println(k + " " + v);
		});

		Number[] arr = new Integer[1];
		// arr[0]=2;
		arr[0] = 2.5;// putting float in integer array ArrayStoreException
		System.out.println(arr[0]); // ArrayStoreException: java.lang.Double

		map.keySet().add(e4); // UnsupportedOperationException
		// The set supports element removal, which removes the corresponding
		// mapping from the map, via the Iterator.remove, Set.remove, removeAll,
		// retainAll, and clear operations. It does not support the add or
		// addAll operations.

		Long c = null;
		try {
			Thread.sleep(c); // NullPointerException passing null Long object to
								// long primitive value
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

enum EnumTest {
	INDIA, US, CHINA
}
