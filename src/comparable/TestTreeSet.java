package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class TestTreeSet {

	
	public void testPassByRef()
	{
		Employee emp = new Employee();
		emp.setId(1);
		int x = 1;
		testPassByRef2(emp,x);
		System.out.println("testPassByRef "+emp.getId()+" x "+x);
	}
	
	private void testPassByRef2(Employee emp,int x) {
		emp.setId(2);
		x=2;
		System.out.println("testPassByRef2 "+emp.getId()+" x "+x);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestTreeSet t = new TestTreeSet();
		t.testPassByRef();
		int a,b;

		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		Employee e4 = new Employee();
		e1.setId(6);
		e2.setId(3);
		e3.setId(4);
		e1.setId(1);
		Map<Employee, String> m = new ConcurrentHashMap<Employee, String>();
		m.put(e1, "");
		m.put(e2, "");
		Set<Employee> set = new TreeSet<Employee>();
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		Collections.sort(new ArrayList<Employee>(set),(id1,id2)->{return id1.compareTo(id2);});
		Iterator<Employee> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getId());
		}
		System.out.println(set.contains(e1));
		
		HashMap<Integer, Integer> map = new LinkedHashMap<Integer,Integer>(16,0.75f,true);
		map.put(1, 1);
		map.put(2, 2);
		map.put(1, 1);
		System.out.println();
		for(int value:map.values())
		{
			System.out.println(value);// 2 1
		}
		
		HashMap<Integer, Integer> map2 = new LinkedHashMap<Integer,Integer>(16,0.75f,false);
		map2.put(1, 1);
		map2.put(2, 2);
		map2.put(1, 1);
		System.out.println();
		for(int value:map2.values())
		{
			System.out.println(value);// 1 2
		}
	}

}
