package oops.concepts.inner;

public class InnerEx {
	static {
		System.out.println("static");
	}

	public InnerEx() {
		System.out.println("outer cons called");
	}

	public class inner {
		public inner() {
			System.out.println("inner cons called");
		}
	}

	public static class inneStatic {

		public inneStatic() {
			System.out.println("static inner cons called");
		}
	}

	public static void main(String[] args) {

		InnerEx.inner obj = new InnerEx().new inner();

		// creating obj of static inner class
		// only inner class cons will be called
		InnerEx.inneStatic obj2 = new InnerEx.inneStatic();

		try {
			// class loader will load class and execute its static block
			Class.forName("oops.concepts.inner.InnerEx");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
