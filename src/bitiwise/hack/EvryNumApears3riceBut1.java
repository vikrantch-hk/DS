package bitiwise.hack;

/*To rectify this mistake, the code makes use of 2 variables. 
 ones - At any point of time, this variable holds XOR of all the elements which have 
 appeared "only" once. 
 twos - At any point of time, this variable holds XOR of all the elements which have 
 appeared "only" twice. 

 So if at any point time, 
 1. A new number appears - It gets XOR'd to the variable "ones". 
 2. A number gets repeated(appears twice) - It is removed from "ones" and XOR'd to the 
 variable "twice". 
 3. A number appears for the third time - It gets removed from both "ones" and "twice". 

 The final answer we want is the value present in "ones" - coz, it holds the unique element. 

 So if we explain how steps 1 to 3 happens in the code, we are done. 
 Before explaining above 3 steps, lets look at last three lines of the code, 

 not_threes = ~(ones & twos) 
 ones & = not_threes 
 twos & = not_threes 

 All it does is, common 1's between "ones" and "twos" are converted to zero. 

 For simplicity, in all the below explanations - consider we have got only 4 elements in the array (one unique element and 3 repeated elements - in any order). 

 Explanation for step 1 
 ------------------------ 
 Lets say a new element(x) appears. 
 CURRENT SITUATION - Both variables - "ones" and "twos" has not recorded "x". 

 Observe the statement "twos| = ones & x". 
 Since bit representation of "x" is not present in "ones", AND condition yields nothing. So "twos" does not get bit representation of "x". 
 But, in next step "ones ^= x" - "ones" ends up adding bits of "x". Thus new element gets recorded in "ones" but not in "twos". 

 The last 3 lines of code as explained already, converts common 1's b/w "ones" and "twos" to zeros. 
 Since as of now, only "ones" has "x" and not "twos" - last 3 lines does nothing. 

 Explanation for step 2. 
 ------------------------ 
 Lets say an element(x) appears twice. 
 CURRENT SITUATION - "ones" has recorded "x" but not "twos". 

 Now due to the statement, "twos| = ones & x" - "twos" ends up getting bits of x. 
 But due to the statement, "ones ^ = x" - "ones" removes "x" from its binary representation. 

 Again, last 3 lines of code does nothing. 
 So ultimately, "twos" ends up getting bits of "x" and "ones" ends up losing bits of "x". 

 Explanation for step 3. 
 ------------------------- 
 Lets say an element(x) appears for the third time. 
 CURRENT SITUATION - "ones" does not have bit representation of "x" but "twos" has. 

 Though "ones & x" does not yield nothing .. "twos" by itself has bit representation of "x". So after this statement, "two" has bit representation of "x". 
 Due to "ones^=x", after this step, "one" also ends up getting bit representation of "x". 

 Now last 3 lines of code removes common 1's of "ones" and "twos" - which is the bit representation of "x". 
 Thus both "ones" and "twos" ends up losing bit representation of "x". */

public class EvryNumApears3riceBut1 {

	static int getSingle(int arr[]) {
		int ones = 0, twos = 0;

		int common_bit_mask;

		// Let us take the example of {3, 3, 2, 3} to understand this
		for (int i = 0; i < arr.length; i++) {
			/*
			 * The expression "one & arr[i]" gives the bits that are there in
			 * both 'ones' and new element from arr[]. We add these bits to
			 * 'twos' using bitwise OR
			 * 
			 * Value of 'twos' will be set as 0, 3, 3 and 1 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */
			twos = twos | (ones & arr[i]);

			/*
			 * XOR the new bits with previous 'ones' to get all bits appearing
			 * odd number of times
			 * 
			 * Value of 'ones' will be set as 3, 0, 2 and 3 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */
			ones = ones ^ arr[i];
			System.out.println("startones " + ones + "twos " + twos);

			/*
			 * The common bits are those bits which appear third time So these
			 * bits should not be there in both 'ones' and 'twos'.
			 * common_bit_mask contains all these bits as 0, so that the bits
			 * can be removed from 'ones' and 'twos'
			 * 
			 * Value of 'common_bit_mask' will be set as 00, 00, 01 and 10 after
			 * 1st, 2nd, 3rd and 4th iterations respectively
			 */
			common_bit_mask = ~(ones & twos);

			/*
			 * Remove common bits (the bits that appear third time) from 'ones'
			 * 
			 * Value of 'ones' will be set as 3, 0, 0 and 2 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */
			ones &= common_bit_mask;

			/*
			 * Remove common bits (the bits that appear third time) from 'twos'
			 * 
			 * Value of 'twos' will be set as 0, 3, 1 and 0 after 1st, 2nd, 3rd
			 * and 4th itearations respectively
			 */
			twos &= common_bit_mask;

			// uncomment this code to see intermediate values
			System.out.println("ones " + ones + "twos " + twos+" common_bit_mask "+common_bit_mask);
		}

		return ones;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(2&(~(2&1)));
		//int arr[] = { 1, 1, 2,3,  1, 3, 3 };
		int arr[] = {1,1,2,1};
		System.out.println("The element with single occurrence is "
				+ getSingle(arr));
	}

}
