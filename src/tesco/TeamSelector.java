package tesco;

// https://leetcode.com/discuss/post/6293018/tesco-sde3-by-anonymous_user-b0di/
/*Given a list of n players with strengths [s0 , s1, s2 ... sn], create two teams (A & B) of size k (k<=n/2)

strength(A) = Sum of strength of all players in a team A
strength(B) = Sum of strength of all players in a team B

Total strength = strength(A)+strength(B)
Diff strength = abs(strength(A)-strength(B))

such that —

Total strength is maximum.
Diff strength is minimum.
In case of same Total strength , select combination with minimum Diff strength

Example
n = no of total players
k = team size (k<=n/2)
players= list of player strength space separated

n = 5
k = 2
players = 4 4 2 2 5
playerIds = 1 2 3 4 5

List<[a,b,c,...]>
[[4,4],[2,5],[2,2]]
0 1 2

Possible Teams :

CombId [Team1] [Team2] Strength Difference
1 [1,2] [3,5] 15 1
2 [1,2] [4,5] 15 1
3 [1,3] [2,5] 15 3
4 [1,4] [2,5] 15 3
5 [1,3] [2,4] 12 0
6 [1,4] [3,2] 12 0
7 [1,4] [3,5] 13 1

combination-1 and combination-2 [1,2][4,5] are winning combinations as their total strength is 15(maximum),
while the difference in strength is closest to minimum. Here [ 1, 2] [4, 5] are the player ids.

Hence, you designed two equal strength teams.

Input Format
First line will be a string containing player strength as an array of space-separated integers.
Second Line will be a string containing player id's as an array of space-separated integers.
Third line will contain an integer denoting the max number of players in a team.

Output Format
Output will contain winning combination's Total strength and the Diff strength separated by a space.
total_strength strength_diff

See Sample Input-output for more clarification.

Sample Test Case
Input
4 4 2 2 5
1 2 3 4 5

2

Output
15 1*/
import java.util.*;

public class TeamSelector {

    static class Team {
        int sum = 0;
        int size = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        void add(int x) { sum += x; size++; maxHeap.add(x); }
    }

    public static void main(String[] args) {
        int[] arr = {4, 4, 2, 2, 5};
        int k = 2;
        int n = arr.length;

        Arrays.sort(arr);              // strongest players last
        Team A = new Team();
        Team B = new Team();

        for (int i = n - 1; i >= 0; i--) {
            int x = arr[i];

            if (A.size < k && (A.sum <= B.sum || B.size == k)) {
                A.add(x);
            } else {
                B.add(x);
            }
        }

        System.out.println("Team A: " + A.maxHeap + " Sum=" + A.sum);
        System.out.println("Team B: " + B.maxHeap + " Sum=" + B.sum);
        System.out.println("Total=" + (A.sum + B.sum));
        System.out.println("Diff=" + Math.abs(A.sum - B.sum));
    }
}
