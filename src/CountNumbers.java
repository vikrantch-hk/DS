import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class CountNumbers {

	public static void doCountNumbers(int[] arr )
	{
		Arrays.sort(arr);
		int count=1;int prev = arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]==prev)
			{
				count++;
			}
			else
			{
				System.out.println(prev+" count "+count);
				count=1;
				prev = arr[i];
			}
		}
		// whenever using count algo based on prev element always remember to count last element separately
		System.out.println(arr[arr.length-1]+" count "+count);
	}
	public static void doCountNumbers2(int[] arr )
	{
		System.out.println();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr.length;i++)
		{
			int count =0;
			if(map.containsKey(arr[i]))
			{
				count=map.get(arr[i])+1;
			}
			else
			{
				count=1;
			}
			map.put(arr[i], count);
		}
		Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
		while(itr.hasNext())
		{
			Entry<Integer,Integer> entry = itr.next();
			System.out.println(entry.getKey()+" count "+entry.getValue());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr=new int[]{1,1,1,2,3,2,2,2,4,3};
		CountNumbers.doCountNumbers(arr);
		CountNumbers.doCountNumbers2(arr);
	}

}
