package oops.concepts.equals;

public class Employee {

	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int id;

	/**
	 * @param args
	 */

	public int getId() {
		return id;
	}

	// by default hashcode returns memory address of object
	@Override
	public int hashCode() {
		return Integer.valueOf(id).hashCode();
	}

	// never do equals(Employee obj)
	// it will overload equals not override
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		/*
		 * if (obj == null) return false; if (getClass() != obj.getClass())
		 * return false;
		 */

		/*
		 * instead of null check we can do instanceof which will automatically
		 * return false if obj is null, additionally it will take care if
		 * classcastexception as well while we'll cast obj to employee
		 */
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void setId(int id) {
		this.id = id;
	}

}
