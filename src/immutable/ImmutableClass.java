package immutable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Always remember that your instance variables will be either mutable or
 * immutable. Identify them and return new objects with copied content for all
 * mutable objects. Immutable variables can be returned safely without extra
 * effort.
 */
public final class ImmutableClass implements Serializable{
	/**
	 * Integer class is immutable as it does not provide any setter to change
	 * its content
	 */
	private final Integer number;
	/**
	 * String class is immutable as it also does not provide setter to change
	 * its content
	 */
	private final String name;
	/**
	 * Date class is mutable as it provide setters to change various date/time
	 * parts
	 */
	private final Date date;
	private transient final Test test;

	// Default private constructor will ensure no unplanned construction of
	// class
	public ImmutableClass(Integer number, String name, Date date, Test test) {
		this.number = number;
		this.name = name;
		this.date = date;
		// this.mutableField = new Date(date.getTime());
		this.test = test;
	}

	// Provide no setter methods
	/**
	 * Integer class is immutable so we can return the instance variable as it
	 * is
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * String class is also immutable so we can return the instance variable as
	 * it is
	 */
	public String getName() {
		return name;
	}

	/**
	 * Date class is mutable so we need a little care here. We should not return
	 * the reference of original instance variable. Instead a new Date object,
	 * with content copied to it, should be returned.
	 */
	public Date getdate() {
		return new Date(date.getTime());
	}

	public Test getTest() {
		Test tnew = new Test();
		tnew.setName(test.getName());
		return tnew;
		// return test;
	}

	@Override
	public String toString() {
		return number + " � " + name + " � " + date + "-" + test.getName();
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.setName("barun");
		Date d = new Date();
		d.setTime(100000000);
		ImmutableClass im = new ImmutableClass(100, "test", d, t);
		System.out.println(im);
		tryModification(im);
		d.setTime(200000000);
		System.out.println(im);

		// Set<ImmutableClass> m = new TreeSet<ImmutableClass>();
		// m.add(null);
		/*
		 * List<Integer> m1 = new ArrayList<Integer>(); for(int
		 * i=1;i<=10000;i++) m1.add(null); long t1=System.currentTimeMillis();
		 * for(Integer i: m1) ; long t2= System.currentTimeMillis();
		 * System.out.println("for"+(t2-t1) ); long
		 * t3=System.currentTimeMillis(); Iterator itr = m1.iterator();
		 * while(itr.hasNext()) ; long t4=System.currentTimeMillis();
		 * System.out.println("itr"+(t4-t3) );
		 */
		// System.out.println(m.size());

		try {
			System.out.println("serializing immutable ");
			FileOutputStream fs = new FileOutputStream("C:\\Users\\vchudhr\\practice\\immutable_seriarizable.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(im);

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\vchudhr\\practice\\immutable_seriarizable.txt");
			ObjectInputStream is = new ObjectInputStream(fis);
			System.out.println(is.readObject());

		} catch (IOException |ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static void tryModification(ImmutableClass im) {
		// im.number = 10000;
		// im.getName() = "test changed";
		im.getdate().setDate(55555);
		im.getTest().setName("tarun");
	}
}
