/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
import java.util.*;
import java.math.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
        
        Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		String arr[] =sc.nextLine().split(" ");
		BigInteger n = new BigInteger("1");
		for(int i=0;i<t;i++)
		{
			n=n.multiply(new BigInteger(arr[i]));
		}
	//	System.out.println("strt");
		print(n);
    }
    
    public static void print(BigInteger n)
	{
		int count=0;
		//System.out.println(n);
		for(BigInteger i=new BigInteger("1");i.compareTo(n)<=0;i=i.add(new BigInteger("1")))
		{
			//System.out.println(i);
			if(n.mod(i).compareTo(new BigInteger("0"))==0)
					{
				count++;
					}
				
		}
		System.out.println(count);
		
	}
	
}
