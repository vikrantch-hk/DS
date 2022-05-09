import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class A {
	static int i;
	int x = 1;
	int y = 1;
	private int z = 1;

	public A() { // Illegal modifier for the constructor in type A; only public,
					// protected & private are permitted
		i = 10;// we can hv static vars in non static methods
	}

	/*
	 * When you set a method as final, it means :
	 * "You don't want any class override it", but constructor by JLS definition
	 * can't overridden,so it is clean. We can't make constructor to be final
	 * because constructor is never inherited. We declare a methd or a class as
	 * final if we dont want it to be overriden.
	 */

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public void m1() {
		System.out.println(x + y);
	}
}
