// https://www.geeksforgeeks.org/program-for-armstrong-numbers/
public class ArmstrongNumber {
    // Function to check whether the given
    // number is Armstrong number or not
    public static boolean isArmstrong(int x)
    {
        String input = x+"";
        int length = input.length();
        int temp = x, sum = 0;
        while (temp != 0) {
            int r = temp % 10;
            sum = sum + (int)Math.pow(r,length);
            temp = temp / 10;
        }

        // If satisfies Armstrong condition
        return (sum == x);
    }

    // Driver Code
    public static void main(String[] args)
    {

        int x = 153;
        System.out.println(isArmstrong(x));
        x = 1253;
        System.out.println(isArmstrong(x));
    }

}
