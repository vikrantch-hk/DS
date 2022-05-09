import java.util.HashSet;
import java.util.Set;


public class Palindrome {
	
	public static boolean isPalindrome(String input)
	{
		char[] arr = input.toCharArray();
		int i=0,j=arr.length-1;
		while(i<=j)
		{
			if(arr[i]!=arr[j])
				return false;
			else
			{
				i++;j--;
			}
		}
		return true;
	}
	public static void main(String[] args)
	{
		String input = "abccba";
		System.out.println(isPalindrome(input));
		
	}

}
