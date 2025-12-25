package tesco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/merge-intervals/description/
public class MergeIntervals {

    public static int[][]  merge(int[][] intervals){
        List<int[]> output = new ArrayList<>();

        Arrays.sort(intervals, (a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

        int[] curr = intervals[0];
        output.add(intervals[0]);

        for(int[] interval:intervals){
            if(interval[0]<=curr[1]){
                curr[1]=curr[1]>interval[1]?curr[1]:interval[1];
            }else {
                curr = interval;
                output.add(interval);
            }
        }

        return output.toArray(new int[output.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals2 = {{1,4},{4,5}};
        int[][] intervals3 = {{4,7},{1,4}};
        System.out.println(Arrays.stream(merge(intervals)).map(a -> "["+a[0]+","+a[1]+"]").collect(Collectors.joining(", ")));
        System.out.println(Arrays.stream(merge(intervals2)).map(a -> "["+a[0]+","+a[1]+"]").collect(Collectors.joining(", ")));
        System.out.println(Arrays.stream(merge(intervals3)).map(a -> "["+a[0]+","+a[1]+"]").collect(Collectors.joining(", ")));
    }
}
