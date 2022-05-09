package oops;

import java.io.FileNotFoundException;

public class B extends A {

	int a = 2;

	@Override
	public void print() throws RuntimeException // overriden method can throw
												// new Runtime exception but not
												// compile time exception
	{
		System.out.println(a);
		// throw new FileNotFoundException(); // compile time exception you have
		// to add try catch or throws
		// throw new RuntimeException();
	}

	public static void main(String[] args) {
		A a = new B();
		System.out.println(a.a);// instance variable got picked from refernce
		a.print();
		A a2 = new A();
		System.out.println(a2.a);// instance variable got picked from refernce
		a2.print();
		System.out.println(a.getClass());
		System.out.println(a);
	}

	@Override
	public String toString() {
		return "B [a=" + a + "]";
	}
}
