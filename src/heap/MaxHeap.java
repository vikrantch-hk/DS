package heap;

import list.List;
import list.ListNode;

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

		/*Give an algorithm for finding the  kth􏰏􏰅􏰆 smallest element in min-heap.
		Solution: One simple solution to this problem is: perform deletion 􏰏k times from min-heap.
		Time Complexity: O(􏰏􏰁􏰂􏰃􏰀klogn).
		Since we are performing deletion operation k times and each deletion takes O(􏰁􏰂􏰃logn􏰀).
		*/

		/*
		Given a big file containing billions of numbers, how can you find the 10 maximum numbers from that file?
		One solution for this problem is to divide the data in sets of 1000 elements (let’s say 1000) and
		make a heap of them, and then take 10 elements from each heap one by one.
		Finally heap sort all the sets of 10 elements and take the top 10 among those.
		But the problem in this approach is where to store 10 elements from each heap.
		That may require a large amount of memory as we have billions of numbers.
		Reusing the top 10 elements (from the earlier heap) in subsequent elements can solve this problem.
		That means take the first block of 1000 elements and subsequent blocks of 990 elements each.
		Initially, Heapsort the first set of 1000 numbers, take max 10 elements,
		and mix them with 990 elements of the 2􏰥􏰦 set. Again, Heapsort these 1000 numbers
		(10 from the first set and 990 from the 2􏰥􏰦 set), take 10 max elements, and mix them with 990 elements
		of the 3􏰧􏰦 set. Repeat till the last set of 990 (or less) elements and take max 10 elements from the
		final heap. These 10 elements will be your answer.
		Time Complexity: O(􏰀n) = 􏰀/1000 ×(complexity of Heapsort 1000 elements)
		Since complexity of heap sorting 1000 elements will be a constant so the O(􏰀n) = 􏰀 i.e. linear complexity.
		 */


		List l1 = new List();
		l1.insertAtEnd(new ListNode(1));
		l1.insertAtEnd(new ListNode(4));
		l1.insertAtEnd(new ListNode(7));

		List l2 = new List();
		l2.insertAtEnd(new ListNode(2));
		l2.insertAtEnd(new ListNode(5));
		l2.insertAtEnd(new ListNode(8));

		List l3 = new List();
		l3.insertAtEnd(new ListNode(3));
		l3.insertAtEnd(new ListNode(6));
		l3.insertAtEnd(new ListNode(9));

		ListNode[] a = {l1.head, l2.head, l3.head};
		ListNode sorted = mergeKLists(a);
		System.out.println(" mergeKLists start ");
		while (sorted!=null){
			System.out.println(sorted.getData());
			sorted = sorted.getNext();
		}
		System.out.println(" mergeKLists end ");



	}

	// https://leetcode.com/problems/merge-k-sorted-lists/submissions/
	// TC O(nlogk) SC o(k)
	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>((n1, n2) -> n1.getData() - n2.getData());
		for (ListNode n : lists) {
			if (n != null) {
				q.add(n);
			}
		}

		ListNode head = new ListNode(0);
		ListNode tail = head;

		while (!q.isEmpty()) {
			ListNode n = q.poll();
			tail.setNext(n);
			tail = n;

			if (tail.getNext() != null) {
				q.add(tail.getNext());
			}
		}
		return head.getNext();
	}

}
