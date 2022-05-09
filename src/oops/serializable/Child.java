package oops.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Child extends Parent implements Serializable {

	// InvalidClassException
	/*
	 * Thrown when the Serialization runtime detects one of the following
	 * problems with a Class. • The serial version of the class does not match
	 * that of the class descriptor read from the stream • The class contains
	 * unknown datatypes • The class does not have an accessible no-arg
	 * constructor
	 */

	public Child(int roll) {
		super(roll);
		// empty constructor is required in Serializable
	}

	private int rollNo;
	private transient ThirdClass thirdClass;

	// readResolve is used for replacing the object read from the stream
	// serailzable dosen't require getter setter
	// if parent is not serializable its properties will not be serialized no
	// exception
	// if you serialize any non serializable class NotSerializableException:
	// oops.serializable.Child
	// if you have any dependency which is not serializable and you serialize
	// that also
	// NotSerializableException: oops.serializable.ThirdClass
	// to serialize a non serializable property declare property as transient
	// override readobject writeobject

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject(); // Write the non-static and non-transient
		// fields of the current class to this stream
		out.writeObject(thirdClass.third);
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		String third = (String) in.readObject();
		ThirdClass thirdClass = new ThirdClass();
		thirdClass.setThird(third);
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

	public static void main(String[] args) {

		Child c = new Child(1);
		c.setId(1);
		c.setName("Parent");
		c.setRollNo(10);
		ThirdClass third = new ThirdClass();
		third.setThird("third");
		c.setThirdClass(third);

		// try can have multiple auto closable statements
		try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\vchudhr\\practice\\seriarizable.txt");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {

			objectOutputStream.writeObject(c);
		} catch (IOException e) {
			System.out.println(e);
		}

		try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\vchudhr\\practice\\seriarizable.txt");

				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
			System.out.println(objectInputStream.readObject());
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e);
		}

	}
}
