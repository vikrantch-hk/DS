package why.immutable.isFinal;

import java.util.HashMap;

public class YImmutableIsFinal {

	public static void main(String[] args) {

		HashMap<Immutable, String> m = new HashMap<Immutable, String>();
		Mutable mutable = new Mutable(4);
		/*
		 * Notice that in my Mutable subclass, I've verridden the behavior of
		 * getValue to read a new, mutable field declared in my subclass. As a
		 * result, your class, which initially looks immutable, really isn't
		 * immutable. I can pass this Mutable object wherever an Immutable
		 * object is expected
		 */
		Immutable immutable = mutable;
		Immutable immutable2 = new Immutable(5);
		m.put(immutable, "4");
		m.put(immutable2, "5");
		System.out.println(m.get(immutable));
		System.out.println(m.get(immutable2));
		mutable.setValue(8);
		System.out.println(m.get(immutable));
		System.out.println(m.get(immutable2));

		/*
		 * method might assume that, since it thinks the object is immutable, it
		 * can be used as the key in a HashMap. I could then break that function
		 * by passing in a Mutable, waiting for it to store the object as a key,
		 * then changing the Mutable object. Now, lookups in that HashMap will
		 * fail, because I changed the key associated with the object
		 */
	}

}
