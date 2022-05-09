package core;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

import javax.management.Query;

public class Test {
	public enum Sample {
		A, B, C;
	}

	public static void main(String[] args) {
		Map<Sample, String> m = new EnumMap<Sample, String>(Sample.class);
		m.put(Sample.B, "B");

		// new ArrayList<>().get(0);//java.lang.IndexOutOfBoundsException:
		// Index: 0, Size: 0

		Set<Sample> s = EnumSet.of(Sample.A, Sample.B);
		s = EnumSet.allOf(Sample.class);
		EnumSet.noneOf(Sample.class);

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.stream().spliterator().forEachRemaining(i -> System.out.println(i));
		System.out.println(list.stream().distinct().reduce((a, b) -> a * b));
		System.out.println(list.stream().distinct().mapToInt(i -> i).sum());
		ListIterator<Integer> itr = list.listIterator();
		while (itr.hasNext()) {
			if (itr.next() == 1)
				itr.add(1);
		}

	}
}
