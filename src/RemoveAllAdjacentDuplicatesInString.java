// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

/*
* You are given a string s consisting of lowercase English letters.
* A duplicate removal consists of choosing two adjacent and equal letters and removing them
* */

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && s.charAt(i)==st.peek()){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));// abbaca->aaca->ca
    }
}
