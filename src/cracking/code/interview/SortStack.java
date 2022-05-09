package cracking.code.interview;

import java.util.Stack;

public class SortStack {

	public static Stack<Integer> sort(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();

		while (!s1.isEmpty()) {
			int temp = s1.pop();
			while (!s2.isEmpty() && s2.peek() > temp)
				s1.push(s2.pop());
			s2.push(temp);
		}

		return s2;
	}

	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(4);
		s1.push(6);
		s1.push(3);
		s1.push(8);

		Stack<Integer> s2 = sort(s1);
		s2.forEach(i -> System.out.print(i + " "));
		System.out.println();
		while (!s2.isEmpty()) {
			System.out.print(s2.pop() + " ");
		}
	}

}
