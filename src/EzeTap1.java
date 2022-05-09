/*
 Make the cheapest palindrome
Max. Marks 100
Palindrome is a string that reads the same backward as forward, e.g., madam.

You are given a string whose length is even, and each character of the string is either 'a', 'b' or '/' Your task is to replace each occurrence of '/' in string with
 either 'a' or 'b' such that the string becomes a palindrome.

You are also given two integers, aCost and bCost. Replacing '/' with 'a' costs aCost, and replacing '/' with 'b' costs bCost.

Return the minimum cost of replacing '/' by 'a' and 'b' such that the string turns into a palindrome. If it is impossible to obtain a palindrome, return -1.

Constraints

String will contain between 1 and 10000 characters, inclusive.
The length of string will be even.
Each character of the string will be either 'a' or 'b' or '/'.
aCost will be between 1 and 100, inclusive.
bCost will be between 1 and 100, inclusive.
Input Format

First line of input will contain the number of test cases. For each test case, there will be of three lines, the first line is the string whose palindrome 
is to be constructed, the second is the aCost and the third is the bCost

Examples

1

aba/bab/

4

6

Returns: 10

The only way to produce a palindrome is to replace 4th character of string with 'b' and 8th character with 'a'. The first replacement costs 4, the second costs 6, 
so the total cost is 4+6=10.

aaaabbbb

12

34

Returns: -1

There is no '/' character, and string is not a palindrome. We have no way to change it into a palindrome.

Sample Input(Plaintext Link)
 1
baba//aaa/ab//
72
23
Sample Output(Plaintext Link)
 213
*/

import java.util.*;
public class EzeTap1 {
    public static void main(String args[] ) throws Exception {
         Scanner sc = new Scanner(System.in);
		 int test = sc.nextInt();
		for (int i = 1; i <= test; i++) {
 
			 String str = sc.next();
			 int aCost = sc.nextInt();
			 int bCost = sc.nextInt();
			char[] arr = str.toCharArray();
			int cost = 0;
			if (arr.length % 2 != 0 || aCost <= 0 || bCost <= 0) {
				cost = -1;
			} else {
				for (int j = 0; j < (arr.length / 2); j++) {
					int start = j;
					int end = arr.length - j - 1;
					if (arr[start] == '/' && arr[end] == '/') {
						cost += (Math.min(aCost, bCost) * 2);
					} else if (arr[start] == '/') {
						if (arr[end] == 'a')
							cost += aCost;
						else if (arr[end] == 'b')
							cost += bCost;
						else {
							cost = -1;
							break;
						}
					} else if (arr[end] == '/') {
						if (arr[start] == 'a')
							cost += aCost;
						else if (arr[start] == 'b') {
							cost += bCost;
						} else {
							cost = -1;
							break;
						}
					} else if (arr[start] != arr[end]) {
						cost = -1;
						break;
					}
 
				}
			}
			System.out.println(cost);
		}
	}
}