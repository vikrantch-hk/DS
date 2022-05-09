package oops.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StopChildClassSerializationInGrandChild extends Child {

	// implement private writeObjet and read object to stop sub class from being
	// serialized automatically

	public StopChildClassSerializationInGrandChild(int roll) {
		super(roll);
	}

	// writeObject specified as private because no other class but the
	// implementor is intended to use them
	public void writeObject(ObjectOutputStream out) throws IOException {
		// out.defaultWriteObject(); //Write the non-static and non-transient
		// fields of the current class to this stream
		throw new NotSerializableException();
	}

	public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
	}

	public static void main(String[] args) {

		StopChildClassSerializationInGrandChild c = new StopChildClassSerializationInGrandChild(1);
		c.setId(1);
		c.setName("Parent");
		c.setRollNo(10);

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
