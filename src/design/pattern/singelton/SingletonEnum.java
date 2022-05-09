package design.pattern.singelton;

/*Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class 
 * exists in the java virtual machine. */
/*By default creation of Enum instance is thread safe but any other method on Enum is programmers responsibility.*/

public enum SingletonEnum {
	INSTANCE;

	public static SingletonEnum getInstance() {
		return INSTANCE;
	}
}
