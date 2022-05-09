package oops.clonable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

// if parent is cloneable child is automatically cloneable
// if both are not clonable CloneNotSupportedException
// if parent not clonable child is clonable then also cloning child will clone parent also
// if there is a property of non clonable type that will also be cloned automatically
public class Child extends Parent implements Cloneable {

	private int rollNo;
	private ThirdClass thirdClass;
	
	// cloning calls default constructor otherwise throws compilation  error
	// The constructor Child() is undefined
	public Child() {
	}

	public Child(int rollNo, ThirdClass thirdClass) {
		super();
		this.rollNo = rollNo;
		this.thirdClass = thirdClass;
	}

	public ThirdClass getThirdClass() {
		return thirdClass;
	}

	public void setThirdClass(ThirdClass thirdClass) {
		this.thirdClass = thirdClass;
	}

	@Override
	public String toString() {
		return "Child [rollNo=" + rollNo + ", thirdClass=" + thirdClass + ", id=" + id + ", name=" + name + "]";
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + rollNo;
		return result;
	}

	/*
	 * If we are writing clone method in a child class e.g. Person then all of
	 * its superclasses should define clone() method in them or inherit it from
	 * another parent class otherwise super.clone() chain will fail.
	 */
	@Override
	protected Child clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		super.clone(); // now parent properties will not be cloned
		Child clonedChild = new Child();
		clonedChild.setRollNo(this.rollNo);
		clonedChild.setThirdClass(this.thirdClass);
		return clonedChild;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Child other = (Child) obj;
		if (rollNo != other.rollNo)
			return false;
		return true;
	}

	public static void main(String[] args) throws CloneNotSupportedException {

		Child c = new Child();
		c.setId(1);
		c.setName("Parent");
		c.setRollNo(10);
		ThirdClass thirdClass = new ThirdClass();
		thirdClass.setThird("third");
		c.setThirdClass(thirdClass);

		Child c2 = (Child) c.clone();
		System.out.println("c==c2 " + (c == c2));
		System.out.println("c.getClass().equals(c2.getClass()) " + (c.getClass().equals(c2.getClass())));
		System.out.println("c.equals(c2) " + (c.equals(c2)));
		System.out.println("c " + c);
		System.out.println("c2 " + c2);

		Parent p = (Parent) c.clone(); // on p.clone compilation error The
										// method clone() from the type Object
										// is not visible
		// default visibility clone is protected
		System.out.println("p " + p);
	}
}
