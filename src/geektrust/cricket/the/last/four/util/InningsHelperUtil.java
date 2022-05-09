package geektrust.cricket.the.last.four.util;

public class InningsHelperUtil {
	public static boolean isOverComplete(int bowlsRemaining) {
		return bowlsRemaining % 6 == 0;
	}
}
