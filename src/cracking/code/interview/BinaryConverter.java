package cracking.code.interview;


//https://stackoverflow.com/questions/61986404/getting-runtime-exception-while-converting-long-to-binary-and-then-concatenated
public class BinaryConverter {
	public static void printBinary(Double n) {
		System.out.println(Integer.toBinaryString(n.intValue()));
	}

	public static void printBinary(int n) {
		StringBuilder s = new StringBuilder();
		while (n > 0) {
			s.append(n % 2);
			n = n / 2;
		}
	
		
		
		
		System.out.println("s"+s.reverse());

	}

	public static void main(String[] args) {
		
		long  n = 3l;
			long	size = 0l;   
				long result = 0l;   
				for (long i=1l; i<=n;i++) {   
				    if ((i & (i - 1)) == 0) {  
				        size += 1;
				    }
				
				    result = ((result << size) | i) % 1000000007 ;
				}
				System.out.println(result);
		System.out.println(2<<16|1);
		
		
		
		
		
		printBinary(50.2);
		printBinary(50);
	}
}
