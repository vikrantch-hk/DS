import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MinPlatform {

	// http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
	static class Schedule implements Comparable<Schedule> {
		Float time;
		String event;

		public Schedule(Float time, String event) {
			super();
			this.time = time;
			this.event = event;
		}

		@Override
		public int compareTo(Schedule o) {
			return this.time.compareTo(o.time);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Float arr[] = { 9.00f, 9.40f, 9.50f, 11.0f, 15.0f, 18.0f };
		Float dep[] = { 9.10f, 12.00f, 11.20f, 11.30f, 19.0f, 20.0f };
		Float arr1[] = { 9.00f, 9.10f, 9.40f };
		Float dep1[] = { 9.20f, 9.50f, 10.00f };
		
		int m = getMinPlatform(arr, dep);
		System.out.println("getMinPlatform " + m);
	}

	public static int getMinPlatform(Float[] arr, Float[] dep) {
		// TODO Auto-generated method stub
		int prev = 0, max = 0, curr = 0;
		List<Float> arrList = Arrays.asList(arr);
		List<Float> depList = Arrays.asList(dep);
		List<Schedule> complteList = new ArrayList<Schedule>();
		arrList.forEach(f -> {
			complteList.add(new Schedule(f, "ARR"));
		});
		depList.forEach(f -> {
			complteList.add(new Schedule(f, "DEP"));
		});
		Collections.sort(complteList);

		for (Schedule s : complteList) {
			System.out.println("s" + s.time + s.event);
			if (s.event.equals("ARR")) {
				curr++;
				if (curr > max)
					max = curr;
			} else
				curr--;
		}
		;
		return max;
	}

}
