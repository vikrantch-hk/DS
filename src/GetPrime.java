import java.util.List;

public class GetPrime {

	/**
	 * @param args
	 */
	
	public static boolean checkprime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 2; i <= 10000; i++)
			if (GetPrime.checkprime(i)) {
				System.out.println(i);
			}
		
	}

}
