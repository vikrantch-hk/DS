package SortMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import comparable.Employee;

public class SortByValue {

	/*
	 * An instance of HashMap has two parameters that affect its performance:
	 * initial capacity and load factor. The capacity is the number of buckets
	 * in the hash table, and the initial capacity is simply the capacity at the
	 * time the hash table is created. The load factor is a measure of how full
	 * the hash table is allowed to get before its capacity is automatically
	 * increased. When the number of entries in the hash table exceeds the
	 * product of the load factor and the current capacity, the hash table is
	 * rehashed (that is, internal data structures are rebuilt) so that the hash
	 * table has approximately twice the number of buckets.
	 * 
	 * As a general rule, the default load factor (.75) offers a good tradeoff
	 * between time and space costs
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> unsortMap = new HashMap<String, Integer>();
		if(unsortMap instanceof Collection)
			System.out.println("mapinstanceof");
		unsortMap.put("z", 10);
		unsortMap.put("b", 5);
		unsortMap.put("a", 6);
		unsortMap.put("c", 20);
		unsortMap.put("d", 1);
		unsortMap.put("e", 7);
		unsortMap.put("y", 8);
		unsortMap.put("n", 99);
		unsortMap.put("j", 50);
		unsortMap.put("m", 2);
		unsortMap.put("f", 9);
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
		if(list instanceof Collection)
			System.out.println("listinstanceof");
		list.addAll(unsortMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> entry1,
					Entry<String, Integer> entry2) {
				// TODO Auto-generated method stub
				return entry2.getValue().compareTo(entry1.getValue());
			}
		});

		Set<Employee> set = new HashSet<Employee>();
		set.add(new Employee());
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();// LinkedHashMap keeps the order hashmap and treemap not
		for (Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		Iterator<Map.Entry<String, Integer> > itr = sortedMap.entrySet().iterator();
		while(itr.hasNext())
		{
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)itr.next();
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
}
