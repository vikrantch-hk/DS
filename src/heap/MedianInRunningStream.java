package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.experimental.max.MaxHistory;

//https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
public class MedianInRunningStream {

	//by deafult PQ returns min element so its a min heap
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	static int median;
	
	public static void median(int newItem) {
		int ls = maxHeap.size();
		int rs = minHeap.size();
		if(ls==rs) {
			if(newItem < median) {
				maxHeap.add(newItem);
				median = maxHeap.peek();
			}else {
				minHeap.add(newItem);
				median = minHeap.peek();
			}
		}else if(ls>rs) {
			if(newItem < median) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(newItem);
				median = (maxHeap.peek()+minHeap.peek())/2;
			}else {
				minHeap.add(newItem);
				median = (maxHeap.peek()+minHeap.peek())/2;
			}
		}else {
			if(newItem < median) {
				maxHeap.add(newItem);
				median = (maxHeap.peek()+minHeap.peek())/2;
			}else {
				maxHeap.add(minHeap.poll());
				minHeap.add(newItem);
				median = (maxHeap.peek()+minHeap.peek())/2;
			}
		}
		
		System.out.println(median);
	}
	
	public static void main(String[] args) {
		int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
		Arrays.stream(A).forEach(i->median(i));
	}
	

}
