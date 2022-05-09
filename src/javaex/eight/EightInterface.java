package javaex.eight;

@FunctionalInterface
public interface EightInterface {
	public static final int i = 10;

	abstract void sample();
	// abstract void sample2(); Invalid '@FunctionalInterface' annotation;
	// EightInterface is not a functional interface

	//https://www.geeksforgeeks.org/default-methods-java/
	default void concrete() {
		System.out.println("concrete");
	}

	static void concrete2() {
		System.out.println("concrete2");
	}

}
