package com.cars24.b2coms.billPayment;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// https://leetcode.com/problems/letter-combinations-of-a-phone-number
public class Test {
    public static String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return new LinkedList<>();
        Queue<String> cq = new LinkedList<String>();
        Queue<String> nq = new LinkedList<String>();
        String curr = str[(digits.charAt(0) - '0')];

        for (int i = 0; i < curr.length(); i++) {
            cq.add("" + curr.charAt(i));
        }


        for (int i = 1; i < digits.length(); i++) {
            curr = str[(digits.charAt(i) - '0')];
            while (!cq.isEmpty()) {
                String cqs = cq.poll();
                for (int j = 0; j < curr.length(); j++) {
                    nq.add(cqs + curr.charAt(j));
                }
            }
            cq = nq;
            nq = new LinkedList<String>();
        }


        return new LinkedList<String>(cq);

    }


    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

}

