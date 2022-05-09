package oops.overloading.most.specific;

public class OverLoading2 {
	
	//  no specific method between print(String e) & print(Integer e)
	public void print(String e)
	{
		System.out.println("Exception");
	}
	
	public void print(Integer e)
	{
		System.out.println("Exception");
	}
	
	public void print(Object e)
	{
		System.out.println("Object");
	}

	public static void main(String[] args) {
		OverLoading2 over = new OverLoading2();
		over.print(null); // The method print(String) is ambiguous for the type OverLoading2

	}

}
