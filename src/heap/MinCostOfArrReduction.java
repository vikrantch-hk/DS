package heap;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

// https://www.geeksforgeeks.org/minimum-cost-of-reducing-array-by-merging-any-adjacent-elements-repetitively/
public class MinCostOfArrReduction {

	// Function to find the total minimum 
	// cost of merging two consecutive numbers 
	static int mergeTwoNumbers(int []numbers) 
	{ 
		// use min heap poll 2 min elements
		// add sum of those to heap again until only 1 element remains
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		IntStream.of(numbers).forEach(i->queue.add(i));
		int sum=0;
		int result =0;
		while (queue.size()>=2) {
			sum=queue.poll()+queue.poll();
			result+=sum;
			queue.add(sum);
		}
		return result;
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 
		// Given set of numbers 
		int []arr1 = { 6, 4, 4, 6 }; 

		// Function Call 
		System.out.print(mergeTwoNumbers(arr1) + "\n"); 
	} 

	
	
}
