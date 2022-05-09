import java.util.HashSet;
import java.util.Set;

/*print length of LongestContiguosSubArrWithDistinctChars
 ex : abccdefgghijkl
 o/p : Max(3,5,6)=6*/
public class LongestContiguosSubArrWithDistinctChars {

	public static void getLengthOfLongestContiguosSubArrWithDistinctChars(
			String s) {

		int maxLength = 0;
		char[] arr = s.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(arr[i]))
				set.add(arr[i]);
			else {
				if (set.size() > maxLength)
					maxLength = set.size();
				set.clear();
				set.add(arr[i]);
			}
		}
		if (set.size() > maxLength)
			maxLength = set.size();
		System.out.println(maxLength);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getLengthOfLongestContiguosSubArrWithDistinctChars("abccdefgghijkl");
	}

}
