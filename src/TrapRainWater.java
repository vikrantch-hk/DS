
// https://leetcode.com/problems/trapping-rain-water/submissions/1884714103/
// Water at any position is: min(maxLeft, maxRight) - height[i]
//
public class TrapRainWater {
    public static int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5})); //9
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); //6
    }
}
