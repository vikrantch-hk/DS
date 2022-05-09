public class B extends A {
	final int a; // can be initialized only at time of declaration or in
					// constructor

	static int b;// static variable can also be initialized in const but not static final
	B() {
		b=4;
		a = 2;
	}
	@Override
	public
	int getZ() {//Cannot reduce the visibility of the inherited method from A compilation error
		// TODO Auto-generated method stub
		return super.getZ();
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	int[] arr = new int[100];
	public void hello() {
		boolean b = new Integer(1000)==new Integer(1000);
		System.out.println("b"+b);
		System.out.println("arr[0]="+arr[0]);// arr[0]=0
		
		//a = 2;// The final field B.a cannot be assigned
		final int d = 2;
		
		//d = 3;// The final local variable d cannot be assigned. It must be blank
				// and not using a compound assignment
		String c = "c";
		c = c + "d";
		System.out.println(c);
		System.out.println("hello");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object o = new String("abc");
		System.out.println(o.equals("abc"));// true // example of overriding
		A a1 = new A();
		//B b1 = (B) a1;// java.lang.ClassCastException: A cannot be cast to B

		A a2 = new B();
		//a2.hello();// The method hello() is undefined for the type A
		B b2 = (B) a2;
		b2.hello();

		String subClass = (String) new Object();// java.lang.ClassCastException:
												// java.lang.Object cannot be
												// cast to java.lang.String
		subClass = "abc";
		System.out.println(subClass.equals("abc"));
	}

}
