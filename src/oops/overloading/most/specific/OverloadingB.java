package oops.overloading.most.specific;

public class OverloadingB extends OverloadingA {
	public void print(String e) {
		System.out.println("Exception");
	}

	public static void main(String[] args) {
		OverloadingA a = new OverloadingB();
		a.print("s");

		// depending on reference method will be called not on object
		OverloadingB b = new OverloadingB();
		b.print(null);
	}

}
