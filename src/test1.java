import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class test1 implements test,Serializable {

	int b = test.a;

	static int k;
	 static final int j;
	 final int l;
	 static{
		 j=0;
	 }
	public test1() {
		l=0;
		//j=1;
	}
	static int i;
	public void read(List<Number> list)
	{
		;
	}

	public void d()
	{
		
	    List<Object> list = new ArrayList<test1>();// will get compile error
		List<Number> list1 = new ArrayList<Integer>();// will get compile error
		
		
		try{
			//System.out.println("a ="+new test1().i);
				i=1/10;
				try {
					FileInputStream fs = new FileInputStream("a");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// for checked exceptions we must put catch block only finally will not work
			}
			finally
			{
			;
			}
	}
	public static void main(String[] args) {
		
		test t2 = new test1();
		System.out.println(t2.toString());
		new test1().d();
		String s1 = "abc";
		String s2 = s1 + "d";
		if(s1 != s2)
		System.out.println(" string is immutable");
		StringBuilder sb1 = new StringBuilder("abc");
		StringBuilder sb2 = sb1.append("d");
		if(sb1 == sb2)
			System.out.println(" StringBuilder is mutable");
		
		
		//List<Number> list = new ArrayList<Integer>();// error cannot convert from ArrayList<Integer> to List<Number>
		//new test1().read(new ArrayList<Integer>());
		
		java.util.Set set = new HashSet();
		set.add(null);
		System.out.println("can add 1 null in hashset without overriding equals");
		java.util.Set set2 = new TreeSet();
		set2.add(null);/// NullPointerException
		System.out.println("can add 1 null in treeset without overriding equals");}

		
		
	}
	
}
