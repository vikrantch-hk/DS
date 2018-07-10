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

	public void traverse() {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + "-->");
			temp = temp.getNext();
		}
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
	}
}
