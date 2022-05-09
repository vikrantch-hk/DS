package oops.concepts;

public class B extends A { //static//Illegal modifier for the class B; only public, abstract & final are permitted

	int i = 4;
	String s = "s1";

	public B() {
		this(10); // even before this super() will be called automatically
		System.out.println("B");
	}

	public B(int i) {
		System.out.println("B10");
	}

	public void my(int i) {
		System.out.println("my B=" + i);
	}
	

	public void my1(int i) {
		System.out.println("my1 B=" + this.i);
	}

//@Override
	public void my3(Object i) {
		System.out.println("my3 B=" + i);
	}

	public void passByValue(String s)
	{
		System.out.println(s==this.s);
		s="s2";
		System.out.println(s==this.s);
	}
	
	
	public void passByValueObject(A a)
	{
		a.i=15;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B obj = new B();
		obj.my(); // 2
		System.out.println(obj.i); // 4
		
		obj.my1(3); // 4

		A obj2 = new B();
		obj2.my(); // 2
		
		obj2.my1(3); // prints this.i of object created
		System.out.println(obj2.i); // 2

		obj.my3(new B()); // my3 B=oops.concepts.B
		obj2.my3(new A()); // my3 A=oops.concepts.A
		
		//obj2.my(1); // The method my() in the type A is not applicable for the arguments (int)
		
		obj.passByValue(obj.s);
		System.out.println(obj.s);
		
		B obj4 = new B();
		A obj5 = new A();
		System.out.println("before passing object i="+obj5.i);
		obj4.passByValueObject(obj5);
		System.out.println("after passing object i="+obj5.i);
		A obj6 = new B();
		obj6.my3(new A());
		
		String a1 = "abc";
		String a2 = "a"+"bc";
		String a3 = "abc";
		System.out.println("a1==a2 "+ a1==a2);
		System.out.println("a2==a3 "+ a2==a3);
	}

}
