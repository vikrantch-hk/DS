package list;

import java.util.HashSet;
import java.util.Set;

public class List {

	ListNode head;
	int length;

	public void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}

	public void insertAtEnd(ListNode node) {
		ListNode p, q;
		p = head;
		if (p == null)
			head = node;
		else {
			q = p.getNext();
			while (q != null) {
				p = p.getNext();
				q = p.getNext();
			}
			p.setNext(node);

		}
		length++;
	}

	public void insertAtPos(ListNode node, int pos) {
		if (pos < 0)
			pos = 0;
		else if (pos > length)
			pos = length;

		if (pos == 0)
			insertAtBegin(node);
		else if (pos == length)
			insertAtEnd(node);
		else {
			ListNode p;
			int q = 1;
			p = head;
			if (p == null)
				head = node;
			else {
				while (q < pos) {
					p = p.getNext();
					q++;
				}
			}
			node.setNext(p.getNext());
			p.setNext(node);
			length++;
		}

	}

	public void removeFrmBeg() {
		ListNode node = head;
		if (head != null) {

			head = head.getNext();
			node.setNext(null);

			length--;
		}
	}

	public void removeFrmEnd() {
		ListNode p, q;
		p = head;
		if (p != null) {

			q = p.getNext();
			if (q == null)// only one node so make head null
				head = null;
			else {
				while (q.getNext() != null) {
					p = q;
					q = q.getNext();
				}
				p.setNext(null);
			}
			length--;
		}
	}

	public void removepos(int pos) {
		if (pos == 0)
			removeFrmBeg();
		else if (pos == length)
			removeFrmEnd();
		else {
			ListNode p = head;
			if (p != null) {
				int q = 1;
				while (q < pos) {
					p = p.getNext();
					q++;

				}
				ListNode temp = p.getNext();
				p.setNext(temp.getNext());
				temp.setNext(null);
				// p.setNext(p.getNext().getNext());
				length--;
			}
		}
	}

	public static int getLength(ListNode headNode) {
		int length = 0;
		ListNode currentNode = headNode;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}

	public void traverse(ListNode headNode) {
		ListNode currentNode = headNode;

		while (currentNode != null) {
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}

	public void getNthNodeFromEnd(ListNode head, int pos) {// here pos will
															// start from 1 if
															// pos strts from 0
															// use i<=pos
		ListNode temp, nth;
		temp = head;
		nth = null;
		for (int i = 1; i < pos; i++) {
			if (temp != null)
				temp = temp.getNext();
		}
		while (temp != null) {
			if (nth == null)
				nth = head;
			else
				nth = nth.getNext();
			temp = temp.getNext();
		}
		System.out.println("nth node from end is " + nth.getData());
	}

	public void printLastNnode(ListNode head, int n) {
		ListNode temp = head, nth = null;
		for (int i = 1; i < n; i++) {
			if (temp != null)
				temp = temp.getNext();
		}
		while (temp != null) {
			if (nth == null)
				nth = head;
			else
				nth = nth.getNext();
			temp = temp.getNext();
		}
		while (nth != null) {
			System.out.println("node is" + nth.getData());
			nth = nth.getNext();
		}
	}

	public ListNode reverseRecursively(ListNode current) {
		ListNode newHead;
		if (current == null)
			return null;
		ListNode next = current.getNext();
		if (next == null) {
			return current;
		}
		newHead = reverseRecursively(next);
		next.setNext(current);
		current.setNext(null);
		return newHead;
	}

	public ListNode reverseIteratively(ListNode head) {
		ListNode current = head;
		ListNode prev = null;
		while (current != null) {
			ListNode next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		return prev;
	}

	public ListNode reverseInPairs(ListNode head) {
		ListNode temp = new ListNode(0);
		temp.setNext(head);
		ListNode prev = temp, curr = head;
		while (curr != null && curr.getNext() != null) {
			ListNode tmp = curr.getNext().getNext();
			curr.getNext().setNext(prev.getNext());
			prev.setNext(curr.getNext());// its needed to set head first time
											// imagine without this step temp's
											// next will still be pointing to 1
											// as head which is wrong it should
											// be 2 now
			curr.setNext(tmp);
			prev = curr;
			curr = prev.getNext();
		}
		return temp.getNext();
	}

	public ListNode reverseKNodes(ListNode head, int k) {
		ListNode prev = null, current = head, next = null;
		int count = 0;
		while (current != null && count < k) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
			count++;
		}

		if (next != null) {
			head.setNext(reverseKNodes(next, k));
		}
		return prev;
	}

	public ListNode reverseBetween(ListNode head, int left, int right) {

		// base case
		if (left > right) {
			return head;
		}

		ListNode lastUnReversed = null;
		ListNode curr = head;

		// 1. Skip the first `m` nodes
		for (int i = 1; curr != null && i < left; i++)
		{
			lastUnReversed = curr;
			curr = curr.getNext();
		}

		// `prev` now points to (m-1)'th node
		// `curr` now points to m'th node

		ListNode firstReversedNode = curr;
		ListNode prev = null;

		// 2. Traverse and reverse the sublist from position `m` to `n`
		for (int i = 1; curr != null && i <= right - left + 1; i++)
		{
			// Take note of the next node
			ListNode next = curr.getNext();

			// move the current node onto the `end`
			curr.setNext(prev);
			prev = curr;

			// move to the next node
			curr = next;
		}

        /*
            `start` points to the m'th node
            `end` now points to the n'th node
            `curr` now points to the (n+1)'th node
        */

		// 3. Fix the pointers and return the head node
		if (firstReversedNode != null)
		{
			firstReversedNode.setNext(curr);
			if (lastUnReversed != null) {
				lastUnReversed.setNext(prev);
			}
			else {
				head = prev;     // when m = 1, `lastUnReversed` is null
			}
		}

		return head;
	}

	public boolean isLengthEven(ListNode head) {
		while (head != null && head.getNext() != null)
			head = head.getNext().getNext();
		if (head == null)
			return true;
		else
			return false;
	}

	public boolean doesLoopExist(ListNode head) {
		ListNode slwPointer = head, fstPointer = head;
		while (fstPointer != null && fstPointer.getNext() != null) {
			slwPointer = slwPointer.getNext();
			fstPointer = fstPointer.getNext().getNext();
			if (slwPointer == fstPointer) {
				return true;
			}
		}
		return false;
	}

	public void printMidElement(ListNode head) {
		ListNode slwPointer = head, fstPointer = head;
		while (fstPointer != null && fstPointer.getNext() != null) {
			slwPointer = slwPointer.getNext();
			fstPointer = fstPointer.getNext().getNext();

		}
		System.out.println("mid element is " + slwPointer.getData());

	}

	public static ListNode meregeTwoSortedLists(ListNode head1, ListNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		if (head1.getData() < head2.getData()) {
			head1.setNext(meregeTwoSortedLists(head1.getNext(), head2));
			return head1;
		} else {
			head2.setNext(meregeTwoSortedLists(head1, head2.getNext()));
			return head2;
		}

	}

	public static void printListFromEnd(ListNode head) {
		if (head == null)
			return;
		printListFromEnd(head.getNext());
		System.out.println(head.getData());
	}

	public static List addTwoNumbersInFormOfList(ListNode head1, ListNode head2) {
		int carry = 0, sum = 0;
		List sumLIst = new List();
		sumLIst.head = null;
		ListNode prev = null;
		while (head1 != null || head2 != null) {
			sum = carry + (head1 != null ? head1.getData() : 0) + (head2 != null ? head2.getData() : 0);
			if (sum >= 10)
				carry = 1;
			sum = sum % 10;
			ListNode temp = new ListNode(sum);
			if (sumLIst.head == null) {
				sumLIst.head = temp;
			} else {
				prev.setNext(temp);
			}
			prev = temp;
			if (head1 != null)
				head1 = head1.getNext();
			if (head2 != null)
				head2 = head2.getNext();
		}

		if (carry != 0) {
			ListNode temp = new ListNode(carry);
			prev.setNext(temp);
		}

		return sumLIst;

	}

	public static void removeDuplicates(List list) {
		Set<Integer> set = new HashSet<Integer>();
		ListNode current = list.head;
		ListNode previous = null;
		while (current != null) {
			if (set.contains(current.getData())) {
				previous.setNext(current.getNext());
			} else {
				previous = current;
				set.add(current.getData());
			}
			current = current.getNext();
		}
		list.traverse(list.head);
	}

	// http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
	public static int findMergePointOfTwoJoinedLinkedLists(ListNode h1, ListNode h2) {
		int len1 = getLength(h1);
		int len2 = getLength(h2);

		int diff = Math.abs(len1 - len2);
		ListNode temp1 = h1, temp2 = h2;
		while (temp1 != null && temp2 != null) {
			for (int i = 1; i <= diff; i++) {
				if (len1 > len2) {
					if (temp1 == null)
						return -1;
					temp1 = temp1.getNext();
				} else {
					if (temp2 == null)
						return -1;
					temp2 = temp2.getNext();
				}
			}

			if (temp1.getData() == temp2.getData()) {
				return temp1.getData();
			}
			temp1 = temp1.getNext();
			temp2 = temp2.getNext();
		}
		return -1;
	}

	// https://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/
	public int FindJosephusPos(int n, int m) {
		// create a circle
		ListNode p, q;
		p = new ListNode(1);
		head = p;
		q = p;
		for (int i = 2; i <= n; i++) {
			ListNode temp = new ListNode(i);
			p.setNext(temp);
			p = p.getNext();
		}
		// point last node to head to make circle
		p.setNext(q);
		// delete node from mth pos u=until list is greater than 0 size
		/* while only one node is left in the
	    linked list*/
		ListNode a=head;
		ListNode b=null;
		while(a.getNext()!=a)
		{
			int count =1;
			while(count<m)
			{
				b=a;
				a=a.getNext();
				count++;
			}
			/* Remove the m-th node and start from it's next in next loop*/
			b.setNext(a.getNext());
			a=b.getNext();

		}
		return a.getData();
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		List list6 = new List();
		// list7.traverse(list7.getHead());
		list6.insertAtBegin(node);
		// list7.traverse(list7.getHead());

		list6.insertAtEnd(new ListNode(2));
		list6.insertAtEnd(new ListNode(2));
		list6.insertAtEnd(new ListNode(1));
		// list7.traverse(list7.getHead());
		// System.out.println(list7.length);
		list6.insertAtPos(new ListNode(3), 2);// ------- pos means index of
												// element starting form 0
		// list7.traverse(list7.getHead());
		// System.out.println(list7.length);
		// list7.removeFrmEnd();
		// list7.traverse(list7.getHead());
		// System.out.println(list7.length);
		list6.insertAtEnd(new ListNode(4));
		list6.insertAtEnd(new ListNode(5));
		list6.traverse(list6.head);
		list6.head = list6.reverseInPairs(list6.head);
		System.out.println("reverseInPairs o/p in next line");
		list6.traverse(list6.head);
		list6.printMidElement(list6.head);
		System.out.println(list6.isLengthEven(list6.head));
		System.out.println(" before reversing ");
		list6.traverse(list6.head);
		System.out.println(" reverseRecursively ");
		list6.head = list6.reverseRecursively(list6.head);
		list6.traverse(list6.head);
		list6.head = list6.reverseIteratively(list6.head);
		list6.traverse(list6.head);
		list6.getNthNodeFromEnd(list6.head, 2);
		list6.printLastNnode(list6.head, 2);
		list6.removepos(3);
		list6.traverse(list6.head);
		System.out.println(list6.isLengthEven(list6.head));
		System.out.println(list6.doesLoopExist(list6.head));
		list6.printMidElement(list6.head);
		System.out.println("firrst sorted list7");
		List list2 = new List();
		list2.insertAtBegin(new ListNode(6));
		list2.insertAtBegin(new ListNode(3));
		list2.insertAtBegin(new ListNode(1));
		list2.traverse(list2.head);
		System.out.println("second sorted list7");
		List list3 = new List();
		list3.insertAtBegin(new ListNode(8));
		list3.insertAtBegin(new ListNode(5));
		list3.insertAtBegin(new ListNode(2));
		list3.traverse(list3.head);
		list3.traverse(list3.head);
		System.out.println("mereged list7");
		List list4 = new List();
		list4.head = meregeTwoSortedLists(list2.head, list3.head);
		list4.traverse(list4.head);
		list4.insertAtEnd(new ListNode(9));
		list4.insertAtEnd(new ListNode(4));
		list4.traverse(list4.head);
		System.out.println("reverseKNodes start");
		list4.head = list4.reverseKNodes(list4.head, 2);
		list4.traverse(list4.head);
		System.out.println("reverseKNodes end");
		System.out.println("sum of ");
		list2.traverse(list2.head);
		System.out.println();
		list3.traverse(list3.head);

		List sumLIst = addTwoNumbersInFormOfList(list2.head, list3.head);
		System.out.println(" sum is ");
		sumLIst.traverse(sumLIst.head);

		removeDuplicates(sumLIst);

		List list7 = new List();
		list7.insertAtEnd(new ListNode(1));
		list7.insertAtEnd(new ListNode(2));
		list7.insertAtEnd(new ListNode(3));
		list7.insertAtEnd(new ListNode(4));
		list7.insertAtEnd(new ListNode(5));

		System.out.println("reverseBetween start");
		list7.reverseBetween(list7.head, 2, 4);
		list7.traverse(list7.head);
		System.out.println("reverseBetween end");

		System.out.println("FindJosephusPos start");
		System.out.println(new List().FindJosephusPos(41, 2));

	}

}
