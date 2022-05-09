package stack.queue;

import stack.Stack;
import list.ListNode;

public class Queue {

	stack.Stack stack1 = new Stack();
	stack.Stack stack2 = new Stack();
	
	public void enqueue(ListNode node)
	{
		stack1.push(node);
	}
	
	public Integer dequeue()
	{
		if(stack2.size>0)
			return stack2.pop();
		else
		{
			while(stack1.size>0)
			{
				stack2.push(new ListNode(stack1.pop()));
			}
			return stack2.pop();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue queue = new Queue();
		queue.enqueue(new ListNode(1));
	       queue.enqueue(new ListNode(2));
	       queue.enqueue(new ListNode(3));
	       queue.enqueue(new ListNode(4));
	       queue.enqueue(new ListNode(5));
	       queue.enqueue(new ListNode(6));
	       System.out.println(queue.dequeue());
	       System.out.println(queue.dequeue());
	       System.out.println(queue.dequeue());
	       System.out.println(queue.dequeue());
	       System.out.println(queue.dequeue());
	       System.out.println(queue.dequeue());
	       System.out.println(queue.dequeue());
	}

}
