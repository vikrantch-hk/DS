package multi.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExampleInTwoThreads {

	public static void main(String[] args) throws InterruptedException {

		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("d");

		Thread newThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				l.remove("b");
			}
		});
		newThread.start();

		// main thread iterating newThread modifying collection
		Iterator<String> itr = l.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
			Thread.sleep(100);
		}
	}

}
