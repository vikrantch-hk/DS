import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Sort array in away that primes are sorted increasing and composite sorted decreasing
 * also don't change combined indexes of primes
 * 
 * 5 9 6 8 2 4--->  2 9 8 6 5 4
 * @author vikrant
 *
 */
public class SortPrimeAndComposite {

	// mark a[i] as prime or not in an boolean array
	// keep primes and non primes in two lists sort them
	// iterate thru boolean array if prime get item from list and increase list pointer
	static int[] sort(int[] arr) {
		List<Integer> primes = new ArrayList<>();
		List<Integer> nonPrimes = new ArrayList<>();
		
		boolean[] boolArray = new boolean[arr.length];
		for(int i=0;i<arr.length;i++) {
			if(isPrime(arr[i])) {
				boolArray[i]=true;
				primes.add(arr[i]);
			}else {
					boolArray[i]=false;
					nonPrimes.add(arr[i]);
			}
		}
		
		primes.sort(Integer::compareTo);
		nonPrimes.sort(Comparator.reverseOrder());
		
		int primeIndex =0;
		int nonPrimeIndex =0;
		for(int i=0;i<boolArray.length;i++) {
			if(boolArray[i]) {
				arr[i]=primes.get(primeIndex);
				primeIndex++;
			}else {
				arr[i]=nonPrimes.get(nonPrimeIndex);
				nonPrimeIndex++;
			}
		}
		
		return arr;
	}
	
     static boolean isPrime(int n) {
    	 if(n==1)return true;
    	 for(int i=2;i<=Math.sqrt(n);i++) {
    		 if(n%i==0)return false;
    	 }
		return true;
	}

	public static void main(String[] args) {
		int[] arr=new int[]{5,9,6,8,2,4};
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}
		sort(arr);
		System.out.println();
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}
	}
	
}
