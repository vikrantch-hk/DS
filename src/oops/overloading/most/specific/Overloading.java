package oops.overloading.most.specific;

public class Overloading {
	
	//  the most specific method is chosen
	public void print(String e)
	{
		System.out.println("Exception");
	}
	
	public void print(Object e)
	{
		System.out.println("Object");
	}

	public static void main(String[] args) {
		Overloading over = new Overloading();
		over.print(null);

	}

}
