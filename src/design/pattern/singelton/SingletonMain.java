package design.pattern.singelton;

public class SingletonMain {

	// when to use singleton when we need to access a class through out all the modules
	// and that config data is not going to change after startup of application this will avoid dirty reads also
	// ex system code config for warehouses
	// page definition 
	public static void main(String[] args) throws InstantiationException {
		SingletonEnum o1 = SingletonEnum.getInstance();
		SingletonEnum o2 = SingletonEnum.getInstance();
		
		if(o1==o2)
			System.out.println("singleton enum worked");
		
		Singleton ob1 = Singleton.getInstance();
		Singleton ob2 = Singleton.getInstance();
		
		
		if(ob1==ob2)
			System.out.println("singleton worked");
		
		Singleton obj3 = Singleton.reflectionInstance();
		if(ob1!=obj3)
			System.out.println("singleton broken by reflection");
	}

}
