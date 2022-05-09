import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ThreadWt implements Comparable<ThreadWt>{
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Collections.sort(new ArrayList<ThreadWt>(), new Comparator<ThreadWt>() {
			@Override
			public int compare(ThreadWt o1, ThreadWt o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		// TODO Auto-generated method stub
		//List<Integer> list = new ArrayList<Integer>();
		//list.add("a");
		//List list = new ArrayList();
		//list.add(1);
		//list.add("a");
		//for(Object i:list)
			//System.out.println((Integer)i);
		/*ThreadWt tw1 = new ThreadWt();
		ThreadWt tw2 = new ThreadWt();
		TreeSet<ThreadWt> set = new TreeSet<ThreadWt>(new Comparator<ThreadWt>() {

			@Override
			public int compare(ThreadWt arg0, ThreadWt arg1) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});
		Map<ThreadWt,ThreadWt> m = new HashMap<ThreadWt,ThreadWt>();
		m.put(tw1, tw2);
		m.put(tw1, tw2);
		m.entrySet().iterator();*/
		Object lock = new Object();
		Thread t1 = new Thread(new ThreadWtEvens(lock));
		Thread t2 = new Thread(new ThreadWtOdds(lock));
		t1.start();
		t2.start();
	}

	@Override
	public int compareTo(ThreadWt arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
