public class StringIntern {

	/*
	 * Java automatically interns String literals. This means that in many
	 * cases, the == operator appears to work for Strings in the same way that
	 * it does for ints or other primitive values. Since interning is automatic
	 * for String literals, the intern() method is to be used on Strings
	 * constructed with new String()
	 */
	public static void main(String[] args) {
		String s1 = "Rakesh";
		String s2 = "Rakesh";
		String s3 = "Rakesh".intern();
		String s4 = new String("Rakesh");
		String s5 = new String("Rakesh").intern();
		/*
		 * if the pool already contains a string equal to this String object as
		 * determined by the equals(Object) method, then the string from the
		 * pool is returned. Otherwise, this String object is added to the pool
		 * and a reference to this String object is returned.
		 */

		if (s1 == s2) {
			System.out.println("s1 and s2 are same"); // 1.
		}

		if (s1 == s3) {
			System.out.println("s1 and s3 are same"); // 2.
		}

		if (s1 == s4) {
			System.out.println("s1 and s4 are same"); // 3.
		}

		if (s1 == s5) {
			System.out.println("s1 and s5 are same"); // 4.
		}
	}
}
