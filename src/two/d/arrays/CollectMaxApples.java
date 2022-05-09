package two.d.arrays;

import java.util.concurrent.Future;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

public class CollectMaxApples {

	// collect max apples in 2 d matrix can move right, down and diagonal
	public static int getMaxApples(int[][] arr) {
		// insteadof atomiclong use longadder
		LongAdder adder= new LongAdder();
		int[][] solution = new int[arr.length][arr[0].length];
		solution[0][0] = arr[0][0];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (i == 0 && j > 0) {
					solution[i][j] = solution[i][j - 1] + arr[i][j];
				} else if (i > 0 && j == 0) {
					solution[i][j] = solution[i - 1][j] + arr[i][j];
				} else if (i > 0 && j > 0) {
					solution[i][j] = Math.max(Math.max(solution[i - 1][j], solution[i][j - 1]), solution[i - 1][j - 1])
							+ arr[i][j];
				}
			}
		}
		return solution[arr.length - 1][arr[0].length - 1];
	}

	public static void main(String[] args) {
		Stream.of("").filter(input->input.isEmpty()).forEach(input->System.out.println(input));
		System.out.println(getMaxApples(new int[][] { { 20, 5, 10 }, { 13, 25, 20 }, { 26, 30, 15 } }));
	}

}
