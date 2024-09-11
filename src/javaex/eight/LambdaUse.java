package javaex.eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import comparable.Employee;

public class LambdaUse {

	List<Employee> list = new ArrayList<Employee>();

	public void example() {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		Employee e4 = new Employee();
		e1.setId(6);
		e2.setId(3);
		e3.setId(4);
		list.add(e1);
		list.add(e2);
		list.add(e3);

		Collections.sort(list, new Comparator<Employee>() {
			public int compare(Employee a, Employee b) {
				return a.getId() - b.getId();
			}
		});

		for (Employee e : list) {
			System.out.println(e.getId());
		}

		System.out.println();
		Collections.sort(list, (a, b) -> {
			return b.getId() - a.getId();
		});

		list.forEach((a) -> { // / internal or passive iterator
			System.out.println(a.getId());
		});

		Optional<Employee> o = list.parallelStream().reduce((a, b) -> {
			Employee e = new Employee();
			e.setId(a.getId() + b.getId());
			return e;
		});

		o.ifPresent((e) -> {
			System.out.println(e.getId());
		});
		System.out.println(o.get().getId()); // optional.get returns employee
												// directly

		System.out.println();
		list.stream().sorted((a, b) -> {
			return a.getId() - b.getId();
		}).forEach((e) -> {
			System.out.println(e.getId());
		});

		System.out.println();

		System.out.println(list.stream().filter((e) -> {
			return (e.getId() % 3) == 0;
		}).count());
		
		
		System.out.println(list.stream().filter(e->{ return e.getId()==1;}).findFirst());
		
		System.out.println("max "+list.stream().mapToInt(e->e.getId()).max());

		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		m.put(1, 1);
		m.put(3, 3);
		m.put(2, 2);

		m.forEach((k, v) -> {
			System.out.println("k " + k + " v " + v);
		});
		
		Map<Integer, javaex.eight.Employee> employeeMap = new ConcurrentHashMap<Integer, javaex.eight.Employee>();
		javaex.eight.Employee e11 = new javaex.eight.Employee();
		e11.setName("a");
		e11.setSal(10000);
		javaex.eight.Employee e22 = new javaex.eight.Employee();
		e22.setName("b");
		e22.setSal(20000);
		javaex.eight.Employee e33 = new javaex.eight.Employee();
		e33.setName("c");
		e33.setSal(30000);
		employeeMap.put(1	, e11);
		employeeMap.put(2	, e22);
		employeeMap.put(3	, e33);
		List<javaex.eight.Employee> el = employeeMap.entrySet().parallelStream().filter(e -> {
			return e.getValue().getSal() > 15000;
		}).map((e) -> {
			return e.getValue();
		}).collect(Collectors.toList());//.forEach(e->{System.out.println(e.getName()+" "+e.getSal());});;
	}

	public static void main(String[] args) {
		new LambdaUse().example();
		
		// terminal operations
		// reduce,count,foreach, min, max
		// intermediate operations
		// filter, map, mapToInt, sorted

		String s = "hi hello how are you.";
        System.out.println(s.chars()
                .filter(value -> Character.isLetterOrDigit(value))
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining("")));
	}
}
