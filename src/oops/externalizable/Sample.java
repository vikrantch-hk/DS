package oops.externalizable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Sample implements Externalizable {

	public Sample() {
		// empty constructor is must in Externalizable
	}

	public Sample(int i) {
	}

	transient int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public String toString() {
		return "Sample [i=" + i + "]";
	}

	@Override // ObjectOutput is interface ObjectOutputStream is implementation
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(getI());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		setI(in.readInt());
	}

	public static void main(String[] args) {
		Sample s = new Sample();
		s.setI(100);
		System.out.println("Initially: " + s.toString());

		try (FileOutputStream fileOutputStream = new FileOutputStream(
				"C:\\Users\\vchudhr\\practice\\externalizable.txt");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			s.writeExternal(objectOutputStream);
		} catch (IOException e) {
			System.out.println(e);
		}

		try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\vchudhr\\practice\\externalizable.txt");

				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
			Sample in = new Sample();
			in.readExternal(objectInputStream);
			System.out.println("After de-serialization: " + in.toString());
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e);
		}

	}
}
