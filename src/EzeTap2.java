/*What is the string made of?
Max. Marks 100
You are given a string, which contains entirely of decimal digits (0-9). Each digit is made of a certain number of dashes, as shown in the image below. For instance
 1 is made of 2 dashes, 8 is made of 7 dashes and so on.

digits made of dashes

You have to write a function that takes this string message as an input and returns a corresponding value in terms of a number. This number is the count of dashes 
in the string message.

Note:

0 consists of 6 dashes, 1 consists of 2 dashes, 2 consists of 5 dashes, 3 consists of 5 dashes, 4 consists of 4 dashes, 5 consists of 5 dashes, 6 consists of 6 dashes,
 7 consists of 4 dashes, 8 consists of 7 dashes, 9 consists of 6 dashes.

Constraints

String message will contain at least one digit, but not more than 100
Each character in code will be a digit ('0'-'9').
Sample Input(Plaintext Link)
 12
Sample Output(Plaintext Link)
 7*/





import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
 
public class EzeTap2 {
    public static void main(String args[] ) throws Exception {
    	HashMap<String, Integer> m= new HashMap<String,Integer>();
    	m.put("0", 6);
    	m.put("1", 2);
    	m.put("2", 5);
    	m.put("3", 5);
    	m.put("4", 4);
    	m.put("5", 5);
    	m.put("6", 6);
    	m.put("7", 3);
    	m.put("8", 7);
    	m.put("9", 6);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int count =0;
        for (int i = 0; i < line.length(); i++) {
        	if(m.containsKey(String.valueOf(line.charAt(i)))){
        		count+=m.get(String.valueOf(line.charAt(i)));
        	}
        }
        System.out.println(count);
        
    }
}