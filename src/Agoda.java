package com.cars24.b2coms.clients.service;

import java.util.Stack;

public class Agoda {
    public static void main(String[] args) {
        String in  = "This1 is tes@at!!!";
        Stack<Character> s = new Stack<>();
        String o = "";
        for(int i=0;i<in.length();i++){
            if(!(Character.isAlphabetic(in.charAt(i)) || Character.isDigit(in.charAt(i)))){
                while(!s.empty()){
                    o+=s.pop();
                }
                o+=in.charAt(i);
            }else {
                s.push(in.charAt(i));
            }
        }
        System.out.println(o);
    }
}
