

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelection {
	static class Job implements Comparable<Job>{
		int start;
		int end;
		public Job(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + end;
			result = prime * result + start;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Job other = (Job) obj;
			if (end != other.end)
				return false;
			if (start != other.start)
				return false;
			return true;
		}



		@Override
		public int compareTo(Job o) {
			// TODO Auto-generated method stub
			return this.end-o.end;
		}
	}
	
	static class Job2 implements Comparable<Job2>{
		int duration;
		int deadline;
		public Job2(int duration, int deadline) {
			super();
			this.duration = duration;
			this.deadline = deadline;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + duration;
			result = prime * result + deadline;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Job other = (Job) obj;
			if (deadline != other.deadline)
				return false;
			if (duration != other.duration)
				return false;
			return true;
		}



		@Override
		public int compareTo(Job2 o) {
			// TODO Auto-generated method stub
			return this.duration-o.duration;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start[] = {1, 3, 0, 5, 8, 5};
		int finish[] = {2, 4, 6, 7, 9, 9};
		selectActivities(start, finish);
		taskWithDurationsAndDeadlines(new int[]{4,3,2,4}, new int[]{2,5,7,5});
	}

	private static void selectActivities(int[] start, int[] finish) {
		// TODO Auto-generated method stub
		List<Job> list = new ArrayList<Job>();
		for(int i=0;i<start.length;i++)
			list.add(new Job(start[i],finish[i]));
		List<Job> originalList = list; 
		Collections.sort(list);
		int indxOfLstJob = 0;
		System.out.println("indexes of jobs selected ");
		System.out.println("index 0"+"( "+start[0]+" "+finish[0]+")");
		for(int i=1;i<list.size();i++)
			if(list.get(i).start>=list.get(indxOfLstJob).end)
			{
				System.out.println("index "+originalList.indexOf(list.get(i))+"( "+start[i]+" "+finish[i]+")");
				indxOfLstJob = i;
			}
		
	}
	
	//profit is sum of deadline-duration
	//greedy strategy is to simply perform the tasks
	//sorted by their durations in increasing order.
	private static void taskWithDurationsAndDeadlines(int[] durations, int[] deadlines) {
		List<Job2> list = new ArrayList<Job2>();
		for(int i=0;i<durations.length;i++)
			list.add(new Job2(durations[i],deadlines[i]));
		Collections.sort(list);
		int profit=0;
		int lastEndTime=0;
		for(int i=0;i<list.size();i++) {
			System.out.println("profit i"+i+" "+profit);
			profit+=list.get(i).deadline-(lastEndTime+list.get(i).duration);
			lastEndTime=lastEndTime+list.get(i).duration;
		}
		
		System.out.println("profit "+profit);
		
	}

}
