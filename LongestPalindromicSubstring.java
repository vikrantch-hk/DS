// https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
/*
* Given a string, find the longest substring which is a palindrome.
For Example:
Input: Given string :"forgeeksskeegfor",
Output: "geeksskeeg".

Input: Given string :"Geeks",
Output: "ee".
* */

// TC O(n^2) SC O(1)
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {

            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        return longest;}

    public static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }

        // while loop iterates an extra time to be outside of the equal characters
        return s.substring(begin + 1, end);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("forgeeksskeegfor"));
    }
}
