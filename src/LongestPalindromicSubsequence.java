// https://leetcode.com/problems/longest-palindromic-subsequence/

/*
 * Given a string s, find the longest palindromic subsequence's length in s.
 * This is basically finding LCS with reverse string
 * */
public class LongestPalindromicSubsequence {

    public static int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        return lcs(s, s2);
    }

    public static int lcs(String s1, String s2) {
        int[][] r = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    r[i][j] = 0;
                } else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        r[i][j] = 1 + r[i - 1][j - 1];
                    } else {
                        r[i][j] = Math.max(r[i][j - 1], r[i - 1][j]);
                    }
                }
            }
        }
        return r[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
        System.out.println(longestPalindromeSubseq("cbbd"));
    }
}
