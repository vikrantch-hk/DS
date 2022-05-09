import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;


public class testrent {

	int id;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		testrent other = (testrent) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.Set set = new HashSet();
set.add(null);
System.out.println("can add 1 null in hashset without overriding equals");
java.util.Set<testrent> set2 = new TreeSet();
set2.add(null);/// NullPointerException
System.out.println("can add 1 null in treeset without overriding compare");
/*//Exception in thread "main" java.lang.NullPointerException
at java.util.TreeMap.compare(TreeMap.java:1290)*/
}

}
