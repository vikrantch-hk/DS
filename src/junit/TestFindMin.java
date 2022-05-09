package junit;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.jupiter.api.Test;

public class TestFindMin {
	@Test
	public void testFindMinInRotatedArray() {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };
		int min = FindMinInRotatedArray.FindMin(arr, 0, arr.length - 1);
		assertEquals(1, min);

		/*
		 * The assertEquals() method returns normally. If the two values are not
		 * equal, an exception is thrown, and the test method stops executing
		 * here. The assertEquals() method is a statically imported method,
		 * which normally resides in the org.junit.Assert class. Using the
		 * static import of the method is shorter than writing
		 * Assert.assertEquals().
		 */
	}
}
