// https://leetcode.com/problems/minimum-window-substring/
/*
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s such that every character in t
 * (including duplicates) is included in the window.
 * If there is no such substring, return the empty string ""
 * 􏰓􏰫􏰫􏰓􏰟􏰫􏰓􏰓􏰓􏰫􏰫􏰓􏰟􏰫􏰓􏰓􏰓􏰫􏰫􏰓􏰟􏰫􏰓􏰓ABBACBAA,  AAB  -> BAA
 * BBA, AB -> BA
 * */

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        // record the letter occurrence of input t in count[] by +1
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            // if right char is found in target reduce count in map and increase count
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0) {
                    count++;
                }
                // if count matches target length try to increase left to minimize window
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if (minLen > s.length()) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen);
    }
}
