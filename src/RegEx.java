
public class RegEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str ="abc";
		if(str.matches("[a-z]*"))
				//str.matches("\\w+"))
			System.out.println("true");
		else
			System.out.println("false");

	}

}
