package bitiwise.hack;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultiplyBy2 {

	public static void multiply(int n, int power) {
		System.out.println(n + " multiply by 2 to the power " + power + " is" + (n << power));
	}

	public static void printInBinaryAndHexadecimalFormat(int n) {
		System.out.println("binary " + Integer.toBinaryString(n));
		System.out.println("Hexadecimal " + Integer.toHexString(n));
	}

	public static void devide(int n, int power) {
		System.out.println(n + " devide by 2 to the power " + power + " is" + (n >> power));
	}

	public static void isNumberPowerOf2(int n) {
		/*
		 * A = A & (A - 1) removes the least significant 1 bit from A. For
		 * example, A = 101100 (in binary). A & (A - 1) would give you 101000.
		 */
		boolean b = (n & (n - 1)) == 0;
		System.out.println(n + " is power of 2 " + b);
	}

	public static void whyMapCapacityIsPowOf2() {
		int hashCode = 9;
		int capacity = 32;
		int a = hashCode % capacity;
		int b = (hashCode & (capacity - 1));
		// coz hascode%size == hashcode&(size-1) if size is pow of 2
		System.out.println(a == b);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new HashMap<>().get(null));
		multiply(5, 2);
		multiply(10, 1);
		devide(20, 1);
		devide(20, 2);
		isNumberPowerOf2(8);
		isNumberPowerOf2(17);
		whyMapCapacityIsPowOf2();
		printInBinaryAndHexadecimalFormat(2);
		System.out.println("2's complement "+ ~2);
		System.out.println(2&(~(2-1)));
		System.out.println(1&1);
	}

}
