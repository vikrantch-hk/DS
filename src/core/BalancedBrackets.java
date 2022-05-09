package core;

import java.util.Stack;

public class BalancedBrackets {

	static String isBalanced(String s) {
		// Complete this function
		// boolean isBalanced = true;
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ']') {
				if (!st.isEmpty()) {
					char c = st.pop();
					if (c != '[')
						return "NO";
				} else
					return "NO";
			} else if (s.charAt(i) == ')') {
				if (!st.isEmpty()) {
					char c = st.pop();
					if (c != '(')
						return "NO";
				} else
					return "NO";
			} else if (s.charAt(i) == '}') {
				if (!st.isEmpty()) {
					char c = st.pop();
					if (c != '{')
						return "NO";
				} else
					return "NO";
			} else
				st.push(s.charAt(i));
		}
		if (st.isEmpty())
			return "YES";
		else
			return "NO";
	}

	public static void main(String[] args) {
		System.out.println(isBalanced("{[()]}"));
		System.out.println(isBalanced("{[(])}"));
		System.out.println(isBalanced("{{[[(())]]}}"));
	}

}
