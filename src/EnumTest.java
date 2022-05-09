import java.io.Serializable;

public enum EnumTest implements Serializable {// extends Object{ // enum can not
												// extend any object

	// Illegal modifier for the enum constant INDIA; no modifier is allowed
	INDIA("Developing") {

		public void test() {
			System.out.println("india test");
		}
	}, // /The enum constant US must implement the abstract method test()
	US("Develpoed") {
		public void test() {

		}
	},
	CHINA("Almost Develpoed") {
		public void test() {

		}
	};
	/*
	 * public EnumTest()///Illegal modifier for the enum constructor; only
	 * private is permitted. {
	 * 
	 * }
	 */
	private String type;

	private EnumTest(String type)/// Illegal modifier for the enum constructor;
									/// only private is permitted.
	{
		this.type = type;
	}

	public abstract void test();// The abstract method test in type EnumTest
									// can only set a visibility modifier, one
									// of public or protected

	public static void main(String[] args) {
		System.out.println(EnumTest.INDIA.name());
		EnumTest.INDIA.test();
		System.out.println(EnumTest.valueOf("CHINA").equals(CHINA));// comparing
																	// string
																	// with enum
	}
}
