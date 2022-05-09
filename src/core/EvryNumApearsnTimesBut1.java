package core;

import java.util.Arrays;

// http://www.ideserve.co.in/learn/find-the-element-that-appears-once-in-an-array#algorithmVisualization
public class EvryNumApearsnTimesBut1 {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 2, 1, 1, 2, 4, 2, 2 };
		System.out.println("The element with single occurrence is " + getSingle(arr));
	}

	private static int getSingle(int[] arr) {

		int[] sumOfBits = new int[32];
		for (int i : arr) {
			for (int j = 0; j < 32; j++) {
				if (getIthBit(i, j) == 1)
					sumOfBits[j]++;
			}
		}

		for (int j = 0; j < 32; j++) {
			sumOfBits[j] %= 4;// here n =4
		}

		return getDecimalFromBinary(sumOfBits);

	}

	private static int getDecimalFromBinary(int[] sumOfBits) {

		int num = 0;
		for (int i = 31; i >= 0; i--) {
			num = num * 2 + sumOfBits[i];
		}
		return num;
	}

	public static int getIthBit(int n, int i) {
		// get ith bit from left i starts from 0
		return (n >> i) & 1;
	}

}
