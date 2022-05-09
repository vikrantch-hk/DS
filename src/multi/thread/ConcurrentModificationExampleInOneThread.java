package multi.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ConcurrentModificationExampleInOneThread {
	
	List<String> l = new ArrayList<String>();
    public static void main(String[] args) {
    	ConcurrentModificationExampleInOneThread ex = new ConcurrentModificationExampleInOneThread();
    	ex.l.add("a");
    	ex.l.add("b");
    	ex.l.add("c");
    	ex.l.add("d");
    	
    	Iterator<String> itr = ex.l.iterator();
    	while (itr.hasNext()) {
			System.out.println(itr.next());
			ex.l.add("e");
		}
	}
}
