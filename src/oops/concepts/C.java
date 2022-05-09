package oops.concepts;

import java.util.ArrayList;
import java.util.Collections;

public class C extends B {
	static String[] arr;
	static int[] intArr = new int[1];
	static Integer[] integerArr = new Integer[1];
	static String str;
	public C() {
		System.out.println("C");
	}
	
	{
		System.out.println("non static anonymous block executes before constructor and after static block");
	}

	public void m()
	{}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C obj = new C();
		obj.my();
	//	C obj2 = (C)new A();// // java.lang.ClassCastException
		//obj2.my();
		A o = new C();
	    ((C) o).m();
	

	System.out.println(arr);
	System.out.println(intArr[0]);
	System.out.println(integerArr[0]);
	System.out.println(str);
	}

	
	/*
	 * The first call in a constructor is always the super(...). This call is
	 * automatically inserted by the compiler if you don't write it down
	 * explicitly. No calls on the constructed object can happen before the call
	 * to super() returned. After super() finished, the fields are initialized
	 * in the order of appearance and then the rest of the constructor is
	 * executed.
	 */
	/*
	 * 1. initialize member fields of the base class(es) 
	 * 2. run the base class(es) constructor(s) 
	 * 3. initialize member fields of this class 
	 * 4. run the constructor of this class
	 */
@Override
public void my() {
	// TODO Auto-generated method stub
	System.out.println("my C=" + i);
	
}

}
