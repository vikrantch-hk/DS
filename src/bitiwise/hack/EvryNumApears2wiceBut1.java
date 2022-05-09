package bitiwise.hack;

public class EvryNumApears2wiceBut1 {

	public static void findNumAppearingOnlyOnce(int[] arr) {

		// every number is appearing twice so XOR for numbers appearing twice will become 0
		// and final result be number appearing only once
		
		int sum=0;
		for(int i:arr)
		{
			sum ^= i;
		}
		System.out.println("NumAppearingOnlyOnce is "+sum);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		findNumAppearingOnlyOnce(new int[] { 2, 3, 1, 2, 1, 3, 4, 4, 5, 7, 6,
				6, 7 });
	}

}
