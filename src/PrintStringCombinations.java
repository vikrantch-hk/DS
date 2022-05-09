
public class PrintStringCombinations {
	
	public static void print(String s) {
		printUtil("",s);
	}

	private static void printUtil(String prefix, String s) {
		System.out.println(prefix);
		for(int i=0;i<s.length();i++)
		{
			printUtil(prefix+s.charAt(i), s.substring(i+1));
		}
		
	}
	public static void main(String[] args) {
		print("abc");
	}
	
	
	/*
	 * 
	 *      abc
		a   bc
		ab   c
		abc   
		ac   
		b   c
		bc   
		c   
		*/

}
