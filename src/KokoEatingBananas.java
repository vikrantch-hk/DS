import java.util.Arrays;

// https://leetcode.com/problems/koko-eating-bananas/description/
// https://www.youtube.com/watch?v=LzZFUTWE55c
public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        if(h<piles.length)
            return -1;
        if(h==piles.length)
            return max(piles);
        int l =0;
        int r = max(piles);
        int ans = Integer.MAX_VALUE;

        while(l<=r){
            int mid = l+((r-l)/2);
            if(isPossible(piles,h,mid)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }

    public static int max(int[] piles){
        return Arrays.stream(piles).max().getAsInt();
    }

    public static boolean isPossible(int[] piles, int h, int mid){
        int c = 0;
        for(int i=0;i<piles.length;i++){
            c+=(int)Math.ceil(piles[i]*1.0/mid);
        }
        return c<=h;
    }

    public static void main(String[] args) {
        minEatingSpeed(new int[]{3,6,7,11},8); // 4
        minEatingSpeed(new int[]{30,11,23,4,20},5); // 30
    }

}
