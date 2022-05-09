package oops.concepts;

import java.util.ArrayList;

public class A {

	int i = 2;

	public A()// if we make super constructor private in sub class at runtime
				// we'll get Implicit super constructor A() is not visible
	{
		System.out.println("A");
	}

	public void my() {
		System.out.println(this.i);
	}

	public void my1(int i) {
		System.out.println("my1 i=" + this.i);
	}

	public void my1(Integer i) {
		System.out.println("my1 Integer=" + i);
	}

	public void my2(String i) {
		System.out.println("my2 String=" + i);
	}

	public void my2(Object i) {
		System.out.println("my2 Object=" + i);
	}

	public void my2(ArrayList i) {
		System.out.println("my2 ArrayList=" + i);
	}

	
	public void my3(A i) {
		System.out.println("my3 A=" + i);
	}

	public static void main(String[] args) {
		A obj = new A();
		obj.my1(3); // my1 i=2
		// obj.my2(null); // my2 String=null
		A obj2 = new C();
		obj2.my();
	}
}
