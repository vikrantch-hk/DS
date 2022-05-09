package stack;

import list.ListNode;

public class Stack {

	public ListNode top;
	public int size;
	
	public void push(ListNode node)
	{
		// insert at begin
		node.setNext(top);
		top=node;
		size++;
	}
	
	public Integer pop()
	{
		// delete from begin
		if(top==null)
			return null;
		else
		{
			ListNode temp = top;
			top=top.getNext();
			size--;
			temp.setNext(null);
			return temp.getData();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Stack stack = new Stack();
       stack.push(new ListNode(1));
       stack.push(new ListNode(2));
       stack.push(new ListNode(3));
       stack.push(new ListNode(4));
       stack.push(new ListNode(5));
       stack.push(new ListNode(6));
       System.out.println(stack.pop());
       System.out.println(stack.pop());
       System.out.println(stack.pop());
       System.out.println(stack.pop());
       System.out.println(stack.pop());
       System.out.println(stack.pop());
       System.out.println(stack.pop());
	}
	

}
