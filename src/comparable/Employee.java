package comparable;

import java.io.Serializable;
import java.util.Comparator;


public class Employee implements Comparable<Employee> {
	
	
	private int id;
	/**
	 * @param args
	 */

	public int getId() {
		return id;
	}

	// by default hascode returns memory address of object
	/*@Override
	public int hashCode() {
		return new Integer(id).hashCode();
	}*/

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}*/

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(Employee o) {
		return new Integer(id).compareTo(new Integer(o.id));
	}

	
	class EmployeeComparator implements Comparator<Employee> {
		public int compare(Employee e1, Employee e2)
		{
			return new Integer(e1.id).compareTo(new Integer(e2.id));
		}
	}

}
