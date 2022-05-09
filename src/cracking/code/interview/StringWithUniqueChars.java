package cracking.code.interview;

public class StringWithUniqueChars {

	public static void isUniqueJava8(String str) {
		str.chars().forEach(c -> System.out.print(c));
		if (str.length() == str.chars().distinct().count())
			System.out.println(" Unique string ");
		else
			System.out.println(" Not Unique string ");
	}

	public static void isUnique(String str) {
		boolean isUnique = true;
		for (int i = 0; i < str.length(); i++) {
			if (i != str.lastIndexOf(str.charAt(i))) {
				System.out.println(" Not Unique string ");
				isUnique = false;
				break;
			}
		}
		if (isUnique)
			System.out.println(" Unique string ");
	}

	public static void main(String[] args) {
		isUnique("abcdd");
	}
}
