package core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Generic<T> {

	public T print(T t)
	{
		return t;
	}
	public Object print2(Object t)
	{
		return t;
	}
	
	public static void main(String[] args) {
		//String s= new Generic<String>().print(1);
		String s= new Generic<String>().print("1");
		String s2= (String) new Generic<String>().print2("abc");
		System.out.println(s+" "+s2);
		List<? extends Object> l = new ArrayList<String>();
		// l.add("abc");// You can't add an String because l could be pointing at a List<Double>
		new Generic2().print(BigDecimal.valueOf(1));
	}
}

class Generic2{
	public <T extends BigDecimal> void print(T t)
	{
		System.out.println(t.add(t));
	}
	
	
	
}
