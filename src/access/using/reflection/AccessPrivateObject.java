package access.using.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Queue;

public class AccessPrivateObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrivateObject privateObject = new PrivateObject("The Private Value");

		try {
			Field privateStringField = PrivateObject.class
					.getDeclaredField("privateString");
			privateStringField.setAccessible(true);
			String fieldValue;
			fieldValue = (String) privateStringField.get(privateObject);
			System.out.println("fieldValue = " + fieldValue);

			Method privateStringMethod = PrivateObject.class.getDeclaredMethod(
					"getPrivateString", null);
			privateStringMethod.setAccessible(true);
			String returnValue = (String) privateStringMethod.invoke(
					privateObject, null);
			System.out.println("returnValue = " + returnValue);

		} catch (IllegalArgumentException | IllegalAccessException
				| SecurityException | NoSuchFieldException
				| NoSuchMethodException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
