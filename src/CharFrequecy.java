/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 */

/*how to change char arr to list */
import java.util.*;

public class CharFrequecy {
	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running
		 * 
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String line = br.readLine(); int N =
		 * Integer.parseInt(line); for (int i = 0; i < N; i++) {
		 * System.out.println("hello world"); }
		 */
		Scanner sc = new Scanner(System.in);
		// char[] chars = sc.nextLine().toCharArray();
		String str = "I love proGramming!!";
		System.out.println("subs" + str.substring(0, 0) + "hahaha");
		char[] chars = str.toCharArray();
		List<Character> listC = new ArrayList<Character>();
		for (char c : chars) {
			listC.add(Character.toLowerCase(c));
		}

		for (Character i = 'a'; i <= 'z'; i++) {
			System.out.print(Collections.frequency(listC, i) + " ");
		}
		frequencyWithoutApi();
	}

	public static void frequencyWithoutApi() {
		String s = "I lovve proGramming!!";
		char[] arr = s.toLowerCase().toCharArray();
		Arrays.sort(arr);
		char prev = arr[0];
		int frequency = 1;
		for (int i = 1; i < arr.length; i++) {
			System.out.println("a[i] "+arr[i]);
			if (arr[i] == prev) {
				frequency++;
			} else {
				System.out.println(prev + " frequency is " + frequency);
				frequency = 1;
				prev = arr[i];
			}
		}
		// this line is for last remaning char
		System.out.println(prev + " frequency is " + frequency);
	}
}
