public class C extends B {
	int x = 2;
	int y = 2;
	private int z = 2;

	public C()
	{
		
	}
	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public void m1() {
		System.out.println(x + y);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A parentRefParentObj = new A();
		parentRefParentObj.m1();
		System.out.println(parentRefParentObj.x);// no instance variable
													// overriding in java so
													// will print reference
													// class variable always
		System.out.println(parentRefParentObj.getZ());
		
		A parentRefChildObj = new C();
		parentRefChildObj.m1();
		System.out.println(parentRefChildObj.x);
		System.out.println(parentRefParentObj.getZ());
		
		/*
		 * C anotherChild = (C) new A(); System.out.println(anotherChild.x);
		 */
	}

}
