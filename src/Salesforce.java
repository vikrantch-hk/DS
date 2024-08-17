package com.cars24.b2coms.clients.service;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
// Consider the garden with n = 5 and ranges = [3, 0, 0, 0, 0, 0].
// there is a gap in coverage: we cannot reach any point beyond 3 because no interval exists that can extend coverage from 3 to 4.
public class Salesforce {
    static class Interval{
        public int s;
        public int e;
        public Interval(int s, int e){
            this.s=s;
            this.e=e;
        }
    }
    public static int minTaps(int n, int[] ranges) {
        List<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < ranges.length; i++) {
            int s = Math.max(0, i - ranges[i]);
            int e = Math.min(n, i + ranges[i]);
            intervals.add(new Interval(s, e));
        }

        // Sort intervals by start point, and by end point descending if start is the same
        intervals.sort((a, b) -> a.s == b.s ? b.e - a.e : a.s - b.s);

        int taps = 0;
        int end = 0;
        int i = 0;
        int farthest = 0;

        while (i < intervals.size() && end < n) {
            while (i < intervals.size() && intervals.get(i).s <= end) {
                farthest = Math.max(farthest, intervals.get(i).e);
                i++;
            }
            if (farthest <= end) {
                return -1; // If we cannot extend the current end
            }
            taps++;
            end = farthest;
        }

        return end >= n ? taps : -1;
    }

    public static void main(String[] args) {
        System.out.println(minTaps(7, new int[]{1, 2, 1, 0, 2, 1, 0, 1}));
    }
}
