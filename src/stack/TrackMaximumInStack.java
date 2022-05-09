package stack;

import java.util.Stack;

import design.pattern.decorator.Main;


// http://algorithms.tutorialhorizon.com/track-the-maximum-element-in-a-stack/
public class TrackMaximumInStack {
	static Stack<Integer> main = new Stack<Integer>();
	static Stack<Integer> track = new Stack<Integer>();

	public static void insert(int n) {
		if (main.isEmpty()) {
			track.push(n);
		}

		else {
			int temp = track.peek();
			if (temp > n)
				track.push(temp);
			else
				track.push(n);
		}
		main.push(n);
	}

	
	public static int pop() {
		if (!main.isEmpty()) {
			track.pop();
			return main.pop();
		}
		return -1;
	}
	
	public static int getMax(){
		return track.peek();
	}
	
	public static void main(String[] args) {
		insert(4);
		insert(2);
		insert(14);
		insert(1);
		insert(18);
		System.out.println("Max Element is " + getMax());
		System.out.println("Removing Element " +pop());
		System.out.println("Max Element is " + getMax());
		System.out.println("Removing Element " +pop());
		System.out.println("Max Element is " + getMax());
		System.out.println("Removing Element " +pop());
		System.out.println("Max Element is " + getMax());
	}
}
