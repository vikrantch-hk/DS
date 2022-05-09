package markerInterface;

public class markerImplementation implements markerExample {

	public void doSomething(Object obj) {
		if (obj instanceof markerExample)
			System.out.println("this is marker example");
		else
			System.out.println("this isnt marker");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		markerImplementation mI = new markerImplementation();

		mI.doSomething(mI);
	}

}
