package cracking.code.interview;

import java.util.ArrayList;
import java.util.List;

// there will be n! permutations 
public class StringPermutation {

	static List<String> permutations = new ArrayList<String>();

	// factorial(n)
	public static List<String> getStringPermutation(String prefix, String str) {

		if (str.length() == 0) {
			permutations.add(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				getStringPermutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
			}
		}

		return permutations;
	}

	// nc0+nc1+nc2.....+ncn
	public static List<String> getStringCombination(String prefix, String str) {

		permutations.add(prefix);
		for (int i = 0; i < str.length(); i++) {
			getStringCombination(prefix + str.charAt(i), str.substring(i + 1));
		}

		return permutations;
	}

	public static void main(String[] args) {
		getStringPermutation("", "abc");
		permutations.forEach(s -> System.out.println(s));
		permutations = new ArrayList<>();
		getStringCombination("", "abc");
		permutations.forEach(s -> System.out.println(s));
	}
}
