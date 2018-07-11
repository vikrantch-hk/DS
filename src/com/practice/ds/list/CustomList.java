package com.practice.ds.list;

public class CustomList {

	ListNode head;

	public ListNode addLast(int data) {
		ListNode temp = new ListNode(data);
		if (head == null) {
			head = temp;
			return head;
		}
		ListNode p = head;
		while (p.getNext() != null) {
			p = p.getNext();
		}
		p.setNext(temp);
		return head;
	}

	public ListNode addFirst(int data) {
		ListNode temp = new ListNode(data);
		if (head == null) {
			head = temp;
			return head;
		}
		temp.setNext(head);
		head = temp;
		return head;
	}

	public void deleteLast() {
		if (head == null)
			return;
		if (head.getNext() == null) {
			head = null;
			return;
		}
		ListNode p = head;
		ListNode q = null;
		while (p.getNext() != null) {
			q = p;
			p = p.getNext();
		}
		q.setNext(null);
	}

	public void deleteFirst() {
		if (head == null)
			return;
		head = head.getNext();
	}

	public void insertAtPos(int data, int pos) {
		// considering pos to start from 1
		int q = 1;
		if (pos == 1) {
			addFirst(data);
			return;
		}
		ListNode p = head;
		while (q < pos - 1) {
			p = p.getNext();
			q++;
		}
		ListNode temp = new ListNode(data);
		temp.setNext(p.getNext());
		p.setNext(temp);
	}

	public void traverse() {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + "-->");
			temp = temp.getNext();
		}
	}

	public void deleteFrmPos(int pos) {
		// considering pos to start from 1
		if (pos == 1) {
			deleteFirst();
		}
		int q = 1;
		ListNode p = head;
		while (q < pos - 1) {
			if (p != null) {
				if (p.getNext() != null) {
					p = p.getNext();
					q++;
				} else {
					head = null;
					return;
				}
			} else {
				return;
			}
		}
		if (p != null) {
			if (p.getNext() != null) {
				ListNode temp = p.getNext();
				p.setNext(temp.getNext());
				temp.setNext(null);
			} else {
				head = null;
			}
		}

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
		CustomList cl = new CustomList();
		cl.addLast(4);
		cl.addLast(2);
		cl.addLast(1);
		cl.addFirst(10);
		cl.addFirst(20);
		cl.traverse();
		cl.deleteLast();
		System.out.println();
		cl.traverse();
		cl.deleteFirst();
		System.out.println();
		cl.traverse();
		System.out.println();
		cl.insertAtPos(8, 3);
		cl.traverse();
		System.out.println();
		cl.deleteFrmPos(3);
		cl.traverse();
		System.out.println();
		System.out.println();
		System.out.println(cl.FindJosephusPos(41, 2));
		System.out.println(cl.FindJosephusPos(5, 3));
	}
}
