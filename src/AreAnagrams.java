import java.util.Arrays;

import geektrust.cricket.Player;

public class AreAnagrams {

	// convert to char array
	// sort both
	// if equals then anagrams
	// pass by value
	void a() {
	Player i1 = new Player("a", new double[]{1.0,2.0})  ;
	System.out.println(i1.getName());
	modify(i1);
	System.out.println(i1.getName());
	}
	void modify(Player i1) {
		i1 = new Player("b", new double[]{1.0,2.0})  ;
	}
	
	public static void main(String[] args) {
		//this.lock(); Cannot use this in a static context
		AreAnagrams anagrams = new AreAnagrams();
		anagrams.a();
		String s1 = "abcd";
		String s2 = "dbca";
		char[] a1= s1.toCharArray();
		char[] a2= s2.toCharArray();
		Arrays.sort(a1);
		Arrays.sort(a2);
		System.out.println("AreAnagrams "+Arrays.equals(a1, a2));
	}

	
	private class B1{
		
		public void main() {
	System.out.println("abc");		
		}
		
	}
}
 
