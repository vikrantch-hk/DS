import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// http://www.geeksforgeeks.org/next-greater-element/
public class NextGreaterElement {

	// i/p 4, 5, 2, 25
	// o/p 4-->5, 5-->25, 2-->25, 25-->-1
	public static void findNextGreaterElement(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && stack.peek() < arr[i])
				System.out.println(stack.pop() + "-->" + arr[i]);
			stack.push(arr[i]);
		}
		/*
		 * After iterating over the loop, the remaining elements in stack do not
		 * have the next greater element, so print -1 for them
		 */
		while (!stack.isEmpty())
			System.out.println(stack.pop() + "-->" + -1);
	}
	
	// i/p 4, 5, 2, 25
		// o/p 4-->5, 5-->25, 2-->25, 25-->-1
	// push index in stack instead of element
		public static void findNextGreaterElementInCircularArrayUsingIndices(int[] arr) {
			Stack<Integer> stack = new Stack<Integer>();
			int[] result = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
					result[stack.pop()] =arr[i];
				}
				stack.push(i);
			}
			int i=0;
	        // second pass -- loop until you reach the top index of stack
	        while(!stack.isEmpty() && i < stack.peek()){
	            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
	                result[stack.pop()] = arr[i];
	            }
	            i++;
	        }
			/*
			 * After iterating over the loop, the remaining elements in stack do not
			 * have the next greater element, so print -1 for them
			 */
			while (!stack.isEmpty()) {
				result[stack.pop()]= -1;
			}
			System.out.println("Indices");
			for (i = 0; i < result.length; i++) {
				System.out.print(result[i]+" ");
			}
		}
	
	// o/p 4-->5, 5-->25, 2-->25, 25-->-1
		public static void findNextGreaterElementChangeArr(int[] arr) {
			Stack<CustIndx> stack = new Stack<CustIndx>();
			for (int i = 0; i < arr.length; i++) {
				while (!stack.isEmpty() && stack.peek().num < arr[i])
					arr[stack.pop().idx]=arr[i];
				stack.push(new CustIndx(i,arr[i]));
			}
			/*
			 * After iterating over the loop, the remaining elements in stack do not
			 * have the next greater element, so print -1 for them
			 */
			while (!stack.isEmpty())
				arr[stack.pop().idx]=-1;
			
			for(int i:arr) {
				System.out.print(i+" ");
			}
		}
		
		private static class CustIndx{
			Integer num;
			Integer idx;
			public CustIndx(Integer idx,Integer num) {
				this.num=num;
				this.idx=idx;
			}
		}

	public static void main(String[] args) {
		/*List<String> l = new ArrayList<String>();
		l.add(1,"abc");
		System.out.println(l.get(0));*/
		findNextGreaterElement(new int[] { 4, 5, 2, 25 });
		findNextGreaterElement(new int[] { 13, 7, 6, 12 });
		findNextGreaterElementChangeArr(new int[] { 4, 5, 2, 25 });
		findNextGreaterElementInCircularArrayUsingIndices(new int[] { 1,2,1 });
	}

}
