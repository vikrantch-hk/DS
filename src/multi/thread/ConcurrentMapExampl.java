package multi.thread;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentMapExampl {

	static Map<Integer, String> map = new HashMap<Integer, String>();

	public static void main(String[] args) {

		List<String> l = new CopyOnWriteArrayList<String>();
		l.add("1");
		l.add("2");
		l.add("3");
		Iterator<String> itr = l.iterator();
		while (itr.hasNext()) {
			if (itr.next().equals("2"))
				itr.remove(); // UnsupportedOperationException
								// CopyOnWriteArrayList COWIterator.remove
		}
		map.put(100, "100");
		System.out.println(map.get(100));
		map.putIfAbsent(100, "200");// if key is already present don't replace
									// value
		System.out.println(map.get(100));
		map.remove(100, "200");// remove entry only if key is present with given
								// value
		System.out.println(map.get(100));
		map.replace(100, "100", "200");
		System.out.println(map.get(100));
	}

}
