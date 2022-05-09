import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListsIntersection {

	public static List<Integer> findIntersection(List<Integer> l1,List<Integer> l2){
		List<Integer> intersection = new ArrayList<Integer>();
		
		intersection = l1.stream().filter(i->{return l2.contains(i);}).collect(Collectors.toList());
		
		return intersection;
	}
	
	public static void main(String[] args) {

		List<Integer> l1 = Arrays.asList(new Integer[]{1,2,3,4,6,10});
		List<Integer> l2 = Arrays.asList(new Integer[]{2,3,6});
		findIntersection(l1, l2).forEach(i->System.out.println(i));
	}

}
