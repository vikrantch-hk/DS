// https://leetcode.com/problems/average-waiting-time/

/*
* There is a restaurant with a single chef. You are given an array customers,
*  where customers[i] = [arrivali, timei]:

arrivali is the arrival time of the ith customer.
*  The arrival times are sorted in non-decreasing order.
timei is the time needed to prepare the order of the ith customer.
*
* Return the average waiting time of all customers
* */

public class AverageWaitingTime {

    public static double averageWaitingTime(int[][] customers) {
        int st=0;
        double wt=0.0;
        for(int i=0;i<customers.length;i++){
            int at = customers[i][0];
            int pt = customers[i][1];
            st = Math.max(st,at);
            wt += pt+ st-at;
            st+=pt;
        }
        return wt/customers.length;
    }

    public static void main(String[] args) {
        System.out.println(averageWaitingTime(new int[][]{{1,2},{2,5},{4,3}}));
        System.out.println(averageWaitingTime(new int[][]{{5,2},{5,4},{10,3},{20,1}}));
    }
}
