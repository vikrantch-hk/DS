
public class TestMain {

	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("a");
		StringBuilder sb2 = new StringBuilder("a");
		// StringBuilder doesn't override equals method
		System.out.println("a".equals(sb2));
	}

}
