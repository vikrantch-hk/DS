package design.pattern.singelton;

import java.io.Serializable;

// still refletion can break it
public class Singleton implements Serializable, Cloneable {

	private static volatile Singleton instance;

	private Singleton() throws InstantiationException {
		// to stop reflection throw InstantiationException
		//throw new InstantiationException();
	}

	// double check locking
	public static Singleton getInstance() throws InstantiationException {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton();
			}
		}
		
		return instance;
	}

	// to return same instance after deserializing
	private Object readResolve() throws InstantiationException {
		return instance;
	}

	// to protect from cloning 
	@Override
	protected Singleton clone() throws CloneNotSupportedException {
		return instance;
	}
	
	public static Singleton reflectionInstance()
	{
		try {
			// reflection newInstance calls default constructor
			instance = (Singleton)Class.forName(Singleton.class.getName()).newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return instance;
	}
}
