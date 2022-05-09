/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/

/*print all number present in string in next line*/

import java.util.*;

public class PrintNumberInStringInNewLine {
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
        //String givenString = sc.nextLine();
        String givenString = "absb1dnkllkds3333nklkjk45";
            String digitStr = "";
            List<Integer> digits = new ArrayList<Integer>();

            for (int i = 0; i < givenString.length(); i++) {
                if (Character.isDigit(givenString.charAt(i))) {
                    digitStr += givenString.charAt(i);
                } else {
                    if (!digitStr.isEmpty()) {
                        digits.add(Integer.parseInt(digitStr));
                        digitStr = "";
                    }
                }
            }
            if (!digitStr.isEmpty()) {
                digits.add(Integer.parseInt(digitStr));
                digitStr = "";
            }

            for (Integer i : digits) {
                System.out.println(i);
            }
        
    }
}
