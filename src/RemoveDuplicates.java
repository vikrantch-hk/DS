import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RemoveDuplicates {

	public static int[] removeDuplucates(int[] input) {
		Arrays.sort(input);
		int i = 0;
		if (input.length <= 1)
		{
			System.out.println("cant sort");
			return input;
		}
		else {
			for (int j = 1; j < input.length; j++) {
				if (input[i] != input[j])
					input[++i] = input[j];
			}
			int newLength = i + 1;
			int[] ouput = new int[newLength];
			for(int k=0;k<newLength;k++)
			{
				ouput[k]=input[k];
			}
			return ouput;
		}
	}

	public static int[] removeDuplucatesUsingList(int[] input) {

		List<Integer> li = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			if (!li.contains(input[i]))
				li.add(input[i]);
		}
		int[] output = new int[li.size()];
		Iterator<Integer> itr = li.iterator();
		int i = 0;
		while (itr.hasNext()) {
			output[i] = itr.next();
			i++;
		}
		return output;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] input = new int[] { 1, 1, 2, 4, 4, 3 };
		int[] input = new int[] { 1, 1, 2, 4, 4, 3 ,1,1};
		int[] a = removeDuplucatesUsingList(input);
		for (int i : a)
			System.out.println(i);
		
		System.out.println();
		int[] b = removeDuplucates(input);
		for (int i : b)
			System.out.println(i);
		
	}

}
