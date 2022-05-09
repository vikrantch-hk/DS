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

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		List list = new List();
		// list.traverse(list.getHead());
		list.insertAtBegin(node);
		// list.traverse(list.getHead());

		list.insertAtEnd(new ListNode(2));
		list.insertAtEnd(new ListNode(2));
		list.insertAtEnd(new ListNode(1));
		// list.traverse(list.getHead());
		// System.out.println(list.length);
		list.insertAtPos(new ListNode(3), 2);// ------- pos means index of
												// element starting form 0
		// list.traverse(list.getHead());
		// System.out.println(list.length);
		// list.removeFrmEnd();
		// list.traverse(list.getHead());
		// System.out.println(list.length);
		list.insertAtEnd(new ListNode(4));
		list.insertAtEnd(new ListNode(5));
		list.traverse(list.head);
		list.head = list.reverseInPairs(list.head);
		System.out.println("reverseInPairs o/p in next line");
		list.traverse(list.head);
		list.printMidElement(list.head);
		System.out.println(list.isLengthEven(list.head));
		System.out.println(" before reversing ");
		list.traverse(list.head);
		System.out.println(" reverseRecursively ");
		list.head = list.reverseRecursively(list.head);
		list.traverse(list.head);
		list.head = list.reverseIteratively(list.head);
		list.traverse(list.head);
		list.getNthNodeFromEnd(list.head, 2);
		list.printLastNnode(list.head, 2);
		list.removepos(3);
		list.traverse(list.head);
		System.out.println(list.isLengthEven(list.head));
		System.out.println(list.doesLoopExist(list.head));
		list.printMidElement(list.head);
		System.out.println("firrst sorted list");
		List list2 = new List();
		list2.insertAtBegin(new ListNode(6));
		list2.insertAtBegin(new ListNode(3));
		list2.insertAtBegin(new ListNode(1));
		list2.traverse(list2.head);
		System.out.println("second sorted list");
		List list3 = new List();
		list3.insertAtBegin(new ListNode(8));
		list3.insertAtBegin(new ListNode(5));
		list3.insertAtBegin(new ListNode(2));
		list3.traverse(list3.head);
		list3.traverse(list3.head);
		System.out.println("mereged list");
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
	}

}
