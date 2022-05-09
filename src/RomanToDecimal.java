

// https://www.geeksforgeeks.org/converting-roman-numerals-decimal-lying-1-3999/
// start from right to left
// if prev is greater than current subtract otherwise add ex VI=1+5=6 IV=5-1=4
public class RomanToDecimal {
	
	static int value(char r) {
		if (r == 'I') 
            return 1; 
        if (r == 'V') 
            return 5; 
        if (r == 'X') 
            return 10; 
        if (r == 'L') 
            return 50; 
        if (r == 'C') 
            return 100; 
        if (r == 'D') 
            return 500; 
        if (r == 'M') 
            return 1000; 
        return -1; 
	}
	
	static int romanToDecimal(String str) {
		int res =0;
		int prev =0;
		for(int i=str.length()-1;i>=0;i--) {
			int  curr = value(str.charAt(i));
			if(prev>curr) {
				res-=curr;
			}else{
			res += curr;
			}
			prev = curr;
		}
		return res;
	}

	public static void main(String[] args) {
		 String str = "MCMIV"; 
		 System.out.println(romanToDecimal(str));
	}
}
