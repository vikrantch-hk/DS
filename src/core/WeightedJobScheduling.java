package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WeightedJobScheduling {
	
	static class Job implements Comparable<Job>{
		int start;
		int end;
		int weight;
		public Job(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Job o) {
			// TODO Auto-generated method stub
			return this.end-o.end;
		}
	}
	
	public static void main(String[] args) {
		List<Job> list = new ArrayList<Job>();
		list.add(new Job(1, 2, 50));
		list.add(new Job(3, 5, 20));
		list.add(new Job(6, 19, 100));
		list.add(new Job(2, 100, 200));
		Collections.sort(list);
		
		list.forEach(job->System.out.println(job.end));
		
		// list conatining max profit till given index
		List<Integer> maxProfitList = new ArrayList<Integer>();
		//for 0th index max profit we can get only by executing 0th job
		maxProfitList.add(list.get(0).weight);
		
		for(int i=1;i<list.size();i++)
		{
			// we are including ith job and most compatiable job with it by binary search
			int inclProf = list.get(i).weight;
			int compatiableIndx = binarySearch(list,i);
			if(compatiableIndx != -1)
			{
				inclProf +=list.get(compatiableIndx).weight;
			}
			maxProfitList.add(Math.max(inclProf, maxProfitList.get(i-1)));
		}
		System.out.println(" Max profit is "+maxProfitList.get(maxProfitList.size()-1));
	}

	private static int binarySearch(List<Job> list, int i) {
		// TODO Auto-generated method stub
		int low=0,high=i-1;
		while(low<=high)
		{
			int mid = (low+high)/2;
			if(list.get(mid).start>=list.get(i).end)
			{
				if(list.get(mid+1).start>=list.get(i).end)
				{
					return mid+1;
				}
				else
					return mid;
			}
			else
				return mid-1;
		}
		return -1;
	}

}
