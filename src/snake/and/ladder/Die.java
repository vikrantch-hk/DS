package snake.and.ladder;

public class Die {
	private static final int MINVALUE = 1;
	private static final int MAXVALUE = 6;

	public int roll() {
		return MINVALUE + (int) ((MAXVALUE - MINVALUE) * Math.random());// math.random
																		// Returns
																		// a
																		// double
																		// value
																		// with
																		// a
																		// positive
																		// sign,
																		// greater
																		// than
																		// or
																		// equal
																		// to
																		// 0.0
																		// and
																		// less
																		// than
																		// 1.0
	}
}