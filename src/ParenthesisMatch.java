/*
 *  Java Program to Check for balanced paranthesis by using Stacks
 */
 
import java.util.*;
 
public class ParenthesisMatch
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        /* Creating Stack */
        Stack<Integer> stk = new Stack<Integer>();
        System.out.println("Parenthesis Matching Test\n");
        /* Accepting strression */
        System.out.println("Enter strression");
        String str = scan.next();        
        int len = str.length();
        System.out.println("\nMatches and Mismatches:\n");
        
    }
    
    
    public static int count(String str)
    {int l = 0;
    int r = 0;
    for (int i = 0; i < str.length(); i++){
    if (str.charAt(i) == '(')
        l++;
    else if (str.charAt(i) == ')')
        r++;
        }
    /*if (l > r) 
    System.out.println("There are " + (l-r) + " more left parentheses than right");
    else if (l < r)
    System.out.println("There are " + (r - l)+ " more right parentheses then left");
    else 
    System.out.println("The amount of left and right parentheses are even.");*/
    return l-r;
    }
}



/* TEstCases */
/*Parenthesis Matching Test

Enter strression
(a+(b*c)-d)
 
Matches and Mismatches:
 
')' at index 8 matched with ')' at index 4
')' at index 11 matched with ')' at index 1
 
 
 
Parenthesis Matching Test
 
Enter strression
((x+y/(z-w))
 
Matches and Mismatches:
 
')' at index 11 matched with ')' at index 7
')' at index 12 matched with ')' at index 2
'(' at index 1 is unmatched
 
 
 
Parenthesis Matching Test
 
Enter strression
(a+b*(c-d)-(e-f/(g+h*(k-i)/(l-j+k
 
Matches and Mismatches:
 
')' at index 10 matched with ')' at index 6
')' at index 26 matched with ')' at index 22
'(' at index 28 is unmatched
'(' at index 17 is unmatched
'(' at index 12 is unmatched
'(' at index 1 is unmatched*/