import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestToArray {

	
	int[] intArr = new int[] { 1, 2, 3, 3, 35, 50 };

	public static void main(String[] args) {
		TestToArray testToArray = new TestToArray();
		List listAbsurd = Arrays.asList(testToArray.intArr);// never use
															// Arrays.asList for
															// iteraor
		listAbsurd = Arrays.asList( 1, 2, 3, 3, 35, 50 );

		int [] arr= (int[] )listAbsurd.get(0);
		int len = arr.length;
		// cannot convert from List<int[]> to List<Integer>
		Iterator itr1 = listAbsurd.iterator();
		while (itr1.hasNext()) {
			System.out.println(itr1.next());
		}

		List<Integer> listProper = new ArrayList<Integer>();
		for (int i : testToArray.intArr) {
			listProper.add(i);
		}
		Iterator<Integer> itr2 = listProper.iterator();
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}
	}
}
