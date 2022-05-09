package heap;

import java.util.Collections;
import java.util.PriorityQueue;

// in java api Heap is implemented using Priority Queue
// by default Priority Queue is min heap for max heap we can add reverse comparator
public class MaxHeap {

	static PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());

	public static void main(String[] args) {
		q.add(97);//O(n) time 
		q.add(100);
		q.add(84);
		q.add(82);
		q.add(98);
		
		System.out.println("removing elements from MaxHeap");
		while (!q.isEmpty()) {
			System.out.println(q.poll());// O(1) time
		}
		
	}

}
