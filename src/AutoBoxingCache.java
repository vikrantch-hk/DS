
public class AutoBoxingCache {
	public static void main(String[] args) {
		Integer a = 127;
		Integer b = 127;
		System.out.println(a == b);
		Integer a1 = 128;
		Integer b1 = 128;
		System.out.println(a1 == b1);

		/*
		 * this method is likely to yield significantly better space and time
		 * performance by caching frequently requested values. This method will
		 * always cache values in the range -128 to 127, inclusive
		 */
		Integer a2 = Integer.valueOf(-128);
		Integer b2 = Integer.valueOf(-128);
		System.out.println(a2 == b2);
	}
}
