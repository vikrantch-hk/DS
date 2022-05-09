package geektrust.cricket.tie.breaker.util;

public class InningsHelperUtil {
	public static boolean isOverComplete(int bowlsRemaining) {
		return bowlsRemaining % 6 == 0;
	}
}
