import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Elevator {

	static class Event implements Comparable<Event> {
		int f;
		String d;

		@Override
		public int compareTo(Event o) {
			if (f == o.f && d == o.d)
				return 0;
			else
				return f - o.f;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		String[] a = sc.nextLine().split("-");
		Event frstEvent= new Event();
		frstEvent.f=Integer.parseInt(a[0]);
		frstEvent.d=a[1];
		String[] a2= sc.nextLine().split(",");
		List<Event> events = new ArrayList<Event>();
		for(int i=0;i<a2.length;i++)
		{
			String[] temp = a2[i].split("-");
			Event tmpEvent= new Event();
			tmpEvent.f=Integer.parseInt(temp[0]);
			tmpEvent.d=temp[1];
			events.add(tmpEvent);
		}
		Collections.sort(events);
		for(int i=0;i<events.size();i++)
		{
			if(events.get(i).d.equals(frstEvent.d))
				{events.remove(i);
			System.out.print(events.get(i).f+",");}
		}
		for(int i=events.size()-1;i>=0;i--)
		{
			if(!events.get(i).d.equals(frstEvent.d))
				{events.remove(i);
			System.out.print(events.get(i).f+",");}
		}
	}
}
