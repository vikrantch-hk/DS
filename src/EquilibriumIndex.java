import java.util.Arrays;

// https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
/*Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the
sum of elements at higher indexes
A[] = {-7, 1, 5, 2, -4, 3, 0}  Output: 3 */
public class EquilibriumIndex {

    public static int findMiddleIndex(int[] nums) {
        int s= Arrays.stream(nums).sum();
        int ls=0;
        for(int i=0;i<nums.length;i++){
            if(ls==s-nums[i]-ls){
                return i;
            }
            ls+=nums[i];
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println("First equilibrium index is " +
                findMiddleIndex(arr));
    }

}
